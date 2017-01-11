package threecard.domain;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import threecard.util.CardComparator;

/**
 * 定义的牌 
 *    牌有花色 
 *       黑桃 4、红桃 3、梅花 2、方块 1（从大到小） 
 *    牌有点数 
 *       2 3 4 5 6 7 8 9 10 11 J 12 Q 13 K 14 A 
 *       
 *    牌有图片路径地址 2_4.jpg //规则自己定义
 * 
 * @author chj
 *
 */
public class Card {

	// 花色
	private int color;
	// 点数
	private int point;
	// 图片url路径地址
	private String url;
	
	//提供52张牌
	public static Card cards[]=new Card[52];
	//随机产生牌下标操作对象
	private static Random rd = new Random();
	
	public static CardComparator cardComparator = new CardComparator();
	/**
	 * 豹子
	 */
	public static final int LEOPARD=7;
	/**
	 * 同花顺
	 */
	public static final int FLUSH =6;
	/**
	 * 同花
	 */
	public static final int WITH_FLOWERS =5;
	/**
	 * 顺子
	 */
	public static final int SHUN_ZI =4;
	/**
	 * 对子
	 */
	public static final int SUB =3;
	/**
	 * 单张
	 */
	public static final int LEAFLETS =2;
	/**
	 * 特殊
	 */
	public static final int SPECIAL =1;
	
	

	
	// 静态块
	static {
		// 接口对象 接口实现类的对象
		Set<Card> set = new HashSet<Card>();
		// 遍历花色
		for (int color = 1; color <= 4; color++) {
			// 遍历点数
			for (int point = 2; point <= 14; point++) {
				// 创建牌对象
				Card card = new Card(color, point, color + "_" + point + ".jpg");
				// 添加到集合中
				set.add(card);
			}
		}
		//转换成数组
		cards=set.toArray(cards);
	}

	/**
	 * 构造函数
	 * 
	 * @param color
	 * @param point
	 * @param url
	 */
	public Card(int color, int point, String url) {
		super();
		this.color = color;
		this.point = point;
		this.url = url;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		// 自定义规则
		if (obj instanceof Card) {
			// 获取比较的牌
			Card card = (Card) obj;
			// 判断花色与点数一致 ，我们认为是同一个牌
			if (this.color == card.color && this.point == card.point) {
				return true;
			}

		}

		return false;
	}

	@Override
	public int hashCode() {
		return (color + "_" + point).hashCode();
	}

	// 提供共有的getXxx() 来获取对应属性值
	public int getColor() {
		return color;
	}

	public int getPoint() {
		return point;
	}

	public String getUrl() {
		return url;
	}

	@Override
	public String toString() {

		String color = "";
		switch (this.color) {
		case 4:
			color = "黑桃";
			break;

		case 3:
			color = "红桃";
			break;
		case 2:
			color = "梅花";
			break;
		case 1:
			color = "方块";
			break;
		}

		String point = "";
		switch (this.point) {
		case 11:
			point = "J";
			break;
		case 12:
			point = "Q";
			break;
		case 13:
			point = "K";
			break;
		case 14:
			point = "A";
			break;
		default:
			point = String.valueOf(this.point);
			break;
		}

		return "Card [color=" + color + ", point=" + point + ", url=" + url + "]";
	}

	
	
	/**
	 * 发牌动作
	 * 传递的是引用数据类型
	 * @param cards
	 */
	public static void sendCards(Card cds[]){
		//存储牌
		Set<Card> set = new HashSet<Card>();
		//发三张牌
		for(int i=0;i<3;i++){
			//随机产生一个下标
		    int index = rd.nextInt(cards.length);
		    System.out.println(index);
		    //取出牌
		    Card card = cards[index];
		    //判断set集合中是否含有这个牌
		    if(set.contains(card)){
		    	i--;
		    }else{
		    	//加入到集合中
		    	set.add(card);
		    }
		}
		//转换成数组
		cds = set.toArray(cds);
	}

}


/*
 * 1、豹子（AAA最大，222最小）。 7
 * 2、同花顺（AKQ最大，A23最小）。6 
 * 3、同花（AKJ最大，352最小）。5 
 * 4、顺子（AKQ最大，234最小）。4
 * 5、对子（AAK最大，223最小）。 3
 * 6、单张（AKJ最大，352最小）。2 
 * 7、特殊牌 2 3 5           1
 */