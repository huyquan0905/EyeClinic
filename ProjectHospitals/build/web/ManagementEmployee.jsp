<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="style/managementemployee.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Management Employee</title>
    </head>
    <body>
        <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">

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
                                <h2>Manage <b>Employees</b></h2>
                            </div>
                            <div class="col-sm-6">
                                <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Employee</span></a>						
                            </div>
                        </div>
                    </div>
                    <form action="search_servlet" method="post">
                        <input type="hidden" name="method" value="searchEmployee">
                        <input value="${key}" type="search" placeholder="Search" aria-label="Search" name="keyword"/>
                        <button class="btn btn-outline-success" type="submit">
                            Search
                        </button>
                    </form>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th></th>
                                <th></th>
                                <th>Address</th>
                                <th>Phone</th>
                                <th>Birth</th>
                                <th>Gender</th>
                                <th>Salary</th>
                                <th>Work Time</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="i" items="${requestScope.listEmployee}" > 
                                <tr>
                                    <td><c:out value = "${i.employee_name}"/></td>
                                    <td></td>
                                    <td></td>                                   
                                    <td><c:out value = "${i.employee_address}"/></td>
                                    <td><c:out value = "${i.employee_phone}"/></td>
                                    <td><c:out value = "${i.employee_birth}"/></td>
                                    <td><c:out value = "${i.employee_gender}"/></td>
                                    <td><c:out value = "${i.employee_salary}"/></td>
                                    <td><c:out value = "${i.employee_worktime}"/></td>
                                    <td>
                                        <a data-target="#editEmployeeModal${i.employee_id}" href="#editEmployeeModal?eid=${i.employee_id}" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                        <a data-target="#deleteEmployeeModal${i.employee_id}" href="#deleteEmployeeModal?eid=${i.employee_id}" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                    </td>
                                </tr>
                            <div class="modal fade" id="editEmployeeModal${i.employee_id}" role="dialog">
                                <div class="modal-dialog">

                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">Edit Employee</h4>
                                        </div>
                                        <form action="edit_employee_servlet" method="post">
                                            <div class="modal-body">
                                                <b></b><input type="hidden" class="form-control" name="eid" value="<c:out value = "${i.employee_id}"/>" readonly="">
                                                <b>Name: </b><input type="text" class="form-control" name="name" value="<c:out value = "${i.employee_name}"/>"><br>
                                                <b>Address: </b><input type="text" class="form-control" name="address" value="<c:out value = "${i.employee_address}"/>"><br>
                                                <b>Phone: </b><input type="text" class="form-control" name="phone" value="<c:out value = "${i.employee_phone}"/>"><br>
                                                <b>Birth: </b><input type="date" class="form-control" name="birth" value="<c:out value = "${i.employee_birth}"/>"><br>
                                                <b>Gender: </b>
                                                    <input type="radio" name="gender" value="1"/> Male
                                                    <input type="radio" name="gender" value="0" /> Female                                                 
                                                <br>
                                                <br>
                                                <b>Salary: </b><input type="text" class="form-control"  name="salary" value="<c:out value = "${i.employee_salary}"/>"><br>
                                                <b>Work Time:</b><input type="text" class="form-control"  name="wtime" value="<c:out value = "${i.employee_worktime}"/>"><br>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                <button type="submit" class="btn btn-success" value="submit">Submit</button>
                                            </div>
                                        </form>
                                    </div>

                                </div>
                            </div>
                            <!-- Delete Modal HTML -->
                            <div id="deleteEmployeeModal${i.employee_id}"" class="modal fade">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <form action="delete_employee_servlet" method="POST">
                                            <b></b><input type="hidden" class="form-control" name="eid" value="<c:out value = "${i.employee_id}"/>" readonly="">
                                            <div class="modal-header">						
                                                <h4 class="modal-title">Delete Employee</h4>
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            </div>
                                            <div class="modal-body">					
                                                <p>Are you sure you want to delete this employee?</p>
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
                        </c:forEach>
                        </tbody>
                        <a href="admin">DASHBOARD</a>
                    </table>
                    <div class="clearfix">

                        <ul class="pagination">
                            <li class="page-item disabled"><a href="#">Previous</a></li>
                            <c:forEach begin="1" end="${requestScope.page}" var="i">
                            <li class="page-item"><a href="management_employee_servlet?index=${i}" class="page-link">${i}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>

        </body>
    </html>
