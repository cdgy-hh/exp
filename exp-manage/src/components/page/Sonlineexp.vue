<template>
    <div class="table">
        <!-- <el-row>
            <el-col :span="5" v-for="(element,index) in tableData" :key="element.expid">
                <div class="grid-content bg-purple center" @click="handleSelect(index)">
                    <video :src="element.url" height="130">
                            您的浏览器不支持 video 标签。
                    </video>
                </div>
                <h6 class="center">{{element.title}}</h6>
            </el-col>
        </el-row> -->

        <el-row>
            <el-col :span="4" v-for="(element,index) in tableData" :key="element.expid">
                <div class="grid-content bg-purple center" @click="handleSelect(index)">
                    <video :src="element.url" height="200">
                            您的浏览器不支持 video 标签。
                    </video>
                </div>
                <h6 class="center">{{element.title}}</h6>
            </el-col>
        </el-row>

        <!-- 分页 -->
        <div class="pagination">
            <el-pagination background @current-change="handleCurrentChange" layout="prev, pager, next" :total="total">
            </el-pagination>
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
            handleSelect(index) {
                this.idx = index;
                console.log(index)
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
        background: #f9fafc;
    }
    .mr10{
        margin-right: 10px;
    }
    .center{
        text-align: center;
    }



    .el-col {
        border-radius: 4px;
        margin: 10px
    }
    .grid-content {
        border-radius: 5px;
        min-height: 36px;
    }

    video {
        border-radius: 5px;
    }

</style>
