package DictionaryMana;

public class DictionaryCommandLine {
	DictionaryManagement d = new DictionaryManagement();
	
	public void showAllWords() {
		System.out.println("No\t\tEnglish\t\tVietnamese");
		for(int i = 0; i < d.dic.arr.size(); i++) {
			System.out.println(i+1 + "\t\t" + d.dic.arr.get(i).word_target + "\t\t" + d.dic.arr.get(i).word_explain);
		}
	}
	
	public void dictionaryBasic() {
		d.insertFromCommandline();
		showAllWords();
	}
}
