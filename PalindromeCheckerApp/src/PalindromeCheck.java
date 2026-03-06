import java.util.Scanner;
import java.util.Stack;

interface PalindromeStrategy {
    boolean check(String input);
}

class StackStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) stack.push(c);
        for (char c : input.toCharArray()) if (c != stack.pop()) return false;
        return true;
    }
}

class ReverseStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equals(reversed);
    }
}

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input : ");
        String input = sc.nextLine();

        PalindromeStrategy stackStrategy = new StackStrategy();
        long start1 = System.nanoTime();
        boolean result1 = stackStrategy.check(input);
        long end1 = System.nanoTime();

        PalindromeStrategy reverseStrategy = new ReverseStrategy();
        long start2 = System.nanoTime();
        boolean result2 = reverseStrategy.check(input);
        long end2 = System.nanoTime();

        System.out.println("Stack Strategy -> " + result1 + " | Time: " + (end1 - start1) + " ns");
        System.out.println("Reverse Strategy -> " + result2 + " | Time: " + (end2 - start2) + " ns");

        sc.close();
    }
}
