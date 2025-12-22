package Stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {

    private static List<Integer> nextGreaterElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            result.add(-1);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                result.set(i, st.peek());
            }

            st.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 6, 8, 0, 1, 3 };

        List<Integer> result = nextGreaterElement(arr);

        System.out.println("Next Greater Element Array is 😊: ");

        result.forEach(i -> {
            System.out.print(i + " ");
        });
    }
}
