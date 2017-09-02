<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script>
	$(document).ready(function() {
		$("#password2").keyup(validate);
	});

	function validate() {
		var password1 = $("#password1").val();
		var password2 = $("#password2").val();

		if (password1 == password2) {
			$("#validate-status").text("password match");
		} else {
			$("#validate-status").text("password mismatch");
		}

	}
</script>
<div class="container" style="margin-top: 100px">
	<div class="row">
		<form:form modelAttribute="admin" method="POST" action="addadmin">
			<!-- 			<h2> Language : <a href="?lang=en">English</a>|<a href="?lang=np">Nepali</a></h2> -->
			<h2>Admin Registration</h2>
			<div class="form-group">

				<div class="span4">
					<span><form:label path="username">UserName</form:label></span> <span><form:input
							class="form-control" path="username" name="username" type="text" /></span>
					<span><form:errors path="username" cssStyle="color:red;" /><span
						class="colorRed">${userexists}</span></span>
				</div>

				<div>
					<span><form:label path="password">Password</form:label></span> <span><form:input
							class="form-control" path="password" type="password" value=""
							id="password1" /></span> <span><form:errors path="password"
							cssStyle="color:red;" /></span>
				</div>

				<div>
					<span><form:label path="confirmPassword">Confirm Password</form:label></span>
					<span><form:input class="form-control"
							path="confirmPassword" type="password" value="" id="password2" /></span>
					<span><span class="colorRed" id="validate-status">${passmismatch}</span></span>
					<!-- 					<span><span ></span></span> -->
				</div>
				<br />
				<div>
					<span><input class="form-control btn btn-success"
						type="submit" value="Register" /></span>
				</div>
			</div>
		</form:form>
	</div>
</div>
