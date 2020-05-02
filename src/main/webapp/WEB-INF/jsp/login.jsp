<html>
<head>
    <link href="webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <title>First Web Application</title>
</head>
<body>
<form method="post">
    Name: <input type="text" name="name"/>
    Password: <input type="password" name="password">
    <input type="submit" name="submit"/>
    <br>
    <span style="color: red; ">${errorMessage}</span>
</form>
</body>
<script src="webjars/jquery/3.2.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</html>