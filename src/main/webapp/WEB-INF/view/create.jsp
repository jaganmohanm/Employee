<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<form action="insertionSuccess" style="border:1px solid #ccc" method="post" name="f1" onsubmit="return validateForm()">
  <div class="container">
    <h1>Add Employee</h1>
    <p>Please fill the details of employee.</p>
   <!-- 
     <label>id</label>
    <input type="text" placeholder="id" name="id" path="id">
     <br>
     --> 
    
    <label>name</label>
    <input type="text" placeholder="name" name="name" path="name">
     <br>
    
  <input type="submit"   class=" " value="Add Employee"> <input type="button"   class=" " value="Cancel">
   
  
  
    </div>
  
</form>
</body>
</html>