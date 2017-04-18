<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Mata Kuliah</title>
<link rel="stylesheet"  type="text/css"  href="${pageContext.request.contextPath}/css/form_1.css">
</head>
<body>
 
   <h3>${formTitle}</h3>
  <div class="form-style-10">
   <form:form action="edit/save" method="POST"
       modelAttribute="mataKuliahForm">
      
       <form:hidden path="id_MK" />
 
       <table>
           <tr>
               <td>Nama_MK</td>
               <td><form:input path="nama_MK" /></td>
               <td><form:errors path="nama_MK"
                       class="error-message" /></td>      
           </tr>
           
                      <tr>
               <td>SKS</td>
               <td><form:input path="SKS" /></td>
               <td><form:errors path="SKS"
                       class="error-message" /></td>      
           </tr>
           
                      <tr>
               <td>Semester</td>
			  <td>
			  <form:select path="semester" >
					<c:forEach items="${smtList}"  var="semester">
    					<option value="${semester}">${semester}</option>
					</c:forEach>
			      </form:select>
	          </td>       
           </tr>
 
           <tr>
               <td>&nbsp;</td>
               <td><input type="submit" value="Submit" />
                  <a href="${pageContext.request.contextPath}/mataKuliahList">Cancel</a>
               </td>
               <td>&nbsp;</td>
           </tr>
       </table>
       
   </form:form>
 </div>
</body>
</html>