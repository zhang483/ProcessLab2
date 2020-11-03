package program_increment4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import binary_tree_increment1.Binary_Tree;
import display_panel_increment2.Displays_binary_tree_Page;
import display_panel_increment2.Momento;
/**
 * ����ฺ��
 * @author DELL
 *
 */
public class Create_Binary_Tree extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1120337579452880085L;
	public Binary_Tree getBt() {
		return bt;
	}
	private JPanel mainpanel;
	private Displays_binary_tree_Page decorate;
	private Integer num;
	private Momento mem;
	private Binary_Tree bt;
	public static void main(String args[])
	{
		JFrame fr = new JFrame();
		fr.setLayout(new BorderLayout());
		int loc[] = {300,300};
		fr.add(new Create_Binary_Tree(new Binary_Tree("0",loc)),BorderLayout.CENTER);
		fr.setVisible(true);
		
	}
	//AF:һ���������ɶ�����������壬����ͨ��������ɶ����������ɵľ���bt��
	private JButton laststep = new JButton("��һ��");
	{
		laststep.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Binary_Tree oldbt = mem.get_last(bt);
		        if(oldbt==null)return;
		        bt = oldbt;
				decorate.setBt(oldbt);
				decorate.repaint();
			}
			
		});
	}
	public Create_Binary_Tree(Binary_Tree bt) {
		super();
		this.decorate = new Displays_binary_tree_Page(bt);
		this.bt = bt;
		this.mainpanel = new JPanel();
		this.mem = new Momento();
		this.num = 1;
		this.decorate.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				int x2 = e.getX();// �õ�����ɿ��ĵ�����
				int y2 = e.getY();
				int loc[] = {x2,y2};
				Binary_Tree node = new Binary_Tree(num.toString(),loc);
				Binary_Tree bt = Create_Binary_Tree.this.bt;
				Binary_Tree father = Binary_Tree.Getclosenodefromloc(x2, y2,bt);//�����ж������㵽������
				if (father == null)return;
				else if (father.getloc()[0] > x2) {
					mem.set_last(bt.clone());
					if (father.getLeft_child() == null)
						{father.setLeft_child(node);//���û�к���ֱ������
						decorate.repaint();}
					else {
						Binary_Tree old = father.getLeft_child();
						if (old.thisdrawdistance(father) >node.thisdrawdistance(father)) 
						{
							father.setLeft_child(node);
						    node.setLeft_child(old);
							decorate.repaint();
						} //����ͺ��Ӿ����ֱ��ȡ��������ֱ������
						else return;
					}

				  } 
				else if (father.getloc()[0] <= x2){
					mem.set_last(bt.clone());
					if (father.getRight_child() == null)
						{father.setRight_child(node);
						 decorate.repaint();
						}
					else {
						Binary_Tree old = father.getRight_child();
						if (old.thisdrawdistance(father) >node.thisdrawdistance(father)) 
						{
							father.setRight_child(node);
							node.setRight_child(old);
							decorate.repaint();
						} else return;
					}
				}
				num++;
			}
			});//�������
		mainpanel.setLayout(new BorderLayout());
		mainpanel.add(decorate,BorderLayout.CENTER);
		mainpanel.add(this.laststep,BorderLayout.SOUTH);
		this.setLayout(new BorderLayout());
		this.add(mainpanel,BorderLayout.CENTER);
	}
	
}
