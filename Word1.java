package DictionaryGraphic;

public class Word1 {
	private String  word_target;
	private String word_explain;
	
	public Word1() {
		word_target = "";
		word_explain = "";
	}
	
	public Word1(String target, String explain)
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
