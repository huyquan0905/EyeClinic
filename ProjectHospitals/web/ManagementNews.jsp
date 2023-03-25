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
        <title>Management News</title>
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
                                <h2>Management <b>News</b></h2>
                            </div>
                            <div class="col-sm-6">
                                <a href="#addNews" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add News</span></a>

                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>

                                </th>

                                <th>Name</th>
                                <th>Summary</th>
                                <th>Detail</th>
                                <th>Image</th>
                                <th>Author</th>



                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="n" items="${requestScope.nl}">

                                <tr>
                                    <td></td>
                                    <td><c:out value = "${n.newsName}"/></td>
                                    <td><c:out value = "${n.newsSummary}"/></td>
                                    <td><c:out value = "${n.newsDetail}"/></td>
                                    <td><img width="200px" height="150px" src="<c:out value = "${n.newsImg}"/>"></td>
                                    <td><c:out value = "${n.newsAuthor}"/></td>

                                    <td>
                                        <a data-target="#edit_news_servlet${n.newsId}" href="#edit_news_servlet?id=${n.newsId}"class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                        <a href="delete_news_servlet?nid=${n.newsId}" onclick="return confirm('Are you sure?')" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                    </td>
                                    <td></td>
                                </tr>


                            <div class="modal fade" id="edit_news_servlet${n.newsId}" role="dialog">
                                <div class="modal-dialog">

                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">Edit News</h4>
                                        </div>
                                        <form action="edit_news_servlet" method="post">
                                            <div class="modal-body">
                                                <b></b><input type="hidden" class="form-control" name="id" value="<c:out value = "${n.newsId}"/>" readonly=""><br>
                                                <b>Name: </b><input type="text" class="form-control" name="name" value="<c:out value = "${n.newsName}"/>"><br>
                                                <b>Summary </b><input type="text" class="form-control"  name="summary" value="<c:out value = "${n.newsSummary}"/>"><br> 
                                                <b>Detail </b><input type="text" class="form-control"  name="detail" value="<c:out value = "${n.newsDetail}"/>"><br>       
                                                <b>Image link:</b><input type="text" class="form-control"  name="img" value="<c:out value = "${n.newsImg}"/>"><br>
                                                <b>Author:</b><input type="text" class="form-control"  name="author" value="<c:out value = "${n.newsAuthor}"/>"><br>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                <button type="submit" class="btn btn-success" value="submit">Submit</button>
                                            </div>
                                        </form>
                                    </div>

                                </div>
                            </div>
                        </c:forEach>



                        </tbody>
                    </table>
                    <div class="clearfix">
                        <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>
                        <ul class="pagination">
                            <li class="page-item disabled"><a href="#">Previous</a></li>
                            <li class="page-item"><a href="#" class="page-link">1</a></li>
                            <li class="page-item"><a href="#" class="page-link">2</a></li>
                            <li class="page-item"><a href="#" class="page-link">3</a></li>
                            <li class="page-item"><a href="#" class="page-link">4</a></li>
                            <li class="page-item"><a href="#" class="page-link">5</a></li>
                            <li class="page-item"><a href="#" class="page-link">Next</a></li>
                        </ul>
                    </div>
                </div>
            </div>
         
            <div id="addNews" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="add_news_servlet" method="post">
                            <div class="modal-body">
                                <b>Name: </b><input type="text" class="form-control" value=""  name="name"><br>
                                <b>Summary: </b><input type="text" class="form-control" value=""  name="summary"><br>
                                <b>Detail: </b><input type="text" class="form-control" required value="" name="detail"><br>
                                <b>Image link:</b><input type="text" class="form-control" required  value="" name="img"><br>
                                <b>Author: </b><input type="text" class="form-control" value=""  name="author"><br>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                <button type="submit" class="btn btn-success" value="submit">Add</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- Edit Modal HTML -->
        </body>
    </html>
