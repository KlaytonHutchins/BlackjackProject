package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	
	protected List<Card> cardsInHand;
	
	public Hand() {
		cardsInHand = new ArrayList<>();
	}
	
	public void addCard(Card card) {
		cardsInHand.add(card);
	}
	
	public void clear() {
		
	}
	
	public abstract int getHandValue();

	public String displayCard(int index) {
		return cardsInHand.get(index).toString();
	}
	
	public int handSize() {
		return cardsInHand.size();
	}
	
	public abstract boolean isBust();
	
	public abstract boolean isBlackjack();
	
}
