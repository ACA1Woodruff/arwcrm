<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<html>
  <head>
    <title>Manage Customers</title>
    <style>body { font-family: Verdana, Geneva, sans-serif; }</style>
  </head>
  <body>

    <h1>Manage Customers</h1>  
    <a href="customerform">Add New Customer</a><br/><br/>
    <table border="1" width="70%" cellpadding="2">  
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Action</th>
      </tr>  

      <c:forEach var="customer" items="${list}">   
        <tr>  
          <td>${customer.id}</td>  
          <td>${customer.name}</td>  
          <td><a href="editcustomer/${customer.id}">Edit</a> <a href="deleteartist/${customer.id}">Delete</a></td>  
        </tr>  
      </c:forEach>  
    </table>  
    <br/> 
  </body>
</html>
