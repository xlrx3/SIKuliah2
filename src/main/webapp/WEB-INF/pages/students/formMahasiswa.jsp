<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Mahasiswa</title>
<link rel="stylesheet"  type="text/css"  href="${pageContext.request.contextPath}/css/form_1.css">
</head>
<body>
 
   <h3>${formTitle}</h3>
  <div class="form-style-10">
   <form:form action="${pageContext.request.contextPath}/student" method="POST"
       modelAttribute="mahasiswaForm">
      
       <form:hidden path="id" />
<%--        <form:hidden path="NPM" /> --%>
 
       <table>
<!--            <tr> -->
<!--                <td>NPM</td> -->
<%--                <td><form:input path="NPM" /></td> --%>
<%--                <td><form:errors path="NPM" --%>
<%--                        class="error-message" /></td>       --%>
<!--            </tr> -->
           
           <tr>
               <td>Nama Mahasiswa</td>
               <td><form:input path="nama"  /></td>
               <td><form:errors path="nama"
                       class="error-message" /></td>      
           </tr>
           
                      <tr>
               <td>Angkatan</td>
               <td><form:input path="angkatan" maxlength="4"  size="4" /></td>
               <td><form:errors path="angkatan"
                       class="error-message" /></td>      
           </tr>
           
                      <tr>
               <td>Status</td>
               <td>
				  <form:select path="status" >
					<c:forEach items="${statsList}"  var="status">
    					<option value="${status}">${status}</option>
					</c:forEach>
			      </form:select>
	          </td>
     
           </tr>
           
           <tr>
               <td>Jurusan</td>
               <td>
	                <form:select path="idJur" name="idJur">
	                    <c:forEach items="${idJur}" var="jurusan">
	                      <c:choose>
	                  <c:when test="${jurusan.idJurusan==mahasiswaForm.idJur}">
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
               <td>&nbsp;</td>
               <td><input type="submit" value="Submit" />
                  <a href="${pageContext.request.contextPath}/students">Cancel</a>
               </td>
               <td>&nbsp;</td>
           </tr>
       </table>
       
   </form:form>
 </div>
</body>
</html>