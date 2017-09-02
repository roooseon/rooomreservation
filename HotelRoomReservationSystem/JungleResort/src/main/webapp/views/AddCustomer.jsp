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

<div class="container" style="margin-top:100px">
<!-- <h2> Language : <a href="?lang=en">English</a>|<a href="?lang=nl">Nepali</a></h2> -->
	<form:form modelAttribute="customer" method="POST" action="addcustomer">
		
		<div class="form-group">
			<div>

				<%-- 					<span><form:label path="name"> --%>
				<%-- 							<spring:message code="message.name" text="Default Text" /> --%>
				<%-- 						</form:label></span> --%>
				<h2>
					<spring:message code="addCustomerInfo" />
				</h2>
				<span><form:label path="name"><spring:message code="Name" /></form:label></span> <span><form:input
						class="form-control" path="name" name="name" type="text" /></span> <span><form:errors
						path="name" cssStyle="color:red;" /></span>
			</div>

			<div>
				<span><form:label path="username"><spring:message code="UserName" /></form:label></span> <span><form:input
						class="form-control" path="username" name="username" type="text" /></span>
				<span><form:errors path="username" cssStyle="color:red;" /><span
					class="colorRed">${userexistscust}</span></span>
			</div>

			<div>
				<span><form:label path="password"><spring:message code="Password" /></form:label></span> <span><form:input
						class="form-control" path="password" type="password" value=""
						id="password1" /></span> <span><form:errors path="password"
						cssStyle="color:red;" /></span>
			</div>

			<div>
				<span><form:label path="confirmPassword"><spring:message code="ConfirmPassword" /></form:label></span>
				<span><form:input class="form-control" path="confirmPassword"
						type="password" value="" id="password2" /></span> <span><span
					class="colorRed" id="validate-status">${passmismatchcust}</span></span>
			</div>

			<div>
				<span><form:label path="email"><spring:message code="Email" /></form:label></span> <span><form:input
						class="form-control" path="email" onclick="" name="email"
						type="email" /></span> <span><form:errors path="email"
						cssStyle="color:red;" /></span>
			</div>

			<div>
				<span><form:label path="phoneNumber"><spring:message code="Phone" /></form:label></span> <span><form:input
						class="form-control" path="phoneNumber" name="phoneNumber"
						type="number" /></span> <span><form:errors path="phoneNumber"
						cssStyle="color:red;" /></span>
			</div>

			<div>
				<span><input class="form-control btn btn-success"
					type="submit" value="<spring:message code="Register" />" /></span>
			</div>
		</div>
	</form:form>
</div>