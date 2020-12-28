package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an expression to check:");
        String s = scanner.nextLine();

        while (!s.equals("end")) {
            String expressions = s;
            System.out.println(checkExpression(expressions));
            s = scanner.nextLine();
        }
    }

    private static String checkExpression (String expression) {
        Stack<Integer> myStack = new Stack<Integer>();
        boolean correctBrackets = true;

        for (int index = 0; index < expression.length(); index++) {
            char ch = expression.charAt(index);

            if(ch == '(') {
                myStack.push(index);
            } else if( ch == ')') {
                if(myStack.isEmpty()) {
                    correctBrackets = false;
                    break;
                }
                myStack.pop();
            }
        }
        if(!myStack.isEmpty()) correctBrackets=false;
        return ("Are the brackets correct? " + correctBrackets);
    }
}
