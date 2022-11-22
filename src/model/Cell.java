package model;


/**
 * 
* @Description 单元格对象---->两种状态0：没有牌 1：有牌
* @author TimTim Email:754595995@qq.com
* @version 
* @date 2022年11月4日下午8:01:54
*
 */
public class Cell {
	private Integer state = 0;
	private Brand brand;
	private Integer floor;
	private Integer x;
	private Integer y;
	private Integer type;
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}	
}
