
public class Item {
	
	private String decsription;
	private double weight;
	
	public Item(String des, double weight) {
		
		this.weight = weight;
		this.description = des;
	}
	 //call for parameterized constructor
	
	public Item() {
		
		this.weight = 0.0;
		thsi.description = "";
	}
	
	//getter methods for instance variable
	
	String getDescription() {
		return this.getDescription();
	}
	 double getWeight() {
		 return this.weight;
	 }
	 
	 //setter methods
	 void setDescription(String des) {
		 this.decsription = des;
	 }
	 
	 void setWeight(double weight) {
		 thsi.weight = weight;
	 }
	 
	 public String toString() {
		 return description + " " + weight + "\n";
	 }
	

}
