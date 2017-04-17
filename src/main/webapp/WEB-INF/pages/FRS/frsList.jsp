<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FRS List</title>
<link rel="stylesheet"  type="text/css"  href="css/bootstrap-table-1.css">
</head>
<body>
 
<a href="${pageContext.request.contextPath}/students">FRS</a>
 
<br/>
 
<table border="1">
 <tr>
   <th>ID</th>
   <th>Mahasiswa</th>
   <th>Total SKS</th>
   <th>Tanggal FRS</th>
   <th>Dosen Wali</th>
   <th>Status</th>
    <th>Semester</th>
   <th>Delete</th>
   <th>Edit</th>
 </tr>
 <c:forEach items="${frsInfo}" var="info">
 
 <tr>
   <td> ${info[0]}  </td>
   <td> ${info[1]}  </td>
   <td> ${info[2]}  </td>
   <td> ${info[3]}  </td>
   <td> ${info[4]}  </td>
   <td> ${info[5]}  </td>
   <td> ${info[6]}  </td>
   <td> <a href="deleteFRS/${info[0]}">Delete</a> </td>
   <td> <a href="PRS/${info[0] }">PRS</a> </td>
    <td> <a href="viewDetail/${info[0]}">View Detail</a> </td>
 </tr>    
 
 </c:forEach>
</table>
<c:if test="${not empty message}">
  
   <div class="message">${message}</div>
</c:if>
 <a href="main">Back</a>
</body>
</html>