import java.util.Scanner;
import java.io.File;

public class TextReader {
    public static void main(String[] args) throws Exception{
        File info = new File("puzzle.txt");
        Scanner reader = new Scanner(info);
        String text = reader.nextLine();

        // find task 2 
        String cutText = text;
        for (int i = 0; i < 10; i++) {
            cutText = cutText.substring(cutText.indexOf("giraffe") + 7);
        }
        
        System.out.println(cutText.substring(0,123));

        // find task 3
        int longestConsecutiveIndex = 0;
        int longestConsecutiveAmount = 0;
        int currentConsecutiveIndex = 0;
        String previousChar = "";
        int charAmount = 1;

        for (int ii = 0; ii < text.length(); ii++) {
            String newChar = text.substring(ii, ii + 1);
            if (previousChar.equals(newChar)) {
                charAmount += 1;
            } else {
               currentConsecutiveIndex = ii;
               charAmount = 1;
            }

            if (charAmount > longestConsecutiveAmount) {
                longestConsecutiveIndex = currentConsecutiveIndex;
                longestConsecutiveAmount = charAmount;
            }
            previousChar = text.substring(ii, ii+1);
        }

        System.out.println(text.substring(longestConsecutiveIndex + longestConsecutiveAmount, longestConsecutiveIndex + longestConsecutiveAmount + 105));

        // find task 4
        int mostVowelsIndex = 0;
        int mostVowelsAmount = 0;
        int currentVowels = 0;

        for (int iii = 0; iii < text.length() - 29; iii++) {
            String currentSubstring = text.substring(iii, iii + 30);
            for (int character = 0; character < currentSubstring.length(); character++) {
                String currentChar = currentSubstring.substring(character, character + 1);
                if (currentChar .equals("a") || currentChar .equals("e") || currentChar .equals("i") || currentChar .equals("o") || currentChar .equals("u")) {
                    currentVowels++;
                }
            }
            if (currentVowels > mostVowelsAmount) {
                mostVowelsAmount = currentVowels;
                mostVowelsIndex = iii;
            }
            currentVowels = 0;
        }
        
        System.out.println(text.substring(mostVowelsIndex + 30, mostVowelsIndex + 110));

        // finish
        int palindromeIndex = 0;

        for (int iiii = 0; iiii < text.length() - 10; iiii++) {
            String currentSubstring = text.substring(iiii, iiii + 11);
            String reversed = "";
            for (int character = 0; character < currentSubstring.length(); character++) {
                reversed = currentSubstring.substring(character, character + 1) + reversed;
            }
            if (reversed.equals(currentSubstring)) {
                palindromeIndex = iiii;
                break;
            }
        }

        System.out.println(text.substring(palindromeIndex + 11, palindromeIndex + 17));
    }
}