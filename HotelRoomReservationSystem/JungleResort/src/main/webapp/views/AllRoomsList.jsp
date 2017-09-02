<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
<script
	src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>

<div class="container" style="margin-top: 100px">
	<h2>All Rooms list</h2>
	<table id="roomTable" class="display">
		<thead>
			<tr>
				<th>Room No.</th>
				<th>Room Type</th>
				<th>Room Status</th>
				<th>Room Category</th>
				<th>Daily Rent</th>
				<th>Guest Capacity</th>
				<th>Room Features</th>
				<th>Images List</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allrooms}" var="allrooms">
				<tr>
					<td>${allrooms.roomNo}</td>
					<td>${allrooms.roomType}</td>
					<td>${allrooms.roomStatus}</td>
					<td>${allrooms.roomCategory}</td>
					<td>${allrooms.dailyRent}</td>
					<td>${allrooms.guestNo}</td>
					<td><c:forEach var="roomFeatures"
							items="${allrooms.roomFeatures}">
							<c:out value="${roomFeatures}" />
						</c:forEach></td>


					<!-- 				<td><img alt="image" height="30px" width="30px" -->
					<%-- 					src="data:image/jpeg; base64,${allrooms.encodeImage}" /></td> --%>
					<td><c:forEach items="${allrooms.image2}" var="imagesSet">
							<img alt="image" height="30px" width="30px"
								src="data:image/jpeg; base64,${imagesSet.encodeImage3}" />
						</c:forEach></td>

					<td>
						<form action="/deleteroom/${allrooms.id}">
							<input class="btn btn-danger" type="submit" value="Delete" />
						</form>
					</td>
					<td>
						<form action="/updateroom/${allrooms.id}">
							<input type="submit" class="btn btn-info btn-bg" value="Update" />
						</form>
					</td>
					<%-- <td>
					<form action="/roomDetail/${allrooms.id}">
						<input type="submit" value="Detail" />
					</form>
				</td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div>
		<form action="/addroom">
			<input type="submit" class="btn btn-success" value="Add New Room" />
		</form>
	</div>

</div>
<script>
	$(document).ready(function() {
		var table = $('#roomTable').DataTable()
	});
</script>