<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <html>
    <head>
        <title>Contact data</title>
    </head>
    <body>
        <h1>Welcome</h1><br />
         <h2>Records</h2><br />
         <table border="1">
             <tr align="center">
                <th>First name</th>
                <th>Last name</th>
                <th>Login</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Comment</th>
             </tr>
             <c:forEach var="record" items="${requestScope.tableData}">
                 <tr align="center">
                     <td>
                         <c:out value="${record.firstName}"/>
                     </td>
                     <td>
                         <c:out value="${record.lastName}"/>
                     </td>
                     <td>
                         <c:out value="${record.login}"/>
                     </td>
                     <td>
                         <c:out value="${record.phoneNumber}"/>
                     </td>
                     <td>
                         <c:out value="${record.email}"/>
                     </td>
                     <td>
                         <c:out value="${record.comment}"/>
                     </td>
                 </tr>
             </c:forEach>
         </table>
         <h2>Создание нового пользователя</h2><br />
         <form method="post" action="">
             <label><input type="text" name="firstNameField"></label>First name<br>
             <label><input type="text" name="lastNameField"></label>Last name<br>
             <label><input type="text" name="loginField"></label>Login<br>
             <label><input type="text" name="commentField"></label>Comment<br>
             <label><input type="text" name="phoneField"></label>Phone<br>
             <label><input type="text" name="emailField"></label>E-mail<br>
             <input type="submit" value="Add" name="addValue"><br>
        </form>
    </body>
</html>