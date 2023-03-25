<%-- 
    Document   : ServiceMedical
    Created on : Feb 16, 2023, 10:50:30 PM
    Author     : Hi! Le Minh Hieu
--%>

<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
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

        <h1> <span style=" background-color: #119462">EXAMINATION</span></h1>

        <div class="container">
            <div class="row">
                <div class="col-md-6">
                <h3>EXAM</h3>
                    <form id="employee-information-form" action="exam_medical_servlet" method="post">
                        <fieldset>

                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="form-group">
                                        <span class="form-label">Conclusion:</span>
                                        <input name="conclusion" class="form-control" type="text" placeholder="Enter Conclusion" required>
                                    </div>
                                </div>


                                <div class="col-sm-12">
                                    <div class="form-group">
                                        <span class="form-label">Exam Date:</span>
                                        <%
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String formattedDate = formatter.format(date);
    %>
    <input name="testdate" class="form-control" type="text" value="<%= formattedDate %>" disabled="false" required>
  
                                    </div>
                                </div>
                            </div>
                            <input type="hidden" name="cid" value="${requestScope.customer.customerId}"/>
                            <button class="button login__submit">
                                <span class="button__text">Next Step</span>
                                <i class="button__icon fas fa-chevron-right"></i>
                            </button>
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

                                    <div  class="col-md-6">Test Price: <c:out value = "${i.getTestPrice1()}"/> VND                               </div>

                                    <div  class="col-md-12">Test Result: <c:out value = "${i.resultTest}"/>                                </div>


                                    <div  class="col-md-12">Test Date: <c:out value = "${i.testDate}"/>                          </div>
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
