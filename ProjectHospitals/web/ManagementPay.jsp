<%-- 
    Document   : ManagementAccount
    Created on : Feb 11, 2023, 10:00:09 PM
    Author     : Hi! Le Minh Hieu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="style/managementaccount.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Management Pay</title>
        <style>
            #bottone1:hover {
                box-shadow: 7px 5px 56px -14px #C3D900;
            }

            #bottone1:active {
                transform: scale(0.97);
                box-shadow: 7px 5px 56px -10px #C3D900;
            }
        </style>
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
                                <h2>Management <b>Pay</b></h2>
                            </div>
                            <div class="col-sm-6">

                            					
                            </div>
                        </div>
                    </div>
                    <form action="search_servlet" method="post">
                        <input type="hidden" name="method" value="searchPay">
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
                                <th>Customer Name</th>
                                <th>Price Service</th>
                                <th>Price Test</th>
                                <th>Price Total</th>
                                <th>Pay Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="i" items="${requestScope.listPay}" >
                                <tr>
                                    <td></td>
                                    <td><c:out value = "${i.customerName}"/></td>
                                    <td><c:out value = "${i.getServicePrice1()}"/></td>
                                    <td><c:out value = "${i.testPrice}"/></td>
                                    <td><c:out value = "${i.getPayTotal1()}"/></td>
                                    <td><c:out value = "${i.payStatus}"/></td>
                                    <td></td>

                                    <td>
                                        <c:if test="${i.payStatus=='Unpaid'}">


                                            <form action="manage_pay_servlet" method="post">
                                                <input type="hidden" name="pid" value="${i.customerId}"/>

                                                 <button style=" border: none;
  outline: none;
  background: #007bff;
  color: white;
  width: 80%;
  height: 40px;
  border-radius: 5px;
  margin: 0px 0 10px;
  font-size: 14px;
  cursor: pointer;

  &:hover,
  &:active {
    background: rgb(113, 113, 113);
  }">Done</button>



                                            </form>  
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                    <div class="clearfix">
                       <a href="admin">Back to Dashboard</a>
                        <ul class="pagination">
                            <li class="page-item disabled"><a href="#">Total Revenue: ${requestScope.totalRevenue}</a></li>
                            <br>
                            <br>
                            <li class="page-item disabled"><a href="#">Previous</a></li>
                            <br>
                               
                        </ul>
                    </div>
                </div>
            </div>
            <!-- Edit Modal HTML -->
            
                </div>
            </div>
            <!-- Edit Modal HTML -->
        </body>
    </html>
