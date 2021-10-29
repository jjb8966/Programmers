package Level2;

import java.util.Arrays;
import java.util.Scanner;

public class StringCompression {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        String result = new String();
        int[] words;
        int count = 1;
        int startIndex, endIndex;

        input = sc.nextLine();
        words = new int[input.length() / 2];

        for (int i = 1; i <= input.length() / 2; i++) {       //i : 쪼개는 단위 수
            for (int j = 0; j + (i * 2) <= input.length(); j++) {
                startIndex = j;
                endIndex = j + (i * 2);
                String leftString = input.substring(startIndex, startIndex + i);
                String rightString = input.substring(startIndex + i, endIndex);
                if (isSame(leftString, rightString)) {
                    count++;
                    j = startIndex + i - 1;
                } else if (count == 1) {
                    if (endIndex != input.length()) {
                        result += input.substring(startIndex, startIndex + 1);
                    } else{
                        result += leftString + rightString;
                    }
                } else {
                    result += count + leftString;
                    count = 1;
                }

                if (count != 1 && endIndex == input.length()) {
                    result += count + leftString;
                    count = 1;
                }
            }
            words[i - 1] = result.length();
            result = "";
        }

        Arrays.sort(words);
        System.out.println(words[0]);
    }

    public static boolean isSame(String leftString, String rightString) {
        if (leftString.equals(rightString)) {
            return true;
        }
        return false;
    }
}