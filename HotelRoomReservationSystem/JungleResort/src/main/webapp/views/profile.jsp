<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
<script
	src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>


<div class="container" style="margin-top: 100px;">
	<div class="profile-head">
		<div class="col-md- col-sm-4 col-xs-12">
			<img
				src="https://scontent-dft4-1.xx.fbcdn.net/v/t1.0-9/15589593_1297298750330006_3781871071582323916_n.jpg?oh=c9cb84ff92d08c5fe39489ce4a6a3da1&oe=593F3325"
				class="img-responsive" />
		</div>
		<!--col-md-4 col-sm-4 col-xs-12 close-->


		<div class="col-md-5 col-sm-5 col-xs-12">
			<h3><strong>${customer.name}</strong></h3>
			<p>Jungle Resort Customer</p>
			<ul>
				<li><span class="glyphicon glyphicon-user"></span> UserName:
				${customer.username}</li>

				<li><span class="glyphicon glyphicon-home"></span> 1000 North
					4th Street, Fairfield, U.S.A.</li>
				<li><span class="glyphicon glyphicon-phone"></span> <a href="#"
					title="call">${customer.phoneNumber}</a></li>
				<li><span class="glyphicon glyphicon-envelope"></span><a
					href="#" title="mail">${customer.email}</a></li>

			</ul>


		</div>
		<!--col-md-8 col-sm-8 col-xs-12 close-->




	</div>
	<!--profile-head close-->
</div>
<!--container close-->


<div style = "padding-top:100px" class="container">

	<!-- Nav tabs -->
	<ul class="nav nav-tabs nav-menu" role="tablist">
		<li class="active"><a href="#profile" role="tab"
			data-toggle="tab"> <i class="fa fa-male"></i> Profile
		</a></li>
		<li><a href="#change" role="tab" data-toggle="tab"> <i
				class="fa fa-key"></i> Edit Profile
		</a></li>
	</ul>
	<!--nav-tabs close-->

	<!-- Tab panes -->
	<div class="tab-content">
		<div class="tab-pane fade active in" id="profile">
			<div class="container">
				<div class="col-sm-11" style="float: left;">
					<div class="hve-pro">
						<p>Welcome ${customer.name}. Thanks for choosing Jungle Side
							Resort. You will never let your expectations down!! Wish you the
							best days ahead!!</p>
					</div>
					<!--hve-pro close-->
				</div>
				<!--col-sm-12 close-->
				<br clear="all" />
				<div class="row">
					<div class="col-md-12">
						<h4 class="pro-title">Bio Graph</h4>
					</div>
					<!--col-md-12 close-->


					<div class="col-md-6">

						<div class="table-responsive responsiv-table">
							<table class="table bio-table">
								<tbody>
									<tr>
										<td>Name</td>
										<td>: ${customer.name}</td>
									</tr>

									<tr>
										<td>UserName</td>
										<td>: ${customer.username}</td>
									</tr>

									<tr>
										<td>User ID</td>
										<td>: ${customer.customerId}</td>
									</tr>

								</tbody>
							</table>
						</div>
						<!--table-responsive close-->
					</div>
					<!--col-md-6 close-->

					<div class="col-md-6">

						<div class="table-responsive responsiv-table">
							<table class="table bio-table">
								<tbody>
									<tr>
										<td>Address</td>
										<td>: U.S.A.</td>
									</tr>
									<tr>
										<td>Email Id</td>
										<td>: ${customer.email}</td>
									</tr>
									<tr>
										<td>Mobile</td>
										<td>: ${customer.phoneNumber}</td>
									</tr>

								</tbody>
							</table>
						</div>
						<!--table-responsive close-->
					</div>
					<!--col-md-6 close-->

				</div>
				<!--row close-->




			</div>
			<!--container close-->
		</div>
		<!--tab-pane close-->


		<div class="tab-pane fade" id="change">
			<div class="container fom-main">
				<div class="row">
					<div class="col-sm-12">
						<h2 class="register">Edit Your Profile</h2>
					</div>
					<!--col-sm-12 close-->

				</div>
				<!--row close-->
				<br />
				<div class="row">

					<form class="form-horizontal main_form text-left" action=" "
						method="post" id="contact_form">
						<fieldset>


							<div class="form-group col-md-12">
								<label class="col-md-10 control-label">First Name</label>
								<div class="col-md-12 inputGroupContainer">
									<div class="input-group">
										<input name="first_name" placeholder="First Name"
											class="form-control" type="text">
									</div>
								</div>
							</div>

							<!-- Text input-->

							<div class="form-group col-md-12">
								<label class="col-md-10 control-label">Last Name</label>
								<div class="col-md-12 inputGroupContainer">
									<div class="input-group">
										<input name="last_name" placeholder="Last Name"
											class="form-control" type="text">
									</div>
								</div>
							</div>

							<!-- Text input-->
							<div class="form-group col-md-12">
								<label class="col-md-10 control-label">E-Mail</label>
								<div class="col-md-12 inputGroupContainer">
									<div class="input-group">
										<input name="email" placeholder="E-Mail Address"
											class="form-control" type="text">
									</div>
								</div>
							</div>


							<!-- Text input-->

							<div class="form-group col-md-12">
								<label class="col-md-10 control-label">Phone #</label>
								<div class="col-md-12 inputGroupContainer">
									<div class="input-group">
										<input name="phone" placeholder="(845)555-1212"
											class="form-control" type="text">
									</div>
								</div>
							</div>

							<!-- Text input-->

							<div class="form-group col-md-12">
								<label class="col-md-10 control-label">Address</label>
								<div class="col-md-12 inputGroupContainer">
									<div class="input-group">
										<textarea class="form-control" name="comment"
											placeholder="Project Description"></textarea>
									</div>
								</div>
							</div>

							<div class="form-group col-md-12">
								<label class="col-md-10 control-label">Project
									Description</label>
								<div class="col-md-12 inputGroupContainer">
									<div class="input-group">
										<textarea class="form-control" name="comment"
											placeholder="Project Description"></textarea>
									</div>
								</div>
							</div>



							<div class="form-group col-md-12">
								<label class="col-md-10 control-label">Industry</label>
								<div class="col-md-12 selectContainer">
									<div class="input-group">
										<select name="state" class="form-control selectpicker">
											<option value=" ">Industry</option>
											<option>Industry</option>
											<option>Industry</option>
											<option>Industry</option>
										</select>
									</div>
								</div>
							</div>


							<!-- Select Basic -->

							<div class="form-group col-md-12">
								<label class="col-md-10 control-label">Qualification</label>
								<div class="col-md-12 selectContainer">
									<div class="input-group">
										<select name="state" class="form-control selectpicker">
											<option value=" ">your Qualification</option>
											<option>M.A.</option>
											<option>B.A.</option>
											<option>B.Ed</option>
										</select>
									</div>
								</div>
							</div>



							<div class="form-group col-md-12">
								<label class="col-md-10 control-label">Expertise areas</label>
								<div class="col-md-12 selectContainer">
									<div class="input-group">
										<select name="state" class="form-control selectpicker">
											<option value=" ">Expertise areas</option>
											<option>Expertise areas1</option>
											<option>Expertise areas1</option>
											<option>Expertise areas1</option>
										</select>
									</div>
								</div>
							</div>

							<div class="form-group col-md-12">
								<label class="col-md-10 control-label">Experience</label>
								<div class="col-md-12 selectContainer">
									<div class="input-group">
										<select name="state" class="form-control selectpicker">
											<option value=" ">your Experience</option>
											<option>1 year</option>
											<option>2 years</option>
											<option>3 years</option>
										</select>
									</div>
								</div>
							</div>

							<div class="form-group col-md-12">
								<label class="col-md-10 control-label">Salary expected</label>
								<div class="col-md-12 selectContainer">
									<div class="input-group">
										<select name="state" class="form-control selectpicker">
											<option value=" ">your Salary expectation</option>
											<option>50 thousand</option>
											<option>30thousand</option>
										</select>
									</div>
								</div>
							</div>

							<div class="form-group col-md-12">
								<label class="col-md-10 control-label">Preferred
									Location</label>
								<div class="col-md-12 selectContainer">
									<div class="input-group">
										<select name="state" class="form-control selectpicker">
											<option value=" ">your Preferred Location</option>
											<option>Chandigarh</option>
											<option>Chandigarh</option>
										</select>
									</div>
								</div>
							</div>

							<!--<div class="form-group col-md-12">
  <label class="col-md-10 control-label">Project Description</label>
    <div class="col-md-10 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-pencil hint_icon"></i></span>
        	<textarea class="form-control" name="comment" placeholder="Project Description"></textarea>
  </div>
  </div>
</div>-->


							<div class="form-group col-md-12">
								<label class="col-md-10 control-label">Choose Password</label>
								<div class="col-md-12 inputGroupContainer">
									<div class="input-group">
										<input name="first_name" placeholder="Choose Password"
											class="form-control" type="password">
									</div>
								</div>
							</div>



							<div class="form-group col-md-12">
								<label class="col-md-10 control-label">Confiram Password</label>
								<div class="col-md-12 inputGroupContainer">
									<div class="input-group">
										<input name="first_name" placeholder="Confiram Password"
											class="form-control" type="password">
									</div>
								</div>
							</div>


							<!-- radio checks -->
							<div class="form-group col-md-12">
								<label class="col-md-10 control-label">Gender</label>
								<div class="col-md-6">
									<div class="radio col-md-2">
										<label> <input type="radio" name="hosting" value="yes" />
											Male
										</label>
									</div>
									<div class="radio col-md-2">
										<label> <input type="radio" name="hosting" value="no" />
											Female
										</label>
									</div>
								</div>
							</div>

							<!-- upload profile picture -->
							<div class="col-md-12 text-left">
								<div class="uplod-picture">
									<span class="btn btn-default uplod-file"> Upload Photo <input
										type="file" />
									</span> <span class="btn btn-default uplod-file"> Upload Resume
										<input type="file" />
									</span> <span class="btn btn-default uplod-file"> Upload Video
										<input type="file" />
									</span>
								</div>
								<!--uplod-picture close-->
							</div>
							<!--col-md-12 close-->
							<!-- Button -->
							<div class="form-group col-md-10">
								<div class="col-md-6">
									<button type="submit" class="btn btn-warning submit-button">Save</button>
									<button type="submit" class="btn btn-warning submit-button">Cancel</button>

								</div>
							</div>
						</fieldset>
					</form>
				</div>
				<!--row close-->
			</div>
			<!--container close -->
		</div>
		<!--tab-pane close-->
	</div>
	<!--tab-content close-->
</div>
<!--container close-->

</section>
<!--section close-->

<!-- Displaying the lists of booked rooms -->
<%--<section>
 <div class="table-responsive">
		<div class="tab-pane fade active in" id="profile">
			<div class="container">

				<section>
					<h1>All Rooms list</h1>
					<div>
						<div>
							<span>Booking ID</span> <span>Room ID</span> <span>Customer
								ID</span> <span>Start Date</span> <span>End Date</span>


						</div>
						<c:forEach items="${booking}" var="booking">
							<div>
								<span>${booking.id}</span> <span>${booking.roomId}</span> <span>${booking.customerId}</span>
								<span>${booking.startDate}</span> <span>${booking.endDate}</span>

								<span>
									<form action="/bookingDetail/${booking.id}">
										<input type="submit" value="Detail" />
									</form>
								</span>
							</div>
						</c:forEach>
					</div>

				</section>
			</div>
			<!--table-responsive close-->
		</div>
		<!--col-md-6 close-->

	</div> --%>
	<div class="container">
<section>
	<h2>My booked rooms</h2>
	<table id="roomTableCustomer" class="display">
		<thead>
			<tr>
				<th>Room No.</th>
				<th>Room Type</th>
				<th>Guest Capacity</th>
				<th>Start Date</th>
				<th>End Date</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${booking}" var="booking">
				<tr>
					<td>${booking.roomNo}</td>
					<td>${booking.roomType}</td>
					<td>${booking.guestNo}</td>
					<td>${booking.startDate}</td>
					<td>${booking.endDate}</td>
					
<!-- 					<td> -->
<%-- 						<form action="/roomDetail/${room.id}"> --%>
<!-- 							<input type="submit" value="Detail" /> -->
<!-- 						</form> -->
<!-- 					</td> -->
				</tr>
			</c:forEach>
		</tbody>
	</table>

</section>

</div>
<script>
	$(document).ready(function() {
		var table = $('#roomTableCustomer').DataTable()
	});
</script>