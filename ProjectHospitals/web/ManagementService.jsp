<%-- 
    Document   : ManagementAccount
    Created on : Feb 11, 2023, 10:00:09 PM
    Author     : Hi! Le Minh Hieu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="style/managementaccount.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Management Service</title>
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
                                <h2>Management <b>Service</b></h2>
                            </div>
                            <div class="col-sm-6">
                                <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Service</span></a>						
                            </div>
                        </div>
                    </div>
                    <form action="search_servlet" method="post">
                        <input type="hidden" name="method" value="searchService">
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
                                <th>Detail</th>
                                <th>Price</th>
                                <th>Image</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="s" items="${requestScope.sl}">

                                <tr>
                                    <td></td>
                                    <td><c:out value = "${s.serviceName}"/></td>
                                    <td><c:out value = "${s.serviceDetail}"/></td>
                                    <td><c:out value = "${s.getServicePrice()}"/></td>
                                    <td><img width="200px" height="150px" src="<c:out value = "${s.serviceImage}"/>"></td>
                                    <td>
                                        <a data-target="#editEmployeeModal${s.serviceId}" href="#editEmployeeModal?id=${s.serviceId}"class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                        <a href="delete_service?sid=${s.serviceId}" onclick="return confirm('Are you sure?')" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                    </td>
                                    <td></td>
                                </tr>
                                  

                            <div class="modal fade" id="editEmployeeModal${s.serviceId}" role="dialog">
                                <div class="modal-dialog">

                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">Edit Service</h4>
                                        </div>
                                        <form action="edit_service" method="post">
                                            <div class="modal-body">
                                                <b></b><input type="hidden" class="form-control" name="id" value="<c:out value = "${s.serviceId}"/>" readonly=""><br>
                                                <b>Name: </b><input type="text" class="form-control" value="<c:out value = "${s.serviceName}"/>" name="name"><br>
                                                <b>Price: </b><input type="number" min="1000" step="0.1" class="form-control" value="<c:out value = "${s.servicePrice}"/>" name="price"><br>

                                                <b>Detail </b><input type="text" class="form-control" value="<c:out value = "${s.serviceDetail}"/>"  name="detail"><br>
                                                <b>Image link:</b><input type="text" class="form-control" value="<c:out value = "${s.serviceImage}"/>"  name="img"><br>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                <button type="submit" class="btn btn-success" value="submit">Submit</button>
                                            </div>
                                        </form>
                                    </div>

                                </div>
                            </div>
                            </c:forEach>


                      
                        </tbody>
                    </table>
                    <div class="clearfix">
                        <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>
                        <ul class="pagination">
                            <li class="page-item disabled"><a href="#">Previous</a></li>
                            <li class="page-item"><a href="#" class="page-link">1</a></li>
                            <li class="page-item"><a href="#" class="page-link">2</a></li>
                            <li class="page-item"><a href="#" class="page-link">3</a></li>
                            <li class="page-item"><a href="#" class="page-link">4</a></li>
                            <li class="page-item"><a href="#" class="page-link">5</a></li>
                            <li class="page-item"><a href="#" class="page-link">Next</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- Edit Modal HTML -->
            <div id="addEmployeeModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="management_service" method="post">
                            <div class="modal-body">
                                <b>Name: </b><input type="text" class="form-control" value="" required name="name"><br>
                                <b>Price: </b><input type="number" min="1000" step="0.1" class="form-control"  required value="" name="price"><br>
                                <b>Detail: </b><input type="text" class="form-control" required value="" name="detail"><br>
                                <b>Image link:</b><input type="text" class="form-control" required  value="" name="img"><br>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                <button type="submit" class="btn btn-success" value="submit">Add</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- Edit Modal HTML -->
        </body>
    </html>
