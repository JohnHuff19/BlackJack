import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class main {
    public static ArrayList<Card> fillDeck(){
        ArrayList<Card>deck=new ArrayList<>();
        deck.add(new Card("Diamonds", "Ace", 11));
        deck.add(new Card("Diamonds", "Two", 2));
        deck.add(new Card("Diamonds", "Three", 3));
        deck.add(new Card("Diamonds", "Four", 4));
        deck.add(new Card("Diamonds", "Five", 5));
        deck.add(new Card("Diamonds", "Six", 6));
        deck.add(new Card("Diamonds", "Seven", 7));
        deck.add(new Card("Diamonds", "Eight", 8));
        deck.add(new Card("Diamonds", "Nine", 9));
        deck.add(new Card("Diamonds", "Ten", 10));
        deck.add(new Card("Diamonds", "Jack", 10));
        deck.add(new Card("Diamonds", "Queen", 10));
        deck.add(new Card("Diamonds", "King", 10));
        deck.add(new Card("Hearts", "Ace", 11));
        deck.add(new Card("Hearts", "Two", 2));
        deck.add(new Card("Hearts", "Three", 3));
        deck.add(new Card("Hearts", "Four", 4));
        deck.add(new Card("Hearts", "Five", 5));
        deck.add(new Card("Hearts", "Six", 6));
        deck.add(new Card("Hearts", "Seven", 7));
        deck.add(new Card("Hearts", "Eight", 8));
        deck.add(new Card("Hearts", "Nine", 9));
        deck.add(new Card("Hearts", "Ten", 10));
        deck.add(new Card("Hearts", "Jack", 10));
        deck.add(new Card("Hearts", "Queen", 10));
        deck.add(new Card("Hearts", "King", 10));
        deck.add(new Card("Clubs", "Ace", 11));
        deck.add(new Card("Clubs", "Two", 2));
        deck.add(new Card("Clubs", "Three", 3));
        deck.add(new Card("Clubs", "Four", 4));
        deck.add(new Card("Clubs", "Five", 5));
        deck.add(new Card("Clubs", "Six", 6));
        deck.add(new Card("Clubs", "Seven", 7));
        deck.add(new Card("Clubs", "Eight", 8));
        deck.add(new Card("Clubs", "Nine", 9));
        deck.add(new Card("Clubs", "Ten", 10));
        deck.add(new Card("Clubs", "Jack", 10));
        deck.add(new Card("Clubs", "Queen", 10));
        deck.add(new Card("Clubs", "King", 10));
        deck.add(new Card("Spades", "Ace", 11));
        deck.add(new Card("Spades", "Two", 2));
        deck.add(new Card("Spades", "Three", 3));
        deck.add(new Card("Spades", "Four", 4));
        deck.add(new Card("Spades", "Five", 5));
        deck.add(new Card("Spades", "Six", 6));
        deck.add(new Card("Spades", "Seven", 7));
        deck.add(new Card("Spades", "Eight", 8));
        deck.add(new Card("Spades", "Nine", 9));
        deck.add(new Card("Spades", "Ten", 10));
        deck.add(new Card("Spades", "Jack", 10));
        deck.add(new Card("Spades", "Queen", 10));
        deck.add(new Card("Spades", "King", 10));
        return deck;
    }
    public static int displayMenu(){
        Scanner sc=new Scanner(System.in);
        System.out.println("1. Hit");
        System.out.println("2. Stand");
        System.out.println("3. Quit");
        return sc.nextInt();
    }
    public static void displayIntro(){
        System.out.println("Welcome to Blackjack!");
        System.out.println("Dealer must stand on 17!");
        System.out.println("You will start with 1000 chips!");
        System.out.println("Over 21 Busts!\nAce is 11 and becomes 1 if you bust!\nBlackjack pays out 1.5x chips!");
        System.out.println("This simulation uses an infinite amount of decks at once!");
        System.out.println("Press any key to continue.");
        Scanner sc=new Scanner(System.in);
        sc.nextLine();
    }
    public static int placeBet(int chips){
        Scanner sc=new Scanner(System.in);
        int bet=0;
        boolean sentinel=true;
        while (sentinel) {
            System.out.print("You currently have " + chips + " chips.\nPlace your bet: ");
            bet = sc.nextInt();
            if (bet > chips) {
                System.out.println("You don't have that many chips.\nTry again.");
            }
            else if (bet<1){
                System.out.println("Minimum bet is 1 chip.");
            }
            else {
                sentinel=false;
            }
        }
        return bet;
    }
    public static int playGame(){
        boolean sentinel=true;
        ArrayList<Card> deck=fillDeck();
        int chips=1000;
        boolean isAce=false;
        do {
            int bet=placeBet(chips);
            Random rand=new Random();
            int card1= rand.nextInt(52);
            int card2=rand.nextInt(52);
            System.out.println("User Cards: "+deck.get(card1)+" and "+deck.get(card2));
            int upcard= rand.nextInt(52);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int uservalue=(deck.get(card1).getValue()+deck.get(card2).getValue());
            if (uservalue==21){
                System.out.println("Blackjack!");
                chips+=(bet*1.5);
                continue;
            }
            System.out.println("Dealer is showing "+deck.get(upcard));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int dealervalue=deck.get(upcard).getValue();
            if (deck.get(card1).getNumber().equals("Ace")||deck.get(card2).getNumber().equals("Ace")){
                isAce=true;
            }
            else {
                isAce=false;
            }
            if (uservalue==22){
                uservalue=12;
                isAce=true;
            }

            boolean insidegame=true;
            while (insidegame){
                System.out.println("Currently at "+uservalue);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int choice=displayMenu();
                switch (choice){
                    case 1:
                        int newcard= rand.nextInt(52);
                        System.out.println(deck.get(newcard));
                        uservalue+=deck.get(newcard).getValue();
                        if (deck.get(newcard).getNumber().equals("Ace")){
                            isAce=true;
                        }
                        if (uservalue>21&&isAce){
                            uservalue-=10;
                            isAce=false;
                        }
                        if (uservalue>21) {
                            System.out.println("Bust!");
                            insidegame=false;
                            chips-=bet;
                            break;
                        }
                        break;
                    case 2:
                        boolean isDealerAce=false;
                        do {
                            int downcard=rand.nextInt(52);
                            System.out.println("Dealer shows a "+deck.get(downcard));
                            if (deck.get(downcard).getNumber().equals("Ace")){
                                isDealerAce=true;
                            }
                            dealervalue+=deck.get(downcard).getValue();
                            if (dealervalue>21&&isDealerAce){
                                dealervalue-=10;
                                isDealerAce=false;
                            }
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } while (dealervalue<17);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Dealer has a "+dealervalue);
                        if (dealervalue>21){
                            System.out.println("Dealer Busts!");
                            chips+=bet;
                            insidegame=false;
                        }
                        else if (dealervalue>uservalue){
                            System.out.println("Dealer Wins!");
                            chips-=bet;
                            insidegame=false;
                        }
                        else if (dealervalue==uservalue){
                            System.out.println("Push!");
                            insidegame=false;
                        }
                        else {
                            System.out.println("User Wins!");
                            chips+=bet;
                            insidegame=false;
                        }
                        break;
                    case 3:
                        sentinel=false;
                        insidegame=false;
                        break;
                }
            }

        }
        while (sentinel);
        return chips;
    }
    public static void displayOutro(int chips){
        System.out.println("Thanks for playing!");
        System.out.println("You finished with "+chips+" chips!");
    }
    public static void main (String [] args){
        displayIntro();
        displayOutro(playGame());
    }
}
