package display_panel_increment2;

import javax.swing.JPanel;

import binary_tree_increment1.Binary_Tree;
import travel_increment1.Aftertravel;
import travel_increment1.Beforetravel;
import travel_increment1.Leveltravel;
import travel_increment1.Middletravel;
import travel_increment1.Travel;
import visualization_increment1.Traversal_visualization;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Frame;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * 这个类负责对Show_Binary_Tree进行包装，让他能完成页面跳转的功能。
 * @author DELL
 *
 */
public class Display_and_traverse extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6172432212708576383L;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	//AF:panel上由两个组件组成的页面，panel_1会放上二叉树展示模块、panel_2会放上跳转模块
	/**
	 * Create the panel.
	 */
	public Display_and_traverse(Binary_Tree bt) {
		setLayout(new CardLayout(0, 0));	
		panel_1 = new JPanel();
		add(panel_1, "name_950084977651400");
		panel = new JPanel();
		add(panel, "name_950082758578100");		
		panel.setLayout(new BorderLayout(0, 0));
		panel_1.setLayout(new BorderLayout(0, 0));
		Component show_an_Binary_Tree = new Displays_binary_tree_Page(bt);
		panel_1.add(show_an_Binary_Tree);
		panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		/**
		 * 这个内部私有类会把bt导向生成模块
		 * @author DELL
		 *
		 */
		class ActionListenertravel_choose implements ActionListener{

			private Travel tr;
			ActionListenertravel_choose(Travel tr)
			{
				this.tr = tr;
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame fm = new Frame();
				fm.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e)
					{
						System.exit(0);
					}
					
				});
				fm.setVisible(true);
				fm.add(new Traversal_visualization(bt,tr));
			}
		}
		
		
		JButton btnNewButton = new JButton("前序遍历");
		btnNewButton.addActionListener(new ActionListenertravel_choose(new Beforetravel()));
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("中序遍历");
		btnNewButton_1.addActionListener(new ActionListenertravel_choose(new Middletravel()));
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("后序遍历");
		btnNewButton_2.addActionListener(new ActionListenertravel_choose(new Aftertravel()));
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("层序遍历");
		btnNewButton_3.addActionListener(new ActionListenertravel_choose(new Leveltravel()));
		panel_2.add(btnNewButton_3);

	}

}
