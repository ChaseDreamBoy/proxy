package com.xh.proxy.staticproxy;

/**
 *
 * @ClassName:  IFootBath 
 *
 * @Description:The interface of foot bath.
 *     the Subject of proxy.
 *
 * @author xiaohe
 *
 * @date: 2018年4月12日 下午4:17:30
 *
 * @version V1.0  
 *
 * @Copyright: 2018 www.xh
 *
 */
public interface IFootBath {
	
	/**
	 *   
	 * @Title: normalFootbath 
	 *
	 * @author: xiaohe
	 *
	 * @Description: The normal foot bath.
	 *
	 * @return: int
	 *     score masseur.
	 *
	 */
	int normalFootbath();
	
	/**
	 *   
	 * @Title: takeAway 
	 *
	 * @author: xiaohe
	 *
	 * @Description: Take away service.
	 *
	 * @param fee
	 *     Pay amount.
	 *
	 * @return: boolean
	 *     Whether to take away the service.
	 *
	 */
	boolean takeAway(int fee);

}
