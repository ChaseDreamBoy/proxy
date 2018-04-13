package com.xh.proxy.staticproxy;

/**
 *
 * @ClassName:  Customer 
 *
 * @Description:The main method.
 *
 * @author xiaohe
 *
 * @date: 2018年4月12日 下午5:24:08
 *
 * @version V1.0  
 *
 * @Copyright: 2018 www.xh
 *
 */
public class Customer {

	public static void main(String[] args) {
		IFootBath footBath = new MassagistProxy();
		footBath.normalFootbath();
		System.out.println("-----------------------------");
		footBath.takeAway(1000);
		System.out.println("-----------------------------");
		footBath.takeAway(60000);
	}

}
