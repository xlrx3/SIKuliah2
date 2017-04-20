<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mahasiswa List</title>
<link rel="stylesheet"  type="text/css"  href="${pageContext.request.contextPath}/css/bootstrap-table-1.css">
</head>
<body>
 
<a href="${pageContext.request.contextPath}/majors">Majors</a>
 
<br />
 
<table border="1">
 <tr>
   <th>NPM</th>
   <th>Nama Mahasiswa</th>
   <th>Angkatan</th>
   <th>Status</th>
   <th>Jurusan</th>
   <th colspan="4">Actions</th>

 </tr>
 <c:forEach items="${listStudent}" var="info">
 
 <tr>
   <td> ${info.NPM}  </td>
   <td> ${info.nama}  </td>
   <td> ${info.angkatan}  </td>
   <td> ${info.status}  </td>
   <td> ${info.jurusan.namaJurusan}  </td>
   <td> <a href="${pageContext.request.contextPath}/student/${info.id}">Delete</a> </td>
   <td> <a href="${pageContext.request.contextPath}/student/${info.id}/edit">Edit</a> </td>
   <td> <a href="${pageContext.request.contextPath}/preCreateFRS/${info.id }">FRS</a> </td>
   <td> <a href="${pageContext.request.contextPath}/report/4/${info.id }">MK yang sudah diambil</a>
 </tr>    
 
 </c:forEach>
</table>
<c:if test="${not empty message}">
  
   <div class="message">${message}</div>
</c:if>
</body>
</html>