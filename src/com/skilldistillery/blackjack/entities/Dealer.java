package com.skilldistillery.blackjack.entities;

public class Dealer extends Player{
	
	private Deck deck;
	private Hand dealerHand;

	public Dealer() {
		deck = new Deck();
		deck.shuffle();
		deck.shuffle();
		dealerHand = new BlackjackHand();
	}
	
	public Card dealCard() {
		return deck.dealCard();
	}
	
}
