package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	private List<Card> deck = new ArrayList<>();
	
	public Deck() {
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deck.add(new Card(suit, rank));
			}
		}
	}
	
	public int checkDeckSize() {
		return deck.size();
	}
	
	public Card dealCard() {
		return deck.remove(0);
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
}
