package program_increment4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import binary_tree_increment1.Binary_Tree;
import display_panel_increment2.Display_and_traverse;

import java.awt.CardLayout;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main_page extends JFrame {
	private static final long serialVersionUID = -4104486053139879333L;
	private JPanel contentPane;
	private JButton jumptovisit = new JButton("开始遍历");
	private JSplitPane create_with_button = new JSplitPane();
	private JPanel visit = new JPanel();
	private Create_Binary_Tree create_Binary_Tree;
	{
		int loc[] = {300,300};
		create_Binary_Tree = new Create_Binary_Tree(new Binary_Tree("0",loc));
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_page frame = new Main_page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(create_with_button, "create");
		create_with_button.setLeftComponent(jumptovisit);
		contentPane.add(visit, "visit");
		create_with_button.setRightComponent(create_Binary_Tree);//create_with_button加组件
		jumptovisit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visit.setLayout(new BorderLayout());
				visit.add(new Display_and_traverse(create_Binary_Tree.getBt()),BorderLayout.CENTER);
				((CardLayout)contentPane.getLayout()).show(contentPane,"visit");
			}
		});	
	}

}
