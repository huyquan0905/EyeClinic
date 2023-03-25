<%-- 
    Document   : Header.jsp
    Created on : Feb 6, 2023, 1:26:49 PM
    Author     : Hi! Le Minh Hieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="style/header.css">
<!DOCTYPE html>
<html>


    <div class="header-all">
        <header class="header responsive-wrapper1">

            <div class="header-left">
                <img src="https://gudlogo.com/wp-content/uploads/2019/04/logo-doi-mat-57.png " align ="left" width="20%" />
            </div>

            <div style="font-size: medium" class="header-middle">
                <a href="home" class="header-link">HOME</a>
                <span>/</span>
                <a href="service" class="header-link">SERVICE</a>
                <span>/</span>
                <c:if test = '${sessionScope.account.accountId == null}'>
                    <a href="login" class="header-link">BOOKING</a>
                </c:if>
                <c:if test = '${sessionScope.account.accountId != null && sessionScope.customer.accountcId == null}'>
                    <a href="profile" class="header-link">BOOKING</a>
                </c:if>
                <c:if test = '${sessionScope.account.accountId != null && sessionScope.customer.accountcId != null}'>
                    <a href="booking" class="header-link">BOOKING</a>
                </c:if> 

                <c:if test="${sessionScope.account.roleAdmin==0&&sessionScope.account.getRoleEmployee1()==1}">
                    <span>/</span>
                    <a href="employee" class="header-link">EMPLOYEE</a>
                </c:if>

                <c:if test="${sessionScope.account.roleAdmin==1&&sessionScope.account.getRoleEmployee1()==1}">
                    <span>/</span>
                    <a href="admin" class="header-link">ADMIN</a>
                </c:if>
                <span>/</span>
                <c:if test = '${sessionScope.account.accountId == null}'>
                    <a href="login" class="header-link">CONTACT US</a>
                </c:if>
                <c:if test = '${sessionScope.account.accountId != null}'>
                    <a href="contact_servlet" class="header-link">CONTACT US</a>
                </c:if> 

            </div>

            <form action="search_servlet" method="post">
                <input type="hidden" name="method" value="customerSearch">
                <input value="${key}" type="search" placeholder="Search" aria-label="Search" name="keyword"/>
                <button class="btn btn-outline-success" type="submit">
                    Search
                </button>
            </form>

            <div style="font-size: medium" class="header-right">
                <c:if test="${sessionScope.account==null}">
                    <nav class="header-nav">
                        <a href="login" class="header-link">Login</a>
                        <span>/</span>
                        <a href="signup" class="header-link header-link--button">Signup</a>
                    </nav>
                </c:if>
                <c:if test="${sessionScope.account!=null}">
                    <nav class="header-nav">
                        <a href="profile" class="header-link">Hello ${sessionScope.account.accountName}</a>
                        <span>/</span>
                        <a href="logout" class="header-link header-link--button">Logout</a>
                    </nav>
                </c:if>


            </div>



        </header>
    </div>

</html>
