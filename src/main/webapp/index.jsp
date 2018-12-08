<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 29.11.2018
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/login">
    <input type="text" name="login"><br/>
    <input type="password" name="pass"><br/><br/>
    <input class="button" type="submit" value="Войти">

</form>

</body>
</html>
