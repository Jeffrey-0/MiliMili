<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="zh-cn">

<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>后台管理</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="css/all.min.css" rel="stylesheet" type="text/css">
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.bundle.min.js" type="text/javascript"></script>
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
                            <li class="breadcrumb-item active" aria-current="page">管理员信息</li>
                        </ol>
                    </nav>
                </div>
                <div class="main-box">
                    <div class="row">
                        <div class="col-lg-3">
                            <div class="card border-left-primary mb-2">
                                <div class="card-body text-primary">
                                    <div class="align-items-center">
                                        <div class="row">
                                            <div class="col">
                                                <div class="text-xs">名称</div>
                                                <div class="h5 font-weight-bold">${admin.username }</div>
                                            </div>
                                            <div class="col text-right">
                                                <i class="fas fa-user fa-2x py-2"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3">
                            <div class="card border-left-success mb-2">
                                <div class="card-body text-success">
                                    <div class="align-items-center">
                                        <div class="row">
                                            <div class="col">
                                                <div class="text-xs">管理员ID</div>
                                                <div class="h5 font-weight-bold">${admin.id}</div>
                                            </div>
                                            <div class="col text-right">
                                                <i class="fas fa-tags fa-2x py-2"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
<%--                        <div class="col-lg-3">--%>
<%--                            <div class="card border-left-info mb-2">--%>
<%--                                <div class="card-body text-info">--%>
<%--                                    <div class="align-items-center">--%>
<%--                                        <div class="row">--%>
<%--                                            <div class="col">--%>
<%--                                                <div class="text-xs">学习资源数量</div>--%>
<%--                                                <div class="h5 font-weight-bold">${Resource.totalResource }</div>--%>
<%--                                            </div>--%>
<%--                                            <div class="col text-right">--%>
<%--                                                <i class="fas fa-box fa-2x py-2"></i>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="col-lg-3">--%>
<%--                            <div class="card border-left-danger mb-2">--%>
<%--                                <div class="card-body text-danger">--%>
<%--                                    <div class="align-items-center">--%>
<%--                                        <div class="row">--%>
<%--                                            <div class="col">--%>
<%--                                                <div class="text-xs">学习资源种类数量</div>--%>
<%--                                                <div class="h5 font-weight-bold">${Category.countCategory }</div>--%>
<%--                                            </div>--%>
<%--                                            <div class="col text-right">--%>
<%--                                                <i class="fas fa-cube fa-2x py-2"></i>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="col-lg-3">--%>
<%--                            <div class="card border-left-primary mb-2">--%>
<%--                                <div class="card-body text-primary">--%>
<%--                                    <div class="align-items-center">--%>
<%--                                        <div class="row">--%>
<%--                                            <div class="col">--%>
<%--                                                <div class="text-xs">用户数量</div>--%>
<%--                                                <div class="h5 font-weight-bold">${User.totalRecord }</div>--%>
<%--                                            </div>--%>
<%--                                            <div class="col text-right">--%>
<%--                                                <i class="fas fa-user fa-2x py-2"></i>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="col-lg-3">--%>
<%--                            <div class="card border-left-success mb-2">--%>
<%--                                <div class="card-body text-success">--%>
<%--                                    <div class="align-items-center">--%>
<%--                                        <div class="row">--%>
<%--                                            <div class="col">--%>
<%--                                                <div class="text-xs">帖子数量</div>--%>
<%--                                                <div class="h5 font-weight-bold">${Posting.totalPosting }</div>--%>
<%--                                            </div>--%>
<%--                                            <div class="col text-right">--%>
<%--                                                <i class="fas fa-tags fa-2x py-2"></i>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
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
</html>