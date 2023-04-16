package Number_guessing_game;

import javax.swing.*;

/**
 * number_guess_game
 */
public class number_guess_game {

    static int guess;
    static int trials = 5;
    static int noOfTimes = 5;

    static void getGuesses() {
        // Generate random numbers from 1 - 10
        int random_guess = (int) Math.floor((Math.random() * 100) + 1);

        for (int i = 0; i < trials; i++) {
            guess = Integer.parseInt(
                    JOptionPane.showInputDialog(null, "Enter guess from 1 - 100 within " + noOfTimes + " trials",
                            "Number Guessing Game", JOptionPane.QUESTION_MESSAGE));
            noOfTimes--;

            if (guess == random_guess) {
                JOptionPane.showMessageDialog(null, "Correct\n You used " + i + " number of times", "Result",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            } else if (guess > random_guess && i != trials - 1) {
                JOptionPane.showMessageDialog(null, "Your Guess is too High!", "Result", JOptionPane.ERROR_MESSAGE);
            } else if (guess < random_guess && i != trials - 1) {
                JOptionPane.showMessageDialog(null, "Your Guess is too Low!", "Result", JOptionPane.ERROR_MESSAGE);
            }

            if (i == (trials - 1)) {
                JOptionPane.showMessageDialog(null, "You have used up your trial Limit", "Result",
                        JOptionPane.INFORMATION_MESSAGE);

                JOptionPane.showMessageDialog(null, "The Correct Number was " + random_guess, "Result",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    public static void main(String[] args) {
        getGuesses();
    }
}