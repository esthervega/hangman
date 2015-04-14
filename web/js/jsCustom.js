function changePic(butPres)
{
  makeRequest("search", butPres.value);
  butPres.disabled=true;
}
function resetGame()
{
  makeRequest("newGame", "");
  document.getElementById("Img").src="images/hangman.png";
  document.getElementById("ImgResult").src="";
  
  // Enable all keyboard buttons
  var alph_letters = document.getElementsByClassName("alph_letter");
  for (var i = 0; i < alph_letters.length; i++) {
	  alph_letters[i].disabled=false;
  }
}

