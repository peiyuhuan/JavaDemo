package threecard.domain;

import java.util.Arrays;

import threecard.util.CardComparator;

/**
 * 定义玩家类
 * 
 * @author chj
 *
 */
public class Player {

	// 昵称
	private String name;
	// 玩家分数
	private int score;
	// 玩家牌
	private Card[] cards = new Card[3];
	// 牌型
	private int cardType;


	/**
	 * 默认构造函数
	 */
	public Player() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Card[] getCards() {
		Arrays.sort(cards,Card.cardComparator);
		return cards;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
	}

	public int getCardType() {
		//根据玩家的牌,来获取牌型
		Card cards[]= getCards();
		
		//豹子情况
		if(cards[0].getPoint()==cards[1].getPoint()&&cards[0].getPoint()==cards[2].getPoint()){
			return Card.LEOPARD;
		}else if(cards[0].getPoint()+1==cards[1].getPoint()&&cards[1].getPoint()+1==cards[2].getPoint()){
			if(cards[0].getColor()==cards[1].getColor()&&cards[1].getColor()==cards[2].getColor()){ //同花顺
				return Card.FLUSH;
			}else{
				return Card.SHUN_ZI; //顺子
			}
			
		}else if(cards[0].getPoint()==2&&cards[1].getPoint()==3&&cards[2].getPoint()==14){
            if(cards[0].getColor()==cards[1].getColor()&&cards[1].getColor()==cards[2].getColor()){ //同花顺
            	return Card.FLUSH;
			}else{
				return Card.SHUN_ZI ;//顺子
			}
		}else if(cards[0].getPoint()==cards[1].getPoint()||cards[1].getPoint()==cards[2].getPoint()){
		    return Card.SUB; //对子
		}else{
		
			//判断花色是否一致
			if(cards[0].getColor()==cards[1].getColor()&&cards[0].getColor()==cards[2].getColor()){
				return Card.WITH_FLOWERS;//同花
			}else{
				if(cards[0].getPoint()==2&&cards[1].getPoint()==3&&cards[2].getPoint()==5){
					return Card.SPECIAL;//特殊
				}else{
					return Card.LEAFLETS;//单张
				}
			}
			
		}
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", score=" + score + ", cards=" + Arrays.toString(cards) + ", cardType="
				+ cardType + "]";
	}
}
