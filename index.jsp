<!DOCTYPE html>
<html>
<head>
	<title>Registration Page</title>
	<style>
		#form1 label.error {
    		color: red;
    		display: inline;
    		font-size: 12px;
    		margin: 0 0 0 5px;
		}
	</style>
</head>
<body>
	<fieldset>
		<legend>Personal Details</legend>
			<form id="form1" action="" method="post" novalidate="novalidate">
				<br>
				Name:
				<br>
				<input type="text" name="name"/>
				<br>
				<br>
				Age:
				<br>
				<input type="text" name="age"/>
				<br>
				<br>
				Email:
				<br>
				<input type="text" name="email"/>
				<br>
				<br>
				<br>
				State:
				<br>
				<select id="state"  onchange="populate_cities();">
					<option value="Select">--Select--</option>
					<option value="Karnataka">Karnataka</option>
					<option value="Rajasthan">Rajasthan</option>
					<option value="UttarPradesh">Uttar Pradesh</option>
				</select>
				<br>
				<br>
				City:
				<br>
				<select name="city" id="city">
					<option>--Choose City--</option>
				</select>
				<br>
				<br>
				<br>
				<button type="button" onclick="show_items();">Show Items</button>
				<br>
				<div id="list"></div>
				<br>
				Enter Items:
				<br>
				<input type="text" name="item" id="itemId"/>
				<br>
				<br>
				<br>
				
				<button type="submit">Submit</button>
				&nbsp;&nbsp;&nbsp; 
				<button type="reset" onClick="window.location.reload()">Reset</button>
				<br>
				<br>
			</form>
	</fieldset>
</body>

<script type="text/javascript" src="web/js/prototype.js"></script>
<script type="text/javascript" src="web/js/jquery-min.js"></script>
<script type="text/javascript" src="web/js/jquery-validate-min.js"></script>
<script type="text/javascript" src="web/js/ajax.js"></script>
</html>