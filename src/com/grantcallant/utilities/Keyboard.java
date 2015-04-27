package com.grantcallant.utilities;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by Grant Callant on 4/19/2015.
 *
 * @author Grant Callant
 * List of static utilities to read imput from user.
 *
 * Copyright 2015 Grant Callant

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
public class Keyboard
	{
		public static String readStringFromUser (Scanner keyboard)
			{
				if(keyboard == null)
					{
						keyboard = new Scanner(System.in);
					}
				String inputString = new String();

				try
					{
						inputString = keyboard.nextLine();
						
						while(inputString.isEmpty())
							{
								System.out.println("Error: you didn't type anything. " +
								"\nPlease try again:\n");
								inputString = keyboard.nextLine();
							}
					}
					catch(NoSuchElementException nsee)
						{
							nsee.printStackTrace();
							System.out.println("Attempting to catch using next...");
							inputString = keyboard.next();
						}
						
				return inputString;
			}

		public static int readIntFromUser (Scanner keyboard)
			{
				if(keyboard == null)
					{
						keyboard = new Scanner(System.in);
					}
				
				int inputInt = 0;
				boolean checkInput = true; //If valid input is received, changes to false to break loop.

				do
					{
						try
							{
								inputInt = keyboard.nextInt();
								checkInput = false;
							}
						catch(InputMismatchException ime)
							{
								keyboard.next(); //clears line buffer
								System.out.println("Error: please input a valid integer " +
								"between " + Integer.MIN_VALUE + " & " +Integer.MAX_VALUE);
							}
					}while(checkInput);

				return inputInt;
			}

		//Guarantees a positive integer is returned; considers 0 to be positive
		public static int readPositiveIntFromUser (Scanner keyboard)
			{
				if(keyboard == null)
					{
						keyboard = new Scanner(System.in);
					}

				int inputInt = -1;

				while (inputInt < 0)
					{
						try
							{
								inputInt = keyboard.nextInt();
								if(inputInt < 0)
									System.out.println("Please input a positive integer " +
									"greater than or equal to zero.");
							}
						catch(InputMismatchException ime)
							{
								keyboard.next(); //clears line buffer
								System.out.println("Error: please input a valid integer " +
								"between 0 & " +Integer.MAX_VALUE);
							}
					}

				return inputInt;
			}

		//Guarantees a negative integer is returned; considers 0 to be positive
		public static int readNegativeIntFromUser (Scanner keyboard)
			{
				if(keyboard == null)
					{
						keyboard = new Scanner(System.in);
					}

				int inputInt = 1;

				while(inputInt >= 0)
					{
						try
							{
								inputInt = keyboard.nextInt();
								if(inputInt >= 0)
									System.out.println("Please input a negative integer " +
											                   "less than zero.");
							} catch(InputMismatchException ime)
							{
								keyboard.next(); //clears line buffer
								System.out.println("Error: please input an integer.");
							}
					}

				return inputInt;
			}

		public static long readLongFromUser (Scanner keyboard)
			{
				if(keyboard == null)
					{
						keyboard = new Scanner(System.in);
					}

				long inputLong = 0;
				boolean checkInput = true; //If valid input is received, changes to false to break loop.

				do
					{
						try
							{
								inputLong = keyboard.nextLong();
								checkInput = false;
							}
						catch(InputMismatchException ime)
							{
								keyboard.next(); //clears line buffer
								System.out.println("Error: please input a valid long " +
										                   "between " + Long.MIN_VALUE + " & " + Long.MAX_VALUE);
							}
					}while(checkInput);

				return inputLong;
			}

		public static float readFloatFromUser (Scanner keyboard)
			{
				if(keyboard == null)
					{
						keyboard = new Scanner(System.in);
					}

				float inputFloat = 0f;
				boolean checkInput = true; //If valid input is received, changes to false to break loop.

				while (checkInput)
					{
						try
							{
								inputFloat = keyboard.nextFloat();
								checkInput = false;
							}
						catch(InputMismatchException ime)
							{
								keyboard.next(); //clears line buffer
								System.out.println("Error: please input a valid floating value.");
							}
					}

				return inputFloat;
			}

		public static double readDoubleFromUser (Scanner keyboard)
			{
				if(keyboard == null)
					{
						keyboard = new Scanner(System.in);
					}

				double inputDouble = 0.0;
				boolean checkInput = true; //If valid input is received, changes to false to break loop.

				while (checkInput)
					{
						try
							{
								inputDouble = keyboard.nextDouble();
								checkInput = false;
							}
						catch(InputMismatchException ime)
							{
								keyboard.next(); //clears line buffer
								System.out.println("Error: please input a valid double value.");
							}
					}

				return inputDouble;
			}

		public static char readCharacterFromUser (Scanner keyboard)
			{
				if(keyboard == null)
					{
						keyboard = new Scanner(System.in);
					}

				char inputChar = '0';
				boolean checkInput = true; //If valid input is received, changes to false to break loop.

				while (checkInput)
					{
						try
							{
								inputChar = keyboard.next().charAt(0);
								checkInput = false;
							}
						catch(InputMismatchException ime)
							{
								keyboard.next(); //clears line buffer
								System.out.println("Error: please input a valid char value.");
							}
					}

				return inputChar;
			}

	}
