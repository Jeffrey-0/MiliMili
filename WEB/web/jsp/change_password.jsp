<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="zh-cn">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>管理员设置</title>
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/all.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/style.css"	rel="stylesheet">
<script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
<script	src="${pageContext.request.contextPath }/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath }/js/sweetalert2.all.min.js"></script>
<script src="${pageContext.request.contextPath }/js/main.js"></script>
</head>

<body>
	<div class="wrapper">
		<div class="container-fluid">
			<div class="sidebar-scroll">
				<div class="sidebar-auto">
					<h5 class="text-center m-4">
						<a href="${pageContext.request.contextPath }/AdminServlet?method=indexJsp">后台管理</a>
					</h5>
					<ul class="menu">
						<li>
							<a href="${pageContext.request.contextPath }/AdminServlet?method=indexJsp">
								<i class="fas fa-tachometer-alt mr-2"></i> <span>首页</span>
							</a></li>
						<li>
							<a href="${pageContext.request.contextPath }/AdminServlet?method=userManageJsp">
								<i class="fas fa-user mr-2"></i> <span>用户管理</span></a>
						</li>
						<li class="collapse-li"><a href="#collapseResource" data-toggle="collapse" aria-haspopup="true" aria-expanded="false" class="collapsed"> <i class="fas fa-box mr-2"></i> <span>电影资源管理</span>
							<i class="fas fa-angle-down"></i>
						</a>
							<div class="collapse" id="collapseResource">
								<div class="card card-body">
									<a class="collapse-item text-center" href="${pageContext.request.contextPath }/AdminServlet?method=resourceManageJsp">管理电影资源</a>
								</div>
							</div></li>
						<li class="collapse-li"><a href="#collapseCategory" data-toggle="collapse" aria-haspopup="true" aria-expanded="false" class="collapsed"> <i class="fas fa-cube mr-2"></i> <span>分类设置</span>
							<i class="fas fa-angle-down"></i>
						</a>
							<div class="collapse" id="collapseCategory">
								<div class="card card-body">
									<a class="collapse-item text-center" href="${pageContext.request.contextPath }/AdminServlet?method=categoryManageJsp">分类总览</a>
								</div>
							</div></li>
						<li class="collapse-li"><a href="#collapsePost" data-toggle="collapse" aria-haspopup="true" aria-expanded="false" class="collapsed"> <i class="fas fa-box mr-2"></i> <span>帖子管理</span>
							<i class="fas fa-angle-down"></i>
						</a>
							<div class="collapse" id="collapsePost">
								<div class="card card-body">
									<a class="collapse-item text-center" href="${pageContext.request.contextPath }/AdminServlet?method=postingManageJsp">帖子管理</a>
									<a class="collapse-item text-center" href="${pageContext.request.contextPath }/AdminServlet?method=postManageJsp">评论管理</a>
								</div>
							</div>
						</li>
						<li class="collapse-li"><a href="#collapseAdmin" data-toggle="collapse" aria-haspopup="true" aria-expanded="false" class="collapsed"> <i class="fas fa-cube mr-2"></i> <span>管理员设置</span>
							<i class="fas fa-angle-down"></i>
						</a>
							<div class="collapse" id="collapseAdmin">
								<div class="card card-body">
									<a class="collapse-item text-center" href="${pageContext.request.contextPath }/AdminServlet?method=adminManageJsp">管理员总览</a>
									<a class="collapse-item text-center" href="${pageContext.request.contextPath }/AdminServlet?method=changePasswordJsp">密码修改</a>
								</div>
							</div></li>
						<li><a href="${pageContext.request.contextPath }/MainServlet" onclick="return confirm('确定退出登录?')"> <i class="fas fa-sign-out-alt mr-2"></i> <span>退出</span>
						</a></li>
					</ul>
				</div>
			</div>
			<div class="main-content">
				<div class="container-fluid">
					<div class="nav-box">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="${pageContext.request.contextPath }/AdminServlet?method=indexJsp">首页</a></li>
								<li class="breadcrumb-item active" aria-current="page">密码修改</li>
							</ol>
						</nav>
					</div>
					<div class="form-box col-6">
						<div class="row">
							<div class="col-12 p-2">
								<form class="m-2" id="form1">
									<div class="form-group">
										<label for="password">新密码</label> <input type="password"
											class="form-control" placeholder="" name="password"
											id="password">
									</div>
									<div class="form-group">
										<label for="password2">再次输入新密码</label> <input type="password"
											class="form-control" placeholder="" name="password2"
											id="password2">
									</div>
									<a href="javascript:" class="btn btn-primary" id="formBtn" type="submit">确认修改</a>
								</form>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
		<div class="footer footer-margin">
			<p class="text-center my-1">© 2019 All Rights Reserved.</p>
		</div>
	</div>
</body>
<script>
	$('#formBtn').click(function() {
		if (checkPwd()) {
			$.ajax({
				type : "post",
				url : "AdminServlet?method=changePassword",
				data : $('#form1').serialize(),
				dataType: "json",
				success : function(response) {
					//密码错误
					/* alert(response.status); */
					if (response.status === "0") {
						Swal.fire({
							type : 'error',
							title : response.message,
							confirmButtonColor : '#007bff',
							confirmButtonText : '确认!'
						})
					}
					if (response.status === "1") {
						Swal.fire({
							type : 'success',
							title : '修改成功',
							confirmButtonColor : '#007bff',
							confirmButtonText : '确认!'
						})
						//修改成功就跳转
						alert("身份已过期，请重新登录");
						if (response.redirect) {
							window.location.replace("/MainServlet");
						}
					}

				},
				error : function() {
					Swal.fire({
						type : 'error',
						title : '服务器错误',
						confirmButtonColor : '#007bff',
						cancelButtonColor : '#dc3545',
						confirmButtonText : '确认!'
					})
				}
			})
		}
	});
</script>
</html>