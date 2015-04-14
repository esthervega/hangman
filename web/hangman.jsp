<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0 Draft//EN'>
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

<%		for(char ch='A';ch<='Z';ch++){ %>
		<button onclick="changePic(this)" value="<%= ch %>" id="<%= ch %>" ><%= ch %></button>
<%		}  %>

<div>	<button onclick="resetGame()" value="">New Game</button></div>

    <div><img id="ImgResult"></img></div>
    </div>
  </body>
</html>