<%-- 
    Document   : Profile
    Created on : Feb 6, 2023, 9:36:10 PM
    Author     : Hi! Le Minh Hieu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <script src="js/profile.js"></script>
    <link rel="stylesheet" href="style/profile.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <head>
        <title>Profile</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>

    <jsp:include page="Header.jsp"/>
    <hr>
    <div class="row">

        <div class="col-sm-10"><h1>CUSTOMER INFORMATION :</h1> </div>


    </div>

    <div class="row">
        <div class="col-sm-3"><!--left col-->


            <div class="text-center">
                <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar img-circle img-thumbnail" alt="avatar">
                <br><!-- comment -->
                <br>
                <br><!-- comment -->

            </div></hr><br>         
        </div><!--/col-3-->
        <div class="col-sm-9">
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#home">Home</a></li>
                <li><a data-toggle="tab" href="#settings">Information Medical</a></li>
            </ul>


            <div class="tab-content">
                <div class="tab-pane active" id="home">
                    <hr>


                    <form class="form" action="profile" method="post" id="registrationForm">
                        <c:if test="${sessionScope.account.accountId!=requestScope.customer.accountcId}">
                            <div class="form-group">
                                <div class="col-xs-6">
                                    <label for="Name"><h4> Name</h4></label>
                                    <input type="text" class="form-control" name="namecustomer" id="CustomerEmail" placeholder=" Name" title="enter your  name if any.">
                                </div>
                            </div>
                            <div class="form-group">

                                <div class="col-xs-6">
                                    <label for="Address"><h4>Address</h4></label>
                                    <input type="text" class="form-control" name="addresscustomer" id="CustomerEmail" placeholder="Address" title="enter your address if any.">
                                </div>
                            </div>

                            <div class="form-group">

                                <div class="col-xs-6">
                                    <label for="Phone"><h4>Phone</h4></label>
                                    <input min="0" step="0.1" max="" type="number" class="form-control" name="phonecustomer" id="CustomerEmail" placeholder="Phone" title="enter your phone number if any.">
                                </div>
                            </div>

                            <div class="form-group">

                                <div class="col-xs-6">
                                    <label for="Birth"><h4>Birth:</h4></label>
                                    <input style="height: 30px; width: 200px" type="date" name="birthcustomer" id="myDate" onchange="checkDate()">
                                </div>
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
                            </div>
                            <div class="form-group">

                                <div class="col-xs-6">
                                    <label for="Gender"><h4>Gender :</h4></label>
                                    <input type="radio" name="customergender" value="1" checked /> Male
                                    <input type="radio" name="customergender" value="0" /> Female
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-xs-12">
                                    <br>
                                    <button name ="check" value ="save" class="btn btn-lg btn-success" type="submit"><i class="glyphicon glyphicon-ok-sign"></i> Save</button>

                                </div>
                            </div>

                        </c:if>
                        <hr>
                        <c:if test="${sessionScope.account.accountId==requestScope.customer.accountcId}">

                            <div class="form-group">

                                <div class="col-xs-6">
                                    <label for="Name"><h4>Name: </h4></label>
                                    <a style="font-size: 20px; color: red">${requestScope.customer.customerName} </a>
                                </div>
                            </div>
                            <div class="form-group">

                                <div class="col-xs-6">
                                    <label for="Address"><h4>Address: </h4></label>
                                    <a style="font-size: 20px; color: red">${ requestScope.customer.customerAddress}</a>

                                </div>
                            </div>

                            <div class="form-group">

                                <div class="col-xs-6">
                                    <label for="Phone"><h4>Phone: </h4></label>
                                    <a style="font-size: 20px; color: red">${requestScope.customer.customerPhone}</a>
                                </div>
                            </div>

                            <div class="form-group">

                                <div class="col-xs-6">
                                    <label for="Birth"><h4>Birth:</h4></label>
                                    <a style="font-size: 20px; color: red">${requestScope.customer.customerBirth} </a>
                                </div>
                            </div>
                            <div class="form-group">

                                <div class="col-xs-6">
                                    <label for="Gender"><h4>Gender: </h4></label>
                                    <a style="font-size: 20px; color: red">${requestScope.customer.customerGender} </a> 
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-xs-12">
                                    <br>

                                    <button style="border-radius: 5px ; background-color: #00a86b"> <a style ="font-size: 20px; color: white; text" data-target="#editEmployeeModal${sessionScope.account.accountId}" href="#editEmployeeModal?id=${sessionScope.account.accountId}"class="edit" data-toggle="modal">  Edit</a></button> 
                                </div>
                            </div>

                        </c:if>
                    </form>

                    <div class="modal fade" id="editEmployeeModal${sessionScope.account.accountId}" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>

                                </div>     
                                <form action="edit_profile_servlet" method="post">
                                    <div class="modal-body">
                                        <br>
                                        <br>
                                        <br>
                                        <h4 class="modal-title">Edit Profile</h4>
                                        <b></b><input type="hidden" class="form-control" name="id" value="<c:out value = "${requestScope.customer.accountcId}"/>" readonly=""><br>
                                        <b>Name: </b><input type="text" class="form-control" name="namecustomer" value="<c:out value = "${requestScope.customer.customerName}"/>"><br>
                                        <b>Address: </b><input type="text" class="form-control" name="addresscustomer" value="<c:out value = "${requestScope.customer.customerAddress}"/>"><br>


                                        <b>Phone </b><input type="text" class="form-control"  name="phonecustomer" value="<c:out value = "${requestScope.customer.customerPhone}"/>"><br>
                                        <b>Birth:</b><input type="date" class="form-control"  name="birthcustomer" value="<c:out value = "${requestScope.customer.customerBirth}"/>"><br>
                                        
                                        <b>Gender: </b>
                                        <input type="radio" name="customergender" value="1" checked /> Male
                                        <input type="radio" name="customergender" value="0" /> Female                                                 
                                        <br>
                                        <br>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                        <button type="submit" class="btn btn-success" value="submit">Submit</button>
                                    </div>
                                </form>
                            </div>

                        </div>
                    </div>



                    <hr>

                </div><!--/tab-pane-->


                <div class="tab-pane" id="settings">


                    <hr>
                    <form class="form" action="##" method="post" id="registrationForm">
                        <div class="form-group">

                            <div class="col-xs-6" >
                                <label for="Booking"><h4>Booking</h4></label>
                                <div class="form-group">
                                    <div class="col-xs-12" >   
                                        <div class="scroll" style="overflow-y: scroll; width: auto; max-height: 300px; padding-top: 20px;">

                                            <br>
                                            <c:forEach var="i" items="${requestScope.listBook}">
                                                <li>
                                                    <label for="Name"><h4>Reason/Symptom: <a style="font-size: 20px; color: red">${i.booking_reason} </a></h4>
                                                    </label>
                                                    <br>
                                                    <label for="Name"><h4>Date: <a style="font-size: 20px; color: red">${i.booking_date} </a></h4>
                                                    </label>
                                                    <br>
                                                    <label for="Name"><h4>Status: <a style="font-size: 20px; color: red">${i.booking_status} </a></h4>
                                                        <c:if test="${i.booking_status=='Processing'}">
                                                        <a href="cancel_booking_servlet?id=${i.booking_id}" style="font-size: 17px; text-decoration: underline">Cancel</a>
                                                        </c:if>
                                                    </label>
                                                        <h4>----------------------------------</h4>
                                                    
                                                    <br>
                                                </li>
                                            </c:forEach>
                                        </div>  
                                    </div>
                                </div>
                                <a Style="height: 300px;" type="text" class="form-control" name="bookingcustomer" id="Customeremail" placeholder="" title="">
                                </a>
                            </div>
                        </div>
                      
                        <div class="form-group">

                            <div class="col-xs-6" >
                                <label for="Booking"><h4>My Record Medical</h4></label>
                                <div class="form-group">
                                    <div class="col-xs-12" >   
                                        <div class="scroll" style="overflow-y: scroll; width: auto; max-height: 300px; padding-top: 20px;">

                                            <br>
                                            <c:if test="${requestScope.customer.customerStatus=='Done All'}">
                                                <div  class="col-md-12" style="font-size: 20px; color: #0c63e4">SERVICE                        </div>

                                        <div  class="col-md-12">Service Name: <c:out value = "${requestScope.customers.serviceName}"/>                                 </div>
                                        <br>
                                        <br>
                                        <div  class="col-md-12" style="font-size: 20px; color: #0c63e4">TEST                        </div>

                                        <c:forEach var="i" items="${requestScope.test}" >

                                            <div  class="col-md-6">Test Name: <c:out value = "${i.testName}"/>                                </div>

                                            <div  class="col-md-6">Test Price: <c:out value = "${i.getTestPrice1()}"/> VND                              </div>

                                            <div  class="col-md-12">Test Result: <c:out value = "${i.resultTest}"/>                                </div>


                                            
                                            <br>
                                            <br>
                                        </c:forEach>

                                        <br>
                                       
                                        <div  class="col-md-12" style="font-size: 20px; color: #0c63e4">EXAMINATION                        </div>

                                        <div  class="col-md-12">Conclusion: <c:out value = "${requestScope.exam.conclusion}"/>                                </div>

                                        <div  class="col-md-12">Exam Date: <c:out value = "${requestScope.exam.examDate}"/>                                     </div>

                                        <br>
                                        <br>
                                        <div  class="col-md-12" style="font-size: 20px; color: #0c63e4">MEDICINE                        </div>

                                        <c:forEach var="i" items="${requestScope.listPres}">
                                            <div  class="col-md-6">Medicine Name: <c:out value = "${i.presName}"/>                                     </div>

                                            <div  class="col-md-6">Medicine Quantity: <c:out value = "${i.presQuantity}"/>                                </div>

                                            <div style="color: red" class="col-md-12">Note: <c:out value = "${i.presNote}"/>                                     </div>
                                            <br>
                                            <br>
                                        </c:forEach>
                                            </c:if>
                                        </div>  
                                    </div>
                                </div>
                                <a Style="height: 300px;" type="text" class="form-control" name="bookingcustomer" id="Customeremail" placeholder="" title="">
                                </a>
                            </div>
                        </div>
                    </form>
                </div>

            </div><!--/tab-pane-->
        </div><!--/tab-content-->

    </div>
</div>
<br>
<br>
<br>
<br>
<br>
<br>

<jsp:include page="Footer.jsp"/>
</html>
