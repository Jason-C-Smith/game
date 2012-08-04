package game;

import java.util.*; 
import java.applet.*; 
import java.awt.*; 

// // 
// LocationDemo - Demonstrates the use of location/exit objects // 
// Last modification date : October 08, 1997 // 



public class Game extends Applet { 
	
	Location currentLocation; 
	String command; 
	TextField commandInput; 
	TextArea displayOutput;
	Button buttonInput;
	private String an_exit; 
	
	// Constructor 
	public Game() {
		super(); 
		} 
	
	// Initialization method 
	public void init() { 
		super.init(); 
		
		// Define colors 
		setBackground(Color.white); 
		setForeground(Color.black); 
		Panel appletPanel = new Panel();
		
		// Use a border layout 
		BorderLayout b = new BorderLayout(); 
		appletPanel.setLayout (b); 
		add(appletPanel); 
		
		// Define UI items 
		commandInput = new TextField(20); 
		displayOutput = new TextArea( 10, 60); 
		
		// 10 rows x 60 chars 
		buttonInput = new Button("Go"); 
		Panel inputPanel = new Panel(); 
		
		// Add components to our layout / panels 
		inputPanel.add(commandInput); 
		inputPanel.add(buttonInput); 
		appletPanel.add("North", displayOutput); 
		appletPanel.add("South", inputPanel); 
		
		// Create thr33 locations 
		Location l1 = new Location ("Entrance to hall", "You stand at the entrance of a long hallway. The hallway gets darker\n" +
				"and darker, and you cannot see what lies beyond. To the east\n" +
				"is an old oaken door, unlocked and beckonning"); 
		Location l2 = new Location ("End of hall", "You have reached the end of a long dark hallway. You can\n" +
				"see nowhere to go but back"); 
		Location l3 = new Location ("Small study", "This is a small and cluttered study, containing a desk covered with\n" +
				"papers. Though they no doubt are of some importance,\n" +
				"you cannot read their writing"); 
		
		// Create an exit for l1 
		l1.addExit (new Exit(Exit.NORTH, l2));
		l1.addExit (new Exit(Exit.EAST, l3)); 
		
		// Create an exit for l2 
		l2.addExit (new Exit(Exit.SOUTH, l1)); 
		
		// Create an exit for l3 
		l3.addExit (new Exit(Exit.WEST, l1)); 
		
		// Set up room locations 
		currentLocation = l1; 
		
		// Show first location 
		showLocation(); 
		repaint(); 
		} 
	private void showLocation() { 
		// Clear screen
		displayOutput.setText("");
		
		// Show room title 
		displayOutput.append( "\n" + currentLocation.getTitle() + "\n" ); displayOutput.append( "\n" ); 
		
		// Show room description 
		displayOutput.append( currentLocation.getDescription() + "\n" ); 
		
		displayOutput.append( "\nAvailable exits : \n" ); 
			
			for (Object element : currentLocation.getExits()) { 
				Exit an_exit = (Exit) element; 
				displayOutput.append(an_exit + "\n");
			}
			} 
		 
	
	public boolean action (Event evt, Object focus) { 
		String command; 
		
		// Was a button pressed ? 
		if (evt.target instanceof Button) { 
			
			// Obtain string 
			command = commandInput.getText(); 
			
			// Don't parse blank commands 
			if (command.length() == 0) return true; 
			
			// Convert to upper case for comparison 
			command = command.toUpperCase();
			
			// Search for an exit match 
			for (Object element : currentLocation.getExits()) { 
					Exit an_exit = (Exit) element; 
					if ( (an_exit.getDirectionName().compareTo(command) == 0) || (an_exit.getShortDirectionName().compareTo(command) == 0 ) ) { 
						
						// Set location to the location pointed to by exit 
						currentLocation = an_exit.getLeadsTo();
						
						// Show new location
						showLocation(); 
						
						// Clear text area 
						commandInput.setText (new String()); 
						
						// Event handled 
						return true; }
					} 
			
			// If code reaches here, direction is invalid 
			displayOutput.append("\nHuh? Invalid direction!\n"); 
			
			// Clear text area 
			commandInput.setText (new String()); 
			
			// Event handled
			return true; } 
		
		// Event not handled 
		else return false; 
		}

	// Get/Set for an exit.
	public String getAn_exit() {
		return an_exit;
	}

	public void setAn_exit(String an_exit) {
		this.an_exit = an_exit;
	} 
}
		
	
