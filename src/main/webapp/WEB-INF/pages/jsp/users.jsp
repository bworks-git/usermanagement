<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
			<!--<ul class='main-nav'>
				<li><a href="index.html"> <span>Dashboard</span>
				</a></li>
				<li><a href="#" data-toggle="dropdown" class='dropdown-toggle'>
						<span>Forms</span> <span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="forms-basic.html">Basic forms</a></li>
						<li><a href="forms-extended.html">Extended forms</a></li>
						<li><a href="forms-validation.html">Validation</a></li>
						<li><a href="forms-wizard.html">Wizard</a></li>
					</ul></li>
				<li><a href="#" data-toggle="dropdown" class='dropdown-toggle'>
						<span>Components</span> <span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="components-timeline.html">Timeline</a></li>
						<li><a href="components-pagestatistics.html">Page
								statistics</a></li>
						<li><a href="components-sidebarwidgets.html">Sidebar
								widgets</a></li>
						<li><a href="components-messages.html">Messages &amp;
								Chat</a></li>
						<li><a href="components-gallery.html">Gallery &amp;
								Thumbs</a></li>
						<li><a href="components-tiles.html">Tiles</a></li>
						<li><a href="components-icons.html">Icons &amp; Buttons</a></li>
						<li><a href="components-elements.html">UI elements</a></li>
						<li><a href="components-typography.html">Typography</a></li>
						<li><a href="components-bootstrap.html">Bootstrap
								elements</a></li>
						<li><a href="components-grid.html">Grid</a></li>
					</ul></li>
				<li class='active'><a href="#" data-toggle="dropdown"
					class='dropdown-toggle'> <span>Tables</span> <span
						class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="tables-basic.html">Basic tables</a></li>
						<li class='active'><a href="tables-advanced.html">Advanced
								tables</a></li>
						<li><a href="tables-large.html">Large tables</a></li>
					</ul></li>
				<li><a href="#" data-toggle="dropdown" class='dropdown-toggle'>
						<span>Plugins</span> <span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="plugins-charts.html">Charts</a></li>
						<li><a href="plugins-calendar.html">Calendar</a></li>
						<li><a href="plugins-filemanager.html">File manager</a></li>
						<li><a href="plugins-filetrees.html">File trees</a></li>
						<li><a href="plugins-elements.html">Editable elements</a></li>
						<li><a href="plugins-maps.html">Maps</a></li>
						<li><a href="plugins-dragdrop.html">Drag &amp; Drop
								widgets</a></li>

					</ul></li>
				<li><a href="#" data-toggle="dropdown" class='dropdown-toggle'>
						<span>Pages</span> <span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="more-error.html">Error pages</a></li>
						<li class='dropdown-submenu'><a href="#"
							data-toggle="dropdown" class='dropdown-toggle'>Shop</a>
							<ul class="dropdown-menu">
								<li><a href="more-shop-list.html">List view</a></li>
								<li><a href="more-shop-product.html">Product view</a></li>
							</ul></li>
						<li><a href="more-pricing.html">Pricing tables</a></li>
						<li><a href="more-faq.html">FAQ</a></li>
						<li><a href="more-invoice.html">Invoice</a></li>
						<li><a href="more-userprofile.html">User profile</a></li>
						<li><a href="more-searchresults.html">Search results</a></li>
						<li><a href="more-login.html">Login</a></li>
						<li><a href="more-locked.html">Lock screen</a></li>
						<li><a href="more-email.html">Email templates</a></li>
						<li><a href="more-blank.html">Blank page</a></li>
						<li class='dropdown-submenu'><a href="#"
							data-toggle="dropdown" class='dropdown-toggle'>Blog</a>
							<ul class="dropdown-menu">
								<li><a href="more-blog-list.html">List big image</a></li>
								<li><a href="more-blog-list-small.html">List small
										image</a></li>
								<li><a href="more-blog-post.html">Post</a></li>
							</ul></li>
					</ul></li>
				<li><a href="#" data-toggle="dropdown" class='dropdown-toggle'>
						<span>Layouts</span> <span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="layouts-sidebar-hidden.html">Default hidden
								sidebar</a></li>
						<li><a href="layouts-sidebar-right.html">Sidebar right
								side</a></li>
						<li><a href="layouts-color.html">Different default color</a>
						</li>
						<li><a href="layouts-fixed.html">Fixed layout</a></li>
						<li><a href="layouts-fixed-topside.html">Fixed topbar and
								sidebar</a></li>
						<li class='dropdown-submenu'><a href="#">Mobile sidebar</a>
							<ul class="dropdown-menu">
								<li><a href="layouts-mobile-slide.html">Slide</a></li>
								<li><a href="layouts-mobile-button.html">Button</a></li>
							</ul></li>
						<li><a href="layouts-footer.html">Footer</a></li>
					</ul></li>
			</ul>-->
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
						<!--<ul class="minitiles">
							<li class='lightred'><a href="#"> <i class="fa fa-cogs"></i>
							</a></li>
							<li class='grey'><a href="#"> <i
									class="fa fa-globe"></i>
							</a></li>
						</ul>-->
						<ul class="stats">
							<!-- <li class='satgreen'><i class="fa fa-money"></i>

								<div class="details">
									<span class="big">$324,12</span> <span>Balance</span>
								</div></li>-->
								<form action="addUser" method="GET">
								<button type="submit" class="btn btn--icon"><i class="fa fa-plus-square"></i>Create User</button>
								<c:if test="${not empty exception }">
									<div class="alert alert-success alert-dismissable">
										${exception }
									</div>
								</c:if>
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
								<h3>Manage Users</h3>
							</div>
							<div class="box-content nopadding">
								<table
									class="table table-hover table-nomargin table-bordered"
									data-column_filter_types="null,select,text,select,daterange,null"
									data-column_filter_dateformat="dd-mm-yy" data-nosort="0"
									data-checkall="all"
									id="user-table">
									<thead>
										<tr>
											<!--
											<th class='hidden-480'>Options</th>
											<th class='with-checkbox'><input type="checkbox"
												name="check_all" class="dataTable-checkall"></th>-->
											 <th>First Name</th>
							     			<th>Last Name</th>
							     			<th>Email</th>
							     			<th>Mobile</th>
							     			<th>Options</th>
										</tr>
									</thead>
									<!-- <tbody>
									<c:if test="${not empty users}">
									<c:forEach var="user" begin="0" end="${fn:length(users)-1}" items="${users}">
										<tr>
											<td class="with-checkbox"><input type="checkbox"
												name="check" value="1"></td>
											<td>${user.firstName}</td>
											<td>${user.lastName}</td>
											<td>${user.EMail}</td>
											<td>${user.mobile}</td>
											<td class='hidden-480'><a href="#" class="btn"
												rel="tooltip" title="View"> <i class="fa fa-search"></i>
											</a> <a href="#" class="btn" rel="tooltip" title="Edit"> <i
													class="fa fa-edit"></i>
											</a> <a href="#" class="btn" rel="tooltip" title="Delete"> <i
													class="fa fa-times"></i>
											</a></td>
										</tr>
									</c:forEach>
									</c:if>
									</tbody> -->
								</table>
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
