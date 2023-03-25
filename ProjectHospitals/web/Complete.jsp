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
        <script src="https://unpkg.com/currency.js@~2.0.0/dist/currency.min.js"></script>


        <div class="container">
            <div class="row">
                <div class="col-md-7">





                    <div id="signature-output" class="col-md-12">
                        <h3 style="text-align: center; font-size: 60px; color: #00a86b">whole examination</h3>

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
                                        <input type="hidden" name="sid" value="${requestScope.service.serviceId}"/>

                                        <div  class="col-md-6">Service Name: <c:out value = "${requestScope.customer.serviceName}"/>                                 </div>
                                        <div  class="col-md-6"> Service Price: <c:out value = "${requestScope.service.getServicePrice1()}"/> VND                                </div>
                                        <br>
                                        <br>
                                        <div  class="col-md-12" style="font-size: 20px; color: #0c63e4">TEST                        </div>

                                        <c:forEach var="i" items="${requestScope.test}" >

                                            <div  class="col-md-6">Test Name: <c:out value = "${i.testName}"/>                                </div>

                                            <div  class="col-md-6">Test Price: <c:out value = "${i.getTestPrice1()}"/> VND                                </div>

                                            <div  class="col-md-12">Test Result: <c:out value = "${i.resultTest}"/>                                </div>


                                            <div  class="col-md-12">Test Date: <c:out value = "${i.testDate}"/>                          </div>
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
                                    </div>
                            </div>  
                            </table>
                        </div>
                        <div id="signature-horizontal-html" class="tab-pane" role="tabpanel">
                            <textarea class="form-control" rows="10"></textarea>
                        </div>
                    </div>

                    <br>

                </div>
                <br>

                <!-- /row -->
            </div>
            <div class="col-md-5">
                <div id="signature-output" class="col-md-12">
                    <h5 style="text-align: center; font-size: 60px; color: #00a86b">Pay</h5>

                    <div class="tab-content">
                        <div id="signature-horizontal-visual" 
                             class="tab-pane active" role="tabpanel">
                            <table style="font-family:'overpass', sans-serif;color:#333;font-style:normal;font-size:14px;margin:0px;padding:0px;border:0px;outline:0px;vertical-align:baseline;line-height:1.15;" border="0" cellpadding="0" cellspacing="0">
                                <div class="row">
                                    <div  class="col-md-12" style="font-size: 20px; color: #0c63e4">INFORMATION CUSTOMER                             </div>
                                    
                                    <c:forEach var="i" items="${requestScope.test}" >
                                        <div  class="col-md-12">Test Price:  <c:out value = "${i.getTestPrice1()}"/> VND                                </div>                                 
                                    </c:forEach>
                                        
                                    <div  class="col-md-12"> Service Price: <c:out value = "${requestScope.service.getServicePrice1()}"/> VND                             </div>
                                    <div  class="col-md-12" name="total5">Total: <c:out value = "${requestScope.total}"/> VND</div>
                                   




                                </div>
                        </div>  
                        </table>
                    </div>
                    <div id="signature-horizontal-html" class="tab-pane" role="tabpanel">
                        <textarea class="form-control" rows="10"></textarea>
                    </div>
                </div>

                <br>

            </div>
            <br>

            <!-- /row -->
        </div>
    <!-- /container --> 
</div>
<form action="complete_medical_servlet" method="post">
    <input type="hidden" name="cid" value="${requestScope.customer.customerId}"/>
    <button class="button login__submit">
        <span class="button__text">DONE</span>
    
        <i class="button__icon fas fa-chevron-right"></i>
    </button>
     <input type="hidden" name="total" value="${requestScope.total1}"/>
</form>
</body>
</html>
