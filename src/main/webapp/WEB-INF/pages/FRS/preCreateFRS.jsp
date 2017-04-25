<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<title>Choose Current Semester</title>
		<link rel="stylesheet"  type="text/css"  href="${pageContext.request.contextPath}/css/form-basic.css">
	</head>
	
	<body>
	
	<h3>Silahkan Masukan Semester</h3>
		<form:form onsubmit="return checkInput(this);" action="${pageContext.request.contextPath}/FRS/${FRSid }" method="GET" modelAttribute="frsf">
			<table>
            <tr>
               <td>Semester</td>
               <td><form:input path="semesters" maxlength="2"  size="2" /></td>
               <td><form:errors path="semesters"
                       class="error-message" /></td>      
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
	
<script>
// var checkForm = function(form){
//     var inputs = form.getElementsByTagName('input');
//     for(var i = 0, l = inputs.length; i < l; i++){
//         var input = inputs[i];
//         if(input.type == "checkbox" && input.checked)
//             return true;
//     }
//     alert('Please checked at least 1 subject(s)');
//     return false;
// };
var checkInput = function(form){
	
	
}
</script>

</html>