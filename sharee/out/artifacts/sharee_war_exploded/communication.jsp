<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <title>交流区</title>
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/classily.css">
    <link rel="stylesheet" href="css/element_ui_index.css">
    <script src="js/vue.js"></script>
    <script src="js/element_ui_index.js"></script>
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <style type="text/css">

        #posts{
            border: #aaa 1px solid;
            margin-bottom: 20px;

        }
        .post_item{
            position: relative;
            border-bottom: #f2f2f2 1px solid;

        }
        .post_item:hover{
            background-color: #f2f2f2;
            cursor: pointer;
        }
        .post_reply_num{
            width: 50px;
            height:30px;
            text-align: center;
            line-height: 25px;
            background-image: url(img/回复数.png);
            background-size: 100% 100%;
            margin: 10px;
            display: inline-block;
            color: #aaa;
            margin-bottom: 0px;
        }
        .post_Name{
            margin:10px;
            display: inline-block;
            color: #aaa;
        }
        .post_Date{
            position: absolute;
            top: 0px;
            right: 0px;
            margin: 10px;
            color: #aaa;
        }
        .post_Content{
            margin: 10px;

        }
        .el-button{
            margin-left: 45%;
        }

    </style>
</head>
<body >
<iframe id="iframe" src="head_bar.jsp" width="100%" height="260px" ></iframe>
<div style="margin-top: -30px" >
    <div class="context">
        <div  id="posts">

            <!-- 			 <table class="post_item"> -->
            <%-- 				<c:forEach items="${list}" var="posting"> --%>
            <!-- 					  	<tr> -->
            <%-- 	                        <td>${posting.post_id }</td>	                         --%>
            <%-- 	                        <td>${posting.post_uid }</td> --%>
            <%-- 	                        <td>${posting.post_title }</td>	                     	                        --%>
            <!-- 	                    </tr> -->
            <%-- 				    </c:forEach> --%>

            <!-- 			   </table> -->
            <div class="post_item" v-for="item in postList" @click="handleClick(item)">
                <div class="post_reply_num">{{item.post_id}}</div>
                <div class="post_Name">{{item.post_name}}</div>
                <div class="post_Content">{{item.post_title}}</div>

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
        <div class="posting" id="posting" style="background-color: #f2f2f2">
            <div style="height: 60px;font-size: 18px; line-height: 60px">发表新帖:</div>
            <el-form >
                <el-form-item >
                    <el-input type="textarea" v-model="Content" ></el-input>
                </el-form-item>
                <el-form-item>
                    <c:if test="${loginUser.speak==null}">
                        <el-button target="_parent" ><a href="login.jsp">请先登录</el-button>
                    </c:if>
                    <c:if test="${loginUser.speak==1}">
                        <el-button type="submit" @click="onSubmit" >发帖</el-button>
                    </c:if>
                    <c:if test="${loginUser.speak==0}">
                        <el-button target="_parent"  >你已被禁言</el-button>
                    </c:if>
                </el-form-item>
            </el-form>
        </div>
    </div>
</div>
<iframe src="bottom_bar.jsp" width="100%" height="auto" ></iframe>
</body>

<script type="text/javascript">
    //设置获取的数据（以下默认数据，应该赋值servlet传入的数据${传入的数据名称}）

    // pages(该种类有几页帖子，每页十个帖子)
    //posts(十个帖子的信息:帖子id，用户名，帖子内容，发帖日期，回复数)




    var posts =${str};
    var pages =${total};
    var page = 1;
    if (window != top) 	top.location.href = location.href; //让iframe中的跳转转换成主页跳转




    //当前页面
    var page=1;
    if (window != top) 	top.location.href = location.href; //让iframe中的跳转转换成主页跳转


    // 绑定该该页面的帖子数据和方法
    const V_posts=new Vue({
        //const V_posting=new Vue({
        // el:'#resource_one',
        //	el:'#posting',
        el:'#posts',
        data:{
            postList:posts,
            //	postList:posting,
            currentPage: 1,
            TotalPage: pages
        },
        methods:{
            handleClick(item) {
                console.log(item.post_id);
                // 设置某个帖子的详细页面，携带帖子id参数
                var link = "PostServlet?id="+item.post_id;
                window.parent.location.href=link;
            },												//把帖子数目传到post.html

            handleCurrentChange(val) {
                console.log(`当前页: ${val}`);
                // 设置页码的跳转路径，携带点击的页码数
                var link ="communi?page="+val;
                window.parent.location.href=link;
            }
        }
    })

    // 绑定发帖子数据和方法
    const posting=new Vue({
        // el:'#resource_one',
        el:'#posting',
        data:{
            Content:""
        },
        methods:{
            onSubmit() {

                // 设置某个帖子的详细页面，携带帖子id参数
                var link = "PostContent?Content="+this.Content;
                // var link = "PostContent?Content="+this.Content+"&post_uid="+${loginUser.id}+"&post_name="+${loginUser.name};
                window.parent.location.href=link;
            },

        }
    })


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

        if(!page) page=1;
        // 设置当前的页数
        V_posts.currentPage=page;
    });
</script>
</html>