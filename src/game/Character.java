package game;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.util.Random;



public class Character {
	 
	public String name = " " ;
	public final String item_MATCH = "match";
	public final String item_FLASHLIGHT = "flashlight";
	public final String item_KEY = "key";
	public final String item_LETTER = "letter";
	public final String item_MEDICINE = "medicine";
	
	 
	 
public String setName (){
		String actor = "";
		Random randomActor = new Random();
		int randomInt = randomActor.nextInt(4);
		
		switch (randomInt)
		{
			case 1:
				actor = "Joe";
				break;
			case 2:
				actor = "Bob";
				break;
			case 3:
				actor = "Kenny";
				break;
			case 4:
				actor = "Billy Joe Bob";
				break;
			default:
				actor = "Casper";
				break;
		}
		
		return actor;
	}
	
public String getName (String actor) {
		
		String name = actor;
				
		return name;
	}	
	
public String[] characterCreator() {
	//String actorName = getName(name);
	String[] createdCharacter = new String[2];
	createdCharacter[0] = getName(name);
	createdCharacter[1] = getName(name);
	createdCharacter[2] = getName(name);
	return createdCharacter;
}

public void showCharacter ()
{
	 
	TextField commandInput; 
	TextArea displayOutput;
	Button buttonInput;
	
	// Define colors
	
	Panel CharacterPanel = new Panel();
	CharacterPanel.setSize(80, 480);
	CharacterPanel.setBackground(Color.white); 
	CharacterPanel.setForeground(Color.black); 
	
	// Use a border layout 
	BorderLayout b = new BorderLayout(); 
	CharacterPanel.setLayout (b); 
	CharacterPanel.add(CharacterPanel); 
			
	// Define UI items 
	commandInput = new TextField(20); 
	displayOutput = new TextArea( 10, 60); 
	
	// 10 rows x 60 chars 
	buttonInput = new Button("Go"); 
	Panel inputPanel = new Panel(); 
	
	// Add components to our layout / panels 
	inputPanel.add(commandInput); 
	inputPanel.add(buttonInput); 
	CharacterPanel.add("North", displayOutput); 
	CharacterPanel.add("South", inputPanel); 
}
}

