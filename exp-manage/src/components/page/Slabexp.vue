<template>
    <div class="table">
        <div class="container">
            <el-table :data="data" border class="table">
                <el-table-column prop="title" label="实验名称" sortable width="200" align="center">
                </el-table-column>
                <el-table-column prop="content" label="实验内容" sortable align="center">
                </el-table-column>
                <el-table-column prop="pub_time" label="发布时间" sortable  align="center">
                </el-table-column>
                <el-table-column prop="end_time" label="结束时间" sortable width="120" align="center">
                </el-table-column>
                <el-table-column prop="choose" label="状态" align="center">
                </el-table-column>
                <el-table-column label="操作" width="180" align="center">
                    <template slot-scope="scope">
                        <el-button type="text" icon="el-icon-circle-plus" @click="handleUpdate(scope.$index, scope.row)">我要选</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="pagination">
                <el-pagination background @current-change="handleCurrentChange" layout="prev, pager, next" :total="total">
                </el-pagination>
            </div>
        </div>

        <!-- 删除提示框 -->
        <el-dialog title="提示" :visible.sync="delVisible" width="300px" center>
            <div class="del-dialog-cnt">删除不可恢复，是否确定删除？</div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="delVisible = false">取 消</el-button>
                <el-button type="primary" @click="deleteRow">确 定</el-button>
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
                delVisible: false,
                tableData: [],
                cur_page: 1,
                total:1,
                form: {},
                idx: -1,//记录索引位置
                currUser:{},
            }
        },
        created() {
            let user = JSON.parse(localStorage.getItem("user"));
            this.currUser=user;
            this.getData();
        },
        computed: {
            data() {
                return this.tableData.filter((d) => {
                    if(d.status){
                        d.choose='可选';
                    }else{
                        d.choose='已选';
                    }
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
                axios.post(Global.baseurl+"/exp_stu/stuexp?flag=true&stuid="+this.currUser.userid)
                    .then((response) => {
                        var code = response.data.code;
                        if(code==2){
                            this.tableData=response.data.data
                        }else{
                            this.$message.error('亲，错了哦，出了一点小异常');
                        }
                    })
                    .catch(function (error) {
                    console.log(error);
                });

            },
            handleUpdate(index, row) {
                this.idx = index;
                const item = this.tableData[index];
                this.form = item;
                this.saveUpdate();
            },
            //保存修改
            saveUpdate(){
                let request={
                    "stuid":this.currUser.userid,
                    "expid":this.form.expid
                }
                axios.post(Global.baseurl+"/exp_stu/insertexp",request)
                    .then((response) => {
                        var code = response.data.code;
                        if(code==2){
                            this.getData();
                            this.$message.success('选课成功');
                        }else{
                            this.$message.error('亲，错了哦，出了一点小异常');
                        }
                    })
                    .catch(function (error) {
                    console.log(error);
                });
            },
            handleDelete(index, row) {
                this.idx = index;
                this.delVisible = true;
            },
            // 确定删除
            deleteRow(){
                let request = this.tableData[this.idx];
                axios.post(Global.baseurl+"/exp/deleteexp",request)
                    .then((response) => {
                        var code = response.data.code;
                        if(code==2){
                            this.tableData.splice(this.idx, 1);
                            this.$message.success('删除成功');
                            this.delVisible = false;
                        }else{
                            this.$message.error('亲，错了哦，出了一点小异常');
                        }
                    })
                    .catch(function (error) {
                    console.log(error);
                });
            },
            initFormDate(){
                this.form={
                    content:"",
                    end_time: "",
                    expid: "",
                    num: "",
                    pub_time: "",
                    pubid: "",
                    status: "",
                    title:"",
                    typeid:"",
                    url:"",
                }
            }
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
    #add{
        float:right;
        margin-bottom: 20px
    }
</style>
