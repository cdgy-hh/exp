<template>
    <div class="table">
        <div class="container">
            <el-table :data="data" border class="table">
                <el-table-column prop="title" label="实验名称" sortable width="200" align="center">
                </el-table-column>
                <el-table-column prop="content" label="实验内容" sortable width="460" align="center">
                </el-table-column>
                <el-table-column prop="pub_time" label="发布时间" sortable width="120" align="center">
                </el-table-column>
                <el-table-column prop="num" label="浏览量" width="80" align="center">
                </el-table-column>
                <el-table-column prop="status" label="状态">
                </el-table-column>
                <el-table-column label="操作" width="180" align="center">
                    <template slot-scope="scope">
                        <el-button type="text" icon="el-icon-caret-right" @click="handleSelect(scope.$index, scope.row)">观看</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="pagination">
                <el-pagination background @current-change="handleCurrentChange" layout="prev, pager, next" :total="total">
                </el-pagination>
            </div>
        </div>

        <!-- 查看弹出框 -->
        <el-dialog class="center" :visible.sync="slectVisible" :before-close="closeSelect" :fullscreen="true" style="background:beige;">
            <video :src="video.url" height="520" controls="controls" autoplay="autoplay">
                您的浏览器不支持 video 标签。
            </video>
            <h3>{{video.content}}</h3>
            <span slot="footer" class="dialog-footer">
                <el-button type="primary" @click="closeSelect">关闭</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
    import Global from '../common/Global'
    import axios from 'axios'
    
    export default {
        name: 'basetable',
        data() {
            return {
                slectVisible: false,
                delVisible: false,
                tableData: [],
                cur_page: 1,
                total:1,
                video:{},
                idx: -1
            }
        },
        created() {
            this.getData();
        },
        computed: {
            data() {
                return this.tableData.filter((d) => {
                    return d;
                })
            }
        },
        methods: {
            // 分页导航
            handleCurrentChange(val) {
                this.cur_page = val;
                this.getData();
            },
            getData() {
                let startRow=10*(this.cur_page-1)+1;
                let request={};
                axios.post(Global.baseurl+"/exp/exp_pub",request)
                .then((response) => {
                    var code = response.data.code;
                    if(code==2){
                        this.tableData=[];
                        let exps = response.data.data;
                        for(let i=0;i<exps.length;i++){
                            if(exps[i].typeid==1){
                                this.tableData.push(exps[i])
                            }
                        }
                    }else{
                        this.$message.error('亲，错了哦，出了一点小异常');
                    }
                })

            },
            handleSelect(index, row) {
                this.idx = index;
                const item = this.tableData[index];
                this.video = item;
                this.slectVisible = true;
            },
            //关闭视频遮藏
            closeSelect(){
                this.video.videoURL="";
                this.slectVisible = false;
            },
        }
    }

</script>

<style scoped>
    .handle-box {
        margin-bottom: 20px;
    }

    .handle-select {
        width: 120px;
    }

    .handle-input {
        width: 300px;
        display: inline-block;
    }
    .del-dialog-cnt{
        font-size: 16px;
        text-align: center
    }
    .table{
        width: 100%;
        font-size: 14px;
    }
    .red{
        color: #ff0000;
    }
    .mr10{
        margin-right: 10px;
    }
    .center{
        text-align: center;
    }
</style>
