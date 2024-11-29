package om.MySeleniumProject.CodingChallange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Challange1 {

	public int findMaxK() {
		int nums[] = { -1, 10, 6, 7, -7, 1 };
		Arrays.sort(nums);
		int j = nums.length - 1, i = 0;
		while (i < j) {
			int a = -1 * nums[j];
			if (nums[i] == a)
				return nums[j];
			else if (nums[i] < a)
				i++;
			else
				j--;
		}
		return -1;
	}

	@Test
	public void test1() {

		List<Integer> a = new ArrayList<Integer>();
		a.add(6);
		a.add(8);
		a.add(12);
		List<Integer> b = new ArrayList<Integer>();
		b.add(7);
		b.add(9);
		b.add(15);
		List<Integer> resultArray = new ArrayList<Integer>();
		int aliceSum = 0;
		int bobSum = 0;

		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) > b.get(i)) {
				aliceSum++;
			}
			if (b.get(i) > a.get(i)) {
				bobSum++;
			}
			if (a.get(i) == b.get(i)) {

			}
		}

		resultArray.add(aliceSum);
		resultArray.add(bobSum);

		Collections.sort(resultArray, Collections.reverseOrder());
		System.out.println(resultArray);

	}

	@Test
	public void test2() {

		int a[] = { 1, 2, 3, 4 };
		int b[] = new int[a.length];
		int c[] = a.clone();

		b = a;

		b[0]++;

		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();

		for (int i = 0; i < a.length; i++)
			System.out.print(b[i] + " ");
		System.out.println();
		

		for (int i = 0; i < a.length; i++)
			System.out.print(c[i] + " ");
		
		if(a.equals(b))
			System.out.println("Arrays are equals");

	}
	@Test
	public void test3() {
		int A[][]= {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int B[][] = {{1,1,1,1}, {1,1,1,1}, {1,1,1,1}};
		int c[][] = new int [A.length][A[0].length];
		
		
		for(int i=0;i<A.length;i++) {
			for(int j=0; j<A[i].length;j++) {
				c[i][j] = A[i][j]+ B[i][j];
			}
		}
		
		
		for(int i=0;i<c.length;i++) {
			for(int j=0;j<c[i].length;j++) {
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
		
		
		System.out.println(A.length + " "+ A[0].length);
	}
	

}
