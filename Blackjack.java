import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");

        scan.nextLine();
        playBlackjack();
        // System.out.println("Press 'y' if you want to play again.");
        // String playAgain = scan.nextLine();
        // while (playAgain.equals('y')) {
        // playBlackJack();
        // playAgain = scan.nextLine();

    }

    public static void playBlackjack() {

        int card1 = drawRandomCard();
        int card2 = drawRandomCard();

        System.out.println("\nYou get a \n" + cardString(card1) + "\nand a\n" + cardString(card2));

        card1 = Math.min(card1, 10);
        card2 = Math.min(card2, 10);
        int playerTotal = card1 + card2;
        System.out.print("your total is: ");
        System.out.println(playerTotal);

        int dealerCard1 = drawRandomCard();
        int dealerCard2 = drawRandomCard();
        String dealerCard1String = cardString(dealerCard1);
        String dealerCard2String = cardString(dealerCard2);

        System.out.println("\nThe dealer shows \n" + cardString(dealerCard1) + "\nand has a card facing down \n" + faceDown());
        dealerCard1 = Math.min(dealerCard1, 10);
        dealerCard2 = Math.min(dealerCard2, 10);
        int dealerTotal = dealerCard1 + dealerCard2;
        System.out.println("\nThe dealer's total is hidden");

        while (true) {
            String answer = hitOrStay();
            if (answer.equals("hit")) {
                int newCard = drawRandomCard();
                System.out.println("\nYou get a \n" + cardString(newCard));
                playerTotal += Math.min(newCard, 10);
                System.out.println("your total is: " + playerTotal);
                if (playerTotal > 21) {
                    System.out.println("Bust! Player loses");
                    break;
                }
            } else if (answer.equals("stay")) {
                break;
            }

        }
        if (playerTotal <= 21 ) {
            System.out.println("\nDealer's turn");
            System.out.println("\nThe dealer's cards are \n" + dealerCard1String + "\nand a \n" + dealerCard2String);
            System.out.println("\nDealer's total is " + dealerTotal);
            while (dealerTotal < 17) {
                int newCard = drawRandomCard();
                dealerTotal += Math.min(newCard, 10);
                System.out.println("\nDealer gets a \n" + cardString(newCard));
                System.out.println("\nDealer's total is " + dealerTotal);
                if (dealerTotal >= 17) {
                    break;
                }
            }
            if (dealerTotal > 21) {
                System.out.println("Bust! Dealer loses.");
            } else if (playerTotal > dealerTotal) {
                System.out.println("Player wins!");
            } else {
                System.out.println("Dealer wins!");
            }
        } 

        System.out.println("\nDo you want to play another game?");
        String anotherGame = scan.nextLine();
            if (anotherGame.equals("yes")) {
                playBlackjack();
            } else {
                System.out.println("Ok, goodbye.");
                System.exit(0);
            }
        scan.close();
    }

    public static int drawRandomCard() {
        double randomNumber = Math.random() * 13;
        randomNumber += 1;
        return (int) randomNumber;
    }

    public static String cardString(int cardNumber) {
        switch (cardNumber) {
            case 1:
                return "   _____\n" +
                        "  |A _  |\n" +
                        "  | ( ) |\n" +
                        "  |(_'_)|\n" +
                        "  |  |  |\n" +
                        "  |____V|\n";
            case 2:
                return "   _____\n" +
                        "  |2    |\n" +
                        "  |  o  |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____Z|\n";
            case 3:
                return "   _____\n" +
                        "  |3    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____E|\n";
            case 4:
                return "   _____\n" +
                        "  |4    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  | o o |\n" +
                        "  |____h|\n";
            case 5:
                return "   _____ \n" +
                        "  |5    |\n" +
                        "  | o o |\n" +
                        "  |  o  |\n" +
                        "  | o o |\n" +
                        "  |____S|\n";
            case 6:
                return "   _____ \n" +
                        "  |6    |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  |____6|\n";
            case 7:
                return "   _____ \n" +
                        "  |7    |\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |____7|\n";
            case 8:
                return "   _____ \n" +
                        "  |8    |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  |____8|\n";
            case 9:
                return "   _____ \n" +
                        "  |9    |\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |____9|\n";
            case 10:
                return "   _____ \n" +
                        "  |10  o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |___10|\n";
            case 11:
                return "   _____\n" +
                        "  |J  ww|\n" +
                        "  | o {)|\n" +
                        "  |o o% |\n" +
                        "  | | % |\n" +
                        "  |__%%[|\n";
            case 12:
                return "   _____\n" +
                        "  |Q  ww|\n" +
                        "  | o {(|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%O|\n";
            case 13:
                return "   _____\n" +
                        "  |K  WW|\n" +
                        "  | o {)|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%>|\n";
            default:
                return "This shouldn't be called.";
        }
    }

    public static String faceDown() {
        return "   _____\n" +
                "  |     |\n" +
                "  |  J  |\n" +
                "  | JJJ |\n" +
                "  |  J  |\n" +
                "  |_____|\n";
    }

    /**
     * Task 7 – make a function that asks the user to hit or stay.
     * Function name – hitOrStay
     * 
     * @return (String)
     *
     *         Inside the function:
     *         1. Asks the user to hit or stay.
     *         2. If the user doesn't enter "hit" or "stay", keep asking them to try
     *         again by printing:
     *         Please write 'hit' or 'stay'
     *         3. Returns the user's option
     */

    public static String hitOrStay() {
        System.out.println("Hit or stay?");
        String answer = scan.nextLine();
        while (!(answer.equals("hit") || answer.equals("stay"))) {
            System.out.println("Please write 'hit' or 'stay'");
            answer = scan.nextLine();
        }
        return answer;
    }

}
