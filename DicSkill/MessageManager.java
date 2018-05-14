package DicSkill;

import java.util.ArrayList;


/**
 * 29.04.2018
 * TO DO:
 * -	finish function findWishedWord
 * -	finish function findFunction
 * -	finish setting all keywords in constructor
 * -	consider category in code
 * -	add functions to change settings
 * @author Lia
 *
 */

public class MessageManager {
	
	/** VARIABlES **/
	private ArrayList<String> keywords_translation;
	private ArrayList<String> keywords_definition;
	private ArrayList<String> keywords_synonyms;
	private ArrayList<String> keywords_scrabble_start;
	private ArrayList<String> keywords_scrabble_end;
	private ArrayList<String> keywords_scrabble_contain;
	private ArrayList<String> keywords_spelling;
	
	
	
	/** Constructor **/
	public MessageManager() {
		
		//All keywords are set here
		
		// TRANSLATION
		keywords_translation = new ArrayList<String>();
		keywords_translation.add("translate");
		
		// DEFINITION
		keywords_definition = new ArrayList<String>();
		keywords_definition.add("define");
		
		// SYNONYMS
		keywords_synonyms = new ArrayList<String>();
		keywords_synonyms.add("synonyms");
		
		// SCRABBLE START WITH
		keywords_scrabble_start = new ArrayList<String>();
		keywords_scrabble_start.add("start");
		
		// SCRABBLE END WITH
		keywords_scrabble_end = new ArrayList<String>();
		keywords_scrabble_end.add("end");
				
		// SCRABBLE CONTAIN WITH
		keywords_scrabble_contain = new ArrayList<String>();
		keywords_scrabble_contain.add("contain");
		
		// SPELLING
		keywords_spelling = new ArrayList<String>();
		keywords_spelling.add("spell");
		
	}
	
	
	/** Methods **/
	
	
	/*
	 * receives the msg, decodes it and calls the corresponding function
	 * Also updates the context in the process
	 */
	public String decodeMsg(String msg, Settings settings, DatabaseCommunicator dbC, Context context) {
		
		String ww; // the wished word
		Function f; // the function
		String result; // the result received from the DatabaseCommunicator 
		
		// calls the functions, which find and return the wished word and function to set parameters
		ww = findWishedWord(msg, context);
		f = findFunction(msg);
		
		// Updates the context
		context.setLastFunctionUsed(f);
		context.setLastWishedWord(ww);
		
		// Calls the corresponding function depending on the result of the evaluation above
		switch(f) {
			
			case TRANSLATION: 
				result = dbC.translate(ww, settings.getNOW_translation());
				break;
			case DEFINITION:
				result = dbC.define(ww, settings.getNOW_definition());
				break;
			case SPELLING:
				result = dbC.spell(ww);
				break;
			case SYNONYMS:
				result = dbC.giveSynonyms(ww, settings.getNOW_synonyms());
				break;
			case SCRABBLE_START:
				result = dbC.scrabble_start(ww, settings.getNOW_scrabble());
				break;
			case SCRABBLE_CONTAIN:
				result = dbC.scrabble_contain(ww, settings.getNOW_scrabble());
				break;
			case SCRABBLE_END:
				result = dbC.scrabble_end(ww, settings.getNOW_scrabble());
				break;
			default:
				result ="";
				System.out.println("Sorry, message could not be computed.");
			}
		
		// returns the msg
		return createMsg(context, result);
		
	}
	
	/*
	 * finds and returns the requested function in the msg
	 */
	private Function findFunction(String msg){
		
		//missing: find out what function is being called
		
		return null;
	}

	
	/*
	 * finds and returns the wished word in the msg. if there is no (new) wished word, it sets the last wished word
	 */
	private String findWishedWord(String msg, Context context){
		
		// missing: find and return wished word
		
		
		// code will only reach this statement if wished word is not found above
		return context.getLastWishedWord();
		
	}
	
	
	// creates a msg depending on the used function, the wished word and the result
	private String createMsg(Context context, String result) {
		
		String outputMsg = "Error: Message could not me created.";
		
		// Translation msg:
		if(context.getLastFunctionUsed() == Function.TRANSLATION)
			outputMsg = "The translation of " + context.getLastWishedWord() + " is " + result;
		
		// Definition msg:
		if(context.getLastFunctionUsed() == Function.DEFINITION)
			outputMsg = "" + result;
		
		// Synonyms msg:
		if(context.getLastFunctionUsed() == Function.SYNONYMS)
			outputMsg = "Synonyms for " + context.getLastWishedWord() + " are " + result;
		
		// Scrabble start msg:
		if(context.getLastFunctionUsed() == Function.SCRABBLE_START)
			outputMsg = "Words which start with " + context.getLastWishedWord() + " are " + result;
		
		// Scrabble end msg:
		if(context.getLastFunctionUsed() == Function.SCRABBLE_END)
			outputMsg = "Words which end with " + context.getLastWishedWord() + " are " + result;
				
		// Scrabble start msg:
		if(context.getLastFunctionUsed() == Function.SCRABBLE_CONTAIN)
			outputMsg = "Words which contain " + context.getLastWishedWord() + " are " + result;
		
		// Spelling msg:
		if(context.getLastFunctionUsed() == Function.SPELLING)
			outputMsg = "" + context.getLastWishedWord() + " is spelled " + result;
		
		
		return outputMsg;
		
	}
	/** Setters and Getters **/

}