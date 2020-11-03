package visualization_increment1;
import java.awt.*;
import java.util.Stack;

import binary_tree_increment1.Binary_Tree;
public class Binary_tree_visualization extends Panel{
	
	private static final long serialVersionUID = 8175815896146163363L;
	private Binary_Tree bt=null;
	//AF：这个是一个面板，我用它来绘制二叉树
	public Binary_tree_visualization(Binary_Tree bt) {
		super();
		this.bt = bt;
	}
	@Override
	/**
	 * 绘制一颗二叉树
	 */
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
		return;
    }
	
}
