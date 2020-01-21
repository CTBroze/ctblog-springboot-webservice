<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

    <title>기억저장소 웹서비스</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    <!-- Custom fonts for this template -->
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="/css/clean-blog.min.css" rel="stylesheet">

</head>
<body>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/about">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/posting">Posting</a>
                </li>
                <c:set var="userName" value="${userName}"/>
                <c:choose>
                    <c:when test="${empty userName}">
                        <li class="nav-item">
                            <a class="nav-link" href="/oauth2/authorization/google">Login</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="/posts/save">Write Post</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>
<header class="masthead" style="background-color:Black">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <div class="site-heading">
                    <h1>CTBroze Memory Storge</h1>
                    <span class="subheading">CTBroze의 개인블로그</span>
                </div>
            </div>
        </div>
    </div>
</header>
<!--게시글 출력-->
     <div class="col-md-12">
            <br>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-md-10 mx-auto">
                        <c:set var="i" value="0"/>
                        <c:forEach items="${posts}" var="post">
                        <c:if test="${i < 5}">
                        <div class="post-preview">
                            <a href="/posts/read/${post.id}">
                                <h2 class="post-title">
                                    ${post.title}
                                </h2>
                            </a>
                            <p class="post-meta">Posted by
                                ${post.author}
                                on ${post.modifiedDate}</p>
                        </div>
                        <hr>
                        </c:if>
                        <c:set var="i" value="${i+1}"/>
                        </c:forEach>
                        <div class="clearfix">
                                  <a class="btn btn-primary float-right" href="/posting">과거글보기</a>
                        </div>
                    </div>
                </div>
            </div>
        <hr>
<!-- Footer -->
       <footer>
           <div class="container">
               <div class="row">
                   <div class="col-lg-8 col-md-10 mx-auto">
                       <p class="copyright text-muted">Copyright &copy; CTBlog.net 2019</p>
                   </div>
               </div>
           </div>
       </footer>
       <!--웹페이지는 위의 코드부터 로딩되기에 로딩이 오래걸리는 js파일들은 아래에 배치시킨다.-->

       <!-- Bootstrap core JavaScript -->
       <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
       <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

       <!-- Custom scripts for this template -->
       <script src="/js/clean-blog.min.js"></script>
       <script src="/js/app/index.js"></script>

       </body>
</html>