package com.skilldistillery.blackjack.entities;

public class Player {
	
	private Hand playerHand;
	
	public Player() {
		playerHand = new BlackjackHand();
	}
	
	public void addCardToPlayerHand(Card card) {
		playerHand.addCard(card);
	}
	
	public String displayCard(int index) {
		return playerHand.displayCard(index);
	}
	
	public int getHandValue() {
		return playerHand.getHandValue();
	}
	
	public boolean isBust() {
		return playerHand.isBust();
	}
	
	public boolean isBlackjack() {
		return (playerHand.handSize() == 2 && getHandValue() == 21);
	}
	
	public boolean isTwentyOne() {
		return (getHandValue() == 21);
	}
	
	public int handSize() {
		return playerHand.handSize();
	}
	
}
