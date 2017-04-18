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
 
<table border="1" align="center">
 <tr>
   <th>Mahasiswa</th>
   <th>Jumlah MK</th>
 </tr>
 <c:forEach items="${repCount}" var="info">
 
 <tr>
   <td> ${info[0].getNama()}  </td>
   <td> ${info[1]}  </td>
 </tr>    
 
 </c:forEach>
</table>
<c:if test="${not empty message}">
  
   <div class="message">${message}</div>
</c:if>
  <a href="${pageContext.request.contextPath}/reportList">Back</a>
</body>
</html>