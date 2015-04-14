/* 
* creates a new XMLHttpRequest 
* Ajax Setup
*/  
function getXMLHttpRequest() {  
  var xmlHttpReq;  
  // to create XMLHttpRequest object in non-Microsoft browsers  
  if (window.XMLHttpRequest) {  
    xmlHttpReq = new XMLHttpRequest();  
  } else if (window.ActiveXObject) {  
    try {  
      //to create XMLHttpRequest object in later versions of Internet Explorer  
      xmlHttpReq = new ActiveXObject("Msxml2.XMLHTTP");  
    } catch (exp1) {  
      try {  
        //to create XMLHttpRequest object in later versions of Internet Explorer  
        xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");  
      } catch (exp2) {  
        //xmlHttpReq = false;  
        alert("Exception in getXMLHttpRequest()!");  
      }  
    }  
  }  
  return xmlHttpReq;  
}  
  
/* 
* AJAX call makeRequest 
*/  
function makeRequest(action, char_to_check) {  
  var xmlHttpRequest = getXMLHttpRequest();  
 
  xmlHttpRequest.onreadystatechange = getReadyStateHandler(xmlHttpRequest);  
  var params = "action=" + action +"&ch=" + char_to_check;
  xmlHttpRequest.open("GET", "Hangman?"+params, true);

  xmlHttpRequest.send(null);  
}  
  
/* 
* Returns a function that waits for the state change in XMLHttpRequest 
*/  
function getReadyStateHandler(xmlHttpRequest) {
  // function returned  
  return function() {
	  var game_data="";
    if (xmlHttpRequest.readyState == 4) {
      if (xmlHttpRequest.status == 200) { 
    	  game_data = JSON.parse(xmlHttpRequest.responseText);
    	  rePrint(game_data);
    	  recreateImage(game_data);
    	  document.getElementById("test_back").innerHTML = xmlHttpRequest.responseText;
      } else {  
        alert("Http error " + xmlHttpRequest.status + ":" + xmlHttpRequest.statusText);  
      }  
    }
  };  
} 

function rePrint(game_data){
	var resultWord="";
	for (var i=0;i<game_data.game.Word.letter.length;i++){
		if(game_data.game.Word.letter[i]==''){
			resultWord=resultWord + " - ";
		}
		else{
			resultWord=resultWord + game_data.game.Word.letter[i];
		}
	}
	document.getElementById("test_code").innerHTML=resultWord;
}

function recreateImage(game_data){
	  document.getElementById("Img").src="images/hangman"+game_data.game.ko_chars.ko_char.length+".png";
	  
	  if(game_data.game.ko_chars.ko_char.length>5){
		  document.getElementById("ImgResult").src="images/hangman_ko.png";
		  //TODO - Disable buttons
		  
	  }else{
		  document.getElementById("ImgResult").src="";
	  }
}