package util;

import javax.swing.JFrame;

import model.Brand;
import model.Cell;
import model.ExtraLayer;
import model.Layer;

import test.TestButton;

public class MarkUtil extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void reset(JFrame jFrame) {
		Brand brand = TestButton.mark.getLastBrand().peek();
		
		brand.getLastCell().setBrand(brand);
		brand.getLastCell().setState(1);
		brand.setCell(brand.getLastCell());
		//brand.setBounds(brand.getMx(),brand.getMy(), 50,50);
		/*brand.setMx(brand.getLastX());
		brand.setMy(brand.getLastY());*/
		int type = brand.getCell().getType();
		int index = brand.getCell().getFloor();
		int x = brand.getCell().getX();
		int y = brand.getCell().getY();
		if (type == 0) {
			Layer layer = TestButton.map.getList().get(index - 1);
			Cell[][] cells = layer.getCells();
			cells[x][y] = brand.getCell();
			layer.setCells(cells);
			TestButton.map.getList().set(index - 1, layer);
		}else{
			ExtraLayer layer = TestButton.map.getExtraList().get(index - 1);
			Cell[][] cells = layer.getCells();
			cells[x][y] = brand.getCell();
		}		
		brand.setBounds(10,950, 50,50);
		jFrame.getContentPane().add(brand);
		TestButton.map.compareAll();
		
	}
}
