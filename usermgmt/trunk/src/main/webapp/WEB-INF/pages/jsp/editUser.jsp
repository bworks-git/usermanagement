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
<script src="js/plugins/wizard/jquery.form.wizard.min.js"></script>
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
						John Doe </a>
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
						<span>User Management <!-- <a href="#" class="toggle-nav" rel="tooltip" data-placement="bottom" title="" data-original-title="Toggle navigation">
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
						</ul></li>
					<li class='dropdown'><a href="#" data-toggle="dropdown">Roles</a>
						<ul class="dropdown-menu">
							<li><a href="addRole">Create Role</a></li>
							<li><a href="roles">List Roles</a></li>
						</ul></li>
					<li class='dropdown'><a href="#" data-toggle="dropdown">Permissions</a>
						<ul class="dropdown-menu">
							<li><a href="addPermission">Create Permission</a></li>
							<li><a href="permissions">List Permissions</a></li>
						</ul></li>
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
							<form action="users" method="GET">
								<button class="btn btn--icon">
									<i class="fa fa-arrow-left"></i>Back
								</button>
							</form>
						</ul>
					</div>
				</div>
				<c:choose>
					<c:when test="${STATUS eq 'SUCCESS'}">
						<div class="row">
							<div class="alert alert-success alert-dismissable">
								<button type="button" class="close" data-dismiss="alert">×</button>
								<strong>Success!</strong> ${MESSAGE}
							</div>
						</div>
					</c:when>
					<c:when test="${STATUS eq 'ERROR'}">
						<div class="row">
							<div class="alert alert-danger alert-dismissable">
								<button type="button" class="close" data-dismiss="alert">×</button>
								<strong>Error!</strong> ${MESSAGE}
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
									<i class="fa fa-user"></i> Edit User
								</h3>
							</div>
							<div class="box-content">
									<form:form action="updateUser?id=${user.userId }" id="save_user" method="post"
										commandName="userForm" class='form-horizontal form-wizard'>
									<div class="step" id="firstStep">
										<ul class="wizard-steps steps-5">
											<li class='active'>
												<div class="single-step">
													<span class="title"> 1</span> <span class="circle">
														<span class="active"></span>
													</span> <span class="description"> Basic information </span>
												</div>
											</li>
											<li>
												<div class="single-step">
													<span class="title"> 2</span> <span class="circle">
													</span> <span class="description"> Logins </span>
												</div>
											</li>
											<li>
												<div class="single-step">
													<span class="title"> 3</span> <span class="circle">
													</span> <span class="description"> Roles </span>
												</div>
											</li>
											<li>
												<div class="single-step">
													<span class="title"> 4</span> <span class="circle">
													</span> <span class="description"> Extras </span>
												</div>
											</li>
											<li>
												<div class="single-step">
													<span class="title"> 5</span> <span class="circle">
													</span> <span class="description"> Confirm </span>
												</div>
											</li>
										</ul>
										<div class="step-forms">
											<div class="form-group">
												<label for="first_name" class="control-label col-sm-2">First
													Name</label>
												<div class="col-sm-10">
													<form:input type="text" name="first_name" id="first_name"
														path="first_name" class="form-control"
														data-rule-required="true" data-rule-maxlength="500" />
												</div>
											</div>
											<div class="form-group">
												<label for="last_name" class="control-label col-sm-2">Last
													Name</label>
												<div class="col-sm-10">
													<form:input type="text" name="last_name" id="last_name"
														path="last_name" class="form-control"
														data-rule-required="true" data-rule-maxlength="500" />
												</div>
											</div>
											<div class="form-group">
												<label for="email" class="control-label col-sm-2">Email</label>
												<div class="col-sm-10">
													<form:input type="text" name="email" id="email"
														path="email" class="form-control"
														data-rule-required="true" data-rule-email="true" data-rule-maxlength="500" />
												</div>
											</div>
											<div class="form-group">
												<label for="email1" class="control-label col-sm-2">Secondary Email</label>
												<div class="col-sm-10">
													<form:input type="text" name="email1" id="email1"
														path="email1" class="form-control"
														data-rule-required="false" data-rule-email="true" data-rule-maxlength="100" placeholder="Optional" />
												</div>
											</div>
											<!-- 
											<div class="form-group">
												<label for="email2" class="control-label col-sm-2">Email 2</label>
												<div class="col-sm-10">
													<form:input type="text" name="email2" id="email2"
														path="email2" class="form-control"
														data-rule-required="false" data-rule-email="true" data-rule-maxlength="100" />
												</div>
											</div>
											-->
											<div class="form-group">
												<label for="mobile" class="control-label col-sm-2">Mobile</label>
												<div class="col-sm-10">
													<form:input type="text" name="mobile" id="mobile"
														path="mobile" class="form-control"
														data-rule-required="true" data-rule-digits="true" data-rule-maxlength="10" data-rule-minlength="10" />
												</div>
											</div>
											<div class="form-group">
												<label for="mobile1" class="control-label col-sm-2">Secondary Mobile</label>
												<div class="col-sm-10">
													<form:input type="text" name="mobile1" id="mobile1"
														path="mobile1" class="form-control"
														data-rule-required="false" data-rule-digits="true" data-rule-maxlength="10" data-rule-minlength="10" placeholder="Optional" />
												</div>
											</div>
											<!-- 
											<div class="form-group">
												<label for="mobile2" class="control-label col-sm-2">Mobile Number 2</label>
												<div class="col-sm-10">
													<form:input type="text" name="mobile2" id="mobile2"
														path="mobile2" class="form-control"
														data-rule-required="false" data-rule-digits="true" data-rule-maxlength="10" data-rule-minlength="10" />
												</div>
											</div>
											-->
										</div>
									</div>
									<div class="step" id="loginstep">
										<ul class="wizard-steps steps-5">
											<li>
												<div class="single-step">
													<span class="title"> 1</span> <span class="circle">

													</span> <span class="description"> Basic information </span>
												</div>
											</li>
											<li class='active'>
												<div class="single-step">
													<span class="title"> 2</span> <span class="circle">
														<span class="active"></span>
													</span> <span class="description"> Logins  </span>
												</div>
											</li>
											<li>
												<div class="single-step">
													<span class="title"> 3</span> <span class="circle">

													</span> <span class="description"> Roles </span>
												</div>
											</li>
											<li>
												<div class="single-step">
													<span class="title"> 4</span> <span class="circle">
													</span> <span class="description"> Extras </span>
												</div>
											</li>
											<li>
												<div class="single-step">
													<span class="title"> 5</span> <span class="circle">
													</span> <span class="description"> Confirm </span>
												</div>
											</li>
										</ul>
										<div class="form-group">
											<label for="loginId" class="control-label col-sm-2">Login Id</label>
											<div class="col-sm-10">
												<form:input type="text" name="loginId" id="loginId"
													path="loginId" class="form-control"
													data-rule-required="true" data-rule-minlength="2"
													data-rule-maxlength="200" />
											</div>
										</div>
										<div class="form-group">
												<label for="password" class="control-label col-sm-2">Password</label>
												<div class="col-sm-10">
													<form:input type="password" name="password" id="password"
														path="password" class="form-control"
														data-rule-required="true" data-rule-minlength="8"
														data-rule-maxlength="200" />
												</div>
										</div>
										<div class="form-group">
											<label for="loginId1" class="control-label col-sm-2">Login ID 1</label>
												<div class="col-sm-10">
													<form:input type="text" name="loginId1" id="loginId1"
														path="loginId1" class="form-control"
														data-rule-required="false" data-rule-maxlength="100" />
												</div>
										</div>
										<div class="form-group">
											<label for="loginId2" class="control-label col-sm-2">Login ID 2</label>
												<div class="col-sm-10">
													<form:input type="text" name="loginId2" id="loginId2"
														path="loginId2" class="form-control"
														data-rule-required="false" data-rule-maxlength="100" />
												</div>
										</div>
										<div class="form-group">
											<label for="loginId3" class="control-label col-sm-2">Login ID 3</label>
												<div class="col-sm-10">
													<form:input type="text" name="loginId3" id="loginId3"
														path="loginId3" class="form-control"
														data-rule-required="false" data-rule-maxlength="100" />
												</div>
										</div>
										<div class="form-group">
											<label for="loginId4" class="control-label col-sm-2">Login ID 4</label>
												<div class="col-sm-10">
													<form:input type="text" name="loginId4" id="loginId4"
														path="loginId4" class="form-control"
														data-rule-required="false" data-rule-maxlength="100" />
												</div>
										</div>
										<div class="form-group">
											<label for="loginId5" class="control-label col-sm-2">Login ID 5</label>
												<div class="col-sm-10">
													<form:input type="text" name="loginId5" id="loginId5"
														path="loginId5" class="form-control"
														data-rule-required="false" data-rule-maxlength="100" />
												</div>
										</div>
									</div>
									<div class="step" id="secondStep">
										<ul class="wizard-steps steps-5">
											<li>
												<div class="single-step">
													<span class="title"> 1</span> <span class="circle">

													</span> <span class="description"> Basic information </span>
												</div>
											</li>
											<li>
												<div class="single-step">
													<span class="title"> 2</span> <span class="circle">
													</span> <span class="description"> Logins </span>
												</div>
											</li>
											<li class='active'>
												<div class="single-step">
													<span class="title"> 3</span> <span class="circle">
														<span class="active"></span>
													</span> <span class="description"> Roles </span>
												</div>
											</li>
											<li>
												<div class="single-step">
													<span class="title"> 4</span> <span class="circle">
													</span> <span class="description"> Extras </span>
												</div>
											</li>
											<li>
												<div class="single-step">
													<span class="title"> 5</span> <span class="circle">
													</span> <span class="description"> Confirm </span>
												</div>
											</li>
										</ul>
										<div class="form-group">
											<label for="userRole" class="control-label col-sm-2">Roles</label>
											<div class="col-sm-10">
												<form:select multiple="true" path="roleSet" items="${roles}" itemLabel="role_name" itemValue="id" id="userRole"
													class="chosen-select form-control" />
											</div>
										</div>
										<div class="form-group">
											<label for="posPermissions" class="control-label col-sm-2">Positive Permissions</label>
											<div class="col-sm-10">
												<form:select multiple="true" path="positivePermissions" items="${permissions}" itemLabel="permissionName" itemValue="id" id="posPermissions"
													class="chosen-select form-control" />
											</div>
										</div>
										<div class="form-group">
											<label for="negPermissions" class="control-label col-sm-2">Nagative Permissions</label>
											<div class="col-sm-10">
												<form:select multiple="true" path="negativePermissions" items="${permissions}" itemLabel="permissionName" itemValue="id" id="negPermissions"
													class="chosen-select form-control" />
											</div>
										</div>
									</div>
									<div class="step" id="thirdStep">
										<ul class="wizard-steps steps-5">
											<li>
												<div class="single-step">
													<span class="title"> 1</span> <span class="circle">

													</span> <span class="description"> Basic information </span>
												</div>
											</li>
											<li>
												<div class="single-step">
													<span class="title"> 2</span> <span class="circle">
													</span> <span class="description"> Logins </span>
												</div>
											</li>
											<li>
												<div class="single-step">
													<span class="title"> 3</span> <span class="circle">
													</span> <span class="description"> Roles </span>
												</div>
											</li>
											<li class='active'>
												<div class="single-step">
													<span class="title"> 4</span> <span class="circle">
														<span class="active"></span>
													</span> <span class="description"> Extras </span>
												</div>
											</li>
											<li>
												<div class="single-step">
													<span class="title"> 5</span> <span class="circle">
													</span> <span class="description"> Confirm </span>
												</div>
											</li>
										</ul>
										<div class="form-group">
											<label for="favIp" class="control-label col-sm-2">Favourite IP</label>
												<div class="col-sm-10">
													<div id="favIps">
														<div>
															<input type="text" name="favouriteIps[]" data-rule-ipv4="true" />
															<button class="deleteFavIp btn">Delete</button>
														</div>
													</div>
													<button id="addFavIp" class="btn btn-primary" style="margin-top: 10px;">Add More IP</button>
												</div>
										</div>
										<div class="form-group">
											<label for="favAgents" class="control-label col-sm-2">Favourite User Agents</label>
												<div class="col-sm-10">
														<form:select multiple="true" path="favouriteAgents" id="favAgents"
															class="chosen-select form-control">
															<form:options items="${userAgents}" />
														</form:select>
												</div>
										</div>
									</div>
									<div class="step" id="fourthstep">
										<ul class="wizard-steps steps-5">
											<li>
												<div class="single-step">
													<span class="title"> 1</span> <span class="circle">

													</span> <span class="description"> Basic information </span>
												</div>
											</li>
											<li>
												<div class="single-step">
													<span class="title"> 2</span> <span class="circle">
													</span> <span class="description"> Logins </span>
												</div>
											</li>
											<li>
												<div class="single-step">
													<span class="title"> 3</span> <span class="circle">
													</span> <span class="description"> Roles </span>
												</div>
											</li>
											<li>
												<div class="single-step">
													<span class="title"> 4</span> <span class="circle">
													</span> <span class="description"> Extras </span>
												</div>
											</li>
											<li class='active'>
												<div class="single-step">
													<span class="title"> 5</span> <span class="circle">
														<span class="active"></span>
													</span> <span class="description"> Confirm </span>
												</div>
											</li>
										</ul>
										<div class="form-group">
											<label for="text" class="control-label col-sm-2">Status</label>
											<div class="col-sm-10">
												<div class="checkbox">
													<label> <input type="checkbox" name="status"
														value="true" data-rule-required="true">Is Active
													</label>
												</div>
											</div>
										</div>
									</div>
									<div class="form-actions">
										<input type="reset" class="btn" value="Back" id="back">
										<input type="submit" class="btn btn-primary" value="Submit"
											id="next">
									</div>
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
