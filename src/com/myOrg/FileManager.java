package com.myOrg;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileManager implements GamesPersistance{
   
    private List<String> readWordsFromFile(String pFilename) throws IOException {
  	
    	ClassLoader loader = FileManager.class.getClassLoader();
          if(loader==null)
            loader = ClassLoader.getSystemClassLoader();
    	
        URL url = loader.getResource(pFilename);
          
        BufferedReader in = new BufferedReader(new FileReader(url.getPath()));  
        List<String> wordsList = new ArrayList<String>(); 
        String oneWord;  
        while((oneWord = in.readLine())!=null){  
        	wordsList.add(oneWord);              
        }    
        return wordsList;  
    }
    
	public String getNewWord() {
		String word="default";
		List<String> wordsList;
		try {
			wordsList = this.readWordsFromFile("conf/words.txt");
			Random randomNum = new Random();
			int position = randomNum.nextInt(wordsList.size());
			word = wordsList.get(position);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot access the word puzzle file");
			e.printStackTrace();
			word=e.getMessage();
		}
		return word;
	}

	public void getGameStatus(int id) {
		// TODO Auto-generated method stub	
	}

	public int setGameStatus() {
		// TODO Auto-generated method stub
		return 0;
	} 
	
	//We'll need to write status from file
    private void writeToFile(String pFilename, StringBuffer pData) throws IOException {  
        BufferedWriter out = new BufferedWriter(new FileWriter(pFilename));  
        out.write(pData.toString());  
        out.flush();  
        out.close();  
    }

    //We'll need to read the status from the file
    private StringBuffer readFromFile(String pFilename) throws IOException {  
        BufferedReader in = new BufferedReader(new FileReader(pFilename));  
        StringBuffer data = new StringBuffer();  
        int c = 0;  
        while ((c = in.read()) != -1) {  
            data.append((char)c);  
        }  
        in.close();  
        return data;  
    }

}