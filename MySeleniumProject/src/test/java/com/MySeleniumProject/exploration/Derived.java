package com.MySeleniumProject.exploration;

public class Derived extends Base {

	private int data;

	public Derived()

	{

		data = 6;
	}

	public  int getData()

	{
		return data;
	}

	public static void main(String[] args)

	{

		Base myData = new Derived();
		System.out.println(myData.getData());
	}

}
