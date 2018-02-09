package test2;

public class Wasp extends Insect implements Queen {

	
	public void fly() {
		System.out.println("BUZZ" + "\n" +getNumLegs());	
		}
	
	public void sting() {
		System.out.println("OUCH!!!!!!!!");
	}
	
	public void createColony() {
		System.out.println("Go my slaves!");
	}
	
	public void order() {
		System.out.println("Do this...");
	}
}
