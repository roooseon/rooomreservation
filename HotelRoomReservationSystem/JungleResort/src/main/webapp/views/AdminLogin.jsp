<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="container" style="margin-top: 100px">
	<h2 style="color: #a94442; font-size: 300%; font-weight: 700">Welcome Admin</h2>
	<br>
	<form action="adminlogin" method="post" modelAttribute="admin">
		<p>
			<span class="glyphicon glyphicon-user"></span> <label>Username</label>
			<input type="text" name="username" value="${cookie.username.value}"
				required />
		</p>
		<p>
			<span class="glyphicon glyphicon-lock"></span> <label>Password</label>
			<input type="password" name="password" required />
		</p>
		<p>
			<input type="checkbox" name="remember"
				<c:if test="${cookie.containsKey('username')}">checked</c:if> /> <label
				style="font-weight: 100; font-size: 70%;">Remember me</label>
		</p>

		<p>
			<input class="btn btn-info btn-bg" type="submit" value="Login" /> <a
				href="/addadmin">Add Admin</a>
		</p>
	</form>

	<div>
		<p style="color: #b94470; font-size: 110%;">${loginfail}
		<p>
	</div>


</div>
</div>