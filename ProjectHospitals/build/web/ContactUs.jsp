<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Contact Us</title>
        <link type="text/css" rel="stylesheet" href="style/bootstrap.min.css" />
        <link type="text/css" rel="stylesheet" href="style/booking.css" />
        <link rel="stylesheet" href="style/contactus.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
        <style>
            .styleSend {
                background: #5029bc;
            }
        </style>
    </head>
    <jsp:include page="Header.jsp"/>
    <body> 
        <div class="container">
            <div class="content">
                <div class="left-side">
                    <div class="address details">
                        <i class="fas fa-map-marker-alt"></i>
                        <div class="topic">Address</div>
                        <div class="text-one">FPT University</div>
                        <div class="text-two">Hoa Lac - Ha Noi</div>
                    </div>
                    <div class="phone details">
                        <i class="fas fa-phone-alt"></i>
                        <div class="topic">Phone</div>
                        <div class="text-one">0942 000 999</div>
                        <div class="text-two">0926 999 000</div>
                    </div>
                    <div class="email details">
                        <i class="fas fa-envelope"></i>
                        <div class="topic">Email</div>
                        <div class="text-one">bacsihieu@gmail.com</div>
                        <div class="text-two">bacsiduong@gmail.com</div>
                    </div>
                </div>
                <div class="right-side">
                    <div class="topic-text">Send us a message</div>
                    <p>If you have any work from me or any types of quries related to my tutorial, you can send me message from here. It's my pleasure to help you.</p>
                    <form action="https://formsubmit.co/a238d70d68956f303598676282e9cb3e" method="POST">
                        <!--<form action="contact" method="POST">-->
                        <div class="input-box">
                            <input type="text" name="Name" required placeholder="Enter your name" required>
                        </div>
                        <div class="input-box">
                            <input type="email" name="Email" placeholder="Enter your Email" required>
                        </div>
                        <div class="input-box">
                            <input name="Phone number" type="text" placeholder="Enter your phone number" required>
                        </div>
                        <div class="input-box message-box">
                            <textarea name="Message" placeholder="Enter your message" required></textarea>
                        </div>  
                        <div class="styleSend">
                            <button type="submit">Send now</button>
                            <!--                            <input type="button" value="Send now" >-->
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
    <jsp:include page="Footer.jsp"/>
</html>




