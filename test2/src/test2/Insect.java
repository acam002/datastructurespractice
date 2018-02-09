package test2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Insect{
	
	private int numLegs;
	
	public void setNumLegs(int num) {
		numLegs = num;
	}
	
	public int getNumLegs() {
		return numLegs;
	}
	
	
	public void fly() {
		System.out.println("buzz buzz");
	}
	
	public void bite() {
		System.out.println("Ouch!!");
	}
	
	public static void main(String[] args) {
		/*
		Double[] num = new Double[20];
		for (int i = 0; i < 20; i++) {
			System.out.println(num[i]);
		}
		*/
		
		// fly() will be called from Wasp class and not insect class in this type of instantiation
		// A wasp is an insect in this direction <--------------
		//Insect wasp = new Wasp();
		//wasp.setNumLegs(6);
		//System.out.println(wasp.getNumLegs());
		//wasp.fly();
		
		// This method call will error if the type of the reference is Insect and not Wasp
		//wasp.sting();
		
		// This results in an error, an insect is not a wasp
		//Wasp wasp2 = new Insect();
		
		// There is another level of inheritance here and it still works, same with wasp on the left
		//Insect wasp3 = new QueenWasp();
		//wasp3.fly();
		
		
		//Ant ant = new Ant();
		
		Queen wasp = new Wasp();
		
		//wasp.sting();
	
		
		
		
		
		
	}
}
