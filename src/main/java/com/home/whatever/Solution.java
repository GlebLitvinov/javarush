package com.home.whatever;

public class Solution {

    public static void main(String[] args) {
        var solution = new Solution();
        solution.solve(new ConsoleInputReader());
    }

    private void solve(InputReader reader) {
        var input = reader.readStrings();
        var result = removeDuplicates(input);
        writeResult(result);
    }

    private void writeResult(String[] result) {
        for (String s : result) {
            System.out.println(s);
        }
    }

    public String[] removeDuplicatesShort(String[] input) {
        for (int i = 0; i < input.length; i++) {
            int count = 0;
            String element = input[i];
            for (int j = 0; j < input.length; j++) {
                if (element != null && element.equals(input[j])) {
                    count++;
                }
                if (count > 1) {
                    for (int k = 0; k < input.length; k++) {
                        if (element.equals(input[k])) {
                            input[k] = null;
                        }
                    }
                    break;
                }
            }
        }
        return input;
    }

    public String[] removeDuplicates(String[] input) {
        // if array contains any element more than 1 time - remove
        // all elements of the array that are equal to this element
        for (int i = 0; i < input.length; i++) {
            int count = countElementsInArrayEqualToString(input[i], input);
            if (count > 1) {
                replaceElementWithNull(input[i], input);
            }
        }

        return input;
    }

    public void replaceElementWithNull(String element, String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equals(element)) {
                array[i] = null;
            }
        }
    }

    public int countElementsInArrayEqualToString(String element, String[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equals(element)) {
                count++;
            }
        }
        return count;
    }


}
