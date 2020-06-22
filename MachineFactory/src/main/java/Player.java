import java.util.*;
import java.io.*;
import java.math.*;

class Player {

    public static final String RIGHT = "RIGHT";
    public static final String LEFT = "LEFT";
    public static final String PICK = "PICK";
    public static final String PLACE = "PLACE";

    public static String solve(int clawPos, int[] boxes, boolean boxInClaw) {
        int maxIndex = 0;
        int minIndex = 0;
        for (int i=1; i<boxes.length; i++) {
           if (boxes[i] >= boxes[maxIndex]) {
               maxIndex = i;
           }   
           if (boxes[i] < boxes[minIndex]) {
               minIndex = i;
           }  
        }

        if (!boxInClaw) {
            if (clawPos == maxIndex) {
                return PICK;
            }
            else if (clawPos < maxIndex) {
                return RIGHT;
            }
            else {
                return LEFT;
            }
        }
        else {
            if (clawPos == minIndex) {
                return PLACE;
            }
            else if (clawPos < minIndex) {
                return RIGHT;
            }
            else {
                return LEFT;
            }
        }
    }


    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // game loop
        while (true) {
            int clawPos = in.nextInt();
            boolean boxInClaw = in.nextInt() != 0;
            int stacks = in.nextInt();
            int[] boxes = new int[stacks];
            for (int i = 0; i < stacks; i++) {
                boxes[i] = in.nextInt();
            }
            PrintStream outStream = System.out;
            System.setOut(System.err);
            String action = solve(clawPos, boxes, boxInClaw);
            System.setOut(outStream);
            System.out.println(action);
        }
    }
}