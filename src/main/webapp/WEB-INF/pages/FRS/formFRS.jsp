<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FRS</title>
</head>
<body>
 
   <h3>${formTitle}</h3>
 
   <form:form action="saveFRS" method="POST"
       modelAttribute="frsForm">
     
       <form:hidden path="id" />
	   <form:hidden path="NPM" value="${mhsNPM}" />
       <table>
           <tr>
<!--                <td>Mahasiswa</td> -->
<!--                <td> -->
<%-- 	                <form:select path="NPM"> --%>
<%-- 	                    <c:forEach items="${mahasiswa}" var="mahasiswa"> --%>
<%-- 	                      <c:choose> --%>
<%-- 	                  <c:when test="${mahasiswa.NPM==FRSForm.getNPM()}"> --%>
<%-- 	                    <option value="${mahasiswa.NPM}" selected>${mahasiswa.nama}</option> --%>
<%-- 	                  </c:when>     --%>
	                    
<%-- 	                  <c:otherwise> --%>
<%-- 	                    <option value="${mahasiswa.NPM}" >${mahasiswa.nama}</option> --%>
<%-- 	                  </c:otherwise> --%>
<%-- 	                </c:choose> --%>
<%-- 	                     </c:forEach> --%>
<%-- 	                </form:select> --%>
<!--                </td> -->
<!--                <td>&nbsp;</td> -->
<!--            </tr> -->
           
           <tr>
               <td>Mata Kuliah</td>
               <td>
		            <form:select path="id_MK">
		                <c:forEach items="${mataKuliah}" var="MataKuliah">
					    	<option value="${MataKuliah.mk.id_MK}" selected>${MataKuliah.mk.nama_MK}</option>
		                 </c:forEach>
		            </form:select>
               </td>
               <td>&nbsp;</td>
           </tr>
                    
            <tr>
               <td>Dosen Wali</td>
               <td><form:input path="dosenWali" /></td>
               <td><form:errors path="dosenWali"
                       class="error-message" /></td>      
           </tr>
           
           <tr>
               <td>&nbsp;</td>
               <td><input type="submit" value="Submit" />
                  <a href="${pageContext.request.contextPath}/frsList">Cancel</a>
               </td>
               <td>&nbsp;</td>
           </tr>
       </table>
       
   </form:form>
 
</body>
</html>