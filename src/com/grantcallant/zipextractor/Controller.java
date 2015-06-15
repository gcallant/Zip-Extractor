package com.grantcallant.zipextractor;

import com.grantcallant.utilities.FileUtil;
import com.grantcallant.utilities.Keyboard;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Grant Callant on 6/13/2015. CSCD211-S15 Zip Extractor
 *
 * @author Grant Callant
 */
public class Controller
	{
		public static void start()
			{
				int choice = -1, firstMenuOption = 1, lastMenuOption = 5;
				File myFile;
				String source = "", destination = "", password = "";
				Scanner kb = new Scanner(System.in);

				while (choice != 5)
					{
						Menu.menu(source, destination, password);

						while(choice < 1 || choice > 5)
							{
								choice = Keyboard.readMenuOptionFromUser(kb,
								                                         firstMenuOption, lastMenuOption);

							}

						switch(choice)
							{
								case 1: myFile = FileUtil.openFolderWithGUI();
							}
					}
			}
	}
