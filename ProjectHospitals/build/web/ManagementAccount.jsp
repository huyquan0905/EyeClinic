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
        <title>Management Account</title>
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
                                <h2>Management <b>Account</b></h2>
                            </div>
                            <div class="col-sm-6">
                                <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Account</span></a>
                                <!--						<a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						-->
                            </div>
                        </div>
                    </div>
                    <form action="search_servlet" method="post">
                        <input type="hidden" name="method" value="searchAccount">
                        <input value="${key}" type="search" placeholder="Search" aria-label="Search" name="keyword"/>
                        <button class="btn btn-outline-success" type="submit">
                            Search
                        </button>
                        <input type="hidden" name="index" value="${requestScope.page}"/>
                    </form>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>

                                </th>
                                <th>User Name</th>
                                <th>Password</th>
                                <th>Role</th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="i" items="${requestScope.listAccount}" >
                                <tr>
                                    <td></td>
                                    <td><c:out value = "${i.accountName}"/></td>
                                    <td><c:out value = "${i.accountWord}"/></td>
                                    <td><c:out value = "${i.roleEmployee}"/></td>
                                    <td></td>
                                    <c:if test="${i.roleAdmin!='1'}">
                                        <td>
                                            <a href="delete_account?aid=${i.accountId}" onclick="return confirm('Are you sure?')" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                        </td>
                                    </c:if>
                                    <c:if test="${i.roleAdmin=='1'}">
                                        <td></td> 
                                    </c:if>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                     <a href="admin">DASHBOARD</a>
                    <div class="clearfix">
                        <div class="hint-text">Showing <b>${requestScope.page}</b> out of <b>.....</b> entries</div>
                       
                        
                        <ul class="pagination">
                            <li class="page-item disabled"><a href="#">Previous</a></li>
                            <c:forEach begin="1" end="${requestScope.page}" var="i">
                            <li class="page-item"><a href="manage_account?index=${i}" class="page-link">${i}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- Edit Modal HTML -->
            <div id="addEmployeeModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="manage_account" method="post">
                            <div class="modal-header">						
                                <h4 class="modal-title">Add Account</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label>User Name(*)</label>
                                    <input type="email" name="usename" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Password(*)</label>
                                    <input type="text" name="password" class="form-control" required>
                                </div>                             
                                <div class="form-group">
                                    <label>Role(*)</label><br>
                                    <label>(1. Employee/ 0.Customer)</label>
                                    <input type="number" min="0" max="1" name="role" class="form-control" required>
                                </div>					
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                <input type="submit" class="btn btn-success" value="Add">
                            </div>
                            <h3 style="text-align: center" style='color: red'></h3>
                        </form>
                    </div>
                </div>
            </div>
            <!-- Edit Modal HTML -->
        </body>
    </html>
