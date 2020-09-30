<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>잉력시장 : 회원가입</title>
    <script src="/Surplus-PowerMarket/resources/juso.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="/Surplus-PowerMarket/resources/css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="/Surplus-PowerMarket/resources/css/animate.css">
    
    <link rel="stylesheet" href="/Surplus-PowerMarket/resources/css/owl.carousel.min.css">
    <link rel="stylesheet" href="/Surplus-PowerMarket/resources/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="/Surplus-PowerMarket/resources/css/magnific-popup.css">

    <link rel="stylesheet" href="/Surplus-PowerMarket/resources/css/aos.css">

    <link rel="stylesheet" href="/Surplus-PowerMarket/resources/css/ionicons.min.css">
    
    <link rel="stylesheet" href="/Surplus-PowerMarket/resources/css/flaticon.css">
    <link rel="stylesheet" href="/Surplus-PowerMarket/resources/css/icomoon.css">
    <link rel="stylesheet" href="/Surplus-PowerMarket/resources/css/style.css">
</head>
<style>
b {

color : red;

}

table {
    width: 500px;
    height: 200px;
    margin-left: auto;
    margin-right: auto;
  }

#table4{
border-bottom:none;
width : 400px;
}  
 
</style>
<body>
	<jsp:include page="header.jsp"></jsp:include>
    <!-- END nav -->
	
	<br>
	<br>
	<h1 style="font-family: 'Do Hyeon', sans-serif;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;회원가입</h1>
	<!-- 회원가입 폼. -->
	<hr style="width:90%;">
	<br>
	<br>
		<form method="post" name="userInfo" action="/Surplus-PowerMarket/signin.do" enctype="multipart/form-data">
        <table>
        <tr>
			<td id = table4><b>*</b> 아이디</td><td><input id="userid" style="width: 200px; text-align: left;" type="text" name="id">
			<input type="button" value="중복확인" onclick="openIdCheck();">
			<input type="hidden" name="idDuplication" value="idUncheck">
		</td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td id = table4><b>*</b> 비밀번호</td><td><input id="firstPW" onKeyUp="checkPW();" style="width: 200px; text-align: left;" type="password" name="password"></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td id = table4><b>*</b> 비밀번호 확인</td><td><input id="secondPW" onKeyUP="checkPW();" style="width: 200px; text-align: left;" type="password" name="passwordcheck"></td>
		</tr>
		<tr>
			<td id="checkMsg"></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td id = table4><b>*</b> 이름</td><td><input id="username" style="width: 200px; text-align: left;" type="text" name="name"></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td id = table4><b>*</b> 이메일</td><td><input id="email" style="width: 200px; text-align: left;" type="email" name="email"></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>	
			<td id = table4><b>*</b> 생일</td><td><input id="birthday" style="width: 200px; text-align: left;" type="date" name="birthday"></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>	
			<td id = table4><b>*</b> 성별</td><td> <SELECT name='sex'>
			            <OPTION value='female'>여자</OPTION>
			            <OPTION value='male'>남자</OPTION>
			            </SELECT></td>
	    </tr>
	    <tr><td>&nbsp;</td></tr>
	    <tr>
			<td id = table4><b>*</b> 핸드폰 번호</td><td><input id="phone" style="width: 200px; text-align: left;" type="tel" name="phone"></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>	
			<td id = table4><b>*</b> 주소
			<input type="button" value="주소 검색" onclick="goPopup();"></td><td>
			<input id="address" style="width: 300px; text-align: left; font-size:12px;" type="text" name="address" 
			class="form-control" required="true" readonly="true"></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>	
			<td id = table4>프로필 사진</td><td> 
			<input id="photo" style="width: 200px; text-align: left;" type="file" name="photo"> </td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td id = table4><b>*</b> 직업 </td><td> <SELECT name='isEmployer'>
				        <OPTION value='1'>사업자</OPTION>
				        <OPTION value='2'>파트타이머</OPTION>
			            </SELECT></td>
		</tr>
		<jsp:useBean id="toDay" class="java.util.Date" />
		<fmt:formatDate value='${toDay}' pattern='yyyy-MM-dd HH:mm' var="nowDate"/>
		<tr>
			<td id = table4><b></b></td><td><input id="register_date" style="width: 200px; text-align: left;" type="hidden" name="date"
			value="${ nowDate }"></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
				<td id = table3 colspan ="2" style = "text-align: center;">
				<input type="submit" value="회원가입"> 
				<input type="reset" value="재작성"> 
				<input onclick="location.href='/Surplus-PowerMarket/main'" type="button" value="취소">
				</td>
			</tr>
		</table>
		</form>
		<br><br><br><br><br><br>

    <jsp:include page="footer.jsp"></jsp:include>
		
  <script src="/Surplus-PowerMarket/resources/js/jquery.min.js"></script>
  <script src="/Surplus-PowerMarket/resources/js/jquery-migrate-3.0.1.min.js"></script>
  <script src="/Surplus-PowerMarket/resources/js/popper.min.js"></script>
  <script src="/Surplus-PowerMarket/resources/js/bootstrap.min.js"></script>
  <script src="/Surplus-PowerMarket/resources/js/jquery.easing.1.3.js"></script>
  <script src="/Surplus-PowerMarket/resources/js/jquery.waypoints.min.js"></script>
  <script src="/Surplus-PowerMarket/resources/js/jquery.stellar.min.js"></script>
  <script src="/Surplus-PowerMarket/resources/js/owl.carousel.min.js"></script>
  <script src="/Surplus-PowerMarket/resources/js/jquery.magnific-popup.min.js"></script>
  <script src="/Surplus-PowerMarket/resources/js/aos.js"></script>
  <script src="/Surplus-PowerMarket/resources/js/jquery.animateNumber.min.js"></script>
  <script src="/Surplus-PowerMarket/resources/js/scrollax.min.js"></script>
  <script src="/Surplus-PowerMarket/resources/js/main.js"></script>
  <script>
  function repeatCheck(){

		var request = new XMLHttpRequest();
		var id = document.getElementsByName("id")[0].value;
		request.onload = function(event){
			if(request.status==200){
				var str = request.responseText;
				var obj = JSON.parse(str);
				alert('zzz');
			}
		}
		request.open('POST',"/Surplus-PowerMarket/idCheck",true);
		request.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
		request.send("id="+id);
	}

	function checkValue(){
		var form = document.userInfo;
		
		if(!form.id.value){
			alert("아이디를 입력하세요.");
			return false;
		}
		
		if(form.idDuplication.value!="idCheck"){
			alert("아이디 중복체크를 해주세요.");
			return false;
		}
		
		if(!form.password.value){
			alert("비밀번호를 입력하세요.");
			return false;
		}
		
		if(form.password.value!=form.passwordcheck.value){
			alert("비밀번호를 동일하게 입력하세요.");
		}
		
		if(!form.name.value){
			alert("이름을 입력하세요.");
			return false;
		}
		
		if(!form.email.value){
			alert("이메일을 입력하세요.");
			return false;
		}
		
		if(!form.birthday.value){
			alert("생일을 입력하세요.");
			return false;
		}
		
		if(!form.phone.value){
			alert("휴대폰 번호를 입력하세요.");
			return false;
		}
		
		if(!form.address.value){
			alert("주소를 입력하세요.");
		}
		
	}

	function openIdCheck(){
		window.name = "parentForm";
		window.open("resources/IdCheckForm.html",
				"checkForm","width=500, height=300, resizable=no,scrollbars=no");
	}

	function inputIdCheck(){
		document.userInfo.idDuplication.value = "idUncheck";
	}

	function checkPW(){
		var pwDom1 = document.getElementById("firstPW");
		var pwDom2 = document.getElementById("secondPW");
		var checkMsgDom = document.getElementById("checkMsg");
		var checkMsg = checkMsgDom.value;
		var color = checkMsgDom.style.color;
		
		var pw1 = pwDom1.value;
		var pw2 = pwDom2.value;
		console.log("pw1 : "+pw1+", pw2 : "+pw2);
		if(pw1!=pw2){
			if(color=="green" || !checkMsg){
				checkMsgDom.textContent = "비밀번호가 일치하지 않습니다!";
				checkMsgDom.style.color = "red";
			}
		}
		if(pw1==pw2){
			if(color=="red" || !checkMsg){
				checkMsgDom.textContent = "비밀번호가 일치합니다.";
				checkMsgDom.style.color = "green";
			}
		}
	}
  </script>
</body>
</html>