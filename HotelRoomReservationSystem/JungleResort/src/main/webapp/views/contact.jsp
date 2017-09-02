<h2>Contact Here</h2>
<div id="msg"></div>
<form id="contact_form">
	<table>
		<tr>
			<td><label>Name</label></td>
			<td><input type="text" name="name" /></td>
		</tr>
		<tr>
			<td><label>Address</label></td>
			<td><textarea name="address"></textarea></td>
		</tr>
		<tr>
			<td><label>Phone</label></td>
			<td><input type="text" name="phone" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Save Contact" /></td>
		</tr>
	</table>
</form>
<script type="text/javascript">
	$(document).ready(
			function(e) {
				$("#contact_form").bind(
						"submit",
						function(event) {
							event.preventDefault();
							$.ajax({
								url : '/saveContact', // point to server-side controller
								dataType : 'html', // what to expect back from the controller
								cache : false,
								data : $("#contact_form").serialize(),
								type : 'post',
								success : function(response) {
									$('#msg').html(
											'<span style="color:green;">'
													+ response + '</span>'); // display success response from the controller
								},
								error : function(response) {
									$('#msg').html(
											'<span style="color:red;">'
													+ response + '</span>'); // display error response from the controller
								}
							});
						});
			});
</script>