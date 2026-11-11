<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Counter Servlet</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br>
<br>
<a href="CounterServlet?inc=1">CounterServlet GET</a>

<form action="CounterServlet" method="GET">
    <br>inc: <input type="text" name="inc" value="1">
    <br><input type="submit" value="CounterServler GET">
</form>
<form action="CounterServlet" method="POST">
    <br>inc: <input type="text" name="inc" value="1">
    <br>dec: <input type="text" name="dec" value="1">
    <br><input type="submit" value="CounterServlet POST">
</form>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>