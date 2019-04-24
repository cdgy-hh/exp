<template>
    <div class="table">
        <div class="container">
            <div class="handle-box">
                <el-button id="add" type="primary" icon="el-icon-circle-plus" @click="handleAdd">添加</el-button>
            </div>
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
                        <el-button type="text" icon="el-icon-edit" @click="handleUpdate(scope.$index, scope.row)">编辑</el-button>
                        <el-button type="text" icon="el-icon-delete" class="red" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="pagination">
                <el-pagination background @current-change="handleCurrentChange" layout="prev, pager, next" :total="total">
                </el-pagination>
            </div>
        </div>

        <!-- 添加弹出框 -->
        <el-dialog title="发布" :visible.sync="addVisible" width="500px">
            <el-form ref="form" :model="form" label-width="100px">
                <el-form-item label="实验标题">
                    <el-input v-model="form.title"></el-input>
                </el-form-item>
                <el-form-item label="实验内容">
                    <el-input v-model="form.content"></el-input>
                </el-form-item>
                <el-form-item label="视频资源">
                    <el-input v-model="form.url"></el-input>
                </el-form-item>
                <el-form-item label="实验状态">
                    <el-input v-model="form.status"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="updateVisible = false">取 消</el-button>
                <el-button type="primary" @click="saveAdd">确 定</el-button>
            </span>
        </el-dialog>

        <!-- 编辑弹出框 -->
        <el-dialog title="编辑" :visible.sync="updateVisible" width="500px">
            <el-form ref="form" :model="form" label-width="100px">
                <el-form-item label="实验标题">
                    <el-input v-model="form.title"></el-input>
                </el-form-item>
                <el-form-item label="实验内容">
                    <el-input v-model="form.content"></el-input>
                </el-form-item>
                <el-form-item label="实验状态">
                    <el-input v-model="form.status"></el-input>
                </el-form-item>
                <el-form-item label="实验状态">
                    <el-input v-model="form.url"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="updateVisible = false">取 消</el-button>
                <el-button type="primary" @click="saveUpdate">确 定</el-button>
            </span>
        </el-dialog>

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
                addVisible: false,
                updateVisible: false,
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
                        let userid = this.currUser.userid;
                        if(code==2){
                            this.tableData=[];
                            let exps = response.data.data;
                            for(let i=0;i<exps.length;i++){
                                if(exps[i].typeid==1
                                && exps[i].pubid==userid){
                                    this.tableData.push(exps[i])
                                }
                            }
                        }else{
                            this.$message.error('亲，错了哦，出了一点小异常');
                        }
                    })
                    .catch(function (error) {
                    console.log(error);
                });

            },
            handleAdd(){
                this.form={
                    content:"",
                    num: 0,
                    pubid:this.currUser.userid,
                    status: "正常",
                    title:"",
                    typeid:1,
                    url:"",
                }    
                this.addVisible=true;
            },
            handleUpdate(index, row) {
                this.idx = index;
                const item = this.tableData[index];
                this.form = item;
                this.updateVisible = true;
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
            //保存修改
            saveUpdate(){
                let request = this.form;
                axios.post(Global.baseurl+"/exp/updateexp",request)
                    .then((response) => {
                        var code = response.data.code;
                        if(code==2){
                            this.updateVisible = false;
                            this.getData();
                            this.$message.success('修改成功');
                        }else{
                            this.$message.error('亲，错了哦，出了一点小异常');
                        }
                    })
                    .catch(function (error) {
                    console.log(error);
                });
            },
            //保存添加
            saveAdd(){
                let request = this.form;
                axios.post(Global.baseurl+"/exp/addexp",request)
                    .then((response) => {
                        var code = response.data.code;
                        if(code==2){
                            this.addVisible = false;
                            this.getData();
                            this.$message.success('添加成功');
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
