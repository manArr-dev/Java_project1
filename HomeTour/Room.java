import java.util.Set;
import java.util.arrayList;

import javax.print.DocFlavor.STRING;

import java.util.HashMap;
import .util.Iterator;

public class Room {
	
	private String description;
	//Storing exits for rooms
	
	private HashMap<STRING, Room>exits;
	private ArrayList<Item>items,
	
	public Room(String description) {
		
		this.description = description;
		exits = new HasMap<String, room>();
		items = news ArrayList<Item>();
		
	}
	
	//Method to add an item to a room
	void addItem(Item item) {
		int index = items.size();
		items.add(index, item);
	}
	
	/*Defining exit from a room
	 * Direction of the exit
	 * neighbor room to which the exit is located
	 */
	
	public void setExit(String direction, Room neighbor) {
		
		exits.put(direction, neighbor);
	}
	
	/*Returning a long description of the room
	 * direction of the exit
	 */
	
	public String getLongDescription() {
		
		String itemDesc = "Items in the room\n";
		for (int i=0; i < items.size(); i++) {
			Item item = items.get(i);
			itemDesc += item;
		}
		
		return "You are" + description + ".\n" + itemDesc + getexitString();
		
	}
	private String getexistString() {
		String returnString = "Exits";
		Set<String> keys = exits.keySet();
		for (String exit: keys) {
			returnString += "" + exit;
		}
		
		return returnString;
	}
	
	public Room getExit(String direction) {
		return exits.get(direction);
	}
}	
