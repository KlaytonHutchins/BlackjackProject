package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {
	
	private Player player = new Player();
	private Dealer dealer = new Dealer();
	boolean stillHitting = true;
	Scanner sc = new Scanner(System.in);
	int canDealerDisplayFirstCard = 1;
	
	public static void main(String[] args) {
		
		BlackjackApp bja = new BlackjackApp();
		bja.play();
		
	}
	
	public void play() {
		dealInitialCards();
		displayCards();
		while (stillHitting) {
			playerHitOrStand();
			if (!player.isBust() && stillHitting) {
				displayCards();
			}
		}
		stillHitting = true;
		canDealerDisplayFirstCard = 0;
		while (stillHitting) {
			dealerHitOrStand();
			if (!dealer.isBust()) {
				displayCards();
			}
		}
		determineAndDisplayWinner();
	}

	private void dealInitialCards() {
		player.addCardToPlayerHand(dealer.dealCard());
		dealer.addCardToDealerHand(dealer.dealCard());
		if (player.isBlackjack()) {
			System.out.println("BLACKJACK, You WON");
			return;
		}
		player.addCardToPlayerHand(dealer.dealCard());
		dealer.addCardToDealerHand(dealer.dealCard());
		if (dealer.isBlackjack()) {
			System.out.println("BLACKJACK, You LOST");
			return;
		}
	}
	
	private void displayCards() {
		System.out.println("Player Cards:");
		for (int i = 0; i< player.handSize(); i++) {
			System.out.println("\t" + player.displayCard(i));
		}
		System.out.println("Dealer Cards:");
		if (canDealerDisplayFirstCard == 1) {
			System.out.println("Card Is Face Down");
		}
		for (int i = canDealerDisplayFirstCard; i< dealer.handSize(); i++) {
			System.out.println("\t" + dealer.displayCard(i));
		}
	}

	public void playerHitOrStand() {
		System.out.print("Would you like to HIT or STAND? ");
		String hitOrStand = sc.nextLine();
		while (!hitOrStand.equals("HIT") && !hitOrStand.equals("STAND")) {
			System.err.println("Invalid entry. Please say \"HIT\" or \"STAND\"");
			hitOrStand = sc.nextLine();
		}
		if (hitOrStand.equals("STAND")) {
			stillHitting = false;
			return;
		} else {
			player.addCardToPlayerHand(dealer.dealCard());
			if (player.isBust()) {
				displayCards();
				stillHitting = false;
				return;
			} else {
				stillHitting = true;
			}
		}
	}
	
	public void dealerHitOrStand() {
		if (dealer.getHandValue() < 17) {
			dealer.addCardToDealerHand(dealer.dealCard());
		} else {
			stillHitting = false;
		}
		if (dealer.isBust()) {
			displayCards();
			stillHitting = false;
		}
	}
	
	public void determineAndDisplayWinner() {
		if (player.isBust()) {
			System.out.println("Player BUST. You LOST");
		} else if (dealer.isBust()){
			System.out.println("Dealer BUST. You WON");
		} else if (player.getHandValue() > dealer.getHandValue()) {
			System.out.println("You WON.");
		} else if (player.getHandValue() < dealer.getHandValue()) {
			System.out.println("You LOST.");
		}
		System.out.println("Your hand value: " + player.getHandValue() + "\nDealer hand value: " + dealer.getHandValue());
	}
	
}
