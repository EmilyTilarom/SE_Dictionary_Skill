import java.util.Scanner;
import rita.*;

public class Prototyp {

    private static RiWordNet dictionary;

    private String input;

    private String wishedWord;
    private String wishedFunction;

    private String[] outputArray;
    private String output;

    private int indexOfCurrentOutput = 0;
    private static int indexOfCurrentPos = 0;

    private int synonymSetter = 3;

    Prototyp() {
        dictionary = new RiWordNet("dict/");
    }

    public void dialogue(){

        System.out.println("Hey, I am ready to go :) (type exit to quit)");

        while(true) {

            System.out.println("Ask me a question ...");

            Scanner s = new Scanner(System.in);
            input = s.nextLine();

            if(input.contains("exit")) {
                System.out.println("Until next time ;)");
                break;
            }

            evaluateInput();

            if((wishedFunction == "unknown") || (wishedWord == "error")) {
                System.out.println("I did not understand you.");
                continue;
            }
            evaluateWishedWord();
        }

    }

    /*
    Evaluates what function should be called for
     */
    private void evaluateInput() {

        if(input.contains("definition") || input.contains("meaning") || input.contains("is") ) {

            int positionOfwishedFunction = 0;

            wishedFunction = "definition";

            if(input.contains("definition of"))
            {
                positionOfwishedFunction = input.indexOf("definition of");
                wishedWord = input.substring(positionOfwishedFunction+("definition of".length()+1));
            }
            else if(input.contains("meaning of"))
            {
                positionOfwishedFunction = input.indexOf("meaning of");
                wishedWord = input.substring(positionOfwishedFunction+("meaning of".length()+1));
            }
            else if(input.contains("is"))
            {
                positionOfwishedFunction = input.indexOf("is");
                wishedWord = input.substring(positionOfwishedFunction+("is".length()+1));
            }
            else {
                wishedWord = "I couldnt understand your wished word.";
            }
        }
        else if(input.contains("synonym") || input.contains("similar")) {

            int positionOfwishedFunction = 0;

            wishedFunction = "synonym";

            if (input.contains("synonym")) {
                positionOfwishedFunction = input.indexOf("synonym of");
                wishedWord = input.substring(positionOfwishedFunction + ("synonym of".length() + 1));
            } else if (input.contains("similar")) {
                positionOfwishedFunction = input.indexOf("similar to");
                wishedWord = input.substring(positionOfwishedFunction + ("similar to".length() + 1));
            } else {
                wishedWord = "I couldnt understand your wished word.";
            }
        }
        else if(input.contains("example")) {

            int positionOfwishedFunction = 0;

            wishedFunction = "example";

            if (input.contains("example to")) {
                positionOfwishedFunction = input.indexOf("example to");
                wishedWord = input.substring(positionOfwishedFunction + ("example to".length() + 1));
            } else if (input.contains("example of")) {
                positionOfwishedFunction = input.indexOf("example of");
                wishedWord = input.substring(positionOfwishedFunction + ("example of".length() + 1));
            } else {
                wishedWord = "I couldnt understand your wished word.";
            }
        }
        else{
            wishedFunction = "unknown";
            wishedWord = "error";
        }
    }

    /*
    Looks for wishes word in Database
     */
    private void evaluateWishedWord() {

        if(dictionary.exists(wishedWord)) {

            String pos;

            switch(wishedFunction) {

                case "definition":

                    pos = getPartsOfSpeech(wishedWord);

                    if(pos != "nonono") {

                        outputArray = dictionary.getAllGlosses(wishedWord, pos);
                        try {
                            output = outputArray[indexOfCurrentOutput];
                        }
                        catch(ArrayIndexOutOfBoundsException oub) {
                            output = "Sorry, there are no matches with your search";
                        }

                        if(wishedWord.contains("love")) {
                            output = "Baby don’t hurt me";
                        }
                    }
                    else {
                        output = "pos is nonono";
                    }

                    break;
                case "synonym":

                    pos = getPartsOfSpeech(wishedWord);

                    if(pos != "nonono") {

                        outputArray = dictionary.getAllSynonyms(wishedWord, pos);
                        try {
                            output = outputArray[indexOfCurrentOutput];
                        }
                        catch(ArrayIndexOutOfBoundsException oub) {
                            output = "Sorry, there are no matches with your search";
                        }

                        for(int i=0; i<synonymSetter; i++ ) {
                            System.out.println(outputArray[i]);
                        }
                    }
                    else {
                        output = "pos is nonono";
                    }

                    break;
                case "example":

                    pos = getPartsOfSpeech(wishedWord);

                    if(pos != "nonono") {

                        outputArray = dictionary.getExamples(wishedWord, pos);
                        try {
                            output = outputArray[indexOfCurrentOutput];
                        }
                        catch(ArrayIndexOutOfBoundsException oub) {
                            output = "Sorry, there are no matches with your search";
                        }
                    }
                    else {
                        output = "pos is nonono";
                    }

                    break;
                default:
                    output = "Sorry, this function is not available";
                    break;
            }
        }
        else {
            output = "Word does not exist in database";
        }

        if(wishedFunction != "synonym") {
            System.out.println("Your answer is: " + output);
        }
    }

    private String getPartsOfSpeech(String word) {
        if(dictionary.exists(word)) {
            String pos;
            String[] posArr;
            posArr = dictionary.getPos(word);
            pos = posArr[indexOfCurrentPos];
            return pos;
        }
        else{
            System.out.println("Word does not exist in database: " + word);
            return "nonono";
        }
    }

    private void resetAll() {
        indexOfCurrentPos = 0;
    }

}
