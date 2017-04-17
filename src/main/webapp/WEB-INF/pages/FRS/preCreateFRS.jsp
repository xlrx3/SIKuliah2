<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<title>Choose Current Semester</title>
		<link rel="stylesheet"  type="text/css"  href="${pageContext.request.contextPath}/css/form-basic.css">
	</head>
	
	<body>
		<form:form action="${pageContext.request.contextPath}/FRS/${FRSid }" method="GET" modelAttribute="frsf">
			<table>
				<tr>
				<td></td>
					<td>
						<form:select path="semesters" >
							<c:forEach items="${smtList}"  var="semester">
    							<option value="${semester}">${semester}</option>
							</c:forEach>
			      		</form:select>
			      	</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
               		<td><input type="submit" value="Submit" />
                  	<a href="${pageContext.request.contextPath}/students">Cancel</a>
              		 </td>
               		<td>&nbsp;</td>
				</tr>
			</table>
		</form:form>
	</body>

</html>