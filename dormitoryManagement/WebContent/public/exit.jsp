<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
   <ul class="nav navbar-nav navbar-right">
                        <li><a>欢迎您,<%=session.getAttribute("loginName") %></a>
                        </li>
                        <li><a href="/dor/servlet/RemoveServlet">安全退出</a>
                        </li> 
                    </ul>
</body>
</html>