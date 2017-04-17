<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FRS</title>
<link rel="stylesheet"  type="text/css"  href="${pageContext.request.contextPath}/css/form-basic.css">
</head>
<body>
<script>
var checkForm = function(form){
    var inputs = form.getElementsByTagName('input');
    for(var i = 0, l = inputs.length; i < l; i++){
        var input = inputs[i];
        if(input.type == "checkbox" && input.checked)
            return true;
    }
    alert('Please checked at least 1 subject(s)');
    return false;
};
</script>
   <h3>${formTitle}</h3>
 
   <form:form onsubmit="return checkForm(this);" action="/SIKuliah2/FRS" method="POST"
       modelAttribute="frsFormCreate">
     
       <form:hidden path="id" />
	   <form:hidden path="NPM" value="${mhsNPM}" />
	    <form:hidden path="semesters" value="${semester}" />
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
           
<!--            <tr> -->
<!--                <td>Mata Kuliah</td> -->
<!--                <td> -->
<%-- 		            <form:select path="id_MK"> --%>
<%-- 		                <c:forEach items="${mataKuliah}" var="MataKuliah"> --%>
<%-- 					    	<option value="${MataKuliah.mk.id_MK}" selected>${MataKuliah.mk.nama_MK}</option> --%>
<%-- 		                 </c:forEach> --%>
<%-- 		            </form:select> --%>
<!--                </td> -->
<!--                <td>&nbsp;</td> -->
<!--            </tr> -->
                    
            <tr>
               <td>Dosen Wali</td>
               <td><form:input path="dosenWali" /></td>
               <td><form:errors path="dosenWali"
                       class="error-message" /></td>      
           </tr>
           		

       </table>
               <table>
						<tr>
							<th>No</th>
							<th>Nama</th>
							<th>SKS</th>
							<th>Pilih</th>
						</tr>
						<c:forEach items="${mataKuliah}" var="info"
							varStatus="status">
							<tr>
								<td>${status.index + 1}</td>
								<td>${info.mk.getNama_MK()}</td>
								<td>${info.mk.getSKS()}</td>
								<td><input type="checkbox" name="choose_mk" value="${info.mk.getId_MK()}"></td>
							</tr>
						</c:forEach>
					</table>
					<table>
							           <tr>
               <td>&nbsp;</td>
               <td><input type="submit" value="Submit" />
                  <a href="${pageContext.request.contextPath}/FRSs">Cancel</a>
               </td>
               <td>&nbsp;</td>
           </tr>
					</table>
   </form:form>
 
</body>
</html>