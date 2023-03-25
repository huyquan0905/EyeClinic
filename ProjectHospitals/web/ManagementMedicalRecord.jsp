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
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
            

        <body>
            <div class="container">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-6">
                                <h2>Management <b>Medical Exam</b></h2>
                            </div>
                            
                        </div>
                    </div>
                    <form action="search_servlet" method="post">
                        <input type="hidden" name="method" value="searchMedicalRecord">
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
                                <th>Name</th>
                                <th>Address</th>
                                <th>Birth</th>
                                <th>Phone</th>
                                <th>Gender</th>
                                <th></th>
                                <th>View</th>
                                
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="i" items="${requestScope.listCustomer}" >
                                   <tr>
                                   
                                    <td> </td>
                                    <td><c:out value = "${i.customerName}"/></td>
                                    <td><c:out value = "${i.customerAddress}"/></td>
                                    <td><c:out value = "${i.customerBirth}"/></td>
                                    <td><c:out value = "${i.customerPhone}"/></td>
                                    <td><c:out value = "${i.customerGender}"/></td>
                                    <td></td>
                                   
                                    <td><a href="view_record_servlet?cid=${i.customerId}"><i data-value="value" data-name ="name" class='fa fa-eye'></i></a></td>
                                    <td></td>
                                    
                                </tr>
                               
                                   <div class="modal fade" id="viewCustomerModal${i.customerId}" role="dialog">
                                <div class="modal-dialog">

                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">View Test</h4>
                                        </div>
                                        <form action="view_record_servlet" method="post">
                                            <div class="modal-body">
                                         <b></b><input type="hidden" class="form-control" name="cid" value="<c:out value = "${i.customerId}"/>" readonly=""><br>
                                               <div  class="col-md-6">Name: <c:out value = "${i.customerName}"/>                                </div>

                                         <div  class="col-md-12">Service Name: <c:out value = "${requestScope.service.serviceName}"/>   </div>

                                        <div  class="col-md-6">Birth: <c:out value = "${requestScope.customer.customerBirth}"/>                                </div>

                                        <div  class="col-md-6">Phone: <c:out value = "${requestScope.customer.customerPhone}"/>                                </div>

                                        <div  class="col-md-6">Gender: <c:out value = "${requestScope.customer.customerGender}"/>                                </div>
                                            </div>
                                            
                                        </form>
                                            <input type="hidden" class="form-control" name="cid" value="<c:out value = "${i.customerId}"/>" readonly="">
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                <a href="view_record_servlet">View</a>
                                            </div>
                                    </div>

                                </div>
                            </div>
                                  </c:forEach>
                               
                              
                            </tbody>
                          
                    </table>
                        <a href="admin">DASHBOARD</a>
                    <div class="clearfix">
                        <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>
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
