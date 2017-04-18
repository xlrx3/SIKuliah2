<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MK Jurusan</title>
<link rel="stylesheet"  type="text/css"  href="${pageContext.request.contextPath}/css/form_1.css">
</head>
<body>
 
   <h3>${formTitle}</h3>
    <div class="form-style-10">
 
   <form:form action="subjectMajor" method="POST"
       modelAttribute="mKJurForm">
     
       <form:hidden path="id" />
 
       <table>
           <tr>
               <td>Jurusan</td>
               <td>
	                <form:select path="id_jur">
	                    <c:forEach items="${jurusan}" var="jurusan">
	                      <c:choose>
	                  <c:when test="${jurusan.idJurusan==mKJurForm.getId_jur()}">
	                    <option value="${jurusan.idJurusan}" selected>${jurusan.namaJurusan}</option>
	                  </c:when>    
	                    
	                  <c:otherwise>
	                    <option value="${jurusan.idJurusan}" >${jurusan.namaJurusan}</option>
	                  </c:otherwise>
	                </c:choose>
	                     </c:forEach>
	                </form:select>
               </td>
               <td>&nbsp;</td>
           </tr>
           
           <tr>
               <td>Mata Kuliah</td>
               <td>
		            <form:select path="id_MK">
		                <c:forEach items="${mataKuliah}" var="MataKuliah">
		                	<c:choose>
					    		<c:when test="${MataKuliah.id_MK==mKJurForm.getId_MK()}">
					    			<option value="${MataKuliah.id_MK}" selected>${MataKuliah.nama_MK}</option>
					    		</c:when>    
					    			
					    		<c:otherwise>
					    			<option value="${MataKuliah.id_MK}" >${MataKuliah.nama_MK}</option>
					    		</c:otherwise>
					    	</c:choose>
		                 </c:forEach>
		            </form:select>
               </td>
               <td>&nbsp;</td>
           </tr>
           
           <tr>
               <td>&nbsp;</td>
               <td><input type="submit" value="Submit" />
                  <a href="${pageContext.request.contextPath}/subjectMajors">Cancel</a>
               </td>
               <td>&nbsp;</td>
           </tr>
       </table>
       
   </form:form>
 </div>
</body>
</html>