package DicSkill;

import java.io.Serializable;

/**
 * 29.04.2018
 * TO DO:
 * -	make settings saveable
 * @author Lia
 *
 */

public class Settings implements Serializable  
{
	/** VARIABlES **/
	
	// NOW = Number Of Words
	private int NOW_translation;
	private int NOW_definition;
	private int NOW_synonyms;
	private int NOW_scrabble;
	
	
	/** Constructor **/
	public Settings()
	{
		this.NOW_translation = 1;
		this.NOW_definition = 1;
		this.NOW_synonyms = 3;
		this.NOW_scrabble = 3;
	}
	
	/** Methods **/
	public void setAll(int x)
	{
		this.NOW_translation = x;
		this.NOW_definition = x;
		this.NOW_synonyms = x;
		this.NOW_scrabble = x;
	}

	
	/** Setters and Getters **/
	public int getNOW_translation() {
		return NOW_translation;
	}

	public void setNOW_translation(int nOW_translation) {
		NOW_translation = nOW_translation;
	}

	public int getNOW_definition() {
		return NOW_definition;
	}

	public void setNOW_definition(int nOW_definition) {
		NOW_definition = nOW_definition;
	}

	public int getNOW_synonyms() {
		return NOW_synonyms;
	}

	public void setNOW_synonyms(int nOW_synonyms) {
		NOW_synonyms = nOW_synonyms;
	}

	public int getNOW_scrabble() {
		return NOW_scrabble;
	}

	public void setNOW_scrabble(int nOW_scrabble) {
		NOW_scrabble = nOW_scrabble;
	}
	
}
