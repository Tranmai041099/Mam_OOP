package DictionaryGraphic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class DictionaryManagement1 {
   
	
	public void insertFromCommandline() {
		int n;
	    Scanner s = new Scanner(System.in);
	    System.out.println("moi nhap n: ");
	    n = s.nextInt();
	    Scanner input = new Scanner(System.in);
	    for (int i = 0; i < n; i++) {
	        String eng, tv;
	        eng = input.nextLine();
	        tv = input.nextLine();
	        Word1 tuvung = new Word1(eng, tv);
	        DictionaryArray.words.add(tuvung);
	    }
	    s.close();
	    input.close();
	}
	
	public void  insertFromFile() {
		BufferedReader br = null;
		try {
			File file = new File("C:/Users/user/Documents/OOP/dictionary/1234.txt");
			
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			 
			String s1;
			Word1 wordtemp = new Word1();
			while((s1 = br.readLine()) != null) {
				if(s1.startsWith(" ")) {
					if(!wordtemp.getMeaning().equals(""))
						wordtemp.setMeaning(wordtemp.getMeaning() + "\n" + s1);
					else
						wordtemp.setMeaning(s1);
				}
				else
				{
					wordtemp = new Word1();
					DictionaryArray.words.add(wordtemp);
					wordtemp.setTarget(s1);
					//s1 = br.readLine();
				}
			 }
		} catch (IOException e ) {
			e.printStackTrace();
		} finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
	
	public String dictionaryLookup(String s) {
        for (Word1 word : DictionaryArray.words) {
        	if(s.equals(word.getTarget()))
        		return word.getMeaning();
        }
        return "No such word";
	}
	
	public void dictionaryLookup1(String meaning, String searchword) {
		boolean x = true;
		if (!meaning.startsWith(" "))
			meaning = " " + meaning;
		meaning = meaning.replaceAll("\n", "\n ");
		meaning = meaning.replaceAll("\n  ", "\n ");
		if(meaning.substring(meaning.length()-1).equals("\n "))
			meaning = meaning.substring(0, meaning.length()-2)+ "\n";
		if(meaning.endsWith("\n "))
			meaning = meaning.substring(0, meaning.length()-2) + "\n";
		for (Word1 word : DictionaryArray.words) {
        	if(searchword.equals(word.getTarget())) {
    			word.setMeaning(meaning);
        		x = false;
        		break;
        	}
		}
		if(x) {
			Word1 g = new Word1(searchword, meaning);
			DictionaryArray.words.add(g);
		}
		
	}
	
	public void replaceFromFile() throws IOException {
		File file = new File("C:/Users/user/Documents/OOP/dictionary/1234.txt");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
		for (Word1 word : DictionaryArray.words) {
			bw.write(word.getTarget()+ "\n");
			if(!word.getMeaning().equals(""))
				bw.write(word.getMeaning() + "\n");
		} 
		bw.close();
	}
	
}
