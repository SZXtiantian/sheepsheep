package model;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import test.TestButton;
import util.MapUtil;
import view.Start;

/**
 * 
* @Description 一个牌
* @author TimTim Email:754595995@qq.com
* @version
* @date 2022年11月4日下午5:28:58
*
 */
public class Brand extends Component{


	private static final long serialVersionUID = 1L;
	//牌名
	private String name;	
	//是否置灰
	private Boolean isGray;	
	//正常图
	private Image image;	
	//灰图
	private Image grayImage;	
	private Integer x;	
	private Integer y;
	private Integer mx;	
	private Integer my;
	private Integer lastX;	
	private Integer lastY;
	@SuppressWarnings("unused")
	private Integer wigth;	
	@SuppressWarnings("unused")
	private Integer height;
	EliminateBox eliminateBox = new EliminateBox();
	private Cell cell;
	private Cell lastCell;
	@Override
	public String getName() {
		return name;
	}

//	public Brand(String name, int num){
//		this.name = name;
//		
//		this.image = Toolkit.getDefaultToolkit().getImage("imgs\\"+name+".png");
//		
//		this.isGray = false;
//		this.wigth = 50;
//		this.height = 50;
//		
//		this.x = 0;
//		this.y = 0;
//		cell.setState(num);
//		
//	}
	// 对应img下图片的前缀
	public Brand(String name, boolean t){
		this.name = name;
		this.image = Toolkit.getDefaultToolkit().getImage("imgs\\"+name+".png");
		this.grayImage = Toolkit.getDefaultToolkit().getImage("imgs\\"+name+".png");
		
		this.isGray = true;
		this.wigth = 50;
		this.height = 50;
		
		this.x = 0;
		this.y = 0;
	}
	public Brand(String name){
		this.name = name;
		
		this.image = Toolkit.getDefaultToolkit().getImage("imgs\\"+name+".png");
		this.grayImage = Toolkit.getDefaultToolkit().getImage("imgs\\"+name+"_gray.png");
		
		this.isGray = false;
		this.wigth = 50;
		this.height = 50;
		
		this.x = 0;
		this.y = 0;
		this.lastX = 0;
		this.lastY = 0;
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			//点一下鼠标（监听）响应才会执行
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				System.out.println("Brand.mouseClick!");
				Brand brand = (Brand)e.getSource();//获取当前组件
				
				if (brand.getIsGray()) {
					return;
				}else{
					if (!TestButton.mark.getLastBrand().isEmpty()) {
						TestButton.mark.getLastBrand().pop();
					}
					System.out.println(brand.name);
					brand.lastX = brand.mx;
					brand.lastY = brand.my;
					//brand.lastCell = brand.cell;
					TestButton.mark.getLastBrand().add(brand);
					boolean isReborn = eliminateBox.addSlot(brand);
					/**
					 * 修改了这里
					 */
					if (isReborn) {
						if (cell.getState() != 2) {
							cell.setState(0);
							cell.setBrand(null);
						}
						MapUtil.buildExtra(TestButton.map);
					}
					else{
						if (cell.getState() != 2) {
							cell.setState(0);
							cell.setBrand(null);
						}
					}
					
					
					//有待修改
					//TestRenderMap.map.compareAll();
					TestButton.map.compareAll();
					Start.map.compareAll();
					if (Start.map.isEmpty()) {
						JOptionPane.showMessageDialog(null, "You win!!!");
					}
					if (TestButton.map.isEmpty()) {
						JOptionPane.showMessageDialog(null, "You win!!!");
						System.exit(0);
					}
				}
				
				//brand.getParent().remove(brand);//调用上层容器删掉自己（树型多用此结构）
			}
		});
	}
	
	
	@Override
	public void paint(Graphics g) {
//		// TODO Auto-generated method stub
//		super.paint(g);
		if (this.isGray == true) {
			//绘制灰色
			g.drawImage(this.grayImage, this.x, this.y, null);
		}else{
			//绘制正常图片
			g.drawImage(this.image, this.x, this.y, null);
		}
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getIsGray() {
		return isGray;
	}
	public void setIsGray(Boolean isGray) {
		this.isGray = isGray;
	}
	public java.awt.Image getImage() {
		return image;
	}
	public void setImage(java.awt.Image image) {
		this.image = image;
	}
	public java.awt.Image getGrayImage() {
		return grayImage;
	}
	public void setGrayImage(java.awt.Image grayImage) {
		this.grayImage = grayImage;
	}
	public Integer getx() {
		return x;
	}
	public void setx(Integer x) {
		this.x = x;
	}
	public Integer gety() {
		return y;
	}
	public void sety(Integer y) {
		this.y = y;
	}
/*	public Integer getWigth() {
		return wigth;
	}
	public void setWigth(Integer wigth) {
		this.wigth = wigth;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	
	*/
	public Cell getCell() {
		return cell;
	}


	public void setCell(Cell cell) {
		this.cell = cell;
	}

	public Integer getLastX() {
		return lastX;
	}

	public void setLastX(Integer lastX) {
		this.lastX = lastX;
	}

	public Integer getLastY() {
		return lastY;
	}

	public void setLastY(Integer lastY) {
		this.lastY = lastY;
	}

	public Cell getLastCell() {
		return lastCell;
	}

	public void setLastCell(Cell lastCell) {
		this.lastCell = lastCell;
	}

	public Integer getMx() {
		return mx;
	}

	public void setMx(Integer mx) {
		this.mx = mx;
	}

	public Integer getMy() {
		return my;
	}

	public void setMy(Integer my) {
		this.my = my;
	}
}
