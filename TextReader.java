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
        System.out.println(text.substring(longestConsecutiveIndex + longestConsecutiveAmount));

        // find task 4
    }
}