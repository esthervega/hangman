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
  //TODO - Enablel all keyboard buttons
}

