<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>添加/编辑学生</title>

		<meta name="description" content="Static &amp; Dynamic Tables" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jquery-ui.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap-datepicker3.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jquery-ui.custom.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/chosen.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap-timepicker.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/daterangepicker.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap-datetimepicker.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap-colorpicker.min.css" />

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

		<div id="navbar" style="height: auto" class="navbar navbar-default          ace-save-state">
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

					<li class="">
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

					<li class="active open">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-list"></i>
							<span class="menu-text"> 学生管理 </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="active">
								<a href="${pageContext.request.contextPath}/index.do" target="">
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
							<li class="active">添加/编辑学生信息</li>
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
								添加/编辑学生信息
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
										<form id="form-student" class="form-horizontal" action="${pageContext.request.contextPath}/student/save.do" role="form" enctype="multipart/form-data" method="post">

											<%--学生id隐藏域--%>
												<div class="form-group">
													<div class="col-sm-9">
														<input type="hidden" id="form-id" value="${student.id}" name="id" class="col-xs-10 col-sm-5" />
													</div>
												</div>

											<div class="form-group">
												<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 学生姓名 </label>

												<div class="col-sm-9">
													<input type="text" id="form-field-1" value="${student.studentName}" name="studentName" placeholder="请输入学生的名字..." class="col-xs-10 col-sm-5" />
												</div>
											</div>

											<div class="form-group">
												<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 学生学号 </label>

												<div class="col-sm-9">
													<input type="text" id="form-field-2" value="${student.studentNum}" name="studentNum" placeholder="请输入学生的学号..." class="col-xs-10 col-sm-5" />
												</div>
											</div>

											<div class="form-group">
												<label class="col-sm-3 control-label no-padding-right" for="form-className"> 添加班级 </label>

												<div class="col-sm-9">
													<%--设计一个隐藏域，存放班级的名称信息，用于回显数据--%>
													<input type="hidden" id="className" value="${student.grade.className}">
													<select name="grade.id" id="form-className" placeholder="" class="col-xs-10 col-sm-5">
													<option value="">选择一个班级</option>
													</select>
												</div>
											</div>

											<div class="form-group">
												<label class="col-sm-3 control-label no-padding-right" for="datePicker"> 出生日期 </label>

												<div class="col-sm-9">
													<input type="text" id="datePicker" value="${student.birthday}" name="birthday" placeholder="请选择您的出生日期..." class="col-xs-10 col-sm-5" data-date-format="yyyy/mm/dd"/>
												</div>
											</div>

											<!-- 性别 -->
											<div class="form-group">
												<label class="col-sm-3 control-label no-padding-right" for="form-gender"> 性别 </label>

												<div class="col-sm-9">
													<select id="form-gender" name="gender">
														<c:if test="${student.gender==1}">
															<option value="1" selected="selected">男</option>
															<option value="0">女</option>
														</c:if>
														<c:if test="${student.gender==0}">
															<option value="0" selected="selected">女</option>
															<option value="1">男</option>
														</c:if>
														<c:if test="${student==null}">
															<option value="1" selected="selected">男</option>
															<option value="0">女</option>
														</c:if>

													</select>
												</div>
											</div>

											<div class="form-group">
												<label class="col-sm-3 control-label no-padding-right" for="form-picture"> 学生照片 </label>

												<div class="col-sm-3">
													<input type="file" id="form-picture" name="picture" />
												</div>
												<div class="col-sm-2">
													<img id="img" style="width:80px;height:60px;" src="${pageContext.request.contextPath}${student.picture}" alt="请选择一张图片">
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

		<!-- page specific plugin scripts -->
		<%--<script src="${pageContext.request.contextPath}/assets/js/buttons.flash.min.js"></script>--%>
		<%--<script src="${pageContext.request.contextPath}/assets/js/buttons.html5.min.js"></script>--%>
		<%--<script src="${pageContext.request.contextPath}/assets/js/buttons.print.min.js"></script>--%>
		<%--<script src="${pageContext.request.contextPath}/assets/js/buttons.colVis.min.js"></script>--%>

		<script src="${pageContext.request.contextPath}/assets/js/jquery-ui.custom.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/chosen.jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/spinbox.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/bootstrap-datepicker.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/bootstrap-timepicker.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/moment.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/bootstrap-datetimepicker.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/bootstrap-colorpicker.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/jquery.knob.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/autosize.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/jquery.inputlimiter.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/jquery.maskedinput.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/bootstrap-tag.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/jquery.validate.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/dataTables.buttons.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/buttons.flash.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/buttons.html5.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/buttons.print.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/buttons.colVis.min.js"></script>


		<!-- ace scripts -->
		<script src="${pageContext.request.contextPath}/assets/js/ace-elements.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/ace.min.js"></script>

		<!-- page specific plugin scripts -->



		<!-- inline scripts related to this page -->
		<script type="text/javascript">

            jQuery(function($) {
                /*private Integer id;
                private String studentName;
                //学号
                private String studentNum;
                //照片存储的是服务器上的地址值
                private String picture;
                //0代表女，1代表男
                private Integer gender ;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
                private Date birthday;*/
                //添加验证规则
                $("#form-student").validate({
                    rules:{
                        studentName:{required: true},
                        studentNum:{required: true,digits:true},
                        picture: "required",
                        birthday: {date:true}
                    },
                    messages:{
                        studentName:{required: '请输入您的姓名'},
                        studentNum:{required: '请输入您的邮箱', email: '请输入整数格式的学号'},
                        picture: "请上传您的图片信息",
                        birthday: "请输入正确的日期格式(yyyy/MM/dd)"
                    }
                });

                //实现图片的预览
                document.getElementById('form-picture').onchange = function() {
                    var imgFile = this.files[0];
                    var fr = new FileReader();
                    fr.onload = function() {
                        document.getElementById('img').src = fr.result;
                    };
                    fr.readAsDataURL(imgFile);
                };

				var className = $("#className").val();

            	//动态加载班级信息
            	$.post("${pageContext.request.contextPath}/grade/findAll.do",function(data){
            		//动态的为班级添加option选项信息
					//alert(data);
            		var classNameNode = $("#form-className");
            		//alert("classname")
            		for (var i = 0; i < data.length; i++) {
            			var obj = data[i];
            			//alert("neinei");
            			//同时需要回显班级
            			//var option = document.createElement("option");
            			//var textNode = document.createTextNode(obj.className);
            			//option.setAttribute("name",obj.id);
						if (className != null && className !="") {
                            if (className == obj.className) {
                                classNameNode.append('<option  selected="selected" value="'+obj.id+'">'+obj.className+'</option>');
                            } else {
                                classNameNode.append('<option value="'+obj.id+'">'+obj.className+'</option>');
                            }
						} else {
                            classNameNode.append('<option value="'+obj.id+'">'+obj.className+'</option>');

                        }

            		}

            	},"json");

				//设置日期控件显示
				$('#datePicker').datepicker({
					autoclose: true,
					todayHighlight: true
				})
				//show datepicker when clicking on the icon
				.next().on(ace.click_event, function(){
					$(this).prev().focus();
				});

				// 文件上传实现
				$('#form-picture').ace_file_input({
					no_file:'请上传您的照片...',
					btn_choose:'上传图片',
					btn_change:"Change",
					droppable:false,
					/*onchange:function(files, dropped){
                        //选择文件 展示之前的事件
                        //return true 保留当前文件; return false 不保留文件；return -1 重置文件框
                        //需要同步等待返回结果
                        alert(files[0].filename);
                        alert(files[0].fileName);
                        alert(files[0].file);
                        //alert(dropped);

                        return true;
                    },*/
					whitelist:'gif|png|jpg|jpeg',
					allowExt: ['gif','png','jpg','jpeg'], 
					thumbnail:false, //| true | large
					//whitelist:'gif|png|jpg|jpeg'
					//blacklist:'exe|php'
					//onchange:'':
                    /*before_change: function(files, dropped){
                        //选择文件 展示之前的事件
                        //return true 保留当前文件; return false 不保留文件；return -1 重置文件框
                        //需要同步等待返回结果
						/!*alert(files[0].filename);
                        alert(files[0].fileName);
                        alert(files[0].file);
						//alert(dropped);*!/

                        return true;
                    }*/
				}).on('file.error.ace', function(event, info) {
        			alert("请上传图片格式文件");
        			// $.confirm("ss","ddd");
        			//$("#dialog").dialog();
      			});

			});
            
			
				
		</script>
	</body>
</html>
