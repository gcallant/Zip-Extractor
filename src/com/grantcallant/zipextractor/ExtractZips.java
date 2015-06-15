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
 *
 * This program makes substantial use of the Zip4j Open Source Library
 * @see "http://www.lingala.net/zip4j/about.php"
 * All references to Zip4j remain the property of Srikanth Reddy Lingala.

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
				//TODO: Refactor all calls from new classes










						//String password = "password";
				for(int x = 0; x <= 0; x++)
					{
						try
							{
								ZipFile zipFile = new ZipFile("File Source");
								if(zipFile.isEncrypted())
									{
										//zipFile.setPassword(password);
									}
								zipFile.extractAll("Destination path");
							} catch(ZipException e)
							{
								e.printStackTrace();
							}

					}







			}
	}
