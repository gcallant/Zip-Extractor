package com.grantcallant.zipextractor;

/**
 * Created by Grant Callant on 6/13/2015. CSCD211-S15 Zip Extractor
 *
 * @author Grant Callant
 */
public class Menu
	{
		public static void menu (String source, String destination, String password)
			{
						printIntro();
						printMenu(source, destination, password);
			}


		private static void printIntro()
			{
				String intro = "";
				intro += "\nHello, welcome to Grant's Zip Extractor.\n" +
						         "This utility will allow you to extract multiple zip\n" +
						         "files (located in the same directory) to any destination\n" +
						         "directory you select.\n\n";

				System.out.print(intro);
			}

		private static void printMenu(String source, String destination, String password)
			{
				String menu = "";

				//Allows menu to first print empty, and then be updated with user input
				if(source == null) {source = "";}
				if(destination == null) {destination = "";}
				if(password == null) {password = "";}

				menu += String.format("\n1. Change source directory\n" +
						  "Current source directory: %s\n\n", source);
				menu += String.format("2. Change destination directory\n" +
					      "Current destination directory: %s\n\n", destination);
				menu += String.format("3. Change password (or password text file)\n" +
						 "Current password or password text file: %s\n\n", password);
				menu += "4. Perform extract with current selected options.\n\n";
				menu += "5. Quit program.\n\n";

				menu += "Enter Selection -----> ";

				System.out.print(menu);
			}
	}
