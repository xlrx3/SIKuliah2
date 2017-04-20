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
<br />
<br /> 
<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Nama/kode Jurusan or Fakultas">
<table border="1" id="myTable">
 <tr>
 	<th>Id</th>
 	<th>KodeJurusan</th>
   <th>NamaJurusan</th>
   <th>FakultasJurusan</th>
   <th>KepalaJurusan</th>
   <th colspan="3">Actions</th>
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
   <td><a href="report/studentInMajor/${info.idJurusan}">Get List Student</a>
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
    td = tr[i].getElementsByTagName("td")[1];
    td2 = tr[i].getElementsByTagName("td")[2];
    td3 = tr[i].getElementsByTagName("td")[3];
    if (td || td2 || td3) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1 || td2.innerHTML.toUpperCase().indexOf(filter) > -1 || td3.innerHTML.toUpperCase().indexOf(filter) > -1 ) {
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