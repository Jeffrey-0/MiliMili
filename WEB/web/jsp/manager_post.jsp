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
    <title>评论总览</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/all.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/sweetalert2.all.min.js"></script>
    <script src="js/main.js"></script>
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
                            <li class="breadcrumb-item"><a
                                    href="${pageContext.request.contextPath }/AdminServlet?method=indexJsp">首页</a></li>
                            <li class="breadcrumb-item active" aria-current="page">评论总览</li>
                        </ol>
                    </nav>
                </div>
                <div class="main-box">
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">
<%--                                    <div class="btn-box">--%>
                                        <button type="button" class="btn btn-danger m-2" disabled style="float: right" onclick="allDelete('${pageContext.request.contextPath }/AdminServlet?method=deleteSelectPost');" id="allDelete">删除选中</button>
<%--                                    </div>--%>
                                    <div class="table-responsive-xl">
                                        <table class="table table-striped">
                                            <thead>
                                            <tr>
                                                <th scope="col"><input type="checkbox" onclick="checkSelect(this);" id="selectAll"></th>
                                                <th scope="col">评论ID</th>
                                                <th scope="col">楼层</th>
                                                <th scope="col">评论者ID</th>
                                                <th scope="col">被评论者ID</th>
                                                <th scope="col">评论内容</th>
                                                <th scope="col">日期</th>
                                                <th scope="col">评论者名称</th>
                                                <th scope="col">被评论者名称</th>
                                            </tr>
                                            </thead>
                                            <c:forEach items="${pageInfo.postList}" var="post">
                                                <tbody>
                                                <tr>
                                                    <th scope="row"><input type="checkbox" name="id" onclick="checkSelect(this);" value="${post.id }"></th>
                                                    <td>${post.post_id}</td>
                                                    <td>${post.post_stprey_id}</td>
                                                    <td>${post.post_from_uid}</td>
                                                    <td>${post.post_to_uid}</td>
                                                    <td>${post.post_content}</td>
                                                    <td>${post.post_date}</td>
                                                    <td>${post.post_from_name}</td>
                                                    <td>${post.post_to_name}</td>
                                                    <td>
                                                        <button type="button" class="btn btn-danger" onclick="btnClick(${post.id },'${pageContext.request.contextPath }/AdminServlet?method=deletePost&postID=${post.id}')">删除</button>
                                                    </td>
                                                </tr>
                                                </tbody>
                                            </c:forEach>
                                        </table>
                                        <nav class="mt-3">
                                            <ul class="pagination justify-content-end">
                                                <c:if test="${pageInfo.currentPage>1 }">
                                                <li class="page-item"><a class="page-link"
                                                                         href="${pageContext.request.contextPath }/AdminServlet?method=postManageJsp&currentPage=1">首页</a>
                                                </li>
                                                <li class="page-item"><a class="page-link"
                                                                         href="${pageContext.request.contextPath }/AdminServlet?method=postManageJsp&currentPage=${pageInfo.currentPage-1}">上一页</a>
                                                    </c:if>
                                                    <c:forEach begin="${pageInfo.beginPage}"
                                                               end="${pageInfo.endPage }" varStatus="status">
                                                    <!-- 判断 -->
                                                    <c:if test="${pageInfo.currentPage eq status.index}">
                                                <li class="page-item active"><a class="page-link"
                                                                                tabindex="-1" aria-disabled="true">${status.index}</a></li>
                                                </c:if>
                                                <c:if test="${pageInfo.currentPage ne status.index}">
                                                    <li class="page-item "><a class="page-link"
                                                                              href="${pageContext.request.contextPath }/AdminServlet?method=postManageJsp&currentPage=${status.index}"
                                                                              tabindex="-1" aria-disabled="true">${status.index}</a></li>
                                                </c:if>

                                                </c:forEach>
                                                <c:if test="${pageInfo.currentPage < pageInfo.totalPages }">
                                                    <li class="page-item"><a class="page-link"
                                                                             href="${pageContext.request.contextPath }/AdminServlet?method=postManageJsp&currentPage=${pageInfo.currentPage+1}">下一页</a>
                                                    <li class="page-item"><a class="page-link"
                                                                             href="${pageContext.request.contextPath }/AdminServlet?method=postManageJsp&currentPage=${pageInfo.totalPages}">尾页</a>
                                                    </li>
                                                </c:if>
                                            </ul>
                                        </nav>
                                    </div>
                                </div>
                            </div>
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
</html>