<template>
    <div class="login-wrap">
        <div>
            <div class="login-btn">
                <el-button type="primary" @click="submitForm()">登录</el-button>
            </div>
        </div>
        <div>
            <div>
                <el-button type="primary" @click="article()">article</el-button>
                <el-button type="primary" @click="require_auth()">require_auth</el-button>
                <el-button type="primary" @click="require_role()">require_role</el-button>
                <el-button type="primary" @click="require_permission()">require_permission</el-button>
            </div>
        </div>
    </div>
</template>

<script>
    import axios from 'axios'
    import Global from '../common/Global'

    export default {
        data: function(){
            return {
            }
        },
        methods: {
            submitForm() {
                let request = {"username":"gz","password":"gz123456"};
                axios.post(Global.baseurl+"/auth-api/userWebRest/login",request)
                .then(res=>{
                    if(res.data.code==2){
                        console.log(res.data.token)
                        localStorage.setItem("Authorization",res.data.token);
                    }
                })
                
            },
            article(){
                axios.get(Global.baseurl+"/auth-api/userWebRest/article",{
                    // axios.get("http://127.0.0.1:9002/userWebRest/article",{
                    headers: {
                        'Authorization': localStorage.getItem("Authorization"),
                    }
                })
                .then(res=>{
                    console.log(res.data.msg)
                })
            },
            require_auth(){
                axios.get(Global.baseurl+"/require_auth",{
                    headers: {
                        'Authorization': localStorage.getItem("Authorization"),
                    }
                })
                .then(res=>{
                    console.log(res.data.msg)
                })
            },
            require_role(){
                axios.get(Global.baseurl+"/require_role",{
                    headers: {
                        'Authorization': localStorage.getItem("Authorization"),
                    }
                })
                .then(res=>{
                    console.log(res)
                })
            },
            require_permission(){
                axios.get(Global.baseurl+"/auth-api/require_permission",{
                    headers: {
                        'Authorization': localStorage.getItem("Authorization"),
                    }
                })
                .then(res=>{
                    console.log(res.data.msg)
                })
            }
        }
    }
</script>

