<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0 Draft//EN'>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="alphabet" value="A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z" />
<html>
<head>
<title> HANGMAN </title>
<script type="text/JavaScript" src="js/ajax.js"></script>
<script type="text/JavaScript" src="js/jsCustom.js"></script>  

</head>

<div align=center>
<h1 >Hangman</h1>
</div>

<br/>
<body>
	<div align=center>
		<img id="Img" src='images/hangman.png' height=150 width=150 alt=''/>
		<div id="test_code"></div>
		<c:forTokens var="letter" items="${alphabet}" delims=",">
			<button onclick="changePic(this)" value="${letter}" id="${letter}" >${letter}</button>
		</c:forTokens>
	<div>
		<button onclick="resetGame()" value="">New Game</button>
	</div>
    <div>
    	<img id="ImgResult"/>
    </div>
    </div>
  </body>
</html>