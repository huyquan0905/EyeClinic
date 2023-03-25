<!DOCTYPE html>
<html class="no-js" lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>News Detail</title>

        <link href="https://fonts.googleapis.com/css?family=Cairo:400,600,700&amp;display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Poppins:600&amp;display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400i,700i" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Ubuntu&amp;display=swap" rel="stylesheet">
    </head>

    <body class="biolife-body">

        <jsp:include page="Header.jsp"/>



        <div class="page-contain single-product">
            <div class="container">

                <!-- Main content -->
                <div id="main-content" class="main-content">

                    <!-- summary info -->
                    <div class="sumary-product single-layout">
                        <div class="product-attribute">
                            <h2 class="title" style="text-align: center">${requestScope.news.getNewsName()}</h2>
                            <div class="rating">
                            </div>
                            <div class="media" style="text-align: center">
                                <img src="${requestScope.news.getNewsImg()}" alt="" width="900px" height="400">
                            </div>
                            <span class="sku"><p style="font-size: 20px; text-align: justify" >
                                    <b></b>${requestScope.news.getNewsDetail()}<br>
                                </p>
                            </span>
                            <div class="price" style="text-align: right">
                                <ins><span class="price-amount"><b>Author: </b><span class="currencySymbol"></span>${requestScope.news.getNewsAuthor()}</span></ins>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="Footer.jsp"/>

        <!-- Scroll Top Button -->
        <a class="btn-scroll-top"><i class="biolife-icon icon-left-arrow"></i></a>


    </body>

</html>