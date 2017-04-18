<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Schedules</title>
<link rel="stylesheet"  type="text/css"  href="css/bootstrap-table-1.css">
</head>
<body>
 
<a href="${pageContext.request.contextPath}/schedule">NEW</a>
<br />
<a href="main">Back</a>
 
<br/>
 
<table border="1">
 <tr>
   <th>Mata Kuliah</th>
   <th>Ruangan</th>
   <th>Hari</th>
   <th>Mulai</th>
   <th>Selesai</th>
   <th colspan="2">Actions</th>

 </tr>
 <c:forEach items="${jadwalInfo}" var="info">
 
 <tr>
   <td> ${info.mk.nama_MK}  </td>
   <td> ${info.ruangan}  </td>
   <td> ${info.hari}  </td>
   <td> ${info.jam_mulai}  </td>
    <td> ${info.jam_selesai}  </td>
   <td> <a href="schedule/${info.id }">Delete</a> </td>
   <td> <a href="schedule/${info.id}/edit">Edit</a> </td>
 </tr>    
 
 </c:forEach>
</table>
<c:if test="${not empty message}">
  
   <div class="message">${message}</div>
</c:if>
 <a href="main">Back</a>
</body>
</html>