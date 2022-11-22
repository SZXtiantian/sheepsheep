package model;

import java.util.Stack;

public class Mark {
	private static Stack<Brand>lastBrand = new Stack<>();

	public Stack<Brand> getLastBrand() {
		return lastBrand;
	}

	public void setLastBrand(Stack<Brand> lastBrand) {
		Mark.lastBrand = lastBrand;
	}
	
}
