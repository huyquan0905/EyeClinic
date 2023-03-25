<%-- 
    Document   : ManageCustomer
    Created on : Feb 14, 2023, 12:11:43 AM
    Author     : Hi! Le Minh Hieu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="style/managementcustomer.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
      <body>
        <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
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
                                <h2>Management <b>Customer</b></h2>
                            </div>
                            
                        </div>
                    </div>
                    <form action="search_servlet" method="post">
                        <input type="hidden" name="method" value="searchCustomer">
                        <input value="${key}" type="search" placeholder="Search" aria-label="Search" name="keyword"/>
                        <button class="btn btn-outline-success" type="submit">
                            Search
                        </button>
                    </form>
                    <table class="table table-striped table-hover">
                        <thead>
                     
                            <tr>
                                <th>

                                </th>
                                <th>Name</th>
                                <th>Address</th>
                                <th>Birth</th>
                                <th>Phone</th>
                                <th>Gender</th>
                                <th></th>
                                <th>Status</th>
                                
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="i" items="${requestScope.listCustomer}" >
                                    <tr>
                                    <td>

                                    </td>
                                    <td><c:out value = "${i.customerName}"/></td>
                                    <td><c:out value = "${i.customerAddress}"/></td>
                                    <td><c:out value = "${i.customerBirth}"/></td>
                                    <td><c:out value = "${i.customerPhone}"/></td>
                                    <td><c:out value = "${i.customerGender}"/></td>
                                    <td></td>
                                    <td><c:out value = "${i.customerStatus}"/></td>
                                    <td></td>
                                    
                                </tr>
                                
                                </c:forEach>
                            </tbody>
                    </table>
                         <a href="admin">DASHBOARD</a>
                    <div class="clearfix">
                        <div class="hint-text">Showing <b>${requestScope.page}</b> out of <b>.....</b> entries</div>
                        <ul class="pagination">
                            <c:forEach begin="1" end="${requestScope.page}" var="i">
                            <li class="page-item"><a href="manage_customer?index=${i}" class="page-link">${i}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
            
        </body>
</html>
