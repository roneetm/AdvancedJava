<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Hello, world!</title>
  </head>
  <body>
<a href="index.jsp">Login</a> | <a href="LogoutServlet">Logout</a> | <a href="ProfileServlet">Profile</a>
        <br>
        <br>
        <br>

    <form action="loginservlet" method="POST">
        Email address: <input type="email" name = "email">
        <br>
        Password: <input type="password" name = "password">
        <br>
      <button type="submit" >Login</button>
    </form>

  </body>
</html>