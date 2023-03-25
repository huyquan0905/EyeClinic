<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="style/managementemployee.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Management Booking</title>
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
                                <h2>Manage <b>Booking</b></h2>
                            </div>

                        </div>
                    </div>
<!--                    <form action="search_servlet" method="post">
                        <input type="hidden" name="method" value="searchBooking">
                        <input value="${key}" type="search" placeholder="Search" aria-label="Search" name="keyword"/>
                        <button class="btn btn-outline-success" type="submit">
                            Search
                        </button>
                    </form>-->
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th></th>
                                <th>Name  </th> 

                                <th></th>
                                <th></th>
                                <th>Reason</th>
                                <th>Date</th>
                                <th>Status</th>

                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach var="i" items="${requestScope.listBooking}" > 
                                <c:if test="${i.booking_status!='#'}">
                                    <tr>
                                        <td></td>
                                        <td><c:out value = "${i.customerName}"/></td>
                                        <td></td>
                                        <td></td>
                                        <td><c:out value = "${i.booking_reason}"/></td>
                                        <td><c:out value = "${i.booking_date}"/></td>
                                        <td><c:out value = "${i.booking_status}"/></td>
                                        <td></td>
                                        <td></td>


                                        <td>
                                            <c:if test="${i.booking_status == 'Done' || i.booking_status == 'Processing'}"> 
                                                <a name="book" value="done" href="booking_status_servlet?bid=${i.booking_id}" onclick="return confirm('Are you sure?')" class="done" data-toggle="modal"><i style="color: green" class="material-icons" data-toggle="tooltip" title="Done">&#10003;</i></a>
                                            </c:if>
                                        </td>


                                        <td></td>
                                        <td>
                                            <c:if test="${i.booking_status == 'Reject' || i.booking_status == 'Processing'}">
                                                <a name="book" value="reject" href="booking_status_reject_servlet?bid=${i.booking_id}" onclick="return confirm('Are you sure?')" class="reject" data-toggle="modal"><i style="color: red" class="material-icons" data-toggle="tooltip" title="Reject">&#x2715</i></a>
                                            </c:if>
                                        </td>

                                    </tr>
                                </c:if>
                            </c:forEach>

                        </tbody>
                    </table>
                    <a href="employee">Back to Dashboard</a>
                    <div class="clearfix">
                        <!--<div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>-->
                       
                    </div>
                </div>
            </div>
            <!-- Edit Modal HTML -->
            <div id="editBookingModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form>
                            <div class="modal-header">						
                                <h4 class="modal-title">Edit Booking Shedule </h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label>Name</label>
                                    <input type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>BookingID</label>
                                    <input type="id" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Date</label>
                                    <textarea class="form-control" required></textarea>
                                </div>
                                <div class="form-group">
                                    <label>Reason/Symptom</label>
                                    <input type="text" class="form-control" required>
                                </div>		
                                <div class="form-group">
                                    <label>Status</label>
                                    <input type="text" class="form-control" required>
                                </div>	
                                <div class="form-group">
                                    <label>CustomerID</label>
                                    <input type="text" class="form-control" required>
                                </div>	
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                <input type="submit" class="btn btn-success" value="Edit">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- Edit Modal HTML -->
            <div id="editBookingModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form>
                            <div class="modal-header">						
                                <h4 class="modal-title">Edit Booking Schedule</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label>Name</label>
                                    <input type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>BookingID</label>
                                    <input type="id" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Date</label>
                                    <textarea class="form-control" required></textarea>
                                </div>
                                <div class="form-group">
                                    <label>Reason/Symptom</label>
                                    <input type="text" class="form-control" required>
                                </div>		
                                <div class="form-group">
                                    <label>Status</label>
                                    <input type="text" class="form-control" required>
                                </div>	
                                <div class="form-group">
                                    <label>CustomerID</label>
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
            <div id="deleteBookingModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form>
                            <div class="modal-header">						
                                <h4 class="modal-title">Delete Booking Schedule</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">					
                                <p>Are you sure you want to delete these records?</p>
                                <p class="text-warning"><small>This action cannot be undo.</small></p>
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
