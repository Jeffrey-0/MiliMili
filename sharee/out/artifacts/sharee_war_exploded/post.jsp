<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
	<title>帖子</title>
	<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/classily.css">
	<link rel="stylesheet" href="css/element_ui_index.css">
	<script src="js/vue.js"></script>
	<script src="js/element_ui_index.js"></script>
	<link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
	<style type="text/css">
		#post{
			border-bottom: #aaa 1px solid;

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
			font-size: 20px;

		}


		#floors{
			border: #aaa 1px solid;
			margin-bottom: 20px;
		}
		.post_title{
			font-size: 20px;
			height: 40px;
			line-height: 40px;
			border-bottom: #f2f2f2 1px solid;
		}
		.floor_item{
			/*position: relative;*/
			border-bottom: #aaa 1px solid;
			background-color: #f2f2f2;
		}
		.floor_left{
			position: absolute;
			display: inline-block;
			width:9%;


		}
		.floor_right{
			margin-left: 10%;
			background-color: #fff;
			display:inline-block;
			width: 90%;
			min-height: 130px;


		}
		.user_head{
			margin: 10px;
			display: inline-block;
			width: 100px;
			height:100px;
			float: left;
		}
		.user_name{
			width: 100%;
			text-align: center;
			margin-top: 20px;
			margin: 10px;
		}
		.floor_text{
			padding: 10px;
			min-height: 100px;
		}

		.floor_id,.floor_time,.floor_submit{
			display: inline-block;
			color: #aaa;
			margin:10px;
		}
		.floor_id{
			margin-left: 78%;
		}
		.floor_submit{
			color: #00f;
		}
		.floor_submit:hover{
			cursor: pointer;
		}
		.comment_user_head{
			display: inline-block;
			width: 30px;
			height:30px;
			background-size: 100% 100%;
		}
		.floor_comments{
			background-color: #f2f2f2;
			margin-left: 20px;
			margin-right: 20px;
			margin-bottom: 20px;
		}
		.comment_item{
			border-bottom: #ddd 1px solid;
			padding:10px;

		}
		.comment_user_name,.comment_time{
			display: inline-block;
			color: #aaa;
			width: 10%;
		}
		.comment_time{
			width: 15%;
		}
		.comment_text{
			display: inline-block;
			width: 70%;
		}
		.el-button{
			margin-left: 45%;
		}

		.floor_comments .el-form-item{
			margin-bottom: 0px;
		}
		.el-input{
			width: 850px;
		}
	</style>
</head>
<body >
<iframe id="iframe" src="head_bar.jsp" width="100%" height="260px" ></iframe>
<div style="margin-top: -30px" >
	<div class="context">

		<div  id="floors">
			<div  id="post">
				<div class="post_reply_num">{{cur_post.post_id}}</div>
				<div class="post_Name">{{cur_post.post_name}}</div>
				<div class="post_Content">{{cur_post.post_title}}</div>
			</div>

			<div class="floor_item" v-for="(item,index) in floorList">
				<div class="floor_left">
					<img class="user_head" src="img/user_head/6.jpg">
					<div class="user_name">{{item.post_from_name}}</div>
				</div>

				<div class="floor_right">
					<div class="floor_text">{{item.post_content}}</div>
					<div class="floor_id">{{item.post_stprey_id}}楼</div>
					<div class="floor_time">{{item.post_date}}</div>
					<div class="floor_comments" >
						<div class="comment_item" v-for="comment_item in cur_comments" v-if="item.post_stprey_id==comment_item.post_stprey_id">


							<img class="comment_user_head" src="img/user_head/6.jpg">
							<span class="comment_user_name">{{comment_item.post_from_name}}</span>
							<span class="comment_text">{{comment_item.post_content}}</span>
							<span class="comment_time">{{comment_item.post_date}}</span>





						</div>

						<el-form :inline="true"  class="demo-form-inline">
							<el-form-item >
								<el-input type="text" v-model="Content[index]"></el-input>
							</el-form-item>
							<el-form-item>



								<c:if test="${loginUser.speak==null}">
									<el-button @click="login">请先登录</el-button>
								</c:if>
								<c:if test="${loginUser.speak==1}">
									<el-button type="submit" @click="onSubmit(item,index)" >评论</el-button>
								</c:if>
								<c:if test="${loginUser.speak==0}">
									<el-button target="_parent"  >你已被禁言</el-button>
								</c:if>

							</el-form-item>
						</el-form>
					</div>
				</div>
			</div>

			<!-- 				<div class="block" style="margin-bottom: 10px;margin-top: 10px;"> -->
			<!-- 				<el-pagination -->
			<!-- 					  background -->
			<!-- 					  layout="prev, pager, next" -->
			<!-- 					  :total="TotalPage" -->
			<!-- 					  @current-change="handleCurrentChange" -->
			<!-- 					:current-page.sync="currentPage" -->
			<!-- 					  > -->
			<!-- 					</el-pagination> -->
			<!-- 					</div> -->
		</div>

		<div class="posting" id="posting" style="background-color: #f2f2f2">
			<div style="height: 60px;font-size: 18px; line-height: 60px">评论:</div>
			<el-form >
				<el-form-item >
					<el-input type="textarea" v-model="Content" ></el-input>
				</el-form-item>
				<el-form-item>

					<c:if test="${loginUser.speak==null}">
						<el-button @click="login" >请先登录</el-button>

					</c:if>
					<c:if test="${loginUser.speak==1}">
						<el-button type="submit" @click="onSubmit" >评论</el-button>

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

	// post 帖子信息
	// floors  该帖子的楼层信息（每页显示六七条）
	// pages  该帖子楼层页数

	var post = ${str};
	// 	var floors = [
	// 		{floor_id:1,user_id:1, user_name:'小疯子',user_head:'img/user_head/6.jpg',floor_text:'666',floor_time:"2019-12-04 20:01",comments:[{comment_id:1,user_id:1, user_name:'小疯子',user_head:'img/user_head/1.jpg',comment_text:'666',comment_time:"2019-12-04 20:01"},{comment_id:2,user_id:2, user_name:'小疯子2',user_head:'img/user_head/2.jpg',comment_text:'555',comment_time:"2019-12-04 20:01"}]},
	// 		{floor_id:2,user_id:2, user_name:'小疯子2',user_head:'img/user_head/6.jpg',floor_text:'666',floor_time:"2019-12-04 20:01",comments:[{comment_id:1,user_id:1, user_name:'小疯子',user_head:'img/user_head/1.jpg',comment_text:'666',comment_time:"2019-12-04 20:01"},{comment_id:2,user_id:2, user_name:'小疯子2',user_head:'img/user_head/2.jpg',comment_text:'555',comment_time:"2019-12-04 20:01"}]},
	// 		{floor_id:3,user_id:3, user_name:'小疯子',user_head:'img/user_head/3.jpg',floor_text:'666',floor_time:"2019-12-04 20:01",comments:[{comment_id:1,user_id:1, user_name:'小疯子',user_head:'img/user_head/1.jpg',comment_text:'666',comment_time:"2019-12-04 20:01"}]},
	// 		{floor_id:4,user_id:1, user_name:'小疯子',user_head:'img/user_head/1.jpg',floor_text:'666',floor_time:"2019-12-04 20:01",comments:[]}
	// 	];
	var comments=${str2};
	var floors = ${str1};
	var pages = 2;


	var page = 1;
	if (window != top) 	top.location.href = location.href; //让iframe中的跳转转换成主页跳转



	// 绑定该帖子的楼层数据和方法
	const V_floors=new Vue({
		// el:'#resource_one',
		el:'#floors',
		data:{
			cur_post:post,
			cur_comments: comments,
			floorList:floors,

			currentPage: 1,
			TotalPage: pages*10,
			Content:['','','','','','','','','','']
		},
		methods:{
			// 设置点击回复的点击事件
			handleClick(index) {
				console.log(index);
				if($(".floor_comments").eq(index).css("display")=="none")
				{
					$(".floor_comments").eq(index).css("display","block");
				}
				else
					$(".floor_comments").eq(index).css("display","none");
			},

			handleCurrentChange(val) {
				console.log(`当前页: ${val}`);
				// 设置页码的跳转路径，携带点击的页码数
				var link ="post.html?post_id="+this.cur_post.PostId+"&page="+val;
				window.parent.location.href=link;
			},
			login(){
				var link ="login.jsp";
				window.parent.location.href=link;
			},

			onSubmit(item,index){
				// 	var link ="PinglunServlet?post_id="+this.cur_post.post_id+"&floor_id="+item.post_stprey_id+"&content="+this.Content+"&post_from_name="+this.item.post_from_name+"&post_from_uid="+this.item.post_from_uid;
				var link ="PinglunServlet?post_id="+this.cur_post.post_id+"&floor_id="+item.post_stprey_id+"&content="+this.Content[index];
				window.parent.location.href=link;
			}

		}

	})

	// 绑定发楼层数据和方法
	const flooring=new Vue({
		// el:'#resource_one',
		el:'#posting',

		data:{
			Content:"",
			cur_post:post
		},
		methods:{
			onSubmit() {

				// 设置评论的参数（未传递楼层参数则要创建新楼层）
				var link ="gailouServlet?post_id="+this.cur_post.post_id+"&content="+this.Content;
				window.parent.location.href=link;
			},
			login(){
				var link ="login.jsp";
				window.parent.location.href=link;
			}

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
		V_floors.currentPage=page;
	});
</script>
</html>