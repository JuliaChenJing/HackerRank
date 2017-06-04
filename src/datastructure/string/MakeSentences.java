package datastructure.string;

public class MakeSentences {
	public String makeSentenceWithString(String[] words) {
		StringBuffer sentence = new StringBuffer();
		for (String w : words)
			sentence.append(w);
		return sentence.toString();
	}

	/*
	 * Question: What is the running time of this code?
	 * 
	 * Answer: O(n*n) where n is the number of letters in sentence. Here’s why:
	 * each time you append a string to sentence, you create a copy of sentence
	 * and run through all the letters in sentence to copy them over. If you
	 * have to iterate through up to n characters each time in the loop, and
	 * you’re looping at least n times, that gives you an O(n^2) run time. Ouch!
	 * 
	 * With StringBuffer (or StringBuilder) can help you avoid this problem.
	 */

	public String makeSentenceWithStringBuffer(String[] words) {
		StringBuffer sentence = new StringBuffer();
		for (String w : words)
			sentence.append(w);
		return sentence.toString();
	}
}
