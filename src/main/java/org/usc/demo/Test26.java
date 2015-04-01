package org.usc.demo;

import com.google.common.primitives.Ints;

/**
 *
 * @author Shunli
 */
public class Test26 {
    private static int calcDice(int left, int step, int dice) {
        int t = left - step + dice;
        return t > 0 ? t : t + Ints.max(6, step - left);
    }

    public static void main(String[] args) {
        for (int step = 18; step < 24; step++) {
            for (int dice = 1; dice <= 6; dice++) {
                System.out.println(step + " == " + dice + " == " + calcDice(18, step, dice) + " == " + (step + calcDice(18, step, dice)));
            }

            System.out.println();
        }

        for (int step = 4; step < 10; step++) {
            for (int dice = 1; dice <= 6; dice++) {
                System.out.println(step + " == " + dice + " == " + calcDice(4, step, dice) + " == " + (step + calcDice(4, step, dice)));
            }

            System.out.println();
        }

        for (int step = 10; step < 18; step++) {
            for (int dice = 1; dice <= 6; dice++) {
                System.out.println(step + " == " + dice + " == " + calcDice(10, step, dice) + " == " + (step + calcDice(10, step, dice)));
            }

            System.out.println();
        }

    }

}
