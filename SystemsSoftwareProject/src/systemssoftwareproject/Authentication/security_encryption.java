package systemssoftwareproject.Authentication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class security_encryption {
    
    public static boolean username_validation(String username_entered){
        String file_name = "Account_details";
        boolean username_valid = true;
        try {
            FileReader fin = new FileReader(file_name);
            BufferedReader din = new BufferedReader(fin);
            //read from the file
            String line = null; // line of text
            while ((line = din.readLine()) != null) {
                // here we have read in a line of text
                // now parse line to extract data and print it out to the screen
                StringTokenizer st = new StringTokenizer(line, ",");
                
                String username_found = (st.nextToken().trim());
                
                if (username_found.equals(username_entered)){
                        System.out.println("Username already taken");
                        username_valid = false;
                }
                else{
                   System.out.println(username_found + "\n" + 
                           username_entered);  
                }
            }
            din.close(); // close the stream
        } catch (IOException e) {
            System.err.println("Error! - " + e.getMessage());
            username_valid = false;
        }
        return username_valid;
    }
    
    public static boolean password_validation(String password_entered){
        // Length check
        int length = password_entered.length();
        if (length < 7){
            return false;
        }
        
        // Contains letter and number check
        char[] chars = password_entered.toCharArray();
        boolean contains_digit = false;
        boolean contains_uppercase = false;
        boolean contains_lowercase = false;
        for(char c : chars){
            if(Character.isDigit(c)){
                contains_digit = true;
            }
            else if(Character.isUpperCase(c)){
                contains_uppercase = true;
            }
            else if(Character.isLowerCase(c)){
                contains_lowercase = true;
            }
            
            if (contains_digit && contains_uppercase && contains_lowercase){
                break;
            }
        }
        return contains_digit && contains_uppercase && contains_lowercase;
    }
        
    public static String encryption(String string_to_encrypt){
        String result = "";
        for (char character: string_to_encrypt.toCharArray()) {
            if (character != ' ') { // Spaces stay unchanged
                int ascii_alpha_postion = character - 'a';
                int new_ascii_alpha_postion = (ascii_alpha_postion + 3) % 26;
                char encrypted_char = (char) ('a' + new_ascii_alpha_postion);
                result += encrypted_char;
            } else {
                result += character;
            }
        }
        return result;
    }
}