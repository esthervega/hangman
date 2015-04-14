package com.myOrg;

import java.util.ArrayList;
import java.util.Iterator;

public class Testing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("########HANGMAN######");
		
		Hangman hm = new Hangman();
		hm.newTry('a');
		hm.newTry('e');
		hm.newTry('i');
		hm.newTry('o');
		hm.newTry('u');
		
		ArrayList<Integer> positions = new ArrayList<Integer>();
		
		Iterator it = positions.iterator();
		while (it.hasNext()){
			System.out.println("Position: " + it.next());
		}
	}

}
