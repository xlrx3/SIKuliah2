<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Majors</title>
<link rel="stylesheet"  type="text/css"  href="${pageContext.request.contextPath}/css/form_1.css">
</head>
<body>
 
   <h3>${formTitle}</h3>
  <div class="form-style-10">
   <form:form action="edit/save" method="POST"
       modelAttribute="jurusanForm">
      
       <form:hidden path="idJurusan" />
 
       <table>
                     <tr>
               <td>Kode Jurusan (2 angka)</td>
               <td><form:input path="code" maxlength="2"  size="2" /></td>
               <td><form:errors path="code"
                       class="error-message" /></td>      
           </tr>
           <tr>
               <td>Nama</td>
               <td><form:input path="namaJurusan" /></td>
               <td><form:errors path="namaJurusan"
                       class="error-message" /></td>      
           </tr>
           
                      <tr>
               <td>Fakultas</td>
               <td><form:input path="fakultasJurusan" /></td>
               <td><form:errors path="fakultasJurusan"
                       class="error-message" /></td>      
           </tr>
           
                      <tr>
               <td>Kepala Jurusan</td>
               <td><form:input path="kepalaJurusan" /></td>
               <td><form:errors path="kepalaJurusan"
                       class="error-message" /></td>      
           </tr>
 
           <tr>
               <td>&nbsp;</td>
               <td><input type="submit" value="Submit" />
                  <a href="${pageContext.request.contextPath}/majors">Cancel</a>
               </td>
               <td>&nbsp;</td>
           </tr>
       </table>
       
   </form:form>
 </div>
</body>
</html>