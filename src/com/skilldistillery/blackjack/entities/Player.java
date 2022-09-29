package com.skilldistillery.blackjack.entities;

public class Player {
	
	protected Hand myHand;
	
	public Player() {
		myHand = new BlackjackHand();
	}
	
	public void addCardToMyHand(Card card) {
		myHand.addCard(card);
	}
	
	public String displayCard(int index) {
		return myHand.displayCard(index);
	}
	
	public int getHandValue() {
		return myHand.getHandValue();
	}
	
	public boolean isBust() {
		return myHand.isBust();
	}
	
	public boolean isBlackjack() {
		return (myHand.handSize() == 2 && getHandValue() == 21);
	}
	
	public boolean isTwentyOne() {
		return (getHandValue() == 21);
	}
	
	public int handSize() {
		return myHand.handSize();
	}
	
}
