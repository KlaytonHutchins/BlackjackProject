package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand{
	
	public BlackjackHand() {
		super();
	}

	@Override
	public int getHandValue() {
		int handValue = 0;
		for (Card card : cardsInHand) {
			handValue += card.getValue();
		}
		return handValue;
	}
	
	public boolean isBlackjack() {
		if (cardsInHand.size() == 2 && getHandValue() == 21) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isBust() {
		if (getHandValue() > 21) {
			return true;
		} else {
			return false;
		}
	}
	
//	public boolean isHard() {
//		
//		return true;
//	}
//	
//	public boolean isSoft() {
//		
//		return true;
//	}
	
}
