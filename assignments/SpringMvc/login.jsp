<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <h2>Login to Your Account</h2>
    <p style="color: green;">${msgReg}</p>
    
    <form action="loginProcess" method="post">
        <label>Name:</label><br>
        <input type="name" name="name" required><br><br>
        
        <label>Password:</label><br>
        <input type="password" name="password" required><br><br>
        
        <button type="submit">Login</button>
    </form>
    
    <br>
    <a href="./">Back to Home</a>
</body>
</html>
