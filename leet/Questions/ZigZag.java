/*
Level: Easy

To test: math ability, manipulate string


*/

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class ZigZag {
  public static String zigzag(String input, int num) {
    String output = "";
    if(input == null || num >= input.length() || input.length() == 0 ) {
      return input;
    }
    
    String[] lineArray = new String[input.length()];
    int currentPos = 0;
    while(currentPos < input.length()) {
      for(int i = 0; i < num && (currentPos + i) < input.length(); i++) {
        if(lineArray[i] == null) {
          lineArray[i] = Character.toString(input.charAt(i));
        } else {
          lineArray[i] = lineArray[i] + Character.toString(input.charAt(currentPos + i));
        }
      }
      
      for(int i = 1; i < num - 1 && (currentPos + num + i - 1) < input.length(); i++) {
        lineArray[num - i - 1] = lineArray[num - i - 1] + Character.toString(input.charAt(currentPos + num + i - 1));
      }
      currentPos = currentPos + 2 * num - 2; 
    }
    
    for(int i = 0; i < num; i++) {
      if(lineArray[i] != null) {
        output += lineArray[i];
      }
    }
    return output;
  }
  public static void main(String[] args) {
    System.out.println(zigzag(null, 2));
    System.out.println(zigzag("", 3));
    System.out.println(zigzag("ABCDEFGHIJKLMN", 26));
    System.out.println(zigzag("ABCDEFGHIJKLMN", 4));
    System.out.println(zigzag("ABCDEFGHIJKLMNO", 4));
    
  }
}
