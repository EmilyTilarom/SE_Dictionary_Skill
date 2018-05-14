import rita.*;

public class Functions {

    //https://rednoise.org/rita/reference/RiWordNet.html
    //https://rednoise.org/rita/reference/PennTags.html

    public static RiWordNet dictionary;

    public static void main(String[] args) {

//		String[] s = w.getAllSynsets("cow", "v");
//		System.out.println(java.util.Arrays.asList(s));
//		
//		RiString rs = new RiString("The elephant took a bite!");
//	    System.out.println(rs.features());

        //Objects

        //create dictionary
//		Thread test = new Thread() {
//		    public void run() {
//		        try {
//		        	dictionary = new RiWordNet("dict/");
//		        } catch(Exception e) {
//		            System.out.println(e);
//		        }
//		    }  
//		};
//		test.start();
        dictionary = new RiWordNet("dict/");

        //implements delay to wait until dictionary is loaded
//		try {
//		    Thread.sleep(2000); 
//		} catch (InterruptedException e) {
//		    e.printStackTrace();
//		}


        //create output
        String [] outputArray;
        String output;
        int outputID;
        boolean isIt;

        //print array:
        //System.out.println(java.util.Arrays.asList(outputArray));


        if(dictionary.exists("car")) //Query if word exists in dictionary
        {
            //do something
            //System.out.println("true");
        }

        //Synonyms
        //returns synonyms for a specific sense (as specified by its unique id)
        outputArray = dictionary.getSynonyms(4234); //Word ID
        System.out.println("Synonyms: " +java.util.Arrays.asList(outputArray));
        //returns synonyms for the most common sense
        outputArray = dictionary.getSynonyms("car", RiWordNet.NOUN); //String word, String pos (parts.of.speech)/constant
        System.out.println("Synonyms: " +java.util.Arrays.asList(outputArray));
        //3rd returns synonyms for ALL senses for the word/pos pair
        outputArray = dictionary.getAllSynonyms("car", "n"); //String,  String pos (parts.of.speech)/constant
        System.out.println("Synonyms: " +java.util.Arrays.asList(outputArray));

        //AlsoSees nouns (?) & adjectives
        outputArray = dictionary.getAllAlsoSees("happy", "a");
        System.out.println("AlsoSees: " +java.util.Arrays.asList(outputArray));

        //Antonyms adjectives only (?)
        outputArray = dictionary.getAllAntonyms("happy", "a");
        System.out.println("Antonyms: " +java.util.Arrays.asList(outputArray));

        //Coordinates ??? btwn nouns/nouns and verbs/verbs
        outputArray = dictionary.getAllCoordinates("car", "n");
        System.out.println("Coordinates: " +java.util.Arrays.asList(outputArray));

        //Derived (adverbs)
        outputArray = dictionary.getAllDerivedTerms("happily", "r");
        System.out.println("Derived: " +java.util.Arrays.asList(outputArray));

        //Examples
        outputArray = dictionary.getAllExamples("car", "n");
        System.out.println("Examples: " +java.util.Arrays.asList(outputArray));

        //Glosses
        outputArray = dictionary.getAllGlosses("car", "n");
        System.out.println("Glosses: " +java.util.Arrays.asList(outputArray));

        //Holonyms nouns and nouns
        outputArray = dictionary.getAllHolonyms("car", "n");
        System.out.println("Holonyms: " +java.util.Arrays.asList(outputArray));

        //Hypernyms
        outputArray = dictionary.getAllHypernyms("car", "n");
        System.out.println("Hypernyms: " +java.util.Arrays.asList(outputArray));

        //Hyponyms
        outputArray = dictionary.getAllHyponyms("car", "n");
        System.out.println("Hyponyms: " +java.util.Arrays.asList(outputArray));

        //Meronyms Nouns and nouns
        outputArray = dictionary.getAllMeronyms("car", "n");
        System.out.println("Meronyms: " +java.util.Arrays.asList(outputArray));

        //Nominalizations nouns, verbs & adjecstives(?)
        outputArray = dictionary.getAllNominalizations("happy", "a");
        System.out.println("Nominalizations: " +java.util.Arrays.asList(outputArray));

        //Similar adjectives
        outputArray = dictionary.getAllSimilar("happy", "a");
        System.out.println("Similar: " +java.util.Arrays.asList(outputArray));

        //Synsets
        outputArray = dictionary.getAllSynsets("car", "n");
        System.out.println("Synsets: " +java.util.Arrays.asList(outputArray));

        //VerbGroups verbs
        outputArray = dictionary.getAllVerbGroups("car", "n");
        System.out.println("VerbGroups: " +java.util.Arrays.asList(outputArray));

        //Anagrams
        outputArray = dictionary.getAnagrams("table", "n");
        System.out.println("Anagrams: " +java.util.Arrays.asList(outputArray));

        //BestPos
        output = dictionary.getBestPos("table");
        System.out.println("BestPos: " +output);

        //CommonParent
        outputID = dictionary.getCommonParent(666, 88);
        System.out.println("CommonParent: " +output);

        //Contains
        outputArray = ((RiWordNet) dictionary).getContains("table", "n");
        System.out.println("Contains: " +java.util.Arrays.asList(outputArray));

        //EndsWith
        outputArray = dictionary.getEndsWith("table", "n");
        System.out.println("EndsWith: " +java.util.Arrays.asList(outputArray));

        //HypernymTree
        outputArray = dictionary.getHypernymTree(444);
        System.out.println("HypernymTree: " +java.util.Arrays.asList(outputArray));

        //HyponymTree
        outputArray = dictionary.getHyponymTree(444);
        System.out.println("HyponymTree: " +java.util.Arrays.asList(outputArray));

        //Pos
        outputArray = dictionary.getPos("table");
        System.out.println("Pos: " +java.util.Arrays.asList(outputArray));

        //RandomExample/s
        output = dictionary.getRandomExample("table", "n");
        System.out.println("RandomExample: " + output);

        //RandomExamples
        outputArray = dictionary.getRandomExamples("n", 15);
        System.out.println("RandomExamples: " +java.util.Arrays.asList(outputArray));

        //RandomWord //getRandomWord(pos (, stemsOnly, maxChars));
        output = dictionary.getRandomWord("table", true, 15);
        System.out.println("RandomWord: " +output);

        //RandomWords
        outputArray = dictionary.getRandomWords("n", 15);
        System.out.println("RandomWords: " +java.util.Arrays.asList(outputArray));

        //RegexMatch //getRegexMatch(pattern, pos (, maxResults));
        outputArray = dictionary.getRegexMatch("table*", "n");
        System.out.println("RegexMatch: " +java.util.Arrays.asList(outputArray));

        //Similar
        outputArray = dictionary.getSimilar("table", "n");
        System.out.println("Similar: " +java.util.Arrays.asList(outputArray));

        //SoundsLike
        outputArray = dictionary.getSoundsLike("table", "n");
        System.out.println("SoundsLike: " +java.util.Arrays.asList(outputArray));

        //StartsWith
        outputArray = dictionary.getStartsWith("table", "n");
        System.out.println("StartsWith: " +java.util.Arrays.asList(outputArray));

        //WildcardMatch
        outputArray = dictionary.getWildcardMatch("*a?le", "n");
        System.out.println("WildcardMatch: " +java.util.Arrays.asList(outputArray));

        //booleans

        //isAdjective
        isIt = dictionary.isAdjective("table");
        System.out.println("isAdjective: " + isIt);

        //isAdverb
        isIt = dictionary.isAdverb("table");
        System.out.println("isAdverb: " + isIt);

        //isNoun
        isIt = dictionary.isNoun("table");
        System.out.println("isNoun: " + isIt);

        //isStem
        isIt = dictionary.isStem("table", "n");
        System.out.println("isStem: " + isIt);

        //isVerb
        isIt = dictionary.isVerb("table");
        System.out.println("isVerb: " + isIt);

        //exists
        isIt = dictionary.exists("table");
        System.out.println("exists: " + isIt);

        //isIgnoringCompoundWords not working
//    	isIt = dictionary.isIgnoringCompoundWords();
//    	System.out.println("isIgnoringCompoundWords: " + isIt);

        //isIgnoringUpperCaseWords not working
//    	isIt = dictionary.isIgnoringUpperCaseWords();
//    	System.out.println("isIgnoringUpperCaseWords: " + isIt);


        //other/flags
//    	ignoreCompoundWords(ignoreCompoundWords);
//    	ignoreUpperCaseWords(ignoreUpperCaseWords);

        outputArray = RiTa.getPosTags("I am hungry"); //Query for PennTags
        System.out.println("PennTags: " +java.util.Arrays.asList(outputArray));

    }

}