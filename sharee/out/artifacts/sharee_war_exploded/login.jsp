<!DOCTYPE HTML>
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Home</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<meta name="author" content="" />
  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="assets2/css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="assets2/css/icomoon.css">
	<!-- Themify Icons-->
	<link rel="stylesheet" href="assets2/css/themify-icons.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="assets2/css/bootstrap.css">

	<!-- Magnific Popup -->
	<link rel="stylesheet" href="assets2/css/magnific-popup.css">

	<!-- Owl Carousel  -->
	<link rel="stylesheet" href="assets2/css/owl.carousel.min.css">
	<link rel="stylesheet" href="assets2/css/owl.theme.default.min.css">

	<!-- Theme style  -->
	<link rel="stylesheet" href="assets2/css/style.css">

	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body>
		
	<div class="gtco-loader"></div>
	
	<div id="page">

	
	<div class="page-inner">
	
	<header id="gtco-header" class="gtco-cover" role="banner" style="background-image: url(assets2/images/img_4.jpg)">
		<div class="overlay"></div>
		<div class="gtco-container">
			<div class="row">
				<div class="col-md-12 col-md-offset-0 text-left">
					

					<div class="row row-mt-15em">
						<div class="col-md-7 mt-text animate-box" data-animate-effect="fadeInUp">
							<span class="intro-text-small">Welcome to Webstore</span>
						</div>
						<div class="col-md-4 col-md-push-1 animate-box" data-animate-effect="fadeInRight">
							<div class="form-wrap">
								<div class="tab">
									<ul class="tab-menu">
										<li class="active gtco-first"><a href="#" data-tab="signup">Sign up</a></li>
										<li class="gtco-second"><a href="#" data-tab="login">Login</a></li>
									</ul>
									<div class="tab-content">
										<div class="tab-content-inner active" data-content="signup">
											<form action="UserRegisterServlet" method="post">
												<div class="row form-group">
													<div class="col-md-12">
														<label for="id">id</label>
														<input type="text" class="form-control" name="id">
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
														<label >UserName</label>
														<input type="text" class="form-control" name="username">
													</div>
												</div>
												
												<div class="row form-group">
													<div class="col-md-12">
														<label >SelfDescn</label>
														<input type="text" class="form-control" name="selfdescn">
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
														<label >Phonenumber</label>
														<input type="text" class="form-control" name="Phonenumber">
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
														<label for="password">Password</label>
														<input type="password" class="form-control" name="password">
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
														<label for="password2">Repeat Password</label>
														<input type="password" class="form-control" name="password2">
													</div>
												</div>

												<div class="row form-group">
													<div class="col-md-12">
														<input type="submit" class="btn btn-primary" value="Sign up">
													</div>
												</div>
											</form>	
										</div>

										<div class="tab-content-inner" data-content="login">
											<form action="UserLoginServlet" method="post">
												<div class="row form-group">
													<div class="col-md-12">
														<label for="username">Username</label>
														<input type="text" class="form-control" name="id">
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
														<label for="password">Password</label>
														<input type="password" class="form-control" name="password">
													</div>
												</div>

												<div class="row form-group">
													<div class="col-md-12">
														<input type="submit" class="btn btn-primary" value="Login">
<%--														<input type="text" class="btn btn-primary" value="Login">--%>
														<a href="forget.jsp" class="btn btn-primary" style="display: inline-block;margin-left: 50px;color:#FFFFFF" value="Forget">Forget</a>
<%--														<li>--%>
<%--															<a href="forget.jsp">Forget</a>--%>

<%--														</li>--%>

													</div>
												</div>




											</form>
<%--											<div class="row form-group">--%>
<%--												<div class="col-md-12">--%>
<%--&lt;%&ndash;													<input type="button" class="btn btn-primary" value="Forget">&ndash;%&gt;--%>
<%--													<a herf="forget.jsp"><input type=button onclick="window.location.href('连接')"></a>--%>
<%--	--%>
<%--												</div>--%>
<%--											</div>--%>




										</div>

									</div>
								</div>
							</div>
						</div>
					</div>
							
					
				</div>
			</div>
		</div>
	</header>

	</div>

	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>
	
	<!-- jQuery -->
	<script src="assets2/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="assets2/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="assets2/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="assets2/js/jquery.waypoints.min.js"></script>
	<!-- Carousel -->
	<script src="assets2/js/owl.carousel.min.js"></script>
	<!-- countTo -->
	<script src="assets2/js/jquery.countTo.js"></script>
	<!-- Magnific Popup -->
	<script src="assets2/js/jquery.magnific-popup.min.js"></script>
	<script src="assets2/js/magnific-popup-options.js"></script>
	<!-- Main -->
	<script src="assets2/js/main.js"></script>

	</body>
</html>

