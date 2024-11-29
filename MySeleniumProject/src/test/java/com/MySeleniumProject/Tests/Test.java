package com.MySeleniumProject.Tests;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {

	public static void main(String[] args) {

		int a[] = { 1, 2, 3, 4, 5, 2, 1, 7, 8 };

//		Set<Integer> set = new HashSet<>();
//		
//		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//		
//		for (int num : a) {
//			set.add(num);
//		}
//
//		System.out.println("Unique Elements: " + set);
		
		
		for(int i=0;i<a.length;i++) {
			
			int k =0;
			for(int j=i+1;j<a.length;j++) {

				if(a[i]==a[j]) {
					System.out.println(a[i]);
					break;
				}
				
			}
			
		}
		
	}
}
