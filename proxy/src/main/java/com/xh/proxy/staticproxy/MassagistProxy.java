package com.xh.proxy.staticproxy;

/**
 *
 * @ClassName:  MassagistProxy 
 *
 * @Description:The receptionist >> ProxySubject.
 *
 * @author xiaohe
 *
 * @date: 2018年4月12日 下午4:41:15
 *
 * @version V1.0  
 *
 * @Copyright: 2018 www.xh
 *
 */
public class MassagistProxy implements IFootBath {
	
	/**
	 * 
	 * Subject
	 * 
	 */
	private IFootBath footBath;
	
	public MassagistProxy() {
		super();
	}

	public MassagistProxy(IFootBath footBath) {
		super();
		this.footBath = footBath;
	}
	
	/**
	 *
	 * <p>Title: normalFootbath</p>   
	 *
	 * <p>Description: </p>   
	 *
	 * @return   
	 *
	 * @see com.xh.proxy.staticproxy.IFootBath#normalFootbath()   
	 *
	 */
	public int normalFootbath() {
		// Extension function start ...
		System.out.println("[ProxySubject] customer want to normalFootbath...");
		System.out.println("[ProxySubject] pay the fees...");
		int score = getFootBath().normalFootbath();
		// Extension function end ...
		return score;
	}

	/**
	 *
	 * <p>Title: takeAway</p>   
	 *
	 * <p>Description: </p>   
	 *
	 * @param fee
	 * 
	 * @return   
	 *
	 * @see com.xh.proxy.staticproxy.IFootBath#takeAway(int)   
	 *
	 */
	public boolean takeAway(int fee) {
		// Extension function start ...
		System.out.println("[ProxySubject] customer want to takeAway...");
		System.out.println("[ProxySubject] check customer's CID...");
		// Extension function end ...
		return getFootBath().takeAway(fee);
	}
	
	private IFootBath getFootBath() {
		if (this.footBath == null) {
			footBath = new Masseuse.Builder()
					.setAge(22)
					.setFaceScore(80)
					.setNickName("xs")
					.setPrice(5000)
					.setSkill(85).build();
		}
		return footBath;
	}

}
