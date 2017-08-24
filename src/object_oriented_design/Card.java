package object_oriented_design;
/*
 * Design the data structures for a generic deck of cards. 
 * Explain how you would subclass it to implement particular card games.
 */

public class Card {

	public enum Suit {

		CLUBS(1), SPADES(2), HEARTS(3), DIAMONDS(4);
		int value;

		// constructor
		private Suit(int v) {
			value = v;
		}
	};

	private int value;
	private Suit suit;// hua se

	public Card(int r, Suit s) {
		value = r;
		suit = s;
	}

	public int getValue() {
		return value;
	}

	public Suit getSuit() {
		return suit;
	}

	/*
	 * Assume that we’re building a blackjack game, so we need to know the value
	 * of the cards. Face cards are ten and an ace is 11 (most of the time, but
	 * that’s the job of the Hand class, not the following class).
	 */

	public class BlackJackCard extends Card {

		public BlackJackCard(int r, Suit s) {
			super(r, s);
		}

		public int value() {
			int r = super.getValue();
			if (r == 1)
				return 11; // aces are 11
			if (r < 10)
				return r;
			return 10;
		}

		boolean isAce() {
			return super.getValue() == 1;
		}
	}
}
