<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="style/employeedashboard.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Dashboard</title>
    </head>
    <body>
    <header>
      <h1>Employee Dashboard</h1>
    </header>
    <div class="container">
      <nav>
        
        <div class="row">
          <div class="column">
    <div class="card">
       
        <h1>Hello Employee</h1>
     
            </div>
             
    </div>
  </div>
           
          <div class="column">
    <div class="card">
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbcCxYk-K7qqRsAgZk8kthnGsFELR8nwdwpQ&usqp=CAU">
     
    </div>
  </div>
          <div class="column">
              
   
  </div>
          
 
          

        
  

      </nav>
      <section id="main">
        <h2 style="font-size: 40px;">Tasks given to Employee</h2>
        <button style="background-color: #00a86b; border-radius: 10px; border-color: #00a86b"><a style="color: white; text-decoration: none " href="register_patient_servlet" class="nav__item-link"><h2>Check Waiting Room</h2><i class="bi bi-person-fill-add"></i></a></button>
         <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-person-fill-add" viewBox="0 0 16 16">
  <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7Zm.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0Zm-2-6a3 3 0 1 1-6 0 3 3 0 0 1 6 0Z"/>
  <path d="M2 13c0 1 1 1 1 1h5.256A4.493 4.493 0 0 1 8 12.5a4.49 4.49 0 0 1 1.544-3.393C9.077 9.038 8.564 9 8 9c-5 0-6 3-6 4Z"/>
</svg>
        <br>
        <br>
        <button style="background-color: #00a86b; border-radius: 10px; border-color: #00a86b"><a style="color: white; text-decoration: none " href="manage_booking" class="nav__item-link"><h2>Approve Booking</h2><i class="bi bi-person-fill-add"></i></a></button>
         <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-person-check-fill" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M15.854 5.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 0 1 .708-.708L12.5 7.793l2.646-2.647a.5.5 0 0 1 .708 0z"/>
  <path d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
</svg>
        <br><!-- comment -->
        <br>
        <button style="background-color: #00a86b; border-radius: 10px; border-color: #00a86b"><a style="color: white; text-decoration: none"  href="test_customer_servlet?index=1" class="nav__item-link"><h2>Fill in test results</h2><i class="bi bi-person-check-fill"></i></a></button>  
        <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-person-workspace" viewBox="0 0 16 16">
  <path d="M4 16s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1H4Zm4-5.95a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5Z"/>
  <path d="M2 1a2 2 0 0 0-2 2v9.5A1.5 1.5 0 0 0 1.5 14h.653a5.373 5.373 0 0 1 1.066-2H1V3a1 1 0 0 1 1-1h12a1 1 0 0 1 1 1v9h-2.219c.554.654.89 1.373 1.066 2h.653a1.5 1.5 0 0 0 1.5-1.5V3a2 2 0 0 0-2-2H2Z"/>
</svg>
<br><!-- comment -->
<br>
        <button style="background-color: #00a86b; border-radius: 10px; border-color: #00a86b"><a style="color: white; text-decoration: none"  href="approve_pay_servlet" class="nav__item-link"><h2>Approve Paying</h2><i class="bi bi-person-check-fill"></i></a></button> 
        <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-credit-card-fill" viewBox="0 0 16 16">
  <path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v1H0V4zm0 3v5a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V7H0zm3 2h1a1 1 0 0 1 1 1v1a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1v-1a1 1 0 0 1 1-1z"/>
</svg>
       
        <div class="table-box">
           
		<table class="table">
			<thead>
				<tr>
					<th>Amount of Work</th>
                                        <th>Your Work Employees</th>
                                        
					
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
                                        <td>Check waiting room</td>
					
				</tr>
                                <tr>
					<td>2</td>
					<td>Approve Booking</td>
				</tr>
				<tr>
					<td>3</td>
					<td>Fill in test result</td>
				</tr>
                                <tr>
					<td>4</td>
					<td>Approve Paying</td>
				</tr>
			</tbody>
		</table>
	</div>
      </section>
    </div>
  </body>
</html>
