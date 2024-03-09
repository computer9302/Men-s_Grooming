<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
</head>
<body>
	<h2>User Registration</h2>
	<form action="register" method="POST">
		<label for="Id">Id:</label>
		<input type="text" id="Id" name="Id" required><br><br>
		
		<label for="password">PassWord</label>
		<input type="password" id="password" name="password" required><br><br>
	
		<label for="password2">PassWord2</label>
		<input type="password2" id="password2" name="password2" required><br><br>
	
		<label for="address">Address</label>
		<input type="address" id="address" name="address" required><br><br>
		
		<label for="phone_number">Phone_number</label>
		<input type="phone_number" id="phone_number" name="phone_number" required><br><br>
	
		<label for="email">Email</label>
		<input type="email" id="email" name="email" required><br><br>
	
		<button type="submit">Register</button>
	</form>
</body>
</html>