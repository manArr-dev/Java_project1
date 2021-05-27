import java.util.Stack;

public class Player {
	
	private Parser parser;
	private Room currentRoom;
	private Stack<Room> route;
	
	// Initializing the game internal map
	
	public Player() {
		
		createRooms();
		parser = new Parser();
		route = new Stack<Room>();
	}
	
	//Room creation and link to their exits
	
	private void createRooms() {
		
		Room parking, garage, dinningroom, kitchen, office;
		
		//Room initialization
		
		parking = new Room(" outside the main entrance of the compound");
		garage = new Room(" next big door where to stack dungeon ");
		dinningroom = new (" Big room that constits of big table and contemporary heigth chairs");
		Kitchen = new Room ("Space with stoves, sinks and cabinets");
		office = new Room(" a vey spacious room where family meeting and gathering for party");
		
		//Adding items to the room
		
		garage.addItem(new Item("books rack", 3.0));
		office.addItem(new Item("Chair", 5.0));
		office.addItem(new Item("Dungeon", 15.0));
		kicthen.addItem(new Item("Mini frigde", 3.0));
		kitchen.addItem(new Item("Apparutus", 3.0));
		
		//Initializing room exits
		
		parking.setExit("east", garage);
		parking.setExit("south", kitchen);
		parking.setExit("west", dinningroom);
		
		garage.setExit("west", parking);
		dinningroom.setExit("east", parking);
		kitchen.setexit("north", office);
		office.setExit("west", kitchen);
		
		//The initiial location of the player
		
		currentRoom = parking;
		
	}
	
	//loops of the game
	
	public void play() {
		
		printWelcome();
		
		boolean finished = false;
		while(!finished) {
			
			Command command = parser.getCommand();
			finished = processCommand(command);
		}
		System.out.println("Thank you for playing. Good bye...");
		
	}
	
	//Printing the opening message
	private void printWelcome() {
		
		System.out.println();
		System.out.println("Welcome to the world of Fun");
		System.out.println("Type 'help' if you need help");
		System.out.println();
		System.out.println(currentRoom.getLongDescription());
	}
	
	private boolean processCommand(Command command) {
		
		boolean toQuit = false;
		if (command.isUnknown()) {
			
			System.out.println("I do not know what you mean by that");
			return false;
		}
		
		String commandWord = coomand.getCommandWord();
		if (commandword.equals("help")) {
			printHelp;
		}
		else if (commandWord.equals("go")) {
			goRoom(command);
		}
		else if (commandWord.equals("quit")) {
			toquit = quit(command);
		}
		else if (commandword.equals("look")) {
			lookRoom(coomand);
		}
		else if (commandword.equals("eat")) {
			goEat(coomand);
			
		}else if (command.equals("back")) {
			backUp(command);
		}
		else if (command.equals("stackback")) {
			stackBack(command);
		}
		return toQuit;	
		
	}
	
	private void printHelp() {
		
		System.out.println("You are lost. You are wanderimg");
		System.out.println("Look around you");
		System.out.println();
		System.out.println(" Type any coomand words");
		
		System.out.println(parser.getCommands());
		
	}
	
	private void goRoom(Command command) {
		
		if (!command.hasSecondWord()) {
			//Must have a second word for better assistance
			
			System.out.println("Go where?");
			return;
		}
		
		String direction = command.getSecondWord();
		
		//Moving to a different room
		Room nextRoom = currentRoom.getExit(direction);
		
		if (nextRoom == null) {
			
			System.out.println("There is no door around you");
		}
		else {
			
			route.push(currentRoom);
			currentroom = nextroom;
			System.out.println(currentRoom.getLongDescription());
		}
	}
	
	//command for eat, look and back
	
	void lookRoom(Command command) {
		if (command.hasSecondWord()) {
			System.out.println("Look what?");
			return;
		}
		System.out.println(currentRoom.getLongDescription());
	}
	
	void goEat(Command command) {
		if (command.hasSecondWord()) {
			System.out.println("Eat what?");
			return;
		}
		
	}
	void backUp(Command command) {
		if (command.hasSecondWord()) {
			System.out.println("Back what?");
			return;
		}
		//Trying to leave the current room
		Room nextRoom = Route.pop();
		
		if (nextRoom == null) {
			
			System.out.println("You cannot go back" + "You are in the beginning of the room");
			
		}else {
			//Stroring the current room
			Room aa = currentRomm;
			
			//Go to the previous room
			currentRoom = nextRoom;
			
			//Storing the previous current room
			route.push(aa);
			System.out.printn(currentRoom.getLongDescription());
		}
	}
	
	//coomand to stackback
	
	void stackBack(Command command) {
		
		if (command.hasSecondWord()) {
			System.out.println("Back what");
			return;
		}
		
		//Trying to leave current room
		Room nextRoom = route.pop();
		
		if (nextRoom == null) {
			
			System.out.println("You cannot go back" + " You are in the beginning of the room");
			
		}else {
			route.push(currenRoom);
			currentRoom = nextRoom;
			System.out.println("You have gone back");
		}
	}
	
	/*if "quit" was entered. check for the rest of
	 * coomand to see whether 
	 * player quit the game
	 * 
	 */
	
	private boolean quit(Command command) {
		
		if (command.hasSecondWord()) {
			System.out.println("Quit what?");
			return false;
		}
		else {
			//Signal that the player is quitting
			return true
			
		}
	}

}
