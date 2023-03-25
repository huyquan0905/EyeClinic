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
                            <div class="col-sm-11">
                                <h2>Customer <b>Testing</b></h2>
                            </div>

                        </div>
                    </div>
                    <table class="table table-striped table-hover">
                        <thead>

                            <tr>
                                <th>

                                </th>
                                <th>Customer Name</th>
                                <th></th>
                                <th></th>
                                <th>Test Name</th>
                                <th></th>
                                <th></th>
                                <th>Status</th>
                                <th></th>

                            </tr>
                        </thead>
                        <tbody>                         
                            <c:forEach var="t" items="${requestScope.listCusTest}">
                                <tr>
                            <input type="hidden" name="tid" value="${t.testId}"/>
                           
                                <td>
                                </td>
                                <td><c:out value = "${t.customerName}"/></td>
                                <td></td>
                                <td></td>
                                <td><c:out value = "${t.testName}"/></td>
                                <td></td>
                                <td></td>
                                <td><c:out value = "${t.testStatus}"/></td>
                                <td></td>
                                <td></td>
                                <td></td> 
                                <c:if test="${t.testStatus=='Processing'}">
                                <td>
                                    <a href="test_medical_servlet?cid=${t.customerId}&tid=${t.testId}">Fill in test results</a>                                       
                                </td>
                                </c:if>
                                <c:if test="${t.testStatus=='Test Done'}">
                                    <td></td> 
                                </c:if>
                            
                            </tr>

                        </c:forEach>  
                        </tbody>
                    </table>
                   <a href="employee">Back to Dashboard</a>
                    <div class="clearfix">

                        <ul class="pagination">
                            <li class="page-item disabled"><a href="#">Previous</a></li>
                           <c:forEach begin="1" end="${requestScope.page}" var="i">
                            <li class="page-item"><a href="test_customer_servlet?index=${i}" class="page-link">${i}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>

        </body>
    </html>
