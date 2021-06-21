import java.util.*;

public class Solution {
    public static String intToRoman(int num) {
        String ret = "";
        int tens_thing = 1;

        while (num != 0) {
            // get the last digit
            int digit = num % 10;

            switch(tens_thing) {
                case 1:
                    if (digit == 4) {

                    } else if (digit == 9)
            }

        }
    }

    public static void main(String[] args) {

    }
}