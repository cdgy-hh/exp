<template>
    <div>
        <div class="container">
            <div class="title">
                <h3>填写注册资料</h3>
            </div>
            <div class="form-box" >
                <el-form ref="form" :model="form" label-width="200px">
                    <el-form-item label="工号/学号">
                        <el-input v-model="form.no"></el-input>
                    </el-form-item>
                    <el-form-item label="姓名">
                        <el-input v-model="form.name"></el-input>
                    </el-form-item>
                    <el-form-item label="性别">
                        <el-radio-group v-model="form.sex">
                        <el-radio label="男"></el-radio>
                        <el-radio label="女"></el-radio>
                        </el-radio-group>
                    </el-form-item>
                    <el-form-item label="手机">
                        <el-input v-model="form.phone"></el-input>
                    </el-form-item>
                    <el-form-item label="角色">
                        <el-select v-model="form.roleid" placeholder="请选择">
                            <el-option key="教师" label="教师" value="2"></el-option>
                            <el-option key="学生" label="学生" value="3"></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="密码" prop="pass">
                        <el-input type="password" v-model="form.password" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="确认密码" prop="checkPass">
                        <el-input type="password" v-model="form.passcheck" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button @click="pre">返回</el-button>
                        <el-button type="primary" @click="onSubmit">注册</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </div>
    </div>
</template>

<script>
    import axios from 'axios'
    import Global from '../common/Global'
    export default {
        name: 'baseform',
        data: function(){
            return {
                form: {
                    no: '',
                    name: '',
                    sex: '男',
                    phone: '',
                    roleid:'',
                    password:'',
                    passcheck:'',
                }
            }
        },
        methods: {
            onSubmit() {
                let form = this.form;
                if (!this.checkRate(form.no)) {
                    this.$message.error('学号为数字');
                }else{
                    if(form.no!='' && form.name!='' && form.sex!=''
                    && form.phone!=''&&form.roleid!=''&& form.password!=''){
                        if(form.password!=form.passcheck){
                            this.$message.error('两次密码不一致');
                        }else{
                            axios.post(Global.baseurl+"/user/insertuser",form)
                            .then(res=>{
                                if(res.data.code==2){
                                    this.$message.success('注册成功');
                                    this.$router.push('/login');
                                }else{
                                    this.$message.error(res.data.msg);
                                }         
                            })
                        }
                    }else{
                        this.$message.error('请将信息补充完整');
                    }
                }
            },
            checkRate(nubmer) {
                //判断正整数
                var re = /^\d+$/;
                if (re.test(nubmer)) {
                   return true;
                }else{
                    return false;
                }
            },
            pre(){
                this.$router.push('/login');
            }
        }
    }
</script>
<style>
    .title{
        text-align: center;
        margin: 30px,30px,30px,30px
    }
    h3{
        margin: 30px;
        color: #00000078;
    }
    .form-box{
        margin:0 auto
    }
    .el-form{
        width: 450px;
    }

</style>
