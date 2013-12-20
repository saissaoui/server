<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script>
	$(function() {
		console.log($(location).attr('pathname'));
$("#nav a").each(function(){

	if($(location).attr('pathname')==$(this).attr('href'))
		$(this).addClass("current-page-item");
	else
		$(this).removeClass("current-page-item");
});
		
	});
</script>

<link href="${pageContext.request.contextPath}/css/blitzer/jquery-ui-1.10.3.custom.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/skel-noscript.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style-desktop.css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui-1.10.3.custom.js"></script>
<style>
body {
	font: 62.5% "Trebuchet MS", sans-serif;
	margin: 50px;
}

</style>



<div id="header-wrapper">
	<div class="container">
		<div class="row">
			<div class="12u">

				<header id="header">
					<h1>
						<a href="#" id="logo">Tunisiana Customer Manager</a>
					</h1>
					<nav id="nav">
						<a id="home" href='${pageContext.request.contextPath}/index.html' >Accueil</a>
						<a id="customer" href="${pageContext.request.contextPath}/client/add.html">Clients</a> <a id="segments"
							href="${pageContext.request.contextPath}/segments.html">Segments</a> <a href="#">Aide</a> <a
							href="#">A propos</a>
					</nav>
				</header>

			</div>
		</div>
	</div>
</div>
