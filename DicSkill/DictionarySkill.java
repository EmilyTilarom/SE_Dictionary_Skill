package DicSkill;

import java.util.Scanner;

/**
 * 29.04.2018
 * This class is the one that can be run and will open a dialog with the user
 * say bye to close the dialog
 * @author Lia
 *
 */

public class DictionarySkill {

	
	public static void main(String[] args)
	{
		Context context = new Context();
		Settings settings = new Settings();
		MessageManager tb = new MessageManager();
		DatabaseCommunicator dbC = new DatabaseCommunicator();
		
		String msg = "";
		Scanner read = new Scanner(System.in);
		
		System.out.println("Hello! How may I help you?");
		
		msg = read.nextLine();
		msg.toLowerCase();
		
		while(!msg.equals("bye"))
		{
			System.out.println( tb.decodeMsg(msg, settings, dbC, context) );
			msg = read.nextLine();
			msg.toLowerCase();
		}
		
		System.out.println("Goodbye");
	}
	
}
