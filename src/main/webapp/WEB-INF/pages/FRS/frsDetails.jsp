<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Details</title>
<link rel="stylesheet"  type="text/css"  href="${pageContext.request.contextPath}/css/bootstrap-table-1.css">
</head>
<body>

	<a href="${pageContext.request.contextPath}/FRSs">FRS</a>

	<br />
	
	<h3>Nama : ${mahasiswa} </h3>
	<h3>Dosen Wali : ${dosen} </h3>
	<h3>Semester : ${semester} </h3>
	
	<table border="1">
		<tr>
			<th>MataKuliah</th>
			<th>SKS</th>

		</tr>
		<c:forEach items="${frsDetailInfo}" var="info">

			<tr>
				<td>${info.mk.nama_MK}</td>
				<td>${info.sks}</td>

			</tr>

		</c:forEach>
	</table>
	<c:if test="${not empty message}">

		<div class="message">${message}</div>
	</c:if>

</body>
</html>