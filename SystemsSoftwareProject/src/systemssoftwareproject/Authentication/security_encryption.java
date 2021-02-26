/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemssoftwareproject.Authentication;

/**
 *
 * @author Jamie
 */
public class security_encryption {
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
