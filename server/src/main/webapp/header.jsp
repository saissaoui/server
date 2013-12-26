<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="${pageContext.request.contextPath}/js/config.js"></script>
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
