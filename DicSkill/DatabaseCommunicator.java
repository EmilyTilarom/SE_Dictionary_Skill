package DicSkill;

/**
 * 29.04.2018
 * TO DO:
 * -	make use of database
 * -	implement all functions
 * -	function translate is a rough template of what the functions (except extractResult) should look like
 * @author Lia
 *
 */


public class DatabaseCommunicator {
	
	/** VARIABlES **/
	
	
	
	/** Constructor **/
	public DatabaseCommunicator(){
		
	}
	
	
	/** Methods **/
	
	/*
	 * makes sense of the gibberish the data base outputs
	 * String shall always be the result (definition/translation/...)
	 */
	private String extractResult(String dbOutput) {
		return null;
	}
	
	// returns the translation of the wished word
	public String translate(String ww, int NOW) {
		
		String result; // = call data base function
		result = ""; // must be deleted later on
		result = extractResult(result);
		
		return result;
	}
	
	// returns the definiton of the wished word
	public String define(String ww, int NOW) {
		return null;
	}
	
	// returns synonyms for the wished word
	public String giveSynonyms(String ww, int NOW) {
		return null;
	}
	
	// returns the spelling of the wished word
	public String spell(String ww) {
		return null;
	}
	
	
	
	// returns words that start with [letters]
	public String scrabble_start(String letters, int NOW) {
		return null;
	}
	
	// returns words that end with [letters]
	public String scrabble_end(String letters, int NOW) {
		return null;
	}
	
	// returns words that contain [letters]
	public String scrabble_contain(String letters, int NOW) {
		return null;
	}


	
	/** Setters and Getters **/

}
