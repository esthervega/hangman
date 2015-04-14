package com.myOrg;

import java.util.ArrayList;
import java.util.Iterator;

public class Hangman {
	
	String playingWord;
	int tryCounter;
	ArrayList<Character> okChars;
	ArrayList<Character> koChars;
	Character[] tmpWord;
	
	//If I disable checked buttons, I don't have to pass back the ko chars
	//Only chars ok and positions;
	//Not even that if they are already printed?
	
	GamesPersistance gameData;
	
	Hangman(){
		gameData=new FileManager();
		setNewPlayingWord();
		okChars=new ArrayList<Character>();
		koChars=new ArrayList<Character>();
		tmpWord = new Character[this.getPlayingWord().length()];
	}
	
	public String newTry(char c){
		ArrayList<Integer> pos= new ArrayList<Integer>();
		//Check the positions
		this.checkChar(c, pos);
		//Create Temporal Word
		Iterator<Integer> it = pos.iterator();
		while(it.hasNext()){
			this.tmpWord[it.next()]=c;
		}

		return this.createGameData();
	}
	
	public void getNewGame(){
		this.setNewPlayingWord();
	}
	
	public boolean checkChar(char c, ArrayList<Integer> characterPositions  ){
		//Playing word is stored in lowercase
		c=Character.toLowerCase(c);
		tryCounter++;
		if (getPlayingWord().contains(String.valueOf(c))){
			characterPositions.addAll(getPositionsArray(c));
			okChars.add(c);
			return true;
		}else{
			//Ensure list returns empty
			characterPositions.clear();
			koChars.add(c);
			return false;
		}
	}

	
	public String getPlayingWord(){
		return this.playingWord;
	}
	
	private void setNewPlayingWord(){
		this.playingWord=gameData.getNewWord().toLowerCase();
		tryCounter=0;
	}
	
	private ArrayList<Integer> getPositionsArray(char c){
		ArrayList<Integer> positions = new ArrayList<Integer>();
		String playingWord = getPlayingWord();
		int p=-1;
		do{
			p = playingWord.indexOf(c, p+1);
			if(p>-1){
				positions.add(p);
			}
		}while(p>-1);
		return positions;
	}
	
	private int getTryCounter(){
		return this.tryCounter;
	}
	
	private ArrayList<Character> getOkChars() {
		return okChars;
	}

	private ArrayList<Character> getKoChars() {
		return koChars;
	}
	
	public String createGameData(){
		StringBuffer xmlResult = new StringBuffer();
		XmlUtil.startXml(xmlResult);
		XmlUtil.adToXML(tmpWord, "Word", "letter", xmlResult);
		XmlUtil.adToXML(okChars.toArray(), "ok_chars", "ok_char",xmlResult);
		XmlUtil.adToXML(koChars.toArray(), "ko_chars", "ko_char",xmlResult);
		XmlUtil.finishXml(xmlResult);
		String jsonResult = XmlUtil.fromXmlToJson(xmlResult.toString());
		return jsonResult;
	}
}

