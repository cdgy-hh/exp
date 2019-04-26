<script type="text/javascript">
const baseurl = "http://127.0.0.1:8085";
const adminTtems = [
                        {
                            icon: 'el-icon-lx-home',
                            index: 'dashboard',
                            title: '系统首页'
                        },
                        {
                            icon: 'el-icon-news',
                            index: 'teacher',
                            title: '教师信息管理'
                        },
                        {
                            icon: 'el-icon-date',
                            index: 'student',
                            title: '学生信息管理'
                        },
                    ];
const teacherTtems = [
                        {
                            icon: 'el-icon-lx-home',
                            index: 'dashboard',
                            title: '系统首页'
                        },
                        {
                            icon: 'el-icon-news',
                            index: 'tonexp',
                            title: '实验室实验管理'
                        },
                        {
                            icon: 'el-icon-printer',
                            index: 'tunberexp',
                            title: '在线实验管理'
                        },
                    ];
const studentTtems = [
                        {
                            icon: 'el-icon-lx-home',
                            index: 'dashboard',
                            title: '系统首页'
                        },
                        {
                            icon: 'el-icon-news',
                            index: 'slabexp',
                            title: '实验选课'
                        },
                        {
                            icon: 'el-icon-goods',
                            index: 'sdeletelab',
                            title: '已选择的'
                        },
                        {
                            icon: 'el-icon-printer',
                            index: 'sunberexp',
                            title: '在线实验管理'
                        },
                    ];
export default{
    baseurl,
    adminTtems,
    teacherTtems,
    studentTtems
}
</script>