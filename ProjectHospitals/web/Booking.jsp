<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Booking Page</title>
        <link type="text/css" rel="stylesheet" href="style/bootstrap.min.css" />
        <link type="text/css" rel="stylesheet" href="style/booking.css" />
        <link rel="stylesheet" href="style/booking.css"/>

    </head>
    <jsp:include page="Header.jsp"/>
    <body>
        <div id="booking" class="section" style="background-color: #009933">
            <div class="section-center">
                <div class="container">
                    <div class="row">
                        <div class="booking-form">
                            <div class="form-header">
                                <h1 style="color: greenyellow">BOOKING SCHEDULE</h1>
                            </div>
                            <form method="post" action="booking">
                                <div class="row">
                                    <input type="hidden" name="bid" value="${requestScope.customer.customerId}"> 
                                    <div class="col-sm-6">
                                        <div class="form-group">

                                            <span class="form-label">Name</span>
                                            <a class="form-control">${requestScope.customer.customerName} </a>
                                        </div>

                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <span class="form-label">Gender</span>
                                            <a class="form-control">${requestScope.customer.customerGender} </a>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <span class="form-label">Phone Number</span>
                                    <a class="form-control">${requestScope.customer.customerPhone} </a>
                                </div>
                                <div class="form-group">
                                    <span class="form-label">Address</span>
                                    <a class="form-control">${requestScope.customer.customerAddress} </a>
                                </div>                           
                                <div class="form-group">
                                    <span class="form-label">Reason/Symptom</span>
                                    <input name="reason" class="form-control" type="text" placeholder="Enter Reason/Symptom">
                                </div>
                                <div class="form-group">
                                    <span class="form-label">Description</span>
                                    <input name="description" class="form-control" type="text" placeholder="Enter booking description">
                                </div>
                                <div class="row">
                                    <div class="col-sm-12">

                                        <div class="form-group">
                                            <span class="form-label">Pickup Date</span>
                                            <input style="font-size: 20px; color: red" type="date" name="date" id="myDate" onchange="checkDate()">
                                        </div>
                                        <script>
                                            function checkDate() {
                                                // Get the selected date from the input field
                                                var selectedDate = document.getElementById("myDate").value;

                                                // Do some validation on the selected date (ensure it is today or in the future)
                                                var currentDate = new Date();
                                                var parsedSelectedDate = new Date(selectedDate);
                                                if (parsedSelectedDate <= currentDate) {
                                                    alert("Please select today's date or a future date.");
                                                    document.getElementById("myDate").valueAsDate = currentDate; // Resets date in case it was invalid
                                                }
                                            }
                                            // Set the default value of the input field to today's date
                                            window.onload = function () {
                                                document.getElementById("myDate").valueAsDate = new Date();
                                            };
                                        </script>

                                    </div>
                                </div>
                                <div class="form-btn">
                                    <button class="submit-btn" type="submit">Book Now</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<jsp:include page="Footer.jsp"/>
</html>
