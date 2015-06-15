package com.grantcallant.utilities;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

/*
*@author Grant Callant
*My FileUtil Class to open and read
*as well as open and write files, user specified, and
*string literal file names.
*  * Copyright 2015 Grant Callant

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

public class FileUtil
{



   //Prevents Instantiating a new object from this class
   private FileUtil(){}


   private static String getFileName (Scanner kb)
       {
           if(kb == null)
               {
                   kb = new Scanner(System.in);
               }
           String fileName = "";

           System.out.println("Please enter the file pathname: ");
           fileName = Keyboard.readStringFromUser(kb);
           return fileName;
       }

    /**
     * Opens a Java swing awt GUI to select a directory
     * Allows JFileChooser to select directories, instead of only files.
     * @see "https://docs.oracle.com/javase/tutorial/uiswing/components/filechooser.html"
     * @return opened file for reading
     */
   public static File openFolderWithGUI()
       {
           final JFileChooser fileChooser = new JFileChooser();
           fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
           fileChooser.setDialogTitle("Select Source Directory");
           int returnVal = fileChooser.showOpenDialog(new Component() {});

           File myFile = fileChooser.getSelectedFile();
           return myFile;
       }

    /**
     * Opens a file for reading from a fileName.
     * @param fileName
     * @return the opened file for reading
     * @throws FileNotFoundException
     */
   public static File openFile(String fileName) throws FileNotFoundException
      {
         Scanner kbInput = new Scanner(System.in);
         File inputFile = null;
         char decide;

         while(fileName.isEmpty() || fileName == null)
             {
                System.out.println("Sorry, no file path was entered " +
                "Would you like to enter a new file path? \nEnter (y/n)");

                 decide = Keyboard.readCharacterFromUser(kbInput);

                 if(decide == 'y')
                     {
                         fileName = getFileName(kbInput);
                     }
                 else if (decide == 'n')
                     {
                         throw new FileNotFoundException("Could not find file: " +
                                               "User Declined to input new path.");
                     }
                 else
                     {
                         System.out.println("Sorry, didn't understand that.");
                     }
             }
         
                //Opens the file if it exists

               inputFile = new File(fileName);
            

               //If file doesn't exist, then asks if user wants to input
               //Once again- if the user decides no- program throws exception.
               while(!inputFile.exists())
                  {
                      System.out.println("Sorry, the file was not found "+
                                 "\nWould you like to try again? \nEnter (y/n)");

                           decide = Keyboard.readCharacterFromUser(kbInput);
                           
                           if(decide == 'y')
                              {
                                 System.out.println("Enter file path: ");
                                 fileName = Keyboard.readStringFromUser(kbInput);
                                 inputFile = new File(fileName);
                              }
                              
                          else if (decide == 'n')
                              {
                                 throw new FileNotFoundException("Could not find file: " +
                                 "User Declined to input new path.");
                              }
                          else
                              {
                                 System.out.println("Sorry, didn't understand that.");
                              }   
                  }
         return inputFile;
      }


    /**
     * Counts the number of lines that are in an input file.
     * @param fin
     * @return the number of lines in the file
     */
 public static int countFileLines (Scanner fin)
   {
      int count = 0;
      while(fin.hasNext())
         {
            count++;
            fin.nextLine();   
         }
     return count;
   }

    /**
     * Recursively counts the number of files that are contained in a folder
     * and all subfolders. If the input file is null, calls openFile to get a new file path.
      * @param inputFile
     * @return the number of files contained in the specified pathname, including all
     * @return subfolders. If the specified path is a file, returns one.
     * @throws FileNotFoundException
     */
 public static int countFilesInFolder (File inputFile) throws FileNotFoundException
     {
         if(inputFile == null)
             {
                 inputFile = openFile(null);
             }

         if(inputFile.isFile())
             {
                 return 1;
             }
         else if(inputFile.isDirectory())
             {

             }
         return 0;
     }

}