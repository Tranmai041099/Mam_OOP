package DictionaryCommandline;

import java.util.Scanner;

public class DictionaryCommandLine {
	DictionaryManagement d = new DictionaryManagement();
	
	public void showAllWords()
    {
        String format = "%-6d |%-40s |%s \n";
		System.out.printf("No    English %31s  Vietnamese \n", " ");
        int wordnum1 = 0;
        for (Word word : DictionaryArrayList.words)  {
        	wordnum1++;
        	System.out.format(format, wordnum1, word.getTarget(), word.getMeaning());
        }
    }
	
	public void dictionaryBasic() {
		d.insertFromCommandline();
		showAllWords();
	}
	
	public void dictionaryAdvanced() {
		//d.insertFromFile();
		showAllWords();
		d.dictionaryLookup();
	}
	
	@SuppressWarnings("resource")
	public void dictionarySearcher() { // ham goi y tu;
		String format = "%-6d |%-40s |%s \n";
		int i = 0;
		System.out.print("Moi nhap tu : ");
		String searchword = new Scanner(System.in).nextLine();
		for (Word word : DictionaryArrayList.words) {
			if(word.getTarget().startsWith(searchword)) {
				i++;
				System.out.format(format, i, word.getTarget(), word.getMeaning());
			}
		}
	}
}
