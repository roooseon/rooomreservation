<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="navbar-wrapper">
	<div class="container">
		Language : <a href="?lang=en">English</a>|<a href="?lang=nl">Nepali</a>
		<nav class="navbar navbar-inverse navbar-static-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="/"><spring:message
							code="JungleSideResort" /></a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="/"><spring:message code="Home" /></a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false"><spring:message code="Rooms" /> <span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Single</a></li>
								<li><a href="#">Double</a></li>
								<li><a href="#">Presidential</a></li>

							</ul></li>
						<li><a href="/availableroomslist"><spring:message
									code="AvailableRooms" /></a></li>
						<li><a href="#contact"><spring:message code="ContactUs" /></a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">

						<li class="dropdown"><c:choose>
								<c:when test="${empty user}">
									<a href='/customerlogin' role="button"><spring:message
											code="Signin" /></a>
								</c:when>
								<c:otherwise>
									<a href="#" class="dropdown-toggle" data-toggle="dropdown"
										role="button" aria-haspopup="true" aria-expanded="false">Logged
										as : ${user.username}<span class="caret"></span>
									</a>
									<ul class="dropdown-menu">
										<li><a href="/profile/${user.customerId}">Profile</a></li>
										<li><a href='/logout'>Logout</a></li>
									</ul>
								</c:otherwise>
							</c:choose></li>
					</ul>
				</div>
			</div>
		</nav>

	</div>
</div>