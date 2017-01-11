package threecard.test;

import org.junit.Test;

import threecard.domain.Card;

public class CardTest {

	@Test
	public void test1(){
		//获取52张牌
		Card[] cards = Card.cards;
		
		for(Card card:cards){
			System.out.println(card);
		}
	}
}
