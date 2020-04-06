<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>我的资源</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="css/element_ui_index.css">
    <script src="js/vue.js"></script>
    <script src="js/element_ui_index.js"></script>
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <link rel="stylesheet" type="text/css" href="css/classily.css">

    <style type="text/css">
        #layout{
            margin-top: -40px;
        }

        .upload_title{
            width: 1200px;
            height: 40px;
            background-color: #fff;
            border:1px solid #00000040;
            margin: 10px auto;
            text-align: center;
            line-height: 40px;
            font-size: 20px;
            margin-top: -20px;

        }
        .layout , .pic{

            width: 1200px;
            min-height: 200px;
            background-color: #fff;
            border:1px solid #00000040;
            margin: 10px auto;
        }
        .context_left{
            width: 1130px;
            margin: 20px;
        }
        .resource_item .delete{
            position: absolute;
            top: 5px;
            right: 5px;
            width: 30px;
            height: 30px;
            background-image: url(img/delete.png);
            background-size: 100% 100%;


        }
        .delete:hover{
            cursor: pointer;
        }



    </style>

</head>
<body>
<iframe src="head_bar.jsp" width="100%" height="260px" scrolling="no"></iframe>


<div class="upload_title" >我的资源</div>

<div class="layout"  >
    <div class="context_left" id="resources" style="min-height: 200px;margin: 0px;width: 1200px;">
        <div class="resource_item" v-for="item in resourceList"  style="height: 320px;margin-right: 8px">

            <div class="delete" @click="deleteClick(item)"></div>
            <div class="resource_title" style="display: inline-block;width: 85%">{{item.name}}</div>
            <div class="resource_pic" @click="handleClick(item)"  style="height: 260px"><img :src="item.img" style="height: 260px"></div>



        </div>
        <div class="block" style="margin-bottom: 20px;">
            <el-pagination
                    background
                    layout="prev, pager, next"
                    :total="TotalPage"
                    @current-change="handleCurrentChange"
                    :current-page.sync="currentPage"
            >
            </el-pagination>
        </div>
    </div>
</div>




<iframe src="bottom_bar.jsp" width="100%" height="auto" scrolling="no"></iframe>


</body>
<script>

    var my_resources =${curRes}
    var pages = ${pages};



    var page = 1;
    // 绑定我的资源该页面的资源数据和方法
    const resources=new Vue({
        // el:'#resource_one',
        el:'#resources',
        data:{
            resourceList:my_resources,
            currentPage: page,
            TotalPage: pages*10

        }
        ,
        methods:{
            handleClick(item) {
                console.log(item.id);
                console.log(item.category);
                // 设置最新资源中某个资源的详细页面，携带资源id参数
                var link = "resource?id=" + item.id + "&classily=" + item.category;
                window.parent.location.href = link;
            },
            deleteClick(item)
            {
                console.log(item.id);
                // 设置某个资源的删除，携带资源id参数
                var link = "deleteResource?id="+item.id;
                window.parent.location.href=link;
            },


            handleCurrentChange(val) {
                console.log(`当前页: ${val}`);
                // 设置页码的跳转路径，携带点击的页码数
                var link ="myRes?page="+val+"&flag="+${flag};
                window.parent.location.href=link;
            }
        }
    });



    //获取url中的参数值

    $(function () {
        (function ($) {
            $.getUrlParam = function (name) {
                var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
                var r = window.location.search.substr(1).match(reg);
                if (r != null) return unescape(r[2]); return null;
            }
        })(jQuery);
        page =parseInt( $.getUrlParam('page'));
        if(!page) page="${page}";
        // 设置当前的页数
        resources.currentPage=page;
    });
</script>

</html>


