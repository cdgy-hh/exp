<template>
    <div class="table">
        <div class="container">
            <div class="handle-box">
                <el-button id="add" type="primary" icon="el-icon-circle-plus" @click="handleAdd">添加</el-button>
            </div>
            <el-table :data="data" border class="table">
                <el-table-column prop="no" label="工号" sortable width="100">
                </el-table-column>
                <el-table-column prop="roleType" label="角色类型" width="100">
                </el-table-column>
                <el-table-column prop="name" label="姓名" sortable width="100">
                </el-table-column>
                <el-table-column prop="sex" label="性别" width="200">
                </el-table-column>
                <el-table-column prop="phone" label="手机">
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
        <el-dialog title="教师信息录入" :visible.sync="addVisible" width="500px">
            <el-form ref="form" :model="form" label-width="100px">
                <el-form-item label="工号">
                    <el-input v-model="form.no"></el-input>
                </el-form-item>
                <el-form-item label="姓名">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="性别">
                    <el-radio v-model="form.sex" label="男">男</el-radio>
                    <el-radio v-model="form.sex" label="女">女</el-radio>
                </el-form-item>
                <el-form-item label="手机">
                    <el-input v-model="form.phone"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="updateVisible = false">取 消</el-button>
                <el-button type="primary" @click="addUser">确 定</el-button>
            </span>
        </el-dialog>

        <!-- 编辑弹出框 -->
        <el-dialog title="编辑教师信息" :visible.sync="updateVisible" width="500px">
            <el-form ref="form" :model="form" label-width="100px">
                <el-form-item label="工号">
                    <el-input v-model="form.no"></el-input>
                </el-form-item>
                <el-form-item label="姓名">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="性别">
                    <el-radio v-model="form.sex" label="男">男</el-radio>
                    <el-radio v-model="form.sex" label="女">女</el-radio>
                </el-form-item>
                <el-form-item label="手机">
                    <el-input v-model="form.phone"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="updateVisible = false">取 消</el-button>
                <el-button type="primary" @click="updateUser">确 定</el-button>
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
                form: {
                    name: '',
                    phone: '',
                    sex: ''
                },
                idx: -1
            }
        },
        created() {
            this.getData();
        },
        computed: {
            data() {
                return this.tableData.filter((d) => {
                    d.roleType = "教师"
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
                axios.get(Global.baseurl+"/user/listUserByRoleType?type=teacher")
                    .then((response) => {
                        var code = response.data.code;
                        if(code==2){
                            this.tableData=response.data.data;
                        }else{
                            this.$message.error('亲，错了哦，出了一点小异常');
                        }
                    })
                    .catch(function (error) {
                    console.log(error);
                });

            },
            handleAdd(){
                this.form = {
                    userid:"",
                    no:"",
                    name:"",
                    password:"",
                    sex:"",
                    phone:"",
                    roleid:"",
                    password:"123456",
                    roleid:2
                }
                this.addVisible=true;
            },
            handleUpdate(index, row) {
                this.idx = index;
                const item = this.tableData[index];
                this.form = {
                    userid:item.userid,
                    no:item.no,
                    name:item.name,
                    password:item.password,
                    sex:item.sex,
                    phone:item.phone,
                    roleid:item.roleid
                }
                this.updateVisible = true;
            },
            handleDelete(index, row) {
                this.idx = index;
                this.delVisible = true;
            },
            // 确定删除
            deleteRow(){
                let request = this.tableData[this.idx];
                axios.post(Global.baseurl+"/user/deleteuser",request)
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
            updateUser(){
                let request = this.form;
                axios.post(Global.baseurl+"/user/updateuser",request)
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
            addUser(){
                let request = this.form;
                axios.post(Global.baseurl+"/user/insertuser",request)
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
