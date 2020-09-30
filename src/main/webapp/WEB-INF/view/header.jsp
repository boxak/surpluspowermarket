<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>Surplus-PowerMarket Header</title>
    </head>
    <body>
    <div class="bg-top navbar-light d-flex flex-column-reverse">
        <div class="container py-3">
            <div class="row no-gutters d-flex align-items-center align-items-stretch">
                <div class="col-md-4 d-flex align-items-center py-4">
                    <a class="navbar-brand" href="/Surplus-PowerMarket/main" style="font-family: 'Do Hyeon', sans-serif;">잉/력/시/장 <span>Surplus-Power Market</span></a>
                </div>
                <div class="col-lg-8 d-block">
                    <div class="row d-flex" style="font-family: 'Do Hyeon', sans-serif;">
                        <div class="col-md d-flex topper align-items-center align-items-stretch py-md-4">
                            <div class="icon d-flex justify-content-center align-items-center"><span class="ion-ios-paper-plane"></span></div>
                            <div class="text">
                                <span>Email</span>
                                <span>surpluspowermarket@gmail.com</span>
                            </div>
                        </div>
                        <div class="col-md d-flex topper align-items-center align-items-stretch py-md-4">
                            <div class="icon d-flex justify-content-center align-items-center"><span class="ion-ios-call"></span></div>
                            <div class="text">
                                <span>Call</span>
                                <span>+123 523 5598</span>
                            </div>
                        </div>
                        <div class="col-md d-flex topper align-items-center align-items-stretch py-md-4">
                            <div class="icon d-flex justify-content-center align-items-center"><span class="ion-ios-time"></span></div>
                            <div class="text">
                                <span>Project Period</span>
                                <span>20200309-20200319</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="top-social-menu py-2 bg-light">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <p class="social mb-0">
                            <a href="#"><i class="ion-logo-facebook"></i><span class="sr-only">Facebook</span></a>
                            <a href="#"><i class="ion-logo-twitter"></i><span class="sr-only">Twitter</span></a>
                            <a href="#"><i class="ion-logo-googleplus"></i><span class="sr-only">Googleplus</span></a>
                        </p>
                    </div>
                    <div class="col text-right">
                        <a href="#" class="btn-link">@JAVAS</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark ftco-navbar-light" id="ftco-navbar">
        <div class="container d-flex align-items-center">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="oi oi-menu"></span> Menu
            </button>
            <div class="collapse navbar-collapse" id="ftco-nav">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item"><a href="/Surplus-PowerMarket/main" class="nav-link" style="font-family: 'Do Hyeon', sans-serif; font-size: 20px;">홈</a></li>
                    <li class="nav-item"><a href="/Surplus-PowerMarket/about" class="nav-link" style="font-family: 'Do Hyeon', sans-serif; font-size: 20px;">소개</a></li>
                    <li class="nav-item"><a href="/Surplus-PowerMarket/developers" class="nav-link" style="font-family: 'Do Hyeon', sans-serif; font-size: 20px;">개발진</a></li>
                    <li class="nav-item"><a href="/Surplus-PowerMarket/board/jobad" class="nav-link" style="font-family: 'Do Hyeon', sans-serif; font-size: 20px;">대타 구인</a></li>
                    <li class="nav-item"><a href="/Surplus-PowerMarket/board/wantad" class="nav-link" style="font-family: 'Do Hyeon', sans-serif; font-size: 20px;">대타 구직</a></li>
                    <li class="nav-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                    <li class="nav-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                    <li class="nav-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                    <li class="nav-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                    <li class="nav-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                    <li class="nav-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                    <li class="nav-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                    <li class="nav-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                    <li class="nav-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                    <li class="nav-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                    <li class="nav-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                    <li class="nav-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                    <li class="nav-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                    <c:if test="${!empty loginVO}">
                        <li class="nav-item"><a href="/Surplus-PowerMarket/mypage" class="nav-link" style="font-family: 'Do Hyeon', sans-serif; font-size: 20px;">마이페이지</a></li>
                        <li class="nav-item"><a href="/Surplus-PowerMarket/logout" class="nav-link" style="font-family: 'Do Hyeon', sans-serif; font-size: 20px;">로그아웃</a></li>
                    </c:if>
                    <c:if test="${empty loginVO}">
                        <li class="nav-item"><a href="/Surplus-PowerMarket/login/form" class="nav-link" style="font-family: 'Do Hyeon', sans-serif; font-size: 20px;">로그인</a></li>
                        <li class="nav-item active"><a href="/Surplus-PowerMarket/signForm" class="nav-link" style="font-family: 'Do Hyeon', sans-serif; font-size: 20px;">회원가입</a></li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>
    </body>
</html>