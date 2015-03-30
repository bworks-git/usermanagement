<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

<script src="js/plugins/form/jquery.form.min.js"></script>
<!-- Validation -->
<script src="js/plugins/validation/jquery.validate.min.js"></script>
<script src="js/plugins/validation/additional-methods.min.js"></script>
	
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
							<form action="roles" method="GET">
								<button class="btn btn--icon"><i class="fa fa-arrow-left"></i>Back</button>
							</form>
						</ul>
					</div>
				</div>
					<c:choose>
						<c:when test="${response.status eq 'Success'}">
							<div class="row">
								<div class="alert alert-success alert-dismissable">
													<button type="button" class="close" data-dismiss="alert">×</button>
													<strong>Success!</strong> ${response.message}
												</div>
							</div>
						</c:when>
						<c:when test="${response.status eq 'Error'}">
								<div class="row">
								<div class="alert alert-danger alert-dismissable">
													<button type="button" class="close" data-dismiss="alert">×</button>
													<strong>Error!</strong> ${response.message}
												</div>
							</div>
						</c:when>
					</c:choose>
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
								<h3>
									<i class="fa fa-user"></i>
									${response.operationType} Role
								</h3>
							</div>
							<div class="box-content">
								<form:form action="saveRole" id="save_role" method="post" commandName="roleForm" class="form-horizontal form-validate">
									<div class="form-group">
										<label for="role_name" class="control-label col-sm-2">Role Name</label>
										<div class="col-sm-10">
											<form:input type="text" name="role_name" id="role_name" path="role_name" class="form-control" data-rule-required="true" data-rule-minlength="2" data-rule-maxlength="200"/>
										</div>
									</div>
									<div class="form-group">
										<label for="description" class="control-label col-sm-2">Description</label>
										<div class="col-sm-10">
											<form:input type="text" name="description" id="description" path="description" class="form-control" data-rule-required="true" data-rule-maxlength="500"/>
										</div>
									</div>
									<div class="form-group">
										<label for="permissions" class="control-label col-sm-2">Permissions</label>
										<div class="col-sm-10">
											<form:select multiple="true" path="permissions" id="permissions" class="form-control chosen-select">
												<c:forEach items="${permissionMap}" var="permissionOption" varStatus="loop">
													<c:set var="selected" value=""></c:set>
														<c:forEach var="selectedPermission" items="${fn:split(roleForm.permissions,',')}" varStatus="loopCount">
															<c:if test="${selectedPermission eq permissionOption.key}">
																<c:set var="selected" value="true"></c:set>
															</c:if>
														</c:forEach>
							                      	<form:option value="${permissionOption.key}" label="${permissionOption.value}" selected="${selected}"></form:option>
							                   	</c:forEach>
							                </form:select>
										</div>
									</div>
									<div class="form-group">
										<label for="policy" class="control-label col-sm-2">Is Active</label>
										<div class="col-sm-10">
											<form:checkbox  path="status" id="status" class="icheck-me" data-skin="square" data-color="blue"/>
										</div>
									</div>
									<div class="form-actions">
										<input type="submit" class="btn btn-primary" value="Submit">
										<button type="button" class="btn">Cancel</button>
									</div>
									<form:hidden path="id" />
									<input id="operationType" name="operationType" type="hidden" value="${response.operationType}"/>
								</form:form>
							</div>
						</div>
					</div>
				</div>
				</div>
		</div>
	</div>
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
