package datastructures.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an array of characters where each character represents a fruit tree,
 * you are given two baskets and your goal is to put maximum number of fruits in each basket.
 * The only restriction is that each basket can have only one type of fruit.
 *
 * You can start with any tree, but once you have started you can’t skip a tree.
 * You will pick one fruit from each tree until you cannot, i.e.,
 * you will stop when you have to pick from a third fruit type.
 *
 * Write a function to return the maximum number of fruits in both the baskets.
 *
 * Input: Fruit=['A', 'B', 'C', 'A', 'C']
 * Output: 3
 * Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
 *
 * A A A B C D
 */
public class FruitsInBasket {
    public static int fruitsInBasket(Character[] a) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        int startWindow = 0;
        for (int endWindow=0; endWindow< a.length; endWindow++) {
            int freqOfEndChar = frequencyMap.getOrDefault(a[endWindow], 0);
            frequencyMap.put(a[endWindow], freqOfEndChar+1);
            // shrink size
            while (frequencyMap.size() > 2) {
                Character startChar = a[startWindow];
                frequencyMap.put(startChar, frequencyMap.get(startChar) - 1);
                if (frequencyMap.get(startChar) == 0) {
                    frequencyMap.remove(startChar);
                }
                startWindow++;
            }
            maxLength = Math.max(maxLength, endWindow - startWindow + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Character[] a = {'A', 'B', 'C', 'A', 'C'};
        System.out.println(fruitsInBasket(a));
    }
}
