package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {
	
	private Scanner sc = new Scanner(System.in);
	private Player player = new Player();
	private Dealer dealer = new Dealer();
	private int canDealerDisplayFirstCard = 1;
	private boolean stillHitting = true;
	private boolean isGameOver = false;
	
	public static void main(String[] args) {
		BlackjackApp bja = new BlackjackApp();
		bja.play();
	}
	
	public void play() {
		dealInitialCards();
		if (player.isBlackjack() || dealer.isBlackjack()) {
			isGameOver = true;
		}
		if (!isGameOver) {
			displayCards();
		}
		while (stillHitting && !isGameOver) {
			playerHitOrStand();
			if (stillHitting && !isGameOver) {
				displayCards();
			}
		}
		stillHitting = true;
		canDealerDisplayFirstCard = 0;
		while (stillHitting && !isGameOver) {
			dealerHitOrStand();
			if (stillHitting && !isGameOver) {
				displayCards();
			}
		}
		displayCards();
		determineAndDisplayWinner();
	}

	private void dealInitialCards() {
		player.addCardToMyHand(dealer.dealCard());
		dealer.addCardToMyHand(dealer.dealCard());
		player.addCardToMyHand(dealer.dealCard());
		dealer.addCardToMyHand(dealer.dealCard());
	}
	
	private void displayCards() {
		if (dealer.isTwentyOne()) {
			canDealerDisplayFirstCard = 0;
		}
		System.out.println("Player Cards:");
		for (int i = 0; i< player.handSize(); i++) {
			System.out.println("\t" + player.displayCard(i));
		}
		System.out.println("\tYour hand value: " + player.getHandValue());
		System.out.println("Dealer Cards:");
		if (canDealerDisplayFirstCard == 1) {
			System.out.println("\tCard Face Down");
		}
		for (int i = canDealerDisplayFirstCard; i< dealer.handSize(); i++) {
			System.out.println("\t" + dealer.displayCard(i));
		}
		if (canDealerDisplayFirstCard == 0) {
			System.out.println("\tDealer hand value: " + dealer.getHandValue());
		}
	}

	public void playerHitOrStand() {
		System.out.print("Would you like to HIT or STAND? ");
		String hitOrStand = sc.next().toUpperCase();
//		sc.nextLine();
		while (!hitOrStand.equals("HIT") && !hitOrStand.equals("STAND")) {
			System.err.println("Invalid entry. Please say \"HIT\" or \"STAND\"");
			hitOrStand = sc.nextLine();
			sc.nextLine();
		}
		if (hitOrStand.equals("STAND")) {
			stillHitting = false;
			return;
		} else if (hitOrStand.equals("HIT")){
			player.addCardToMyHand(dealer.dealCard());
			if (player.isBust() || player.isTwentyOne()) {
				isGameOver = true;
			} else {
				stillHitting = true;
			}
		}
	}
	
	public void dealerHitOrStand() {
		if (dealer.getHandValue() < 17) {
			System.out.println("Dealer drawing card..");
			dealer.addCardToMyHand(dealer.dealCard());
		} else {
			stillHitting = false;
			isGameOver = true;
		}
		if (dealer.isBust() || dealer.isTwentyOne()) {
			isGameOver = true;
		}
	}
	
	public void determineAndDisplayWinner() {
		System.out.println("--------------------------");
		if (player.isBust()) {
			System.out.println("Player BUST. You LOST");
		} else if (dealer.isBust()){
			System.out.println("Dealer BUST. You WON");
		} else if (player.getHandValue() > dealer.getHandValue()) {
			System.out.println("You WON.");
		} else if (player.getHandValue() < dealer.getHandValue()) {
			System.out.println("You LOST.");
		} else {
			System.out.println("DRAW.");
		}
		System.out.println("Your hand value: " + player.getHandValue() + "\nDealer hand value: " + dealer.getHandValue());
	}
	
}
