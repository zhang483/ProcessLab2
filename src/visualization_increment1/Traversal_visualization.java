package visualization_increment1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.util.List;
import java.util.Stack;

import binary_tree_increment1.Binary_Tree;
import travel_increment1.Travel;

public class Traversal_visualization extends Panel{
	private static final long serialVersionUID = 4836038528741008071L;
	private Binary_Tree bt;
	private Travel travel;
	//AF:一颗二叉树bt,用travel遍历后绘制过程。travel_increment1：绘制中采用的遍历方法
	public Traversal_visualization(Binary_Tree bt, Travel travel) {
		super();
		this.bt = bt;
		this.travel = travel;
	}
	public void setTravel(Travel travel) {
		this.travel = travel;
	}	
	@Override
    public void  paint(Graphics g) {
		super.paint(g);
		Stack<Binary_Tree> s = new Stack<Binary_Tree>();
		s.add(bt);
		g.setColor(Color.BLUE);
		while(!s.isEmpty())
		{
			Binary_Tree node = s.pop();
			Binary_Tree btr = node.getRight_child();
			Binary_Tree btl = node.getLeft_child();
			g.drawOval(node.getloc()[0],node.getloc()[1],20,20);
			g.drawString(node.getNum(),node.getloc()[0],node.getloc()[1]);
			if(btr!=null)
			{
				s.add(btr);
				g.drawLine(btr.getloc()[0]+10,btr.getloc()[1]+10,node.getloc()[0]+10,node.getloc()[1]+10);
			}
			if(btl!=null)
			{
				s.add(btl);
				g.drawLine(btl.getloc()[0]+10,btl.getloc()[1]+10,node.getloc()[0]+10,node.getloc()[1]+10);
			}
		}
		List<int[]> locs = this.travel.travel(bt);
		Integer counter =0;
		for(int []loc:locs)
		{
			g.fillOval(loc[0],loc[1],20,20);
			g.drawString(counter.toString(),loc[0]-10, loc[1]-10);
			try {
				Thread.sleep(1000);
				counter++;
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return;
    }
	
}
