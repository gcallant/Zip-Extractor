package com.grantcallant.utilities;

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
   
   public static File openFile(String fileName)
      {
                  
         Boolean choice = true; 
         File fille = null;
         Scanner fin = null;
         Scanner kbInput = new Scanner(System.in);
         
         //Opens the file if it exists
         try
            {                         
               fille = new File(fileName);
               fin = new Scanner(fille);
            }
            
         catch(FileNotFoundException fnf)
            {
               //Clear buffer
               //fin.next();
               
               //If file doesn't exist, then asks if user wants to input
               //One again- if the user decides no- program throws exception and exists.
               while(choice)
                  {
                     try
                        {
                           System.out.println("Sorry, the file was not found "+
                              "\nWould you like to try again? (yes/no)");
                           
                           String decide = "";
                           decide = kbInput.nextLine();
                           
                           if(decide.equalsIgnoreCase("yes"))
                              {
                                 System.out.println("Enter filename: ");
                                 fileName = kbInput.nextLine();            
                                 fille = new File(fileName);
                                 if(fille.exists())
                                    {
                                       choice = false;
                                    }
                                 fin = new Scanner(fille);
                              }
                              
                          else if (decide.equalsIgnoreCase("no"))
                              {
                                 choice = false;
                              }
                          else
                              {
                                 System.out.println("Sorry, didn't understand that.");
                              }   
                        }
                     
                     catch(Exception fnf2)
                        {
                           //We're going to loop through again.
                        }
                  }
                  
            }
         
         return fille; 
      } 
      
 public static int countFileLines (Scanner fin)
   {
      int count = 0;
      while(fin.hasNext())
         {
            count++;
            fin.nextLine();   
         }
         
       fin.close();
       
     return count;
   }
   
 public static Date [] getDatesFromFile (int count, Scanner fin)
   {
      String [] temp = new String [count];
      String [] dates = new String [count];
      Date [] dateArray = new Date [count]; 
      //Has to be big enough for each int to have its own index
      
      //Resets the cursor to the top line
      count = 0;
      while(fin.hasNextLine())
         {
            temp[count] = fin.nextLine();
            count++;
         }
       
      fin.close();
      
      
      //Creates a String array composed of seperate date strings
      //Per Index
      for(int i = 0; i < dateArray.length; i++)
         {
            String str = temp[i];
            dates = str.split("/");
            dateArray[i] = new Date(Integer.parseInt(dates[0]), Integer.parseInt
            (dates[1]), Integer.parseInt(dates[2]));
         }
      
      
      return dateArray;
   }
   
 public static void writeToFile (Date [] array, String fileName) throws Exception
   {
      File fn = new File(fileName);
      
      PrintWriter fout = new PrintWriter(fn);
      
      for(int i = 0; i < array.length; i++)
         {
            
         }
      
      
   }
}