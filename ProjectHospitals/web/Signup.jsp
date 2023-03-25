<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="style/signup.css">


<html>
    <body>
        <div class="container">
            <div class="screen">
                <div class="screen__content">
                    <form class="login" action="signup" method="post">
                        <div class="login__field">
                            <i class="login__icon fas fa-user"></i>

                            <input minlength="10" maxlength="30" type="email" required name="user" class="login__input" placeholder="User name / Email">

                        </div>


                        <div class="login__field">
                            <i class="login__icon fas fa-lock"></i>
                            <input minlength="8" maxlength="15" type="password" required name="pass" class="login__input" placeholder="Password">
                        </div>
                        <div class="login__field">
                            <i class="login__icon fas fa-lock"></i>
                            <input minlength="8" maxlength="15" type="password" required name="repass" class="login__input" placeholder="Re-Password">
                        </div>
                        <button class="button login__submit">
                            <span class="button__text">Sign up</span>
                            <i class="button__icon fas fa-chevron-right"></i>
                        </button>				
                    </form>
                    <h3  style="text-align: center" style='color: red'>${requestScope.error}</h3>
                    <div class="social-login">
                        
                        <br>
                        <br>
                        <br>
                        <button class="button login__submit" onclick='window.history.go(-1);'>< Back to Home</button>

                        <i class="button__icon fas fa-chevron-right"></i>
                        </button>

                        <i class="button__icon fas fa-chevron-right"></i>


                    </div>
                </div>
                    <div class="screen__background">
			<span class="screen__background__shape screen__background__shape4"></span>
			<span class="screen__background__shape screen__background__shape3"></span>		
			<span class="screen__background__shape screen__background__shape2"></span>
			<span class="screen__background__shape screen__background__shape1"></span>
		</div>	

            </div>
        </div>
    </body>
</html>