<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
<script
	src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
<section>
<div class="container" style="margin-top: 100px">
	<h2>All Available Rooms list</h2>
	<table id="roomTable" class="display">
		<thead>
			<tr>
				<th>Room No.</th>
				<th>Room Type</th>
				<th>Room Category</th>
				<th>Daily Rent</th>
				<th>Guest Capacity</th>
				<th>Room Features</th>
				<th>Images List</th>
				<th>&nbsp;</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${availablerooms}" var="availablerooms">
				<tr>
					<td>${availablerooms.roomNo}</td>
					<td>${availablerooms.roomType}</td>
					<td>${availablerooms.roomCategory}</td>
					<td>${availablerooms.dailyRent}</td>
					<td>${availablerooms.guestNo}</td>
					<td><c:forEach var="roomFeatures"
							items="${availablerooms.roomFeatures}">
							<c:out value="${roomFeatures}" />
						</c:forEach></td>


					<!-- 				<td><img alt="image" height="30px" width="30px" -->
					<%-- 					src="data:image/jpeg; base64,${allrooms.encodeImage}" /></td> --%>
					<td><c:forEach items="${availablerooms.image2}"
							var="imagesSet">
							<img alt="image" height="30px" width="30px"
								src="data:image/jpeg; base64,${imagesSet.encodeImage3}" />

						</c:forEach></td>

					<td>
						<form action="/roomDetail/${availablerooms.id}">
							<input type="submit" value="Detail" />
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</section>
<script>
	$(document).ready(function() {
		var table = $('#roomTable').DataTable()
	});
</script>