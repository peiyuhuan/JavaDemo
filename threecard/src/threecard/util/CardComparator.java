package threecard.util;

import java.util.Comparator;

import threecard.domain.Card;

/**
 * 数组排序： Comparator接口 强行对某个对象 collection 进行整体排序 的比较函数
 * 
 * @author Administrator
 *
 */
public class CardComparator implements Comparator<Card> {

	@Override
	public int compare(Card o1, Card o2) {
		//排除null对象的情况
		if (o1 == null || o2 == null) {
			return 0;
		} else {
			return o1.getPoint() - o2.getPoint();
		}
	}

}
