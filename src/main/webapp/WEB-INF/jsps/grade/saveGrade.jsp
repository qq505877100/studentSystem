<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>添加班级</title>

		<meta name="description" content="Static &amp; Dynamic Tables" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jquery-ui.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jquery-ui.custom.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/chosen.min.css" />

		<!-- text fonts -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/fonts.googleapis.com.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-rtl.min.css" />

		<script src="${pageContext.request.contextPath}/assets/js/ace-extra.min.js"></script>

	</head>

	<body class="no-skin">

		<div id="navbar" class="navbar navbar-default          ace-save-state">
			<div class="navbar-container ace-save-state" id="navbar-container">
				<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
					<span class="sr-only">Toggle sidebar</span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>
				</button>

				<div class="navbar-header pull-left">
					<a href="studentList.jsp" class="navbar-brand">
						<small style="align-content: center;">
							<i class="fa fa-leaf"></i>
							学生信息管理系统
						</small>
					</a>
				</div>

				<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav" style="height: auto">

						<li class="light-blue dropdown-modal">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="${pageContext.request.contextPath}/assets/images/avatars/user.jpg" alt="Jason's Photo" />
								<span class="user-info">
									<small>你好</small>
									欢迎！
								</span>

								<i class="ace-icon fa fa-caret-down"></i>
							</a>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="ace-icon fa fa-cog"></i>
										Settings
									</a>
								</li>

								<li>
									<a href="profile.html">
										<i class="ace-icon fa fa-user"></i>
										Profile
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="#">
										<i class="ace-icon fa fa-power-off"></i>
										Logout
									</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div><!-- /.navbar-container -->
		</div>

		<div class="main-container ace-save-state" id="main-container">
			<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
			</script>

			<div id="sidebar" class="sidebar responsive ace-save-state">
				<script type="text/javascript">
					try{ace.settings.loadState('sidebar')}catch(e){}
				</script>

				<ul class="nav nav-list">
					<li class="">
						<a href="#">
							<i class="menu-icon fa fa-tachometer"></i>
							<span class="menu-text"> 菜单栏 </span>
						</a>

						<b class="arrow"></b>
					</li>

					<li class="active open">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text">
								班级管理
							</span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">

	
							<li class="">
								<a href="${pageContext.request.contextPath}/grade/toGradeList.do">
									<i class="menu-icon fa fa-caret-right"></i>
									班级信息列表
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="${pageContext.request.contextPath}/grade/toSave.do">
									<i class="menu-icon fa fa-caret-right"></i>
									班级添加
								</a>

								<b class="arrow"></b>
							</li>
						</ul>
					</li>

					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-list"></i>
							<span class="menu-text"> 学生管理 </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="active">
								<a href="${pageContext.request.contextPath}/index.do">
									<i class="menu-icon fa fa-caret-right"></i>
									学生信息列表
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="${pageContext.request.contextPath}/student/toSave.do">
									<i class="menu-icon fa fa-caret-right"></i>
									添加学生信息
								</a>

								<b class="arrow"></b>
							</li>
						</ul>
					</li>

					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-list-alt"></i>
							<span class="menu-text"> 课程管理 </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a href="${pageContext.request.contextPath}/subject/toSubjectList.do">
									<i class="menu-icon fa fa-caret-right"></i>
									课程信息列表
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="${pageContext.request.contextPath}/subject/toSave.do">
									<i class="menu-icon fa fa-caret-right"></i>
									课程添加
								</a>

								<b class="arrow"></b>
							</li>

						</ul>
					</li>

					
					<li class="">
						<a href="#">
							<i class="menu-icon fa fa-picture-o"></i>
							<span class="menu-text"> Gallery </span>
						</a>

						<b class="arrow"></b>
					</li>

				</ul><!-- /.nav-list -->

				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>
			</div>




			<!-- 右边页面 -->
			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">

							<li>
								<a href="#">学生管理</a>
							</li>
							<li class="active">添加班级信息</li>
						</ul><!-- /.breadcrumb -->

						
					</div>

					<div class="page-content">
						<div class="ace-settings-container" id="ace-settings-container">
							<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
								<i class="ace-icon fa fa-cog bigger-130"></i>
							</div>

							<div class="ace-settings-box clearfix" id="ace-settings-box">
								<div class="pull-left width-50">
									<div class="ace-settings-item">
										<div class="pull-left">
											<select id="skin-colorpicker" class="hide">
												<option data-skin="no-skin" value="#438EB9">#438EB9</option>
												<option data-skin="skin-1" value="#222A2D">#222A2D</option>
												<option data-skin="skin-2" value="#C6487E">#C6487E</option>
												<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
											</select>
										</div>
										<span>&nbsp; Choose Skin</span>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" checked="checked" id="ace-settings-navbar" autocomplete="off" />
										<label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-sidebar" autocomplete="off" />
										<label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-breadcrumbs" autocomplete="off" />
										<label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" autocomplete="off" />
										<label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-add-container" autocomplete="off" />
										<label class="lbl" for="ace-settings-add-container">
											Inside
											<b>.container</b>
										</label>
									</div>
								</div><!-- /.pull-left -->

								<div class="pull-left width-50">
									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-hover" autocomplete="off" />
										<label class="lbl" for="ace-settings-hover"> Submenu on Hover</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-compact" autocomplete="off" />
										<label class="lbl" for="ace-settings-compact"> Compact Sidebar</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-highlight" autocomplete="off" />
										<label class="lbl" for="ace-settings-highlight"> Alt. Active Item</label>
									</div>
								</div><!-- /.pull-left -->
							</div><!-- /.ace-settings-box -->
						</div><!-- /.ace-settings-container -->

						<div class="page-header">
							<h1>
								添加班级信息
							</h1>
						</div><!-- /.page-header -->

						<!-- 设置一个添加学生按钮 -->
						<!-- <div class="breadcrumbs ace-save-state">
							<a href = '#'>
								<button class='btn btn-minier btn-primary no-radius'>
									<i class='ace-icon fa fa-pencil align-top'>
									</i>添加学生
								</button>
							</a>
						</div> -->

						<!-- 学生信息展示列表动态 使用jqGrid -->
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<!-- 注册表单 -->
										<form class="form-horizontal" action="${pageContext.request.contextPath}/grade/save.do" role="form" method="post">

											<div class="form-group">
												<div class="col-sm-7">
													<input type="hidden" id="form-id" value="${grade.id}" name="id" class="col-xs-10 col-sm-5" />
												</div>
											</div>

											<div class="form-group">
												<label class="col-sm-5 control-label no-padding-right" for="form-className"> 班级名称 </label>

												<div class="col-sm-7">
													<input type="text" id="form-className" value="${grade.className}" name="className" placeholder="请输入班级的名称..." class="col-xs-10 col-sm-5" /><span id="className"></span>
												</div>
											</div>

											<div class="space-4"></div>

											<div class="space-4"></div>

											<div >
												<div class="col-md-offset-5 col-md-7">
													<button class="btn btn-info" type="submit">
														<i class="ace-icon fa fa-check bigger-110"></i>
														保存
													</button>

													&nbsp; &nbsp; &nbsp;
													<button class="btn" type="reset">
														<i class="ace-icon fa fa-undo bigger-110"></i>
														重置
													</button>
												</div>
											</div>
								</form>
							</div>
						</div>
						
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->

		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script src="${pageContext.request.contextPath}/assets/js/jquery-2.1.4.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
		<script src="${pageContext.request.contextPath}/assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='${pageContext.request.contextPath}/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>


		<script src="${pageContext.request.contextPath}/assets/js/jquery-ui.custom.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/chosen.jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/spinbox.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/moment.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/jquery.knob.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/autosize.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/bootstrap-tag.min.js"></script>


		<!-- ace scripts -->
		<script src="${pageContext.request.contextPath}/assets/js/ace-elements.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/ace.min.js"></script>

		<!-- page specific plugin scripts -->



		<!-- inline scripts related to this page -->
		<script type="text/javascript">

            jQuery(function($) {
				//给班级添加一个失焦事件，用于查看班级名称是否有存在的

				$("#form-className").blur(function () {

					var classNameValidNode = $("#className");
					var className = $("#form-className").val();

					$.post("${pageContext.request.contextPath}/grade/testClassName.do",{"className":className},function (data) {

						if (data.classExist == "1"){
						    //存在，提示用户
                            $("#className").val("该班级名称已存在");
						} else {
                            $("#className").val("该班级名称可用");
                            //classNameValidNode.attr("style","color:green");
						}
                    },"json");
                });
            	//动态加载班级信息

				// 文件上传实现

			});

		</script>
	</body>
</html>
