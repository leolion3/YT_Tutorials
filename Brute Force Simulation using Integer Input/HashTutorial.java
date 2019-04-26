import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashTutorial {

    //Constructor of class, calls compare() function
    HashTutorial(){
        compare();
    }

    //Take in a String throw JOptionpane, convert to Integer and hash it, then run brute force until a match for the
    // int is found
    static void compare(){
        //Declared as null because assignment bellow happens in a try-catch which could (theoretically) fail
        byte[] userDefined=null;
        //Same thing as above goes for the Integer
        int inp=0;
        try{
            //Try to parse the entered String to an Integer and then hash it
            inp = Integer.parseInt(JOptionPane.showInputDialog(null,"Please enter your integer!"));
            userDefined=hash(inp);
        }
        //Should the parsing or the hash fail, the function will call itself and start over
        catch(Exception e){
            compare();
        }
        //Check if the Integer is smaller than 0, if it is, start over
        if(inp<0){
            try {
                //JOptionPane can throw a NullPointerException when clicking on window x, so we use a try-catch statement
                //to eliminate a potential software termination
                JOptionPane.showMessageDialog(null, "The integer must be bigger than or equal to 0!");
            }
            //Should an exception be thrown, the program will terminate. Replace with compare(); if you would like
            //it to try again instead of stopping
            catch(NullPointerException e){
                System.exit(-1);
            }
            //if the input is smaller than 0, start over
            compare();
        }

        //Brute force starts here. Start at int 0, and goes till the integer size limit is reached, calculating the hash
        //of each integer and comparing it to the input's hash. If a match is found, it prints out the input in plain text.
        for(int i=0;i<2147483647;i++){
            //Print out the current integer, it's good to have an overview if you enter a higher valued integer that
            // takes longer
            System.out.println(i);
            //Check if the current integer's hash matches the input's hash
            if(MessageDigest.isEqual(hash(i),userDefined)){
                //if a match is found, print the integer in plain text. Again, try catch is for the JOptionPane
                try {
                    JOptionPane.showMessageDialog(null, "Found a match for " + i);
                }
                catch(Exception e){
                    System.out.println("Found a match for " + i);
                }
                //and terminate the program
                System.exit(0);
                break;
            }
        }
        //This statement is only reached if no match is found
        System.out.println("No match found!");
    }

    //Hashing function. Takes an Integer input and returns the hash as a byte array
    static byte[] hash(int input){
        //Because assignment is in a try-catch statement, we set the start value to null
        byte[] output=null;
        //Convert the integer input to a String, because the hash function uses a String
        String inp=Integer.toString(input);
        //try-catch because misspelling the Algorithm type will return a NoSuchAlgorithmException
        try{
            //Set hash algorithm type
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            //Calculate the inputs hash as a byte array, and assign it to the variable output
            output = digest.digest(inp.getBytes(StandardCharsets.UTF_8));
        }
        //Catch NoSuchAlgorithmException
        catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        //return the byte array
        return output;
    }

    //Finally, the main method, obviously...
    public static void main(String[] args){
        new Tutorial();
    }
}
