<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mahasiswa List</title>
<link rel="stylesheet"  type="text/css"  href="css/bootstrap-table-1.css">
</head>
<body>
 
<a href="${pageContext.request.contextPath}/student">NEW</a>
 
<br/>
 
<table border="1">
 <tr>
   <th>NPM</th>
   <th>Nama Mahasiswa</th>
   <th>Angkatan</th>
   <th>Status</th>
   <th>Jurusan</th>
   <th colspan="3">Actions</th>

 </tr>
 <c:forEach items="${mahasiswaInfo}" var="info">
 
 <tr>
   <td> ${info.NPM}  </td>
   <td> ${info.nama}  </td>
   <td> ${info.angkatan}  </td>
   <td> ${info.status}  </td>
   <td> ${info.jurusan.namaJurusan}  </td>
   <td> <a href="student/${info.id}">Delete</a> </td>
   <td> <a href="student/${info.id}/edit">Edit</a> </td>
   <td> <a href="preCreateFRS/${info.id }">FRS</a> </td>
 </tr>    
 
 </c:forEach>
</table>
<c:if test="${not empty message}">
  
   <div class="message">${message}</div>
</c:if>
 <a href="main">Back</a>
</body>
</html>