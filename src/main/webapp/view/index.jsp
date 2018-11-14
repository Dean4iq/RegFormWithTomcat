<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <html>
    <head>
        <title>Contact data</title>
    </head>
    <body>
        <h1>Welcome</h1><br />
         <h2>Contacts</h2><br />
         <c:forEach var="contact" items="${requestScope.contacts}">
            <ul>
                 <li>Имя: <c:out value="${contact.name}"/></li>
                 <li>Возраст: <c:out value="${contact.group}"/></li>
            </ul>
            <hr />
         </c:forEach>
         <h2>Создание нового пользователя</h2><br />
         <form method="post" action="">
             <label><input type="text" name="name"></label>Имя<br>
             <label><input type="text" name="group"></label>Возраст<br>
             <input type="submit" value="Ok" name="Ok"><br>
        </form>
    </body>
</html>