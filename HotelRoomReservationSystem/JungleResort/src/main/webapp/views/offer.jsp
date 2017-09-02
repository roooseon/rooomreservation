<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	// get all list function
	var modelList;
	function getList(event) {
		$.ajax({
			url : "offers",
			//beforeSend: function(xhr){xhr.setRequestHeader(header, token);},
			type : "GET",
			error : function(response) {
				$("#div1").html("Cannot be selected");
			},
			success : function(result, status) {
				//var models = JSON.parse(result);
				//$("#div1").html("Dipen "+ models);	
				var json = JSON.stringify(result);

				/* var options = $("#nameList");
					options.empty();
					$.each(result, function() {

						options.append($("<option />").val(this.offerName).text(
								this.offerName));
					});  */

				$("#div1").html(json);
			}

		});
	}

	//getSpecefic Model
	function getModel(event) {
		var name = $("#offerId").val();
		$.ajax({
			url : "offers/" + name,
			//beforeSend: function(xhr){xhr.setRequestHeader(header, token);},
			type : "GET",
			error : function(response) {
				$("#div2").html("Cannot be selected");
			},
			success : function(result, status) {
				var json = JSON.stringify(result);
				modelList = json;
				$("#div1").html(json);
			}

		});
	}

	// delete model
	function deleteModel(event) {
		var name = $("#offerId").val();
		$.ajax({
			url : "offers/" + name,
			//beforeSend: function(xhr){xhr.setRequestHeader(header, token);},
			type : "DELETE",
			error : function(response) {
				$("#div1").html("Cannot be Deleted");
			},
			success : function(result, status) {
				alert("Successfully deleted offer with " + name);
				getList();
			}

		});
	}
	/*
	// 	// post operation
	// 	$(document).ready(function() {
	// 		var url = "models";

	// 		$("#submitBtn").click(function(e) {
	// 			e.preventDefault();
	// 			var name = $("#name").val();
	// 			var address = $("#address").val();
	// 			var rollno = $("#rollno").val();

	// 			//  var search = $("#nameForm").serialize();
	// 			var search = {
	// 				"name" : name,
	// 				"address" : address,
	// 				"rollno" : rollno
	// 			};
	// 			//  alert(search);

	// 			$.ajax({
	// 				type : "POST",
	// 				contentType : 'application/json; charset=utf-8',
	// 				dataType : 'json',
	// 				url : url,
	// 				data : JSON.stringify(search), // Note it is important
	// 				success : function(result) {
	// 					// do what ever you want with data
	// 					getList();
	// 				}
	// 			});
	// 		});

	// 		//select data for update
	// 		$("#getDataToUpdate").click(function(e) {
	// 			var json = JSON.parse(modelList);
	// 			$('#name').val(json["name"]);
	// 			$("#address").val(json["address"]);
	// 			$("#rollno").val(json["rollno"]);
	// 		});

	// 		// update Data
	// 		$("#update").click(function(e) {
	// 			e.preventDefault();
	// 			var SelectedName = $("#nameList").val();
	// 			var name = $("#name").val();
	// 			var address = $("#address").val();
	// 			var rollno = $("#rollno").val();

	// 			//  var search = $("#nameForm").serialize();
	// 			var search = {
	// 				"name" : name,
	// 				"address" : address,
	// 				"rollno" : rollno
	// 			};
	// 			//  alert(search);

	// 			$.ajax({
	// 				type : "PUT",
	// 				contentType : 'application/json; charset=utf-8',
	// 				dataType : 'json',
	// 				url : "models/" + SelectedName,
	// 				data : JSON.stringify(search), // Note it is important
	// 				success : function(result) {
	// 					// do what ever you want with data
	// 					getList();
	// 				}
	// 			});
	// 		});

	// 	});
	 */
</script>
<div class="container" class="row" style="margin-top: 120px">
	<div class="col col-md-6">
		<h1>Rest Operations with offers</h1>

		<button id="btn_get_all" onclick="getList()">Select List</button>
		<input type="text" id="offerId" />
		<button id="btn_get" onclick="getModel()">Select By ID</button>
		<button id="delete_model" onclick="deleteModel()">Delete By
			Id</button>

		<!-- 	<button id="getDataToUpdate">Get Data To Update</button> -->




		<div id="div1"></div>
		<div id="div2"></div>

	</div>
	<div class="col col-md-6">

		<form> 
<input type="text" id="offerId"/> <input type = "submit" onclick="getModel()" value = "Find By Id"/>
</form>
			<div id="content">
			<div class="form-group">
				<form id="nameForm">
					Offer Id: <input class="form-control" type="text" id="name" name="name" /><br /> Offer Name: <input
						type="text" class="form-control"  id="address" name="address" /><br />  Description : <input
						type="text" class="form-control"  id="rollno" name="rollno" /><br />
						Offer Date: <input class="form-control"  type="text" id="name" name="name" /><br /> Offered By : <input
						type="text" id="address" class="form-control"  name="address" /><br />
					<button id="submitBtn" class= "btn btn-success" onclick="saveModel()">Submit</button>
					<button class="btn btn-info btn-bg" id="update">Update</button>
				</form>
				</div>
		<!-- 	</div> -->
	</div>
	</div>
</div>