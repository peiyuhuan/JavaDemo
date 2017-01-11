package threecard.test;

import java.util.Arrays;

import org.junit.Test;

import threecard.domain.Card;
import threecard.domain.Player;
import threecard.util.CardComparator;

public class PlayerTest {

	@Test
	public void test1(){
		//创建玩家
		Player player1 = new Player();
		//设置玩家名称
		player1.setName("xx土豆");
		//设置分数
		player1.setScore(0);
	
		//先发牌
		Card.sendCards(player1.getCards());
		
		
		//获取牌
		Card[] cards = player1.getCards();
		
		
		
		//遍历玩家的三张牌
		for(Card card:cards){
			System.out.println(card);
		}
		
		
		
		
		int cardType = player1.getCardType();
		
		switch (cardType) {
		case Card.LEOPARD:
			 System.out.println("牌型@@@豹子");
			break;
		case Card.FLUSH:
			 System.out.println("牌型@@@同花顺");
			break;
		case Card.WITH_FLOWERS:
			 System.out.println("牌型@@@同花");
			break;
		case Card.SHUN_ZI:
			 System.out.println("牌型@@@顺子");
			break;
		case Card.SUB:
			 System.out.println("牌型@@@对子");
			break;
		case Card.LEAFLETS:
			 System.out.println("牌型@@@单张");
			break;

		case Card.SPECIAL:
			 System.out.println("牌型@@@特殊");
			break;
		 default:
			 System.out.println("没有牌型");
			 break;

		}
	
	}
	
	
	
	@Test
	public void test2(){
		//创建玩家
		Player player1 = new Player();
		//设置玩家名称
		player1.setName("xx土豆");
		//设置分数
		player1.setScore(0);
		
		Card[] xx = new Card[3];
		
		xx[0]=new Card(4, 3, "");
		xx[1]=new Card(3, 2, "");
		xx[2]=new Card(4, 14, "");
		//先发牌
		//Card.sendCards(player1.getCards());
		
		player1.setCards(xx);
		//获取牌
		Card[] cards = player1.getCards();
		
		
		
		//遍历玩家的三张牌
		for(Card card:cards){
			System.out.println(card);
		}
		
		
		
		
		int cardType = player1.getCardType();
		
		switch (cardType) {
		case Card.LEOPARD:
			 System.out.println("牌型@@@豹子");
			break;
		case Card.FLUSH:
			 System.out.println("牌型@@@同花顺");
			break;
		case Card.WITH_FLOWERS:
			 System.out.println("牌型@@@同花");
			break;
		case Card.SHUN_ZI:
			 System.out.println("牌型@@@顺子");
			break;
		case Card.SUB:
			 System.out.println("牌型@@@对子");
			break;
		case Card.LEAFLETS:
			 System.out.println("牌型@@@单张");
			break;

		case Card.SPECIAL:
			 System.out.println("牌型@@@特殊");
			break;
		 default:
			 System.out.println("没有牌型");
			 break;

		}
	
	}
}
