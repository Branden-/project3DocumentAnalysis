
public class WordFreq implements Comparable {
	
	private StringBuilder word;
	private int frequency;
	
	public WordFreq(String key){
		word = (key == null)? null : new StringBuilder(key);
		frequency = 0;
	}
	
	public WordFreq(String key, int num){
		word = (key == null)? null : new StringBuilder(key);
		frequency = num;
	}
	
	public String getWord(){
		return word.toString();
	}
	
	public int getFrequency(){
		return frequency;
	}
	
	public void setWord(String newWord){
		word = new StringBuilder(newWord);
	}
	
	public void setFrequency(int newFreq){
		frequency = newFreq;
	}
	
	public void clone(WordFreq newValue){
		setWord(newValue.getWord());
		setFrequency(newValue.getFrequency());
	}
	
	public void incrementFreq(int i){
		frequency = frequency + i;
	}

	@Override
	public int compareTo(Comparable value) {
		WordFreq clone = (WordFreq) value;
		return word.toString().compareTo(clone.word.toString());
	}
	
	public int compareTo(String key){
		return word.toString().compareTo(key);
	}
}
