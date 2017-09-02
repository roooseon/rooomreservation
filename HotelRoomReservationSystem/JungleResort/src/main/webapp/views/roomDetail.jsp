<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Room Detail</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$(".datepicker").datepicker();
	});
</script>

<hr>
<div class="container">
	<div class="col-md-8 col-md-offset-2" style="margin-top: 100px">
		<div>
			<!-- <div class="row">
				<div class="col-md-9"> -->
			<div class="row">

				<c:forEach items="${room.image2}" var="imagesSet">
					<div class="col-md-4">
						<img alt="image" height="225px" width="225px"
							src="data:image/jpeg; base64,${imagesSet.encodeImage3}" />
					</div>
				</c:forEach>

			</div>
			<!-- </div>
			</div> -->
			<div class="row">
				<div class="col-md-6">
					<div>
						<h1>Room No : ${room.roomNo}</h1>
					</div>
					<div>
						<span>Price : $</span>${room.dailyRent}</div>
					<div>
						<span>No. of Guest : </span>${room.guestNo}</div>
					<%-- <div>${product.manufacturer}</div> --%>
					<div>
						<span>Statu of Room : </span>${room.roomStatus}</div>
					<div>
						<span>Room Type : </span>${room.roomType}</div>
					<div>
						<span>Room Category : </span>${room.roomCategory}</div>

					<div>
						<span>Features :</span>
						<c:forEach var="roomFeatures" items="${room.roomFeatures}">
							<c:out value="${roomFeatures}" />
						</c:forEach>
					</div>
					<%-- <div>
							<span>Condition : </span>${room.condition}</div>
					</div> --%>
				</div>
				<form
					<c:choose>
    <c:when test="${empty user}">
       action="/customerlogin/${room.id}" method="get"
    </c:when>
    <c:otherwise>
        action="/booking/${user.username}/${room.id}" method="post"
    </c:otherwise>
</c:choose>>
					<div class="row">
						<br />
						<div class="col-md-6">
							<br /> <br /> <span>Start Date : <input type="text"
								class="datepicker" name="startDate"></span>
						</div>
						<div class="col-md-6">
							<br /> <br /> <span>End Date : <input type="text"
								class="datepicker" name="endDate"></span>
						</div>
					</div>
					<div></div>
					
			</div>
			<div>


				<input type="hidden" value="${room.id}" name="roomid" /> <input
					type="submit" class="btn btn-success" value="Book Now">
				</form>
			</div>
		</div>
	</div>
</div>
</body>
<hr>