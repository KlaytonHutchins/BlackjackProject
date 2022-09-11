package com.skilldistillery.blackjack.entities;

public class Dealer {
	
	private Deck deck;
	private BlackjackHand dealerHand;

	public Dealer() {
		deck = new Deck();
		deck.shuffle();
		deck.shuffle();
		dealerHand = new BlackjackHand();
	}
	
	public void addCardToDealerHand(Card card) {
		dealerHand.addCard(card);
	}
	
	public Card dealCard() {
		return deck.dealCard();
	}
	
	public String displayCard(int index) {
		return dealerHand.displayCard(index);
	}
	
	public int getHandValue() {
		return dealerHand.getHandValue();
	}
	
	public boolean isBust() {
		return dealerHand.isBust();
	}
	
	public boolean isBlackjack() {
		return (dealerHand.handSize() == 2 && getHandValue() == 21);
	}
	
	public boolean isTwentyOne() {
		return (getHandValue() == 21);
	}
	
	public int handSize() {
		return dealerHand.handSize();
	}
	
}
