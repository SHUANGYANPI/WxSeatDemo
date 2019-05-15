<%--
  Created by IntelliJ IDEA.
  User: 王长城
  Date: 2019/4/29
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>测试成功</h3>
    <a href="/studentController/findOneStudent">测试</a>

    <form action="/studentController/testWx" method="post">
        用户姓名:<input type="text" name="uname"><br/>
        <input type="submit" value="submit"/>
    </form>

</body>
</html>
