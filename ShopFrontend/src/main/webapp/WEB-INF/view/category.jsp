<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
<spring:form action="${pageContext.request.contextPath}/addCategory" modelAttribute="cat" method="post">
<c:if test="${not empty cat.categoryName}">
CategoryId<spring:input type="text" path="categoryId" readonly="true" disabled="true"/>
<spring:hidden path="categoryId"/>
</c:if>

Category Name<spring:input type="text" path="categoryName"/>
Category Description<spring:input type="text" path="categoryDescription"/><br>
<c:if test="${empty cat.categoryName}"><input type="submit" value="Add"/></c:if>
<c:if test="${not empty cat.categoryName}"><input type="submit" value="Update"/></c:if>
</spring:form>


<c:if test="${not empty categoryList}">

<table border="1">
<tr><td>categoryId</td>
<td>categoryName</td>
<td>categoryDesc</td>

<td>Edit</td>
<td>delete</td>
</tr>
<c:forEach items="${categoryList}" var="cate">
<tr>
<td>${cate.categoryId}</td>
<td>${cate.categoryName}</td>
<td>${cate.categoryDescription}</td>

<td><a href="editCategory/${cate.categoryId}">Edit</a></td>

<td><a href="deleteCategory/${cate.categoryId}">delete</a></td>
</tr>


</c:forEach>
</table>

</c:if>

</body>
</html>