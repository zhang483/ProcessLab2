package binary_tree_increment1;

import java.util.Stack;

public class Binary_Tree implements Cloneable{
	private String num = null;
	private Binary_Tree left_child = null;
	private Binary_Tree right_child = null;
	private int [] loc = null;
	private boolean visit = false;;
	public boolean isVisit() {
		return visit;
	}
	public void setVisit(boolean visit) {
		this.visit = visit;
	}
	//AF:一个编号为Num，左孩子为left_child，右孩子为right_child。将会在loc位置显示的二叉树结点。
	public Binary_Tree(String num, int[] loc) {
		super();
		this.num = num;
		this.loc = loc;
		if(loc==null)
		{
			int []a = {100,300};
			this.loc=a;
		}
	}
	public Binary_Tree getLeft_child() {
		return left_child;
	}
	public void setLeft_child(Binary_Tree left_child) {
		this.left_child = left_child;
	}
	public Binary_Tree getRight_child() {
		return right_child;
	}
	public void setRight_child(Binary_Tree right_child) {
		this.right_child = right_child;
	}
	public int[] getloc()
	{
		return loc;
	}
	public void setLoc(int[] loc) {
		this.loc = loc;
	}
	public String getNum() {
		return num;
	}
	public double thisdrawdistance(Binary_Tree a)
	{
		return Math.sqrt((a.getloc()[0]-this.getloc()[0])*(a.getloc()[0]-this.getloc()[0])+(a.getloc()[1]-this.getloc()[1])*(a.getloc()[1]-this.getloc()[1]));
	}
	@Override
	public Binary_Tree clone()
	{
		Binary_Tree newbt = new Binary_Tree(this.getNum(),this.getloc());
		if(this.left_child!=null)newbt.setLeft_child(this.left_child.clone());
		if(this.right_child!=null)newbt.setRight_child(this.right_child.clone());
		return newbt;
	}
	/**
	 * 获得本二叉树上与{x2,y2}最近的一颗结点，不能在其上
	 * @param x2  x位置坐标
	 * @param y2   y位置坐标
	 * @param bt   需要求的二叉树
	 * @return  本二叉树上与{x2,y2}最近的一颗结点
	 */
    public static Binary_Tree Getclosenodefromloc(int x2,int y2,Binary_Tree bt)
    {
		Stack <Binary_Tree> s = new Stack<Binary_Tree>();
		s.add(bt);
		Binary_Tree father  = null;
		double min = 5000;
		while(!s .isEmpty())
		{
			Binary_Tree node = s.pop();
			
			if(Math.sqrt((x2-node.getloc()[0])*(x2-node.getloc()[0])+(y2-node.getloc()[1])*(y2-node.getloc()[1]))<min )
             {
	            if(node.getloc()[1]<y2)
	            {
	            	min = Math.sqrt((x2-node.getloc()[0])*(x2-node.getloc()[0])+(y2-node.getloc()[1])*(y2-node.getloc()[1]));
	            	father = node;
	            }
             }
			Binary_Tree btr = node.getRight_child();
			Binary_Tree btl = node.getLeft_child();
			if(btr!=null)
			{
				s.add(btr);
			}
			if(btl!=null)
			{
				s.add(btl);
			}
		}
		return father;
    }
}
