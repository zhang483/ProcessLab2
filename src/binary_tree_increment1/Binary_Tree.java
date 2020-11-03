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
	//AF:һ�����ΪNum������Ϊleft_child���Һ���Ϊright_child��������locλ����ʾ�Ķ�������㡣
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
	 * ��ñ�����������{x2,y2}�����һ�Ž�㣬����������
	 * @param x2  xλ������
	 * @param y2   yλ������
	 * @param bt   ��Ҫ��Ķ�����
	 * @return  ������������{x2,y2}�����һ�Ž��
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
