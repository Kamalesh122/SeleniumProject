package com.MySeleniumProject.CoreJava;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.testng.annotations.Test;

public class hashMapexample {

	@Test
	public void main() { // TODO Auto-generated method stub

		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(0, "hello");
		hm.put(1, "Gudbye");
		hm.put(42, "morning");
		hm.put(3, "evening");
		System.out.println(hm.get(42));
		hm.remove(42);
		System.out.println(hm.get(42));
		Set sn = hm.entrySet();
		Iterator it = sn.iterator(); // hashtable -pass table set collections

		while (it.hasNext()) {
			// System.out.println(it.next());
			Map.Entry mp = (Map.Entry) it.next();//
			// System.out.println(mp.getKey());
			System.out.println(mp.getValue());
		}

	}

	@Test
	public void occurancesOfCharacter() {

		String str = "My name is Kamales";

		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		char arr[] = str.toCharArray();

		for (char c : arr) {
			if (c != ' ') {
				if (hm.containsKey(c))
					hm.put(c, hm.get(c) + 1);
				else
					hm.put(c, 1);
			}
		}
		System.out.println(hm);

		for (Map.Entry entry : hm.entrySet())
			System.out.println("The Occurences of character: " + entry.getKey() + "=" + entry.getValue());
	}

	@Test
	public void primeNumberOrNot() {

		int num = 50;
		
		for (int i = 2; i <= num; i++) {
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					break;
				} else {
					System.out.print(i + " ");
					break;
				}
			}
		}

	}
}
