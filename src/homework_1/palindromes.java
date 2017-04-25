package homework_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by y7usuf on 06/04/2017.
 * Yusuf Emre Göksu
 * 14050111023
 */

class myStack {
    private int maxSize;        // size of stack array
    private String[] stackArray;
    private int top;            // top of stack

    //--------------------------------------------------------------
// This is the constructor that takes as an argument the maximum size
// s that it ever needs to be
    myStack(int s)         // constructor
    {
        maxSize = s;             // set array size
        stackArray = new String[maxSize];  // create array
        top = -1;                // no items yet
    }

    //--------------------------------------------------------------
    void push(String j)    // put item on top of stack
    {
        stackArray[++top] = j;     // increment top, insert item
    }

    //--------------------------------------------------------------
    String pop()           // take item from top of stack
    {
        return stackArray[top--];  // access item, decrement top
    }

    //--------------------------------------------------------------
    public String peek()          // peek at top of stack
    {
        return stackArray[top];
    }

    //--------------------------------------------------------------
    boolean isEmpty()    // true if stack is empty
    {
        return (top == -1);
    }

    //--------------------------------------------------------------
    public boolean isFull()     // true if stack is full
    {
        return (top == maxSize - 1);
    }
//--------------------------------------------------------------
}  // end class myStack

class StackApp {
    public static void main(String[] args) {
        myStack theStack = new myStack(10);  // make new stack
        theStack.push("a");               // push items onto stack
        theStack.push("b");
        theStack.push("7");
        theStack.push("d");

        while (!theStack.isEmpty())     // until it's empty,
        {                             // delete item from stack
            String value = theStack.pop();
            System.out.print(value);      // display it
            System.out.print(" ");
        }  // end while
    }  // end main()
}  // end class StackApp

class palindromes {

    private String[] MyLines;
    private myStack theStack = new myStack(9);

    public String[] getMyLines() {
        return MyLines;
    }

    public void setMyLines(String[] myLines) {
        MyLines = myLines;
    }

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("/Users/daimon/Development/CENG202/src/homework_1/palindromes.txt"))) {
            for (String Line; null != (Line = br.readLine()); ) {
                String original, reverse = "";

                String newLine = Line.replaceAll("[,./:;'?! ]", "");

                original = newLine.toLowerCase();

                int length = original.length();

                for (int i = length - 1; i >= 0; i--) {
                    reverse = reverse + original.charAt(i);
                }

                //                System.out.print(reverse);

                if (original.equals(reverse))
                    System.out.println("\"" + Line + "\" is a palindrome.");
                else
                    System.out.println("\"" + Line + "\" is not a palindrome.");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}