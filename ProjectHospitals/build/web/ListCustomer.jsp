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
                            <div class="col-sm-11">
                                <h2>Customer <b>Process</b></h2>
                            </div>
                            <div class="col-sm-1" style="padding-top: 10px;">                                
                                <a href="customer_test_servlet"><i style="font-size: 30px; color: pink;" class="fa fa-bell"><span style="background-color: red; margin-top: -30px; margin-left: -10px" class="badge">${requestScope.countCus}</span></i></a>
                            </div>
                    
                        </div>
                    </div>
                    <table class="table table-striped table-hover">
                        <thead>
                     
                            <tr>
                                <th>

                                </th>
                                <th>Name</th>
                                <th>Address</th>
                                <th>Birth</th>
                                <th>Phone</th>
                                <th>Gender</th>
                                <th>Status</th>
                                <th></th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                             
                                <c:forEach var="i" items="${requestScope.listCustomer}" >
                                    <tr>
                                     
                                    <td>

                                    </td>
                                    <td><c:out value = "${i.customerName}"/></td>
                                    <td><c:out value = "${i.customerAddress}"/></td>
                                    <td><c:out value = "${i.customerBirth}"/></td>
                                    <td><c:out value = "${i.customerPhone}"/></td>
                                    <td><c:out value = "${i.customerGender}"/></td>
                                    <td><c:out value = "${i.customerStatus}"/></td>                          
                                    <td></td>
                                       <td>
                                        <a href="service_medical_servlet?cid=${i.customerId}">Medical Exam</a>                                       
                                    </td>
                                       
                                    
                                </tr>
                                
                                </c:forEach>
                               
                            </tbody>
                    </table>
                    <div class="clearfix">
                        <a href="admin">DASHBOARD</a>
                        <ul class="pagination">
                            <li class="page-item disabled"><a href="#">Previous</a></li>
                            <li class="page-item"><a href="#" class="page-link">1</a></li>
                            <li class="page-item"><a href="#" class="page-link">2</a></li>
                            <li class="page-item active"><a href="#" class="page-link">3</a></li>
                            <li class="page-item"><a href="#" class="page-link">4</a></li>
                            <li class="page-item"><a href="#" class="page-link">5</a></li>
                            <li class="page-item"><a href="#" class="page-link">Next</a></li>
                        </ul>
                    </div>
                </div>
            </div>

        </body>
</html>
