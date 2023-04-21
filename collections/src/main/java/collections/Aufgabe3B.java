package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Aufgabe3B {
    
    public static int[] removeDuplicates(List<Integer> numbers) {
        // Use a Set to keep track of unique numbers.
        Set<Integer> uniqueNumbers = new HashSet<>();
        
        // Use a List to keep track of the result.
        List<Integer> result = new ArrayList<>();
        
        for (int number : numbers) {
            // Add the number to the result list if it's not already in the uniqueNumbers set.
            if (uniqueNumbers.add(number)) {
                result.add(number);
            }
        }
        
        // Convert the result list to an array.
        int[] arrayResult = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arrayResult[i] = result.get(i);
        }
        
        return arrayResult;
    }
    
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 2, 4, 4, 5);
        int[] uniqueNumbers = removeDuplicates(numbers);
        System.out.println(Arrays.toString(uniqueNumbers));
    }
}
