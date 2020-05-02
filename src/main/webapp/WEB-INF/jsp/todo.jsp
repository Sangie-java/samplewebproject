<html>
<head>
    <title>First Web Application</title>
    <link href="webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    Add to do page for ${name}
    <form method="post">
        <fieldset class="form-group">
            <label>Description</label>
            <input name="desc" type="text" class="form-control" required="required">
        </fieldset>
        <button type="submit" class="btn btn-success">Add</button>

    </form>
</div>
<script src="webjars/jquery/3.2.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>