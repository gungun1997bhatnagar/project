<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
<spring:form action="${pageContext.request.contextPath}/addProduct" modelAttribute="pro" method="post">
<c:if test="${not empty pro.productName}">
ProductId<spring:input type="text" path="productId" readonly="true" disabled="true"/>
<spring:hidden path="productId"/>
</c:if>

Product Name<spring:input type="text" path="productName"/>
Product Description<spring:input type="text" path="productDescription"/><br>
<c:if test="${empty pro.productName}"><input type="submit" value="Add"/></c:if>
<c:if test="${not empty pro.productName}"><input type="submit" value="Update"/></c:if>
</spring:form>


<c:if test="${not empty productList}">

<table border="1">
<tr><td>productId</td>
<td>productName</td>
<td>productDesc</td>

<td>Edit</td>
<td>delete</td>
</tr>
<c:forEach items="${productList}" var="prod">
<tr>
<td>${prod.productId}</td>
<td>${prod.productName}</td>
<td>${prod.productDescription}</td>

<td><a href="editProduct/${prod.categoryId}">edit</a></td>


<td><a href="deleteProduct/${prod.categoryId}">delete</a></td>
</tr>


</c:forEach>
</table>

</c:if>




</body>
</html>