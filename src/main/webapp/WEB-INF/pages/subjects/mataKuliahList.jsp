<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mata Kuliah List</title>
<link rel="stylesheet"  type="text/css"  href="css/bootstrap-table-1.css">
</head>
<body>
 
<a href="${pageContext.request.contextPath}/subject">Create Mata Kuliah</a>
 
<br />
<a href="main">Back</a>
 
<table border="1">
 <tr>
   <th>id_MK</th>
   <th>Nama_MK</th>
   <th>SKS</th>
   <th>Semester</th>
   <th>Edit</th>
   <th>Delete</th>
 </tr>
 <c:forEach items="${mKInfo}" var="info">
 
 <tr>
   <td> ${info.id_MK}  </td>
   <td> ${info.nama_MK}  </td>
   <td> ${info.SKS}  </td>
   <td> ${info.semester}  </td>
   <td> <a href="subject/${info.id_MK}">Delete</a> </td>
   <td> <a href="subject/${info.id_MK}/edit">Edit</a> </td>
 </tr>    
 
 </c:forEach>
</table>
<c:if test="${not empty message}">
  
   <div class="message">${message}</div>
</c:if>
 <a href="main">Back</a>
</body>
</html>