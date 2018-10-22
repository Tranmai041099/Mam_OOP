package DictionaryGraphic;

public class DictionaryCommandline1 {
	DictionaryManagement1 d = new DictionaryManagement1();
	
	public void showAllWords()
    {
        String format = "%-6d %-25s %s \n";
		System.out.printf("No    English %16s  Vietnamese \n", " ");
        int wordnum1 = 0;
        for (Word1 word : DictionaryArray.words)
        {
        	wordnum1++;
        	System.out.format(format, wordnum1, word.getTarget(), word.getMeaning());
        }
    }
	
	public void dictionaryBasic() {
		d.insertFromCommandline();
		showAllWords();
	}
	
	public void dictionaryAdvanced() {
		d.insertFromFile();
		//showAllWords();
		//d.dictionaryLookup();
	}
}
