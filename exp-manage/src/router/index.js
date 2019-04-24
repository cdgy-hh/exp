import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/',
            redirect: '/dashboard'
        },
        {
            path: '/',
            component: resolve => require(['../components/common/Home.vue'], resolve),
            meta: { title: '自述文件' },
            children:[
                {
                    path: '/dashboard',
                    component: resolve => require(['../components/page/Dashboard.vue'], resolve),
                    meta: { title: '系统首页' }
                },
                {
                    path: '/teacher',
                    component: resolve => require(['../components/page/Teacher.vue'], resolve),
                    meta: { title: '教师信息管理' }
                },
                {
                    path: '/student',
                    component: resolve => require(['../components/page/Student.vue'], resolve),
                    meta: { title: '学生信息管理' }
                },
                {
                    path: '/tonexp',
                    component: resolve => require(['../components/page/Tlabexp.vue'], resolve),
                    meta: { title: '实验室实验管理' }
                },
                {
                    path: '/tunberexp',
                    component: resolve => require(['../components/page/Tonlineexp.vue'], resolve),
                    meta: { title: '在线实验管理' }
                },
                {
                    // test
                    path: '/test',
                    component: resolve => require(['../components/page/Test.vue'], resolve),
                    meta: { title: 'Test' }   
                },
                {
                    path: '/404',
                    component: resolve => require(['../components/page/404.vue'], resolve),
                    meta: { title: '404' }
                },
                {
                    path: '/403',
                    component: resolve => require(['../components/page/403.vue'], resolve),
                    meta: { title: '403' }
                }
            ]
        },
        {
            path: '/login',
            component: resolve => require(['../components/page/Login.vue'], resolve)
        },
        {
            path: '*',
            redirect: '/404'
        }
    ]
})
