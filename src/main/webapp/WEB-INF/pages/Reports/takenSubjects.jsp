<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mahasiswa dengan MK terbanyak</title>
<link rel="stylesheet"  type="text/css"  href="${pageContext.request.contextPath}/css/bootstrap-table-1.css">
</head>
<body>
 
<%-- <a href="${pageContext.request.contextPath}/createMataKuliah">Create Mata Kuliah</a> --%>
 
<br/>
 	<h3>Nama : ${student.nama} </h3>
	<h3>NPM : ${student.NPM} </h3>
	<h3>Status : ${student.status} </h3>
	<h3 " align="center"> Telah Mengambil : </h3>
	
<table border="1" align="center">
 <tr>
   <th>Mata Kuliah</th>
   <th>SKS</th>
 </tr>
 <c:forEach items="${taken}" var="info">
 
 <tr>
   <td> ${info.mk.nama_MK}  </td>
   <td>${info.mk.SKS}</td>
 </tr>    
 
 </c:forEach>
</table>
<c:if test="${not empty message}">
  
   <div class="message">${message}</div>
</c:if>
  <a href="${pageContext.request.contextPath}/students">Students</a> 
  <br />
  
  <a href="${pageContext.request.contextPath}/majors">Majors</a>
</body>
</html>