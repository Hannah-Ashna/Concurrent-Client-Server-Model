package systemssoftwareproject.Authentication;

public class security_encryption {
    
    public static boolean password_validation(String password_entered){
        // Length check
        int length = password_entered.length();
        if (length < 7){
            return false;
        }
        
        // Contains letter and number check
        char[] chars = password_entered.toCharArray();
        boolean contains_digit = false;
        boolean contains_letter = false;
        for(char c : chars){
            if(Character.isDigit(c)){
                contains_digit = true;
            }
            else if(Character.isLetter(c)){
                contains_letter = true;
            }
            if (contains_digit && contains_letter){
                break;
            }
        }
        return contains_digit && contains_letter;
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
