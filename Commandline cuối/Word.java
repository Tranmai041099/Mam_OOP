package DictionaryCommandline;

public class Word {
	private String  word_target;
	private String word_explain;
	
	public Word() {
		word_target = "";
		word_explain = "";
	}
	
	public Word(String target, String explain)
	 {
	      this.word_explain = explain;
	      this.word_target = target;
	 }
	
	public String getTarget() {
		return word_target;
	}
	
	public void setTarget(String target) {
		word_target = target;
	}
	
	public String getMeaning() {
		return word_explain;
	}
	
	public void setMeaning(String target) {
		word_explain = target;
	}
	
}
