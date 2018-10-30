package DictionaryManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

import com.sun.speech.freetts.VoiceManager;

public class DictionaryManagement {
	
	public void  insertFromFile(String s, ArrayList <Word> w) { // ham doc file
		w.clear();
		BufferedReader br = null;
		File f = new File(s);
		s = f.getAbsolutePath();
		try {
			
			FileInputStream fileInPutStream = new FileInputStream(s);
            Reader reader = new InputStreamReader(fileInPutStream, "utf8");
            br = new BufferedReader(reader);
            
			String s1 = "";
			Word wordtemp = new Word();
			while((s1 = br.readLine()) != null) {
				if(s1.startsWith(" ")) {
					if(!wordtemp.getMeaning().equals(""))
						wordtemp.setMeaning(wordtemp.getMeaning() + "\n" + s1);
					else
						wordtemp.setMeaning(s1);
				}
				else
				{
					wordtemp = new Word();
					w.add(wordtemp);
					wordtemp.setTarget(s1);
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
	
	public String dictionaryLookup(String s) { // ham tim kiem tu
		for (Word word : DictionaryArrayList.words) {
			if(s.equals(word.getTarget()))
        		return word.getMeaning();
			if(s.toLowerCase().equals(word.getTarget().toLowerCase()))
				return word.getMeaning();
        }
        return "No such word";
	}
	
	public void dictionaryLookuptoReplace(String meaning, String searchword) { // ham tim kiem de sua va them
		boolean x = true;
		if (!meaning.startsWith(" "))
			meaning = " " + meaning;
		meaning = meaning.replaceAll("\n", "\n ");
		meaning = meaning.replaceAll("\n  ", "\n ");
		if(meaning.substring(meaning.length()-1).equals("\n "))
			meaning = meaning.substring(0, meaning.length()-2)+ "\n";
		if(meaning.endsWith("\n "))
			meaning = meaning.substring(0, meaning.length()-2) + "\n";
		for (Word word : DictionaryArrayList.words) {
        	if(searchword.equals(word.getTarget()) || searchword.toLowerCase().equals(word.getTarget()) ||  searchword.toLowerCase().equals(word.getTarget().toLowerCase())) {
    			word.setMeaning(meaning);
        		x = false;
        		break;
        	}
		}
		if(x) {
			Word g = new Word(searchword, meaning);
			DictionaryArrayList.words.add(g);
		}
	}
	
	public void dictionaryExpertToFile(String filename, ArrayList <Word> w) throws IOException { // ham ghi du lieu tu mang vao file
		File f = new File(filename);
		filename = f.getAbsolutePath();
		
		FileOutputStream fileOutputStream = new FileOutputStream(filename);
        Writer writer = new OutputStreamWriter(fileOutputStream, "utf8");
        BufferedWriter bw = new BufferedWriter(writer);
		int i = 0;
		for (Word word : w) {
			bw.write(word.getTarget()+ "\n");
			if(!word.getMeaning().equals("")) {
				if(i < w.size()-1)
					bw.write(word.getMeaning() + "\n");
				else
					bw.write(word.getMeaning());
			}
			i++;
		} 
		bw.close();
	}
	
	public void dictionaryLookuptoDelete(String searchword, String meaning, String filename) throws IOException { // xoa tu
		int i = 0;
		for (Word word : DictionaryArrayList.words) {
        	if(searchword.equals(word.getTarget()) && meaning.equals(word.getMeaning())) {
        		DictionaryArrayList.words.remove(i);
        		break;
        	}
        	i++;
		}
	}
	
	public void Speech(String searchword) { // phat am
		
		System.setProperty("mbrola.base", "res/mbrola");
		VoiceManager voiceManager = VoiceManager.getInstance();
		com.sun.speech.freetts.Voice syntheticVoice = voiceManager.getVoice("mbrola_us1");
		syntheticVoice.allocate();
		syntheticVoice.speak(searchword);
		syntheticVoice.deallocate();
	}


}
