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
 
<a href="${pageContext.request.contextPath}/room">NEW</a>
 
<br />
<a href="main">Back</a>
<br />
<br /> 
<input type="text" id="myInput" onkeyup="myFunction()" placeholder="kode ruangan">
<table border="1" id="myTable">
 <tr>
 	<th>KodeRuangan</th>
   <th>Gedung</th>
   <th>Nama Ruangan</th>
   <th>Lantai</th>
   <th colspan="2">Actions</th>
 </tr>
 <c:forEach items="${roomList}" var="info">
 
 <tr> 
   <td> ${info.roomCode}  </td>
   <td> ${info.buildingNum}  </td>
   <td> ${info.name}  </td>
   <td> ${info.floorNum}  </td>
   <td> <form action="room/${info.id}" method="GET" > <input type="submit" value="delete"> </form> </td>
   <td> <a href="room/${info.id}/edit">Edit</a> </td>
 </tr>    
 
 </c:forEach>
</table>
<c:if test="${not empty message}">
  
   <div class="message">${message}</div>
</c:if>
 <a href="main">Back</a>
 
 <script>
function myFunction() {
  // Declare variables
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}
</script>
</body>
</html>