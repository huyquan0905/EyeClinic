<%-- 
    Document   : ManagementTest
    Created on : Feb 13, 2023, 9:58:55 PM
    Author     : Hi! Le Minh Hieu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="style/managementaccount.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Management Test</title>
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
                                <h2>Management <b>Test</b></h2>
                            </div>
                            <div class="col-sm-6">
                          
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover">
                        <thead>
                     
                            <tr>
                                <th>

                                </th>
                                <th>Customer Name</th>
                                <th>Test Name</th>
                                <th>Test Price</th>
                                <th>Result Test</th>
                                <th>Date Test</th>
                                <th>Status Test</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="i" items="${requestScope.listTest}" >
                                    <tr>
                                    <td>

                                    </td>
                                    <td><c:out value = "${i.customerName}"/></td>
                                    <td><c:out value = "${i.testName}"/></td>
                                    <td><c:out value = "${i.testPrice}"/></td>
                                    <td><c:out value = "${i.resultTest}"/></td>
                                    <td><c:out value = "${i.testDate}"/></td>
                                    <td>
                                      
                                    </td>
                                    <td><c:out value = "${i.testStatus}"/></td>                                    
                                    
                                </tr>
                                
                                </c:forEach>
                            </tbody>
                    </table>
                    <div class="clearfix">
                        <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>
                        <ul class="pagination">
                            <li class="page-item disabled"><a href="#">Previous</a></li>
                                 <c:forEach begin="1" end="${requestScope.page}" var="i">
                            <li class="page-item"><a href="manage_test?index=${i}" class="page-link">${i}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- Edit Modal HTML -->
            <div id="addEmployeeModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="manage_test" method="post">
                            <div class="modal-header">						
                                <h4 class="modal-title">Add Employee</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label>Customer Name</label>
                                    <input name="cusname" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Test Name</label>
                                    <input name="testname" type="text" class="form-control" required>
                                </div>
                                 <div class="form-group">
                                    <label>Test Price</label>
                                    <input name="testprice" type="number" class="form-control" required>
                                </div>
                                                               
                                <div class="form-group">
                                    <label>Test Result</label>
                                    <textarea name="testresult" class="form-control" required></textarea>
                                </div>
                                <div class="form-group">
                                    <label>Test Date</label>
                                    <input name="testdate" type="date" class="form-control" required>
                                </div>					
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                <input type="submit" class="btn btn-success" value="Add">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- Edit Modal HTML -->
            <div id="editEmployeeModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form>
                            <div class="modal-header">						
                                <h4 class="modal-title">Edit Employee</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label>Name</label>
                                    <input type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Email</label>
                                    <input type="email" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Address</label>
                                    <textarea class="form-control" required></textarea>
                                </div>
                                <div class="form-group">
                                    <label>Phone</label>
                                    <input type="text" class="form-control" required>
                                </div>					
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                <input type="submit" class="btn btn-info" value="Save">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- Delete Modal HTML -->
            <div id="deleteEmployeeModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form>
                            <div class="modal-header">						
                                <h4 class="modal-title">Delete Employee</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">					
                                <p>Are you sure you want to delete these Records?</p>
                                <p class="text-warning"><small>This action cannot be undone.</small></p>
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                <input type="submit" class="btn btn-danger" value="Delete">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </body>
    </html>