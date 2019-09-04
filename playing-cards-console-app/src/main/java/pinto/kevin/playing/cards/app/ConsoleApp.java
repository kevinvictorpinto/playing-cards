package pinto.kevin.playing.cards.app;

import pinto.kevin.playing.cards.DeckOfCards;
import pinto.kevin.playing.cards.DeckOfCardsEmptyException;
import pinto.kevin.playing.cards.PlayingCard;
import pinto.kevin.playing.cards.PlayingCardFactory;
import pinto.kevin.playing.cards.fiftytwodeck.FiftyTwoDeckPlayingCardFactory;

import java.util.Iterator;
import java.util.Scanner;

public class ConsoleApp {

    public static void showCard(PlayingCard card) {
        System.out.println(card +
                ", color: " + card.getColor() +
                ", value: " + card.getNumericValue());
    }

    public static void printHelp() {
        System.out.println("Please choose one of the following options: ");
        System.out.println("1 - Deal");
        System.out.println("2 - Shuffle");
        System.out.println("3 - Reset");
        System.out.println("4 - Show cards");
        System.out.println("0 - Exit program");
    }

    public static int run(PlayingCardFactory factory) {
        DeckOfCards deck = factory.getDeckOfCards();

        System.out.println("Welcome to simple 52 deck card dealing app.");

        try(Scanner scanner = new Scanner(System.in)) {

            int choice = -1;

            while (choice != 0) {
                try{
                    System.out.println();
                    printHelp();
                    System.out.print("Enter an option: ");
                    choice = Integer.parseInt(scanner.next());
                    System.out.println();
                } catch (NumberFormatException e) {
                    System.out.println("You may only enter an integer choice.");
                    continue;
                }

                switch (choice) {
                    case 0:
                        System.out.println("Exiting application.");
                        break;
                    case 1:
                        System.out.print("Deal requested: ");
                        try {
                            PlayingCard card = deck.dealOneCard();
                            showCard(card);
                        } catch (DeckOfCardsEmptyException e) {
                            System.out.println("Deck is empty. Nothing to deal.");
                        }
                        break;
                    case 2:
                        System.out.println("Shuffling deck ...");
                        deck.shuffle();
                        break;
                    case 3:
                        System.out.println("Resetting deck");
                        deck = factory.getDeckOfCards();
                        break;
                    case 4:
                        System.out.println("Showing cards: ");
                        int count = 0;
                        Iterator<PlayingCard> iterator = deck.getIterator();
                        while(iterator.hasNext()) {
                            showCard(iterator.next());
                            count++;
                        }

                        System.out.println();
                        System.out.println("Displayed " + count + " cards.");

                        break;
                    default:
                        System.out.println("Invalid option.");

                }

            }

        }

        return 0;
    }

    public static void main(String[] args) {

        PlayingCardFactory factory = new FiftyTwoDeckPlayingCardFactory();

        System.exit(run(factory));
    }
}
