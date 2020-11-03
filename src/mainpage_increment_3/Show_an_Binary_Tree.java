package mainpage_increment_3;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import binary_tree_increment1.Binary_Tree;
import travel_increment1.Aftertravel;
import travel_increment1.Beforetravel;
import travel_increment1.Leveltravel;
import travel_increment1.Middletravel;
import visualization_increment1.Binary_tree_visualization;
import visualization_increment1.Traversal_visualization;

public class Show_an_Binary_Tree extends JPanel{
	private static final long serialVersionUID = 4707838436079114800L;
	public Show_an_Binary_Tree(Binary_Tree bt, Container mainpage) {
		Button front = new Button("前序遍历");
		Button behind = new Button("后序遍历");
		Button middle = new Button("中序遍历");
		Button layer = new Button("层序遍历");
		Binary_tree_visualization vis = new Binary_tree_visualization(bt);
		Panel n = new Panel();
		n.add(front);
		n.add(behind);
		n.add(middle);
		n.add(layer);
		front.addActionListener(new ActionListener(){

			@Override
			public  void  actionPerformed(ActionEvent e) {
	            mainpage.removeAll();
	            mainpage.repaint();
	            mainpage.add(new Traversal_visualization(bt,new Beforetravel()),BorderLayout.CENTER);
	    		mainpage.add(n,BorderLayout.WEST);
	            mainpage.revalidate();
			}
		});
		middle.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
	            mainpage.removeAll();
	            mainpage.repaint();
	            mainpage.add(new Traversal_visualization(bt,new Middletravel()),BorderLayout.CENTER);
	    		mainpage.add(n,BorderLayout.WEST);
	            mainpage.revalidate();
				
			}
			
		});
		behind.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
	            mainpage.removeAll();
	            mainpage.repaint();
	            mainpage.add(new Traversal_visualization(bt,new Aftertravel()),BorderLayout.CENTER);
	    		mainpage.add(n,BorderLayout.WEST);
	            mainpage.revalidate();
				
			}
			
		});
		layer.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
	            mainpage.removeAll();
	            mainpage.repaint();
	            mainpage.add(new Traversal_visualization(bt,new Leveltravel()),BorderLayout.CENTER);
	    		mainpage.add(n,BorderLayout.WEST);
	            mainpage.revalidate();
				
			}
			
		});
		mainpage.add(vis,BorderLayout.CENTER);
		mainpage.add(n,BorderLayout.WEST);
		mainpage.revalidate();
	}

}
