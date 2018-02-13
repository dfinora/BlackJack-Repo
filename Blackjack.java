//debug for lab 5//
import java.util.*;
import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        P1Random rng = new P1Random();


        boolean play = true;
        int gameNum = 0;
        int myHand = 0;
        double playerGamesWon = 0;
        int dealerGamesWon = 0;
        int tieGames = 0;
        double totalGames = 0;
        boolean firstCard = true;
        double playerPercentage = 0;

        String ace = "ACE";
        String jack = "JACK";
        String queen = "QUEEN";
        String king = "KING";


        while (play == true) {

            if (firstCard == true) {

                //These are the strings created to give a meaningful name to the randomly generated numbers 1, 11, 12, 13.


                System.out.println("START GAME #" + ++gameNum);
                System.out.println("");

                int startingNum = rng.nextInt(13) + 1;
//These are statements associating the previously created strings with a randomly generated value.
                if (startingNum == 1) {
                    System.out.println("Your card is a " + ace + "!");
                } else if (startingNum == 11) {
                    System.out.println("Your card is a " + jack + "!");
                    startingNum = 10;
                } else if (startingNum == 12) {
                    System.out.println("Your card is a " + queen + "!");
                    startingNum = 10;
                } else if (startingNum == 13) {
                    System.out.println("Your card is a " + king + "!");
                    startingNum = 10;
                } else {
                    System.out.println("Your card is a " + startingNum + "!");
                }

                myHand = myHand + startingNum;

                System.out.println("Your hand is: " + (myHand));
                System.out.println("");

                firstCard = false;
            }


            //The following lines of code exist to create and print the Menu of the game.
            System.out.println("1. Get another card");
            System.out.println("2. Hold hand");
            System.out.println("3. Print statistics");
            System.out.println("4. Exit");
            System.out.println("");
            System.out.print("Choose an option: ");


            int option = scanner.nextInt();
            System.out.println("");
            //The following lines exist to dictate what each option choice does
            if (option == 1) {

                int myNumber = rng.nextInt(13) + 1;

                if (myNumber == 1) {
                    System.out.println("Your card is a " + ace + "!");
                } else if (myNumber == 11) {
                    System.out.println("Your card is a " + jack + "!");
                    myNumber = 10;
                } else if (myNumber == 12) {
                    System.out.println("Your card is a " + queen + "!");
                    myNumber = 10;
                } else if (myNumber == 13) {
                    System.out.println("Your card is a " + king + "!");
                    myNumber = 10;
                } else {
                    System.out.println("Your card is a " + myNumber + "!");
                }
                myHand = myHand + myNumber;
                System.out.println("Your hand is: " + (myHand));
                System.out.println("");

                if (myHand > 21) {
                    System.out.println("You exceeded 21! You lose.");
                    firstCard = true;
                    System.out.println("");
                    myHand = 0;
                    ++dealerGamesWon;
                    ++totalGames;
                }
                else if (myHand == 21) {
                    System.out.println("BLACKJACK! You win!");
                    firstCard = true;
                    System.out.println("");
                    myHand = 0;
                    ++playerGamesWon;
                    ++totalGames;
                }
            }


            else if (option == 2) {
                int dealerHand = rng.nextInt(11) + 16;
                System.out.println("Dealer's hand: " + dealerHand);
                System.out.println("Your hand is: " + myHand);
                if (myHand > dealerHand) {
                    System.out.println("");
                    System.out.println("You win!");
                    firstCard = true;
                    System.out.println("");
                    myHand = 0;
                    ++playerGamesWon;
                    ++totalGames;

                } else if (dealerHand > 21) {
                    System.out.println("");
                    System.out.println("You win!");
                    firstCard = true;
                    System.out.println("");
                    myHand = 0;
                    ++playerGamesWon;
                    ++totalGames;

                } else if (myHand < dealerHand) {
                    System.out.println("");
                    System.out.println("Dealer wins!");
                    firstCard = true;
                    System.out.println("");
                    myHand = 0;
                    ++dealerGamesWon;
                    ++totalGames;

                } else if (myHand == dealerHand) {
                    System.out.println("");
                    System.out.println("It's a tie! No one wins!");
                    firstCard = true;
                    System.out.println("");
                    myHand = 0;
                    ++tieGames;
                    ++totalGames;
                }
            }


           else if (option == 3) {
                if (totalGames==0){
                   playerPercentage = 0;
                }
                else if (totalGames>0){
                    playerPercentage = (playerGamesWon) / (totalGames) * 100;
                }
                int tempPlayerGames = (int) playerGamesWon;
                int tempTotalGames = (int) totalGames;

                System.out.println("Number of Player wins: " + tempPlayerGames);
                System.out.println("Number of Dealer wins: " + dealerGamesWon);
                System.out.println("Number of tie games: " + tieGames);
                System.out.println("Total # of games played is: " + tempTotalGames);
                System.out.println("Percentage of Player wins: " + playerPercentage + "%");
                System.out.println("");
            }

            else if (option == 4) {
                play = false;
            }

            else {
                System.out.println("Invalid input!");
                System.out.println("Please enter an integer value between 1 and 4.");
                System.out.println("");
            }
        }
    }
}




