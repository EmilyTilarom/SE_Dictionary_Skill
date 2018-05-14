package DicSkill;

import java.io.Serializable;

/**
 * 29.04.2018
 * TO DO:
 * -	make context saveable
 * @author Lia
 *
 */

public class Context implements Serializable {

	/** VARIABlES **/
	private Function lastFunctionUsed;
	private String preferredCategory;
	private String lastWishedWord; // The Wished Word, is the word, the function will be applied to
	
	
	/** Constructor **/
	public Context(){
		
	}
	
	
	/** Methods **/


	
	/** Setters and Getters **/
	public Function getLastFunctionUsed() {
		return lastFunctionUsed;
	}


	public void setLastFunctionUsed(Function lastFunctionUsed) {
		this.lastFunctionUsed = lastFunctionUsed;
	}


	public String getPreferredCategory() {
		return preferredCategory;
	}


	public void setPreferredCategory(String preferredCategory) {
		this.preferredCategory = preferredCategory;
	}


	public String getLastWishedWord() {
		return lastWishedWord;
	}


	public void setLastWishedWord(String lastWishedWord) {
		this.lastWishedWord = lastWishedWord;
	}
	
}
