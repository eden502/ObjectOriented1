package id_205518178_id_308065176;

import java.awt.List;
import java.util.ArrayList;
import java.util.Vector;

public class Generics {

	public static <T> void main(String[] args) {
		
		Integer [] i = {1,2,3,4};
		Character [] c = {'a','b','c','d'};
		
		printMe(i);
		printMe(c);
		
	Vector <Integer> k = new Vector<Integer>();
	//k.add(5, null);
	Integer s = 5;
	k.add(s);
	k.add(s);
	System.out.println(k);
	//private Vector<Citizen> allCitizens = new Vector<Citizen>();
	}
	public static <T> void printMe(T[] a) {
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
		System.out.println();
		
	}

}
