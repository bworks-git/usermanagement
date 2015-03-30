<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:url value="/resources/js" var="jsURL" />
<c:url value="/resources/css" var="cssURL" />
<c:url value="/resources/img" var="imageURL" />
<!doctype html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<!-- Apple devices fullscreen -->
<meta name="apple-mobile-web-app-capable" content="yes" />
<!-- Apple devices fullscreen -->
<meta names="apple-mobile-web-app-status-bar-style"
	content="black-translucent" />

<title>OSL - User Management</title>

<!-- Bootstrap -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- jQuery UI -->
<link rel="stylesheet" href="css/plugins/jquery-ui/jquery-ui.min.css">
<!-- dataTables -->
<link rel="stylesheet" href="css/plugins/datatable/TableTools.css">
<!-- chosen -->
<link rel="stylesheet" href="css/plugins/chosen/chosen.css">
<!-- Theme CSS -->
<link rel="stylesheet" href="css/style.css">
<!-- Color CSS -->
<link rel="stylesheet" href="css/themes.css">

<!-- jQuery -->
<script src="js/jquery.min.js"></script>

<!-- Nice Scroll -->
<script src="js/plugins/nicescroll/jquery.nicescroll.min.js"></script>
<!-- imagesLoaded -->
<script src="js/plugins/imagesLoaded/jquery.imagesloaded.min.js"></script>
<!-- jQuery UI -->
<script src="js/plugins/jquery-ui/jquery-ui.js"></script>
<!-- slimScroll -->
<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<!-- Bootstrap -->
<script src="js/bootstrap.min.js"></script>
<!-- Bootbox -->
<script src="js/plugins/bootbox/jquery.bootbox.js"></script>
<!-- New DataTables -->
<script src="js/plugins/momentjs/jquery.moment.min.js"></script>
<script src="js/plugins/momentjs/moment-range.min.js"></script>
<script src="js/plugins/datatables/jquery.dataTables.min.js"></script>
<script
	src="js/plugins/datatables/extensions/dataTables.tableTools.min.js"></script>
<script
	src="js/plugins/datatables/extensions/dataTables.colReorder.min.js"></script>
<script src="js/plugins/datatables/extensions/dataTables.colVis.min.js"></script>
<script
	src="js/plugins/datatables/extensions/dataTables.scroller.min.js"></script>

<!-- Chosen -->
<script src="js/plugins/chosen/chosen.jquery.min.js"></script>

<!-- Theme framework -->
<script src="js/eakroko.js"></script>
<!-- Theme scripts -->
<script src="js/application.js"></script>
<!-- Just for demonstration -->
<script src="js/demonstration.js"></script>

<!--[if lte IE 9]>
	<script src="js/plugins/placeholder/jquery.placeholder.min.js"></script>
	<script>
		$(document).ready(function () {
			$('input, textarea').placeholder();
		});
	</script>
	<![endif]-->

<!-- Favicon -->
<link rel="shortcut icon" href="img/favicon.ico" />
<!-- Apple devices Homescreen icon -->
<link rel="apple-touch-icon-precomposed"
	href="img/apple-touch-icon-precomposed.png" />

</head>

<body style="margin-bottom: 300px;">
	<div id="navigation">
		<div class="container-fluid">
			<a href="#" id="brand">OSL</a> <a href="#" class="toggle-nav"
				rel="tooltip" data-placement="bottom" title="Toggle navigation">
				<i class="fa fa-bars"></i>
			</a>
			<div class="user">
				<ul class="icon-nav">
					<li class="dropdown sett"><a href="#" class='dropdown-toggle'
						data-toggle="dropdown"> <i class="fa fa-cog"></i>
					</a>
						<ul class="dropdown-menu pull-right theme-settings">
							<li><span>Layout-width</span>

								<div class="version-toggle">
									<a href="#" class='set-fixed'>Fixed</a> <a href="#"
										class="active set-fluid">Fluid</a>
								</div></li>
							<li><span>Topbar</span>

								<div class="topbar-toggle">
									<a href="#" class='set-topbar-fixed'>Fixed</a> <a href="#"
										class="active set-topbar-default">Default</a>
								</div></li>
							<li><span>Sidebar</span>

								<div class="sidebar-toggle">
									<a href="#" class='set-sidebar-fixed'>Fixed</a> <a href="#"
										class="active set-sidebar-default">Default</a>
								</div></li>
						</ul></li>
					<li class='dropdown colo'><a href="#" class='dropdown-toggle'
						data-toggle="dropdown"> <i class="fa fa-tint"></i>
					</a>
						<ul class="dropdown-menu pull-right theme-colors">
							<li class="subtitle">Predefined colors</li>
							<li><span class='red'></span> <span class='orange'></span> <span
								class='green'></span> <span class="brown"></span> <span
								class="blue"></span> <span class='lime'></span> <span
								class="teal"></span> <span class="purple"></span> <span
								class="pink"></span> <span class="magenta"></span> <span
								class="grey"></span> <span class="darkblue"></span> <span
								class="lightred"></span> <span class="lightgrey"></span> <span
								class="satblue"></span> <span class="satgreen"></span></li>
						</ul></li>
				</ul>
				<div class="dropdown">
					<a href="#" class='dropdown-toggle' data-toggle="dropdown">
						John Doe 
					</a>
					<ul class="dropdown-menu pull-right">
						<li><a href="more-userprofile.html">Edit profile</a></li>
						<li><a href="#">Account settings</a></li>
						<li><a href="more-login.html">Sign out</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid" id="content">
		<div id="left">
			<div class="subnav">
				<div class="subnav-title">
					<a href="#" class='toggle-subnav'> <i class="fa fa-angle-down"></i>
						<span>User Management
						<!-- <a href="#" class="toggle-nav" rel="tooltip" data-placement="bottom" title="" data-original-title="Toggle navigation">
								<i class="fa fa-bars"></i>
							</a> -->
						</span>
					</a>
				</div>
				<ul class="subnav-menu">
					<li class='dropdown'><a href="#" data-toggle="dropdown">Users</a>
						<ul class="dropdown-menu">
							<li><a href="addUser">Create User</a></li>
							<li><a href="users">List Users</a></li>
						</ul>
					</li>
					<li class='dropdown'><a href="#" data-toggle="dropdown">Roles</a>
						<ul class="dropdown-menu">
							<li><a href="addRole">Create Role</a></li>
							<li><a href="roles">List Roles</a></li>
						</ul>
					</li>
					<li class='dropdown'><a href="#" data-toggle="dropdown">Permissions</a>
						<ul class="dropdown-menu">
							<li><a href="addPermission">Create Permission</a></li>
							<li><a href="permissions">List Permissions</a></li>
						</ul>
					</li>
					<li><a href="auditTrial">Audit Trial</a></li>
					<!--<li><a href="auditAction">Audit Action</a></li>-->
				</ul>
			</div>
		</div>
		<div id="main">
			<div class="container-fluid">
				<div class="page-header">
					<div class="">
						<ul class="stats">
							<form action="addPermission" method="GET">
								<button type="submit" class="btn btn--icon"><i class="fa fa-plus-square"></i>Create Permission</button>
							</form>
						</ul>
					</div>
				</div>
				<!--<div class="breadcrumbs">
					<ul>
						<li><a href="more-login.html">Home</a> <i
							class="fa fa-angle-right"></i></li>
						<li><a href="tables-basic.html">Tables</a> <i
							class="fa fa-angle-right"></i></li>
						<li><a href="tables-advanced.html">Advanced tables</a></li>
					</ul>
					<div class="close-bread">
						<a href="#"> <i class="fa fa-times"></i>
						</a>
					</div>
				</div> -->
				<div class="row">
					<div class="col-sm-12">
						<div class="box box-color box-bordered">
							<div class="box-title">
								<h3>Manage Permissions</h3>
							</div>
							<div class="box-content nopadding">
								<table
									class="table table-hover table-nomargin table-bordered dataTable dataTable-column_filter"
									data-column_filter_types="text,select,select,text,text,daterange,daterange,null"
									data-column_filter_dateformat="yyyy-MM-dd HH:mm:ss" data-nosort="7"
									id="role-table">
									<thead>
										<tr>
											<!--
											<th class='with-checkbox'><input type="checkbox"
												name="check_all" class="dataTable-checkall"></th>-->
											<th>Permission Name</th>
											<th>Description</th>
											<th>Status</th>
							     			<th>Created By</th>
							     			<th>Modified By</th>
							     			<th>Create Date&nbsp;&nbsp;</th>
							     			<th>Modified Date</th>
							     			<th class='hidden-480'>Options&nbsp;&nbsp;&nbsp;</th>
										</tr>
									</thead>
									<tbody>
									<c:if test="${not empty permissions}">
									<c:forEach var="permission" begin="0" end="${fn:length(permissions)-1}" items="${permissions}">
										<tr>
											<!-- <td class="with-checkbox"><input type="checkbox"
												name="check" value="1"></td> -->
												<!--<c:set var="statucIcon" value="fa-square-o"/>
												<c:if test="${role.status eq true}">
													<c:set var="statucIcon" value="fa-check-square-o"/>
												</c:if> 
												<i class="fa ${statucIcon}"></i> -->
											<td>${permission.permissionName}</td>
											<td>${permission.description}</td>
											<td>${permission.status}</td>
											<td>${permission.createBy}</td>
											<td>${permission.modifiedBy}</td>
											<td>
											<c:set var="createdDate" value="${permission.createDate}" />
											<fmt:formatDate type="both" pattern="yyyy-MM-dd HH:mm:ss" value="${createdDate.time}" /> 
											</td>
											<td>
											<c:set var="modifiedDate" value="${permission.modifiedDate}" />
											<fmt:formatDate type="both" pattern="yyyy-MM-dd HH:mm:ss" value="${modifiedDate.time}" /> 
											</td>
											<td class='hidden-480'>
												<!--<a href="#" class="btn"	rel="tooltip" title="View"> <i class="fa fa-search"></i></a> --> 
												<a href="editPermission?id=${permission.id}" class="btn" rel="tooltip" title="Edit"> <i class="fa fa-edit"></i></a> 
												<a href="#" id="${permission.id}-delete" class="delete-btn btn" rel="tooltip" title="Delete"> <i class="fa fa-times"></i></a>
											</td>
										</tr>
											</c:forEach>
									</c:if>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="delete-modal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Delete Permission</h4>
				</div>
				<!-- /.modal-header -->
				<div class="modal-body">
					<p id="modal-message">Are you sure you want to delete?</p>
				</div>
				<input type="hidden" id="deleteId" value=""/>
				<input type="hidden" id="deleteURL" value="deletePermission"/>
				<!-- /.modal-body -->
				<div class="modal-footer">
					<button type="button" class="btn btn-default" id="delete-no" data-dismiss="modal">No</button>
					<button type="button" id="delete-yes" class="btn btn-primary">Yes</button>
				</div>
				<!-- /.modal-footer -->
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /#modal-1.modal fade -->
	<script type="text/javascript">
		var _gaq = _gaq || [];
		_gaq.push([ '_setAccount', 'UA-38620714-4' ]);
		_gaq.push([ '_trackPageview' ]);

		(function() {
			var ga = document.createElement('script');
			ga.type = 'text/javascript';
			ga.async = true;
			ga.src = ('https:' == document.location.protocol ? 'https://ssl'
					: 'http://www')
					+ '.google-analytics.com/ga.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(ga, s);
		})();
	</script>
</body>

</html>
