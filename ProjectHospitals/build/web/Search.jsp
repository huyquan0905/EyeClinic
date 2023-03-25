<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="style/search.css">

<jsp:include page="Header.jsp"/>
<main class="responsive-wrapper">
    <br>
    <br>
    <br>   
    <c:forEach var="s" items="${requestScope.listService}">
        <div class="border1" style="margin-left: 200px; margin-right: 200px;pad">
            <div class="card">
                <div>
                    <div class="img1"><img width="auto" height="130px" src="<c:out value = "${s.serviceImage}"/>"></div>
                </div>

                <div class="card-info">
                    <h2 style="color: #35f126" id="desc"><c:out value = "${s.serviceName}"/></h2>
                </div>

            </div>
        </div>
        <br><br><br><br><br><br><br><br><br>
    </c:forEach>
    <br>
    <br>
    <br>
    <c:forEach var="n" items="${requestScope.listNews}">
        <div class="border1" style="margin-left: 200px; margin-right: 200px;pad">
            <div class="card">
                <div>
                    <div class="img1"><img width="auto" height="130px" src="<c:out value = "${n.newsImg}"/>"></div>
                </div>

                <div class="card-info">
                    <h2 style="color: #35f126" id="desc"><c:out value = "${n.newsName}"/></h2>
                </div>

            </div>
        </div>
        <br><br><br><br><br><br><br><br><br>
    </c:forEach>

</main>

<jsp:include page="Footer.jsp"/>
</html>
