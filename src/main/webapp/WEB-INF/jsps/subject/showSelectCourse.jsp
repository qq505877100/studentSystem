<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>学生选课管理</title>

		<meta name="description" content="Static &amp; Dynamic Tables" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jquery-ui.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap-datepicker3.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ui.jqgrid.min.css" />

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

				<div class="navbar-buttons navbar-header  pull-right" role="navigation">
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
							<li class="active">学生选课信息列表</li>
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
								${student.studentName}课程信息列表展示
							</h1>
						</div><!-- /.page-header -->

						<!-- 学生信息展示列表动态 使用jqGrid -->
						<div class="row">
							<div class="col-xs-12">

								<table id="grid-table"></table>
								<%--这是一个存放选课/退课是否成功标志的div--%>
									<div>
										<input type="hidden" id="selectedCourse" value="${flag.selectedCourse}">
										<input type="hidden" id="unBindingCourse" value="${flag.unBindingCourse}">
										<input type="hidden" id="studentId" value="${student.id}">
									</div>

								<div id="grid-pager"></div>

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
						
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
		<script src="${pageContext.request.contextPath}/assets/js/jquery.dataTables.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/jquery.dataTables.bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/dataTables.buttons.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/buttons.flash.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/buttons.html5.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/buttons.print.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/buttons.colVis.min.js"></script>


		<!-- ace scripts -->
		<script src="${pageContext.request.contextPath}/assets/js/ace-elements.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/ace.min.js"></script>

		<!-- page specific plugin scripts -->
		<script src="${pageContext.request.contextPath}/assets/js/bootstrap-datepicker.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/jquery.jqGrid.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/grid.locale-en.js"></script>



		<!-- inline scripts related to this page -->
		<script type="text/javascript">




			//初始化jqGRID 控件
			jQuery(function($) {
				var grid_selector = "#grid-table";
				var pager_selector = "#grid-pager";

                var unBindCourse = $("#unBindingCourse").val();
                //设置是否退课成功提示
				if (unBindCourse == "0") {
                    alert("退课失败！！！")
                } else if (unBindCourse == "1"){
                    alert("退课成功！！！");
                }


                //判断是否选课成功，进行提示
                var selectedCourse = $("#selectedCourse").val();
                //alert(selectedCourse);
                if (selectedCourse == "") {

                }else if (selectedCourse == "0") {
                    alert("选课失败")
                } else if (selectedCourse == "1"){
                    alert("选课成功！！！");
                }

				//获取学生id
				var studentId = $("#studentId").val();
				
				
				var parent_column = $(grid_selector).closest('[class*="col-"]');
				//resize to fit page size 调整大小适应页面大小
				$(window).on('resize.jqGrid', function () {
					$(grid_selector).jqGrid( 'setGridWidth', parent_column.width() );
			    })
				
				//resize on sidebar collapse/expand
				$(document).on('settings.ace.jqGrid' , function(ev, event_name, collapsed) {
					if( event_name === 'sidebar_collapsed' || event_name === 'main_container_fixed' ) {
						//setTimeout is for webkit only to give time for DOM changes and then redraw!!!
						setTimeout(function() {
							$(grid_selector).jqGrid( 'setGridWidth', parent_column.width() );
						}, 20);
					}
			    })
				
				//if your grid is inside another element, for example a tab pane, you should use its parent's width:
				/**
				$(window).on('resize.jqGrid', function () {
					var parent_width = $(grid_selector).closest('.tab-pane').width();
					$(grid_selector).jqGrid( 'setGridWidth', parent_width );
				})
				//and also set width when tab pane becomes visible
				$('#myTab a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
				  if($(e.target).attr('href') == '#mygrid') {
					var parent_width = $(grid_selector).closest('.tab-pane').width();
					$(grid_selector).jqGrid( 'setGridWidth', parent_width );
				  }
				})
				*/
				
				
			
			
			
				jQuery(grid_selector).jqGrid({
					//direction: "rtl",
			
					//subgrid options 是否打开子网选项
					subGrid : false,
					//subGridModel: [{ name : ['No','Item Name','Qty'], width : [55,200,80] }],
					//datatype: "xml",
					//for this example we are using local data
					
					//设置提交的url
					//url: "http://localhost:8080/student/findAll.do",
					url: "${pageContext.request.contextPath}/subject/getSelectCourseMessage.do?studentId=" + studentId,
					//设置提交的方式
					mtype: "post",
					//使用本地数据显示
					//data: grid_data,
					//服务器端返回的数据类型
					datatype: "json",
					height: 300,
					//展示给用户看的头行列,这里的''代表的是删除和编辑按钮
					//colNames:['id','picture','学号','姓名', '性别', '出生日期','所在班级','选修科目数','平均分','分数录入','选课','操作'],
					colModel:[
						
						{label: "selectFlag",name:'selectFlag',hidden: true,index:'selectFlag', width:60, sorttype:"int", editable: false},
						{label: "state",name:'state',hidden: true,index:'state', width:60, sorttype:"int", editable: false},
						{label: "studentId",name:'studentId',hidden: true,index:'studentId', width:60, sorttype:"int", editable: false},
						{label: "subjectId",name:'subjectId',hidden: true,index:'subjectId', width:60, sorttype:"int", editable: false},
						{label: "课程名称",name:'subjectName',index:'subjectName',width:100, editable:true,sortable:false},
						{label: "课程人数上限",name:'limitStu',index:'limitStu', width:100,editable: true,editoptions:{size:"20",maxlength:"30"}},
						{label: "已选",name:'totalStus',index:'totalStus', width:50, editable: true},
                        {label: "操作",name:'operation',search:false,index:'', width:80, fixed:true, sortable:false, resize:false,
                            formatter:operations
                        }
					], 
					//设置传递到后台的数据格式
					jsonReader : {   
						//每页显示页数
					     root: "rows",
					      //当前页数
					     page: "page",
					       
					     total: "totalPages",
					       
					     records: "totalElements",
					       
					     repeatitems: false,
					       
					     cell: "cell", 
					       
					     id: "id"

					},  

					//定义是否要显示总记录数
					viewrecords : true,
					rowNum:10,
					rowList:[10,20,30],
					pager : pager_selector,
					altRows: true,
					//toppager: true,
					
					multiselect: true,
					//multikey: "ctrlKey",
			        multiboxonly: true,
			
					loadComplete : function() {
						var table = this;
						setTimeout(function(){
							styleCheckbox(table);
							
							updateActionIcons(table);
							updatePagerIcons(table);
							enableTooltips(table);
						}, 0);
					},
					//当返回的行信息为0时显示的信息
					//emptyrecords: "没有查询到相关记录，请重新查询！",
					//编辑信息提交的地址
					//editurl: "${pageContext.request.contextPath}/student/update.do",//nothing is saved
					//editurl: "${pageContext.request.contextPath}/student/update.do",
					caption: "课程信息列表",
					//显示行号
					rownumbers: true
			
					//,autowidth: true,
			
			
					/**
					,
					grouping:true, 
					groupingView : { 
						 groupField : ['name'],
						 groupDataSorted : true,
						 plusicon : 'fa fa-chevron-down bigger-110',
						 minusicon : 'fa fa-chevron-up bigger-110'
					},
					caption: "Grouping"
					*/
			
				});
				$(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size









                //给选课或者退课功能一个按钮,
                function operations(cellvalue, options, rowObject) {
                    var studentId = rowObject.studentId;
                    var subjectId = rowObject.subjectId;
                    var state = rowObject.state;
                    var selectFlag = rowObject.selectFlag;

                    var html;
                    if (selectFlag == "1") {
                        //说明已选择了该课程，设置为退课状态；
                        html = "<a href = '${pageContext.request.contextPath}/subject/unBindingCourse.do?studentId="+ studentId +"&subjectId="+subjectId+"'>"+"<button class='btn btn-minier btn-danger no-radius'><i class='ace-icon fa fa-pencil align-top'></i>退课</button></a>";

                    } else {
                        //设置为选课状态
                        if (state) {
                            html = "<a href = '${pageContext.request.contextPath}/subject/selectCourse.do?studentId="+ studentId +"&subjectId="+subjectId+"'>"+"<button class='btn btn-minier btn-primary no-radius'><i class='ace-icon fa fa-pencil align-top'></i>选课</button></a>";
                        }/* else {
                        html = "<a href = 'javascript:alert("+"\"\""+")'>"+"<button class='btn btn-minier btn-primary no-radius'><i class='ace-icon fa fa-pencil align-top'></i>选课</button></a>";
                    	}*/
					}


                    <%--/*"<a href='<%=request.getContextPath()%>/Admin/editProvider/" + rowdata.providerId + "' class='ui-icon ui-icon-pencil' ></a>";*/--%>
                    return html;
                };

                /*//实现编辑学生功能，这个方法应该定义在外部不然onclick方法无法调用局部函数
                function editStudent(obj) {
                    //alert(obj.name);
                    console.log(obj.name);
                }

                function delStudent(rowId) {
                    //alert(rowId);
                    console.log(rowId);
                }*/

				//switch element when editing inline
				function aceSwitch( cellvalue, options, cell ) {
					setTimeout(function(){
						$(cell) .find('input[type=checkbox]')
							.addClass('ace ace-switch ace-switch-5')
							.after('<span class="lbl"></span>');
					}, 0);
				}
				//enable datepicker
				function pickDate( cellvalue, options, cell ) {
					setTimeout(function(){
						$(cell) .find('input[type=text]')
							.datepicker({format:'yyyy/mm/dd' , autoclose:true}); 
					}, 0);
				}
			
			
				//navButtons
				jQuery(grid_selector).jqGrid('navGrid',pager_selector,
					{ 	//navbar options
						//这里设置添加，编辑，删除等功能图标
						edit: false,
						editicon : 'ace-icon fa fa-pencil blue',
						add: false,
						addicon : 'ace-icon fa fa-plus-circle purple',
						del: false,
						delicon : 'ace-icon fa fa-trash-o red',
						search: true,
						searchicon : 'ace-icon fa fa-search orange',
						refresh: false,
						refreshicon : 'ace-icon fa fa-refresh green',
						view: false,
						viewicon : 'ace-icon fa fa-search-plus grey',
					},
					/*{
						//edit record form
						//closeAfterEdit: true,
						//width: 700,
						//编辑功能的相关设置
						recreateForm: true,
						beforeShowForm : function(e) {
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_edit_form(form);
						}
					},*/
					/*{
						//new record form
						//width: 700,
						closeAfterAdd: true,
						recreateForm: true,
						viewPagerButtons: false,
						beforeShowForm : function(e) {
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar')
							.wrapInner('<div class="widget-header" />')
							style_edit_form(form);
						}
					},*/
					/*{
						//delete record form
						recreateForm: true,
						beforeShowForm : function(e) {
							var form = $(e[0]);
							if(form.data('styled')) return false;
							
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_delete_form(form);
							
							form.data('styled', true);
						},
						onClick : function(e) {
							//alert(1);
						}
					},*/
                    /*{
                        //view record form
                        recreateForm: true,
                        //这里的e可能是选择的row
                        beforeShowForm: function(e){
                            var form = $(e[0]);
                            form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
                        }
                    },*/
					{
						//search form
						recreateForm: true,
						afterShowSearch: function(e){
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
							style_search_form(form);
						},
						afterRedraw: function(){
							style_search_filters($(this));
						}
						,
						multipleSearch: true,
						/**
						multipleGroup:true,
						showQuery: true
						*/
					}

				)
			
			
				
				function style_edit_form(form) {
					//enable datepicker on "sdate" field and switches for "stock" field
					form.find('input[name=sdate]').datepicker({format:'yyyy-mm-dd' , autoclose:true})
					
					form.find('input[name=stock]').addClass('ace ace-switch ace-switch-5').after('<span class="lbl"></span>');
							   //don't wrap inside a label element, the checkbox value won't be submitted (POST'ed)
							  //.addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');
			
							
					//update buttons classes
					var buttons = form.next().find('.EditButton .fm-button');
					buttons.addClass('btn btn-sm').find('[class*="-icon"]').hide();//ui-icon, s-icon
					buttons.eq(0).addClass('btn-primary').prepend('<i class="ace-icon fa fa-check"></i>');
					buttons.eq(1).prepend('<i class="ace-icon fa fa-times"></i>')
					
					buttons = form.next().find('.navButton a');
					buttons.find('.ui-icon').hide();
					buttons.eq(0).append('<i class="ace-icon fa fa-chevron-left"></i>');
					buttons.eq(1).append('<i class="ace-icon fa fa-chevron-right"></i>');		
				}
			
				function style_delete_form(form) {
					var buttons = form.next().find('.EditButton .fm-button');
					buttons.addClass('btn btn-sm btn-white btn-round').find('[class*="-icon"]').hide();//ui-icon, s-icon
					buttons.eq(0).addClass('btn-danger').prepend('<i class="ace-icon fa fa-trash-o"></i>');
					buttons.eq(1).addClass('btn-default').prepend('<i class="ace-icon fa fa-times"></i>')
				}
				
				function style_search_filters(form) {
					form.find('.delete-rule').val('X');
					form.find('.add-rule').addClass('btn btn-xs btn-primary');
					form.find('.add-group').addClass('btn btn-xs btn-success');
					form.find('.delete-group').addClass('btn btn-xs btn-danger');
				}
				function style_search_form(form) {
					var dialog = form.closest('.ui-jqdialog');
					var buttons = dialog.find('.EditTable')
					buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'ace-icon fa fa-retweet');
					buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'ace-icon fa fa-comment-o');
					buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'ace-icon fa fa-search');
				}
				
				function beforeDeleteCallback(e) {
					var form = $(e[0]);
					if(form.data('styled')) return false;
					
					form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
					style_delete_form(form);
					
					form.data('styled', true);
				}
				
				function beforeEditCallback(e) {
					var form = $(e[0]);
					form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
					style_edit_form(form);
				}
			
			
			
				//it causes some flicker when reloading or navigating grid
				//it may be possible to have some custom formatter to do this as the grid is being created to prevent this
				//or go back to default browser checkbox styles for the grid
				function styleCheckbox(table) {
				/**
					$(table).find('input:checkbox').addClass('ace')
					.wrap('<label />')
					.after('<span class="lbl align-top" />')
			
			
					$('.ui-jqgrid-labels th[id*="_cb"]:first-child')
					.find('input.cbox[type=checkbox]').addClass('ace')
					.wrap('<label />').after('<span class="lbl align-top" />');
				*/
				}
				
			
				//unlike navButtons icons, action icons in rows seem to be hard-coded
				//you can change them like this in here if you want
				function updateActionIcons(table) {
					/**
					var replacement = 
					{
						'ui-ace-icon fa fa-pencil' : 'ace-icon fa fa-pencil blue',
						'ui-ace-icon fa fa-trash-o' : 'ace-icon fa fa-trash-o red',
						'ui-icon-disk' : 'ace-icon fa fa-check green',
						'ui-icon-cancel' : 'ace-icon fa fa-times red'
					};
					$(table).find('.ui-pg-div span.ui-icon').each(function(){
						var icon = $(this);
						var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
						if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
					})
					*/
				}
				
				//replace icons with FontAwesome icons like above
				function updatePagerIcons(table) {
					var replacement = 
					{
						'ui-icon-seek-first' : 'ace-icon fa fa-angle-double-left bigger-140',
						'ui-icon-seek-prev' : 'ace-icon fa fa-angle-left bigger-140',
						'ui-icon-seek-next' : 'ace-icon fa fa-angle-right bigger-140',
						'ui-icon-seek-end' : 'ace-icon fa fa-angle-double-right bigger-140'
					};
					$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
						var icon = $(this);
						var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
						
						if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
					})
				}
			
				function enableTooltips(table) {
					$('.navtable .ui-pg-button').tooltip({container:'body'});
					$(table).find('.ui-pg-div').tooltip({container:'body'});
				}
			
				//var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
			
				$(document).one('ajaxloadstart.page', function(e) {
					$.jgrid.gridDestroy(grid_selector);
					$('.ui-jqdialog').remove();
				});
			});
				
				
		</script>
	</body>
</html>
