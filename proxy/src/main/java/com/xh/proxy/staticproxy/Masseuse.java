package com.xh.proxy.staticproxy;

import java.util.Random;

/**
 *
 * @ClassName:  Masseuse 
 *
 * @Description:The Masseuse  -- RealSubject
 *
 * @author xiaohe
 *
 * @date: 2018年4月12日 下午4:24:45
 *
 * @version V1.0  
 *
 * @Copyright: 2018 www.xh
 *
 */
public class Masseuse implements IFootBath {

	/**
	 * 
	 * The Masseuse age.
	 * 
	 */
	private int age;
	
	/**
	 * 
	 * the skill of this Masseuse.
	 * 
	 */
	private int skill;
	
	/**
	 * 
	 * the faceScore of this Masseuse.
	 * 
	 */
	private int faceScore; 
	
	/**
	 * 
	 * She's nick name.
	 * 
	 */
	private String nickName;
	
	/**
	 * 
	 * the price.
	 * 
	 */
	private int price;
	
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
		System.out.println("[real subject] Masseuse >> "+ nickName + " will serve you, do footbath, chatting, blah blah blah...");
		return skill + (28 - age) + faceScore - new Random().nextInt(30);
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
		boolean canTakeAway = (fee >= price && price > 0);
		if(canTakeAway) {
			System.out.println("[real subject] Oh boss, you can ask me out!");
		} else {
			System.out.println("[real subject] Sorry, I'M NOT WHO YOU THINK I AM.");
		}
		return canTakeAway;
	}
	
	public Masseuse() {
		super();
	}

	public Masseuse(int age, int skill, int faceScore, String nickName, int price) {
		super();
		this.age = age;
		this.skill = skill;
		this.faceScore = faceScore;
		this.nickName = nickName;
		this.price = price;
	}
	
	public Masseuse(Masseuse buildMasseuse) {
		super();
		this.age = buildMasseuse.age;
		this.skill = buildMasseuse.skill;
		this.faceScore = buildMasseuse.faceScore;
		this.nickName = buildMasseuse.nickName;
		this.price = buildMasseuse.price;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSkill() {
		return skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}

	public int getFaceScore() {
		return faceScore;
	}

	public void setFaceScore(int faceScore) {
		this.faceScore = faceScore;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 *
	 * @ClassName:  Builder 
	 *
	 * @Description:Builder model.
	 *
	 * @author xiaohe
	 *
	 * @date: 2018年4月12日 下午4:35:02
	 *
	 * @version V1.0  
	 *
	 * @Copyright: 2018 www.xh
	 *
	 */
	public static class Builder {
		
		private Masseuse masseuse;

		public Builder () {
			masseuse = new Masseuse();
		}

		public Builder setAge(int age) {
			masseuse.age = age;
			return this;
		}

		public Builder setSkill(int skill) {
			masseuse.skill = skill;
			return this;
		}

		public Builder setFaceScore(int faceScore) {
			masseuse.faceScore = faceScore;
			return this;
		}

		public Builder setNickName(String nickName) {
			masseuse.nickName = nickName;
			return this;
		}

		public Builder setPrice(int price) {
			masseuse.price = price;
			return this;
		}
		
		public Masseuse build () {
			return new Masseuse(masseuse);
		}
		
	}

}
