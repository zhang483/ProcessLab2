package mainpage_increment_3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Stack;

import binary_tree_increment1.Binary_Tree;

public class Mainpage extends Frame{

	public static void main(String[] args)
	{
		Mainpage p =new Mainpage();
		Frame s = new Frame();
		p.setVisible(true);
	}
	private static final long serialVersionUID = -4209244585177465122L;
	private Binary_Tree bt;
	Mainpage()
	{
		this.setSize(3000,3000);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		TextField inputnode = new TextField("请输入初始结点的值");
		Button but = new Button("确认输入");
		Panel p = new Panel();
		p.setBounds(250,250,200,200);
		p.add(inputnode);
		p.add(but);
		this.add(p);
		but.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String p = inputnode.getText();
				if(p==null)p="null";
				int loc[] = {150,100};
				bt = new Binary_Tree(p,loc);
				Stack<Binary_Tree> s = new Stack<Binary_Tree>();
				s.add(bt);
				Mainpage.this.removeAll();
				Mainpage.this.repaint();
				new Create_Binary_Tree(s,bt,Mainpage.this);
				
			}
			
		});
		
	}
}
