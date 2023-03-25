<%-- 
    Document   : ServiceDetail
    Created on : Feb 6, 2023, 9:39:31 PM
    Author     : Hi! Le Minh Hieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/servicedetail.css">

        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="Header.jsp"/>
        <div class="check-body">

            <div class="container" id="app">

                <section style="text-decoration: none">
                    <h2 ><span>SERVICE DETAIL</span></h2>



                    <form method="post" action="servicedetail">
                        <div class="border1">
                            <div class="card">
                                <div>
                                    <div class="img1"><img src="${requestScope.service.serviceImage}" style="width: 300px" height="200px"> </img></div>
                                </div>
                                <div>
                                <div class="card-info">
                                    <h2 style="color: #35f126" id="desc">${requestScope.service.serviceName}</h2>
                                    <p id="card-info-desc">${requestScope.service.serviceDetail}</p>
                                    <p style="color: #f66f4e; font-size: medium" id="card-info-desc">${requestScope.service.servicePrice} VND</p>
                                    <a href="#">

                                    </a>
                                </div>
                                    </div>
                            </div>
                        </div>
                    </form>
                                    <br><!-- comment -->
                                    
                    <button class="button" onclick='window.history.go(-1);'>< Return </button>
                </section>
            </div>
        </div>
    </body>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br><br>
    <br><!-- <br> --><br><br><!-- comment -->
    
    <br><br><!-- <br> -->
    <br><!-- comment -->
     <jsp:include page="Footer.jsp"/>
</html>
