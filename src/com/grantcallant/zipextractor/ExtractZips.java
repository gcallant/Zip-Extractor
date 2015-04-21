package com.grantcallant.zipextractor;

import com.grantcallant.utilities.Keyboard;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Grant Callant on 1/22/2015.
 * @author Grant Callant
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
public class ExtractZips
	{
		public static void main(String [] args)
			{
				String destination = null;
				String pathName = null;
				Scanner kb = new Scanner(System.in);

				System.out.println("Please enter the directory name that " +
						                   "your zip files are located in:\n");
				pathName = Keyboard.readStringFromUser(kb);



				File file = new File(pathName);
				ArrayList<File> list = new ArrayList<File>(3);

				while(!file.exists())
					{
						System.out.println("That directory doesn't exist, try again.");
						pathName = Keyboard.readStringFromUser(kb);
						file = new File(pathName);
					}

				System.out.println("Enter the destination directory.");
				destination = Keyboard.readStringFromUser(kb);



				String [] src = null;//getAllFiles(file, list);


				for(int i = 0; i < src.length; i++)
					{
						String source = null;
						source = src[i];





						//String password = "password";
				for(int x = i; x <= i; x++)
					{
						try
							{
								ZipFile zipFile = new ZipFile(source);
								if(zipFile.isEncrypted())
									{
										//zipFile.setPassword(password);
									}
								zipFile.extractAll(destination);
							} catch(ZipException e)
							{
								e.printStackTrace();
							}

					}
				}






			}
	}
