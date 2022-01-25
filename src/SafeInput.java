import java.util.Scanner;

public class SafeInput {
    /**
     * User enters a string that is not zero length
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt){
     String retString = "";
     do {
         System.out.print(prompt + ": ");
         retString = pipe.nextLine();
         if (retString.length() == 0) {
             System.out.println("[Error] Invalid Input.");
         }
     }while(retString.length() == 0);
     return retString;
    }
    /**
     * Get a String which has a minimum length that you set
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is greater than minimum length
     */
    public static String getMinLenString(Scanner pipe, String prompt, int minLen){
        String retString = "";
        do{
            System.out.print("\n" + prompt + "[ >= " + minLen + " chars]: ");
            retString = pipe.nextLine();
            if(retString.length() < minLen)
                System.out.println("Too short! Must be at least " + minLen + " chars long!");
        }while(retString.length() < minLen);
        return retString;
    }
    /**
     * Get a String which has a maximum length that you set
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is less than maximum length
     */
    public static String getMaxLenString(Scanner pipe, String prompt, int maxLen){
        String retString = "";
        do{
            System.out.print("\n" + prompt + "[<= " + maxLen + " chars]: ");
            retString = pipe.nextLine();
            if(retString.length() > maxLen)
                System.out.println("Too long! Maximum character limit " + maxLen + " reached.");
        }while(retString.length() > maxLen);
        return retString;
    }
    public static String titleValidator(Scanner pipe, String prompt){
        boolean done;
        String title = "";
        do{
            System.out.print( prompt + " [ Mr. | Mrs. | Ms. | Dr. | Prof. | Esq. | Hon. ]: ");
            title = pipe.nextLine();
            if(title.equalsIgnoreCase("Mr") || title.equalsIgnoreCase("Mr.") || title.equalsIgnoreCase("Mrs") ||
            title.equalsIgnoreCase("Mrs.") || title.equalsIgnoreCase("Ms") || title.equalsIgnoreCase("Ms.") ||
            title.equalsIgnoreCase("Dr") || title.equalsIgnoreCase("Dr.") ||
            title.equalsIgnoreCase("Prof") || title.equalsIgnoreCase("Prof.") || title.equalsIgnoreCase("Esq") ||
            title.equalsIgnoreCase("Esq.") || title.equalsIgnoreCase("Hon") || title.equalsIgnoreCase("Hon.")){
                done = true;
            }
            else{
                System.out.println("[Error] Invalid Input.");
                done = false;
            }
        }while(!done);
        return title;
    }
     /**
      * Does not accept until user enters an integer value
      * @param pipe a Scanner opened to read from System.in
      * @param prompt prompt for user
      * @return an Integer value 
      */
     public static int getInt(Scanner pipe, String prompt){
         String trash;
         boolean done;
         int result = 0;
         do{
             System.out.print(prompt + ": ");
             if(pipe.hasNextInt()){
                 result = pipe.nextInt();
                 pipe.nextLine();
                 done = true;
             }
             else{
                 done = false;
                 trash = pipe.nextLine();
                 System.out.println("[Error] Please enter an integer: " + trash + " is not valid");
             }
         }while(!done);
         return result;
    }
     /**
      * Does not accept until user enters a double value
      * @param pipe a Scanner opened to read from System.in
      * @param prompt prompt for user
      * @return a Double value
      */
     public static double getDouble(Scanner pipe, String prompt){
         String trash;
         boolean done = false;
         double result = 0;
         do{
             System.out.print(prompt + ": ");
             if(pipe.hasNextDouble()){
                 result = pipe.nextDouble();
                 pipe.nextLine();
                 done = true;
             }
             else{
                 done = false;
                 trash = pipe.nextLine();
                 System.out.println("[Error] Please enter a double: " + trash + " is not valid");
             }
         }while(!done);
         return result;
    }
      /**
      * User enters an integer within a range of values
      * @param pipe a Scanner opened to read from System.in
      * @param prompt prompt for user
      * @param lo Lowest value in range
      * @param hi Highest value in range
      * @return an integer value in given range
      */
     public static int getRangedInt(Scanner pipe, String prompt, int lo, int hi){
        boolean done = false;
        int result = 0;
        String trash;
        do{
            System.out.print(prompt + "[" + lo + "-" + hi + "]: " );
            if(pipe.hasNextInt()){
                result = pipe.nextInt();
                pipe.nextLine(); // Input buffer
                    if(result >= lo && result <= hi){
                        done = true;
                    }
                    else{
                        System.out.println("[Error] Invalid Input. You must enter a value in range " + "[" + lo + "-" + hi + "]");
                    }
            }
            else{
                trash = pipe.nextLine();
                System.out.println("[Error] Invalid Input. Enter a value in range" + "[" + lo + "-" + hi +"]");
            }
        }while(!done);
        return result;
    }
     /**
      * User enters a double within a range of values
      * @param pipe a Scanner opened to read from System.in
      * @param prompt prompt for user
      * @param lo Lowest value in range
      * @param hi Highest value in range
      * @return a double value in given range
      */
     public static double getRangedDouble(Scanner pipe, String prompt, double lo, double hi){
         boolean done = false;
         double result = 0;
         do{
             System.out.print(prompt + "[" + lo + "-" + hi + "]: " );
            if(pipe.hasNextDouble()){
                result = pipe.nextDouble();
                pipe.nextLine(); // Input buffer
                    if(result >= lo && result <= hi){
                        done = true;
                    }
                    else{
                        System.out.println("You must enter a value in range " + "[" + lo + "-" + hi + "]: " + result);
                    }
            }
            else{
                System.out.println("[Error] Invalid Input. Enter a value in range" + "[" + lo + "-" + hi +"]: ");
            }
         }while(!done);
         return result;
     }
     /**
      * boolean is assigned to [Y/N] question
      * @param pipe a Scanner opened to read from System.in
      * @param prompt prompt for user
      * @return True or False boolean
      */
     public static boolean getYNConfirm(Scanner pipe, String prompt){
         String tOrF = "";
         do{
             System.out.print(prompt + " [Y/N]: ");
             if(pipe.hasNextLine()){
                 tOrF = pipe.nextLine();
             }
         }while(!(tOrF.equalsIgnoreCase("Y") || tOrF.equalsIgnoreCase("N")));
         
         if(tOrF.equalsIgnoreCase("Y")){
             return true;
         }
         else{
             return false;
         }
     }
     /**
      * 
      * @param pipe
      * @param prompt prompt for user
      * @param regEx Pattern to validate user input
      * @return 
      */
     public static String getRegExString(Scanner pipe, String prompt, String regEx){
        String input = "";
        boolean valid = false;
        do{
        System.out.print(prompt + ": ");
        input = pipe.nextLine();
        if(input.matches(regEx)){ 
            valid = true;
        }
        else{
            System.out.println("[Error] Invalid input.");
        }
        }while(!valid);
        return input;
     }
}