<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form Jadwal</title>
<link rel="stylesheet"  type="text/css"  href="${pageContext.request.contextPath}/css/form_1.css">
<link rel="stylesheet"  type="text/css"  href="${pageContext.request.contextPath}/css/clockpicker.css">
<link rel="stylesheet"  type="text/css"  href="${pageContext.request.contextPath}/css/standalone.css">
</head>
<body>
 
   <h3>${formTitle}</h3>
 
 <div class="form-style-10">
   <form:form action="${pageContext.request.contextPath}/schedule" method="POST"
       modelAttribute="jadwalForm">
      
       <form:hidden path="id" />
 
       <table>
       <tr>
        <td>Mata Kuliah</td>
               <td>
	                <form:select path="idMK" name="idMK">
	                    <c:forEach items="${id_mk}" var="mk">
	                    <option value="${mk.id_MK}" selected>${mk.nama_MK}</option>
	                     </c:forEach>
	                </form:select>
               </td>
               <td>&nbsp;</td>
           </tr>
           
           <tr>
               <td>Ruangan</td>
               <td><form:input path="ruangan" /></td>
               <td><form:errors path="ruangan"
                       class="error-message" /></td>      
           </tr>
           	
           	<tr>
               <td>Hari</td>
               <td>
				  <form:select path="hari" >
					<c:forEach items="${daysList}"  var="day">
    					<option value="${day}">${day}</option>
					</c:forEach>
			      </form:select>
			   </td>    
           </tr>
           
                      <tr>
               <td>Mulai</td>
               <td><form:input path="jam_mulai" /></td>
               <td><form:errors path="jam_mulai"
                       class="error-message" /></td>      
           </tr>
           <tr>
               <td>Selesai</td>
               <td><form:input path="jam_selesai" /></td>
               <td><form:errors path="jam_selesai"
                       class="error-message" /></td>      
           </tr>
           
           
           <tr>
              
 
           <tr>
               <td>&nbsp;</td>
               <td><input type="submit" value="Submit" />
                  <a href="${pageContext.request.contextPath}/schedules">Cancel</a>
               </td>
               <td>&nbsp;</td>
           </tr>
       </table>
       
   </form:form>
 </div>
</body>
</html>