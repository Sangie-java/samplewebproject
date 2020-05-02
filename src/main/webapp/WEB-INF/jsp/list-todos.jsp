<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>>
<html>
<head>
    <title>ToDos for ${name}</title>
    <link href="webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <caption>Your todos are</caption>
    <br><br>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is it Done?</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.desc}</td>
                <td><fmt:formatDate value="${todo.targetDate}" pattern="dd/mm/yyyy"/></td>
                <td>${todo.done}</td>
                <td><a type="button" class="btn btn-success"
                       href="/update-todo?id=${todo.id}">Update</a></td>
                <td><a type="button" class="btn btn-warning"
                       href="/delete-todo?id=${todo.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <br><br>
        <a class="button" href="/add-todo">Add a Todo</a>
    </div>
</div>
<script src="webjars/jquery/3.2.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>