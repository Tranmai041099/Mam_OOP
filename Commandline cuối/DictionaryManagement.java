package DictionaryCommandline;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;



public class DictionaryManagement {
	

	public void insertFromCommandline() {
		int n;
	    System.out.print("So tu can them: ");
	    n = new Scanner(System.in).nextInt();
	    for (int i = 1; i <= n; i++) {
	        String target, explain;
	        System.out.print("Nhap tu thu " + i + ": ");
	        target = new Scanner(System.in).nextLine();
	        System.out.print("Nhap nghia: ");
	        explain = new Scanner(System.in).nextLine();
	        Word wordtemp = new Word(target, explain);
	        DictionaryArrayList.words.add(wordtemp);
	    }

	}
	
	public void  insertFromFile() { // ham doc file
		BufferedReader br = null;
		try {
			File file = new File("C:/Users/user/Documents/OOP/dictionary/a.txt");
			
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			 
			String s;
			while((s = br.readLine()) != null) {
				String s1[] = s.split("\t");
				Word wordtemp = new Word(s1[0], s1[1]);
				DictionaryArrayList.words.add(wordtemp);
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
	
	public void dictionaryLookup() { // ham tim kiem tu
		boolean x = true;
		System.out.print("Nhap tu can tra: ");
		String s = new Scanner(System.in).nextLine();
		for (Word word : DictionaryArrayList.words) {
        	if(s.equals(word.getTarget())) {
        		System.out.println("Nghia: " + word.getMeaning());
        		x = false;
        		break;
        	}
        }
        if(x)
        	System.out.println("No such word");
	}
	
	public void dictionaryReplace() throws IOException { // ham sua tu
		for (Word word : DictionaryArrayList.words) {
			System.out.print("Nhap tu can sua: ");
			String s = new Scanner(System.in).nextLine();
			System.out.print("Nhap nghia can sua: ");
			String meaning = new Scanner(System.in).nextLine();
			if(s.equals(word.getTarget())) {
        		word.setMeaning(meaning);
        		break;
        	}
		}
        System.out.println("Da sua tu");
	}
	
	
	public void dictionaryExpertToFile() throws IOException { // ham ghi du lieu tu mang vao file
		File file = new File("C:/Users/user/Documents/OOP/dictionary/a.txt");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
		for (Word word : DictionaryArrayList.words) {
			bw.write(word.getTarget()+ "\t");
			bw.write(word.getMeaning() + "\n");
		} 
		bw.close();
	}
	
	public void dictionaryDelete() throws IOException { // ham xoa tu
		System.out.print("Nhap tu can xoa: ");
		String searchword = new Scanner(System.in).nextLine();
		int i = 0;
		for (Word word : DictionaryArrayList.words) {
        	if(searchword.equals(word.getTarget())) {
        		DictionaryArrayList.words.remove(i);
        		break;
        	}
        	i++;
		}
		System.out.println("Da xoa");
	}
	
	public void dictionaryAddword() throws IOException { // ham them tu
		System.out.print("Nhap tu can them: ");
		String target = new Scanner(System.in).nextLine();
		System.out.print("Nhap nghia: ");
		String explain = new Scanner(System.in).nextLine();
		Word wordtemp = new Word(target, explain);
        DictionaryArrayList.words.add(wordtemp);
        System.out.println("Da them tu");
	}
	
}
