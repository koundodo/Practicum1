
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tom Wulf Tom.Wulf@uc.edu
 */
public class SafeInput 
{
   /**
    * Get a String which contains at least one character
    * @param pipe a Scanner opened to read from System.in
    * @param prompt prompt for the user
    * @return a String response that is not zero length
    */ 
   public static String getNonZeroLenString(Scanner pipe, String prompt)
   {
       String retString;
       do
       {
           System.out.print("\n" + prompt + ": ");
           retString = pipe.nextLine();
       }while(retString.length() == 0); // until we have some characters
       
       return retString;
       
   }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
       int retVal = 0;
       String trash = "";
       boolean done = false;
       
       do
       {
           System.out.print("\n" + prompt + "[" + low + "-" + high + "]: ");
           if(pipe.hasNextInt())
           {
               retVal = pipe.nextInt();
               pipe.nextLine();
               if(retVal >= low && retVal <= high)
               {
                  done = true;
               }
               else
               {
                   System.out.println("\nNumber is out of range [" + low + "-" + high + "]: " + retVal);
               }
           }
           else
           {
               trash = pipe.nextLine();
               System.out.println("You must enter an int: " + trash);
           }
       }while(!done);
       
       return retVal;
    }


    public static int getInt(Scanner pipe, String prompt)
    {
       int retVal = 0;
       String trash = "";
       boolean done = false;
       
       do
       {
           System.out.print("\n" + prompt + ": ");
           if(pipe.hasNextInt())
           {
               retVal = pipe.nextInt();
               pipe.nextLine();
               done = true;               
           }
           else
           {
               trash = pipe.nextLine();
               System.out.println("You must enter an int: " + trash);
           }
       }while(!done);
       
       return retVal;
    }

    

    public static double getRangedDouble(Scanner pipe, String prompt, int low, int high)
    {
       double retVal = 0;
       String trash = "";
       boolean done = false;
       
       do
       {
           System.out.print("\n" + prompt + "[" + low + "-" + high + "]: ");
           if(pipe.hasNextDouble())
           {
               retVal = pipe.nextDouble();
               pipe.nextLine();
               if(retVal >= low && retVal <= high)
               {
                  done = true;
               }
               else
               {
                   System.out.println("\nNumber is out of range [" + low + "-" + high + "]: " + retVal);
               }
           }
           else
           {
               trash = pipe.nextLine();
               System.out.println("You must enter a double: " + trash);
           }
       }while(!done);
       
       return retVal;
    } 
    

    public static double getDouble(Scanner pipe, String prompt)
    {
       double retVal = 0;
       String trash = "";
       boolean done = false;
       
       do
       {
           System.out.print("\n" + prompt + ": ");
           if(pipe.hasNextDouble())
           {
               retVal = pipe.nextDouble();
               pipe.nextLine();
               done = true;
           }
           else
           {
               trash = pipe.nextLine();
               System.out.println("You must enter a double: " + trash);
           }
       }while(!done);
       
       return retVal;
    }     
    

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        boolean retVal = true;
        String response = "";
        boolean gotAVal = false;
        
        do
        {
            System.out.print("\n" + prompt + " [Y/N] ");
            response = pipe.nextLine();
            if(response.equalsIgnoreCase("Y"))
            {
                gotAVal = true;
                retVal = true;
            }
            else if(response.equalsIgnoreCase("N"))
            {
                gotAVal = true;
                retVal = false;
            }
            else
            {
                System.out.println("You must answer [Y/N]! " + response );
            }
            
        }while(!gotAVal);
        
        return retVal;
    }

    
    public static String getRegExString(Scanner pipe, String prompt, String regExPattern)
    {
        String response = "";
        boolean gotAVal = false;
        
        do
        {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine();
            if(response.matches(regExPattern))
            {
                gotAVal = true;                
            }
            else
            {
                System.out.println("\n" + response + " must match the pattern " + regExPattern);
                System.out.println("Try again!");
            } 
            
        }while(!gotAVal);
        
        return response;
    }
}
