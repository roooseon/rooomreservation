<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div  class="container" style="margin-top:100px">
			<h2 style="color: #a94442; font-size: 300%; font-weight: 700">Welcome
				to Jungle Side Resort Login</h2>
			<br>
			<form action="/customerlogin" method="post" modelAttribute="customer">
				<p>
					<span class="glyphicon glyphicon-user"></span> <label>Username</label>
					<input type="text" name="username" value="${cookie.usernameCust.value}" required />
				</p>
				<p>
					<span class="glyphicon glyphicon-lock"></span> <label>Password</label>
					<input type="password" name="password" required />
				</p>
				<p>
					<input type="checkbox" name="remember"
						<c:if test="${cookie.containsKey('usernameCust')}">checked</c:if> />

					<label style="font-weight: 100; font-size: 70%;">Remember
						me</label>
				</p>

				<p>
					<input class="btn btn-info btn-bg" type="submit" value="Login" />
					<a href="/addcustomer">Register Here</a>
				</p>


			</form>

			<div>
				<p style="color: #b94470; font-size: 110%;">${loginfail}
				<p>
			</div>


		</div>
</div>
<!--</body>
</html> -->