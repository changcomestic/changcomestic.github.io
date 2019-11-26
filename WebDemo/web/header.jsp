<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Header</title>
        <link rel="stylesheet" href="style/styleHeader.css" />
        <link rel="shortcut icon" href="favicon.ico" />
        <script src="https://use.fontawesome.com/releases/v5.11.2/js/all.js" data-auto-replace-svg="nest"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    </head>

    <body>
        <% String userName = (String) session.getAttribute("USERNAME"); %>
        <header>
            <a href="#" class="logo">
                <img src="icon.png" alt="Logo" />
            </a>
            <div class="menu-toggle"></div>
            <nav>
                <ul class="nav_links">
                    <li><a href="#" class="active"><i class="fas fa-home"></i></a></li>
                    <li><a href="#">Services</a></li>
                    <li><a href="#">Products</a></li>
                    <li><a href="#">About Us</a></li>
                    <li><a href="#">Contact</a></li>
                        <% if (userName == null) { %> 
                    <li> 
                        <a class="btnLogin" href="login.html">
                            Login
                        </a>
                    </li>
                    <%} else {%>
                    <li> 
                        <a class="welcomeUser" href="login.html">
                            Welcome back!!
                        </a>
                    </li>
                    <%}%>



                    <li><a class="shopping-cart" href="#">
                            <i class="fas fa-shopping-cart"></i>
                        </a>
                    </li>
                </ul>
            </nav>
            <div class="clearfix"></div>
        </header>

        <script type="text/javascript">
            $(document).ready(function () {
                $('.menu-toggle').click(function () {
                    $('.menu-toggle').toggleClass('active')
                    $('nav').toggleClass('active')
                })
            })
        </script>

    </body>

</html>