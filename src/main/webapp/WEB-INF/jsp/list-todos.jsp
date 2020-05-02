<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <title>ToDos for ${name}</title>
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
<%@ include file="common/footer.jspf" %>