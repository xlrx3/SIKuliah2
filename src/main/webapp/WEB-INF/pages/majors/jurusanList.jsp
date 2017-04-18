<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jurusan List</title>
<link rel="stylesheet"  type="text/css"  href="css/bootstrap-table-1.css">
</head>
<body>
 
<a href="${pageContext.request.contextPath}/major">NEW</a>
 
<br />
<a href="main">Back</a>
 
<table border="1">
 <tr>
 	<th>Id</th>
 	   <th>KodeJurusan</th>
   <th>NamaJurusan</th>
   <th>FakultasJurusan</th>
   <th>KepalaJurusan</th>
   <th colspan="2">Actions</th>>
 </tr>
 <c:forEach items="${jurusanInfo}" var="info">
 
 <tr> 
   <td> ${info.idJurusan}  </td>
   <td> ${info.code}  </td>
   <td> ${info.namaJurusan}  </td>
   <td> ${info.fakultasJurusan}  </td>
   <td> ${info.kepalaJurusan}  </td>
   <td> <form action="major/${info.idJurusan}" method="GET" > <input type="submit" value="delete"> </form> </td>
   <td> <a href="major/${info.idJurusan}/edit">Edit</a> </td>
 </tr>    
 
 </c:forEach>
</table>
<c:if test="${not empty message}">
  
   <div class="message">${message}</div>
</c:if>
 <a href="main">Back</a>
</body>
</html>