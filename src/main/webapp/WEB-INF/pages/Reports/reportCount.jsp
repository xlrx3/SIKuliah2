<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jumlah MK Tiap Jurusan</title>
</head>
<body>
 
<%-- <a href="${pageContext.request.contextPath}/createMataKuliah">Create Mata Kuliah</a> --%>
 
<br/>
 
<table border="1">
 <tr>
   <th>Jurusan</th>
   <th>Jumlah MK</th>
 </tr>
 <c:forEach items="${repCount}" var="info">
 
 <tr>
   <td> ${info[0].getNamaJurusan()}  </td>
   <td> ${info[1]}  </td>
 </tr>    
 
 </c:forEach>
</table>
<c:if test="${not empty message}">
  
   <div class="message">${message}</div>
</c:if>
 
 <a href="reportList">Back</a>
</body>
</html>