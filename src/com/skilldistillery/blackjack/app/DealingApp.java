package com.skilldistillery.blackjack.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Deck;

public class DealingApp {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		DealingApp da = new DealingApp();
		da.run();

	}

	public void run() {

		System.out.print("How many cards would you like? ");
		int numCardsToDeal = 0;
		boolean gotValidNumCards = false;
		while (!gotValidNumCards) {
			try {
				numCardsToDeal = sc.nextInt();
				if (numCardsToDeal >= 0 && numCardsToDeal <= 52) {
					gotValidNumCards = true;
				} else {
					System.err.print("Invalid Input. Number must be from 0 - 52");
					sc.nextLine();
				}
			} catch (InputMismatchException e) {
				System.err.print("Invalid Input. Enter a Number: ");
				sc.nextLine();
			}
		}

		Deck deck = new Deck();
		deck.shuffle();
		int totalValue = 0;
		Card card;
		for (int i = 0; i < numCardsToDeal; i++) {
			card = deck.dealCard();
			totalValue += card.getValue();
			System.out.println(card);
		}
		System.out.println(totalValue);

	}

}
