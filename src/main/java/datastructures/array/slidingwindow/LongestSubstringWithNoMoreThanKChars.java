package datastructures.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 * <p>
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 */
public class LongestSubstringWithNoMoreThanKChars {

    public static int compute(String a, int k) {
        int windowStart = 0;
        int maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < a.length(); windowEnd++) {
            Character rightChar = a.charAt(windowEnd);
            int count = charFrequencyMap.getOrDefault(rightChar, 0);
            charFrequencyMap.put(rightChar, count+1);

            while (charFrequencyMap.size() > k) {
                Character leftChar = a.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar)-1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++;
            }
            int size = windowEnd - windowStart + 1;
            maxLength = Math.max(size, maxLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(compute("araaci", 2));
    }
}
