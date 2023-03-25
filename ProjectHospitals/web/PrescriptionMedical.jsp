<%-- 
    Document   : ServiceMedical
    Created on : Feb 16, 2023, 10:50:30 PM
    Author     : Hi! Le Minh Hieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="style/servicemedical.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="https://overpass-30e2.kxcdn.com/overpass.css" rel="stylesheet" />
        <link href="https://overpass-30e2.kxcdn.com/overpass-mono.css" rel="stylesheet" />

        <h1> <span style=" background-color: #119462">DESCRIPTION</span></h1>

        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h3>MEDICINE</h3>
                    <form id="employee-information-form" action="prescription_medical_servlet" method="post">
                        <fieldset>

                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="form-group">
                                        <span class="form-label">Medicine Name:</span>
                                        <input name="presname" class="form-control" type="text" placeholder="Enter Medicine Name" >
                                    </div>
                                </div>


                                <div class="col-sm-12">
                                    <div class="form-group">
                                        <span class="form-label">Medicine Quantity:</span>
                                        <input name="presquantity" class="form-control" type="number" placeholder="Enter Quantity">
                                    </div>
                                </div>

                                <div class="col-sm-12">
                                    <div class="form-group">
                                        <span class="form-label">Note:</span>
                                        <input name="presnote" class="form-control" type="text" placeholder="Enter Note">
                                    </div>
                                </div>
                            </div>
                            <input type="hidden" name="cid" value="${requestScope.customer.customerId}"/>
                            <div class="row">
                            <div class="col-md-10">
                                <button value="add" name="1" class="button login__submit">
                                    <span class="button__text">Add</span>
                                    <i class="button__icon fas fa-chevron-right"></i>
                                </button>

                            </div>
                            <div class="col-md-2">

                                <button value="next" name="1" class="button login__submit">
                                    <span class="button__text">Next Step</span>
                                    <i class="button__icon fas fa-chevron-right"></i>
                                </button>
                            </div>
                                </div>
                        </fieldset>
                    </form>
                </div>


                <div id="signature-output" class="col-md-6">
                    <h3>View</h3>

                    <div class="tab-content">
                        <div id="signature-horizontal-visual" 
                             class="tab-pane active" role="tabpanel">
                            <table style="font-family:'overpass', sans-serif;color:#333;font-style:normal;font-size:14px;margin:0px;padding:0px;border:0px;outline:0px;vertical-align:baseline;line-height:1.15;" border="0" cellpadding="0" cellspacing="0">
                                <div class="row">
                                     <div  class="col-md-12" style="font-size: 20px; color: #0c63e4">INFORMATION CUSTOMER                             </div>


                                    <div  class="col-md-6">Name: <c:out value = "${requestScope.customer.customerName}"/>                                </div>

                                    <div  class="col-md-6">Address: <c:out value = "${requestScope.customer.customerAddress}"/>                                </div>

                                    <div  class="col-md-6">Birth: <c:out value = "${requestScope.customer.customerBirth}"/>                                </div>

                                    <div  class="col-md-6">Phone: <c:out value = "${requestScope.customer.customerPhone}"/>                                </div>

                                    <div  class="col-md-6">Gender: <c:out value = "${requestScope.customer.customerGender}"/>                                </div>
                                    <br>
                                    <br>
                                    <div  class="col-md-12" style="font-size: 20px; color: #0c63e4">SERVICE                        </div>

                                    <div  class="col-md-12">Service Name: <c:out value = "${requestScope.customer.serviceName}"/>                                 </div>
                                    <br>
                                    <br>
                                    <div  class="col-md-12" style="font-size: 20px; color: #0c63e4">TEST                        </div>

                                      <c:forEach var="i" items="${requestScope.test}" >

                                    <div  class="col-md-6">Test Name: <c:out value = "${i.testName}"/>                                </div>

                                    <div  class="col-md-6">Test Price: <c:out value = "${i.getTestPrice1()}"/>                                </div>

                                    <div  class="col-md-12">Test Result: <c:out value = "${i.resultTest}"/>                                </div>


                                    <div  class="col-md-12">Test Date: <c:out value = "${i.testDate}"/>                          </div>
                                    <br>
                                    <br>
                                     </c:forEach>
                                    <br>
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
                                    </div>
                            </table>
                        </div>
                        <div id="signature-horizontal-html" class="tab-pane" role="tabpanel">
                            <textarea class="form-control" rows="10"></textarea>
                        </div>
                    </div>

                    <br>


                </div>
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->

    </body>
</html>
