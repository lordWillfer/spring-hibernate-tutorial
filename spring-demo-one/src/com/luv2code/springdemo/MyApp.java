package com.luv2code.springdemo;

public class MyApp {

	public static void main(String[] args) {
		// Create the object
		Coach theCouch = new TrackCoach();
		
		// Use the object
		System.out.println(theCouch.getDailyWorkout());
	}
}