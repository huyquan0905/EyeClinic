<%-- 
    Document   : ManageCustomer
    Created on : Feb 14, 2023, 12:11:43 AM
    Author     : Hi! Le Minh Hieu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="style/managementcustomer.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
      <body>
        <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
            <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
            <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <body>
            <div class="container">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-6">
                                <h2>Waiting <b>Room</b></h2>
                            </div>
                            <div class="col-sm-6">
                                <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add Patient</span></a>						
                            </div>
                        </div>
                    </div>
                    <form action="search_servlet" method="post">
                        <input type="hidden" name="method" value="searchCustomer">
                        <input value="${key}" type="search" placeholder="Search" aria-label="Search" name="keyword"/>
                        <button class="btn btn-outline-success" type="submit">
                            Search
                        </button>
                    </form>
                    <table class="table table-striped table-hover">
                        <thead>
                     
                            <tr>
                                <th>

                                </th>
                                <th></th>
                                <th>Name</th>
                                <th>Address</th>
                                <th>Birth</th>
                                <th>Phone</th>
                                <th>Gender</th>
                                <th></th>
                               
                                
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                    <td>
                                        
                                    </td>
                                    <td><h4 style="color: red">Customer Booking Online</h4></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td>
                                           
                                        </td>
                                    <td></td>                                    
                                </tr>
                                <c:forEach var="i" items="${requestScope.listCusBook}" >
                                    <tr>
                                        <td></td>
                                    <td>

                                    </td>
                                    <td><c:out value = "${i.customerName}"/></td>
                                    <td><c:out value = "${i.customerAddress}"/></td>
                                    <td><c:out value = "${i.customerBirth}"/></td>
                                    <td><c:out value = "${i.customerPhone}"/></td>
                                    <td><c:out value = "${i.customerGender}"/></td>
                                    <td></td>
                                    <td>
                                            <a href="check_patient?bid=${i.bookingId}&cid=${i.customerId}" onclick="return confirm('Are you sure?')" class="done" data-toggle="modal"><i class="fa fa-check" aria-hidden="true"></i></a>
                                        </td>
                                    <td></td>                                    
                                </tr>
                                
                                </c:forEach>
                                 
                                    <tr>
                                    <td>
                                        
                                    </td>
                                    <td><h4 style="color: red">Customer Register Offline</h4></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td>
                                           
                                        </td>
                                    <td></td>                                    
                                </tr>
                                
                                
                     
                                <c:forEach var="i" items="${requestScope.listCusRe}" >
                                    <tr>
                                        <td></td>
                                    <td>

                                    </td>
                                    <td><c:out value = "${i.customerName}"/></td>
                                    <td><c:out value = "${i.customerAddress}"/></td>
                                    <td><c:out value = "${i.customerBirth}"/></td>
                                    <td><c:out value = "${i.customerPhone}"/></td>
                                    <td><c:out value = "${i.customerGender}"/></td>
                                    <td></td>
                                   <td>
                                        
                                            <a href="check_patient?bid=${i.bookingId}&cid=${i.customerId}" onclick="return confirm('Are you sure?')" class="done" data-toggle="modal"><i class="fa fa-check" aria-hidden="true"></i></a>
                                        </td>
                                    <td></td>                                    
                                </tr>
                                
                                </c:forEach>
                                
                            </tbody>
                    </table>
                        <a href="employee">Back to Dashboard</a>
                    <div class="clearfix">
                       
                    </div>
                </div>
                        <div id="addEmployeeModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="register_patient_servlet" method="post">
                            <div class="modal-body">
                                 <b>User Name: </b><input minlength="10" maxlength="30" type="email" class="form-control" value="" required name="username"><br>
                                 <b>Password: </b><input minlength="8" maxlength="15" type="password" class="form-control" value="" required name="password"><br>
                                 <br>
                                 <b>Name: </b><input type="text" class="form-control" value="" required name="name"><br>
                                <b>Address: </b><input type="text" class="form-control" value="" required name="address"><br>
                                
                                <b>Birth:<input style="height: 30px; width: 200px" type="date" name="birth" id="myDate" onchange="checkDate()"> <br>
                                    <br>
                                
                                <script>
    function checkDate() {
        // Get the selected date from the input field
        var selectedDate = document.getElementById("myDate").value;

        // Do some validation on the selected date (ensure it is in the past and not too far back)
        var currentDate = new Date();
        var parsedSelectedDate = new Date(selectedDate);
        var maxDate = new Date();
        maxDate.setFullYear(currentDate.getFullYear() - 100); // Set maximum date to 100 years ago
        if (parsedSelectedDate >= currentDate || parsedSelectedDate <= maxDate) {
            alert("Please select a valid birthdate.");
            document.getElementById("myDate").valueAsDate = maxDate; // Resets date to maximum allowed date
        }
    }

    // Set the default value of the input field to a reasonable age (e.g. 25 years old)
    window.onload = function () {
        var defaultDate = new Date();
        defaultDate.setFullYear(defaultDate.getFullYear() - 25); // Set default date to 25 years ago
        document.getElementById("myDate").valueAsDate = defaultDate;
    };
</script>
                                
                                <b>Phone:</b><input type="number" class="form-control" required  value="" name="phone"><br>
                                <div>
                                    <label for="Gender"><b>Gender</b> </label>
                                    <input type="radio" name="gender" value="1" checked /> Male
                                    <input type="radio" name="gender" value="0" /> Female
                                </div>
                                <br>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                <button type="submit" class="btn btn-success" value="submit">Add</button>
                                <h3  style="text-align: center" style='color: red'>${requestScope.error}</h3>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            </div>
            
        </body>
</html>
