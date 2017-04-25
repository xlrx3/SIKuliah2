<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${formTitle}</title>
<link rel="stylesheet"  type="text/css"  href="${pageContext.request.contextPath}/css/form_1.css">
</head>
<body>
 
   <h3>${formTitle}</h3>
  <div class="form-style-10">
   <form:form action="${pageContext.request.contextPath}/room" method="POST"
       modelAttribute="roomForm">
      
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
               <td>Nomor Ruangan</td>
               <td><form:input path="roomCode" maxlength="2" size="2"  /></td>
               <td><form:errors path="roomCode"
                       class="error-message" /></td>      
           </tr>
           
                      <tr>
               <td>Nomor Gedung</td>
               <td><form:input path="buildingNum" maxlength="1"  size="1" /></td>
               <td><form:errors path="buildingNum"
                       class="error-message" /></td>      
           </tr>
           
           
           <tr>
               <td>Lantai</td>
               <td><form:input path="floorNum" maxlength="1"  size="1" /></td>
               <td><form:errors path="floorNum"
                       class="error-message" /></td>      
           </tr>
           
           <tr>
               <td>Nama Ruangan</td>
               <td><form:input path="name" /></td>
               <td><form:errors path="name"
                       class="error-message" /></td>      
           </tr>
           
           
 
           <tr>
               <td>&nbsp;</td>
               <td><input type="submit" value="Submit" />
                  <a href="${pageContext.request.contextPath}/rooms">Cancel</a>
               </td>
               <td>&nbsp;</td>
           </tr>
       </table>
       
   </form:form>
 </div>
</body>
</html>