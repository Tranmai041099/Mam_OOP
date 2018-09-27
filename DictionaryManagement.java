package DictionaryMana;

import java.util.Scanner;

public class DictionaryManagement {
	
	public DictionaryArray dic = new DictionaryArray();
	
	public void insertFromCommandline() {
		Scanner input  = new Scanner(System.in);
		String tv, eng;
		eng = input.nextLine();
		tv = input.nextLine();
		Word s = new Word(eng, tv);
		dic.arr.add(s);
	}
}
