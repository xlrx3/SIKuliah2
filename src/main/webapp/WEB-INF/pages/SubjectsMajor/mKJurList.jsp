<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MK-Jur List</title>
<link rel="stylesheet"  type="text/css"  href="css/bootstrap-table-1.css">
</head>
<body>
 
<a href="${pageContext.request.contextPath}/subjectMajor">Create MK-Jur</a>
 
<br />
<a href="main">Back</a>
 
<table border="1">
 <tr>
   <th>Jurusan</th>
   <th>MataKuliah</th>
   <th>Delete</th>
<!--    <th>Edit</th> -->
 </tr>
 <c:forEach items="${mKJurInfo}" var="info">
 
 <tr>
   <td> ${info.jurusan.namaJurusan}  </td>
   <td> ${info.mk.nama_MK}  </td>
   <td> <a href="subjectMajor/${info.id }">Delete</a> </td>
<%--    <td> <a href="subjectMajor/${info.id}/edit">Edit</a> </td> --%>
 </tr>    
 
 </c:forEach>
</table>
<c:if test="${not empty message}">
  
   <div class="message">${message}</div>
</c:if>
  <a href="main">Back</a>
</body>
</html>