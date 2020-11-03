package mainpage_increment_3;

import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import binary_tree_increment1.Binary_Tree;
import visualization_increment1.Binary_tree_visualization;

public class Create_Binary_Tree extends Panel{

	private Stack<Binary_Tree> s;
	private Binary_Tree bt;
	private Binary_tree_visualization vis;
	private Mainpage mainpage;
	public Create_Binary_Tree(Stack<Binary_Tree> s,Binary_Tree bt,Mainpage mainpage) {
		this.s = s;
		this.bt=bt;
		this.mainpage = mainpage;
		Binary_Tree node = s.pop();
		Label leftlabel = new Label("输入"+node.getNum()+"左节点");
		Label rightlabel = new Label("输入"+node.getNum()+"右节点");
		TextField left = new TextField(10);
		TextField right = new TextField(10);
		this.vis= new Binary_tree_visualization(bt);
		Button but = new Button("确认");
		Button but2 = new Button("结束");
		this.setBounds(0,0,1000,1000);
		vis.setBounds(0,200,500,500);
		this.add(leftlabel);
		this.add(left);
		this.add(rightlabel);
		this.add(right);
		this.add(but);
		this.add(but2);
		mainpage.add(vis);
		mainpage.add(this);
		mainpage.revalidate();
		but.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String leftnum;
				String rightnum;
				int loc[] = node.getloc();
				int l[] = new int[2];
				l[0] = loc[0]-25;
				l[1] = (int) (loc[1]+25*1.732);
				if(((leftnum = left.getText())!=null)&&!leftnum.equals(""))
					{
					Binary_Tree lchild = new Binary_Tree(leftnum,l);
					s.push(lchild);
					node.setLeft_child(lchild);}
				l = new int[2];
				l[0] = loc[0]+25;
				l[1] = (int) (loc[1]+25*1.732);
				if(((rightnum = right.getText())!=null)&&!rightnum.equals(""))
					{  Binary_Tree rchild = new Binary_Tree(rightnum,l);
					   s.push(rchild);
					   node.setRight_child(rchild);}			
				mainpage.removeAll();
				mainpage.repaint();
				mainpage.revalidate();
			    if(!s.isEmpty())new Create_Binary_Tree(s,bt,mainpage);
			    else new Show_an_Binary_Tree(bt,mainpage);
			}
			
		});
		but2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainpage.removeAll();
				mainpage.repaint();
				new Show_an_Binary_Tree(bt,mainpage);		
			}
			
		});
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3454805610417539786L;
}
