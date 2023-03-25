<%-- 
    Document   : Service
    Created on : Feb 6, 2023, 7:45:29 PM
    Author     : Hi! Le Minh Hieu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="style/service.css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <jsp:include page="Header.jsp"/>
     <body>
    <div class="our-service-sass hide-pr show-pr">
				<div class="container">
					<div class="theme-title-one text-center">
						<div class="icon-box hide-pr">
							<img src="http://html.creativegigs.net/rogan/rogan-c/html/images/shape/bg-shape1.svg" alt="" class="bg-shape">
							<img src="http://html.creativegigs.net/rogan/rogan-c/html/images/icon/icon23.svg" alt="" class="icon">
						</div>
						<h2 class="main-title">MEDICAL  EXAMINATION  SERVICE </h2>
					</div> <!-- /.theme-title-one -->
					
					<div class="inner-wrapper">
						<div class="row">
                                                    <c:forEach var="i" items="${requestScope.service}" >
							<div class="col-lg-4 single-block aos-init aos-animate" data-aos="fade-up">
								<div class="service-block">
									<span class="snow-dot"></span>
									<span class="snow-dot"></span>
									<span class="snow-dot"></span>
									<span class="snow-dot"></span>
									<span class="snow-dot"></span>
									<span class="snow-dot"></span>
									<span class="snow-dot"></span>
									<div class="hover-content"></div>
                                                                        
									<i class="flaticon-web user"></i>
                                                                        <div class="item">
                                                                        <img src="<c:out value = "${i.serviceImage}"/>">
                                                                        </div>
                                                                        <h5 class="title"><a href="servicedetail?sid=${i.serviceId}"><c:out value = "${i.serviceName}"/></a></h5>
									<p><c:out value = "${i.servicePrice}"/>VND</p>
									<a class="detail-button"><i class="icon-img"><img src="https://cdn-icons-gif.flaticon.com/6172/6172532.gif" width="100%"></i></a>
								</div> <!-- /.service-block -->
							</div> <!-- /.single-block -->
                                                        </c:forEach>
						</div> <!-- /.row -->
					</div> <!-- /.inner-wrapper -->
				</div> <!-- /.container -->
			</div>
        </body>
     <jsp:include page="Footer.jsp"/>
</html>
