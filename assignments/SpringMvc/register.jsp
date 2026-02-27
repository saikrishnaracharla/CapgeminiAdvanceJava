<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Page</title>
</head>
<body>
    <h2>Create a New Account</h2>
    
    <form action="registerProcess" method="post">
        <label>Full Name:</label><br>
        <input type="text" name="name" required><br><br>
        
        <label>Email Address:</label><br>
        <input type="email" name="email" required><br><br>
        
        <label>Set Password:</label><br>
        <input type="password" name="password" required><br><br>
        
        <button type="submit">Register</button>
    </form>
    
    <br>
    <a href="./">Back to Home</a>
</body>
</html>
