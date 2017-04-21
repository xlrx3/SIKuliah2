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
 
<br />
<br />
<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Nama/NPM mahasiswa">
<a href="main">Back</a>
 
<table border="1" id="myTable">
 <tr>
   <th>NPM</th>
   <th>Nama Mahasiswa</th>
   <th>Angkatan</th>
   <th>Status</th>
   <th>Jurusan</th>
   <th colspan="4">Actions</th>

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
   <td> <a href="report/4/${info.id }">MK yang sudah diambil</a>
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
    td2 = tr[i].getElementsByTagName("td")[1];
    if (td || td2 ) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1 || td2.innerHTML.toUpperCase().indexOf(filter) > -1 ) {
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