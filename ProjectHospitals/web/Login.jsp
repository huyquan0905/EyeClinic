<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="style/login.css">
 <script src="login.js"></script>
 
 <html>
 <body>
 <div class="container">
	<div class="screen">
		<div class="screen__content">
                    <form class="login" action="login" method="post">
				<div class="login__field">
					<i class="login__icon fas fa-user"></i>
                                        <input minlength="10" maxlength="30" type="email" required name="user" class="login__input" placeholder="User name / Email">
				</div>
				<div class="login__field">
					<i class="login__icon fas fa-lock"></i>
                                        <input minlength="8" maxlength="15" type="password" required name="pass" class="login__input" placeholder="Password">
				</div>
				<button class="button login__submit">
					<span class="button__text">Login</span>
					<i class="button__icon fas fa-chevron-right"></i>
				</button>
                           
			</form>
                      <a href="https://accounts.google.com/o/oauth2/auth?scope=email profile&redirect_uri=http://localhost:9999/ProjectHopitals/googlelogin&response_type=code
		   &client_id=552976946992-f70ttf013s9nn0mldloam90p662kakrv.apps.googleusercontent.com&approval_prompt=force">Login With Google</a>      
                      <h3 style="text-align: center" style='color: red'>${requestScope.error}</h3>
			<div class="social-login">
                                  
          
					<span class="button__text">Forgot Password</span>
                                        <br>
                                        <br>
                                        <span class="button__text"><a href="changepw" style="color: white">Change password</a></span>
                                    
                                            <button class="button login__submit" onclick='window.history.go(-1);'>< Back to Home</button>
					
					<i class="button__icon fas fa-chevron-right"></i>
				</button>
                                        
					<i class="button__icon fas fa-chevron-right"></i>
                                       
                           
				<div class="social-icons">
					<a href="#" class="social-login__icon fab fa-instagram"></a>
					<a href="#" class="social-login__icon fab fa-facebook"></a>
					<a href="#" class="social-login__icon fab fa-twitter"></a>
				</div>
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