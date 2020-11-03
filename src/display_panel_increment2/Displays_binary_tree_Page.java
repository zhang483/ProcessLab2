package display_panel_increment2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JPanel;

import binary_tree_increment1.Binary_Tree;

/***
 * ����ฺ�𴴽���һ�Ŷ��������У���ʾһ�Ŷ�������ͬʱ�ṩ��������������λ��
 * @author DELL
 *
 */
public class Displays_binary_tree_Page extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6402096786142569327L;
	private Binary_Tree bt;
	//AF:һ����ʾ��bt�����
	//RI��bt��Ϊ�գ�bt��λ�����Բ����и���
	/**
	 * @param bt ��Ҫ��ʾ�Ķ�����
	 */
	public Displays_binary_tree_Page(Binary_Tree bt) {
		JButton front = new JButton("���滯");
		this.bt = bt;
		front.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Normalization();
				repaint();			
			}
			
		});
		this.add(front);
	}
	public void paint(Graphics g)
	{
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
	/**
	 * ��ҳ���϶�������λ���������
	 */
	private void Normalization()
	{
		Stack<Binary_Tree> s = new Stack<Binary_Tree>();
		int loc[] = {300,100};
		Map<Integer,Integer> m = new HashMap<Integer, Integer>();
		m.put(loc[0],loc[1]);
		bt.setLoc(loc);
		s.add(bt);
		while(!s.isEmpty())
		{
			Binary_Tree node = s.pop();
			loc = node.getloc();
			if(node.getLeft_child()!=null)
			{
				Binary_Tree btl = node.getLeft_child();
				int l[] = new int[2];
				l[0] = loc[0]-25;
				l[1] = (int) (loc[1]+25*1.732);
				while(m.containsKey(l[0])&&Math.abs(m.get(l[0])-l[1])<3)
				{
					l[0]-=20;
				}
				m.put(l[0],l[1]);
				btl.setLoc(l);
				s.add(btl);
			}
			if(node.getRight_child()!=null)
			{
				Binary_Tree btr = node.getRight_child();
				int l[] = new int[2];
				l[0] = loc[0]+25;
				l[1] = (int) (loc[1]+25*1.732);
				while(m.containsKey(l[0])&&Math.abs(m.get(l[0])-l[1])<3)
				{
					l[0]+=20;
				}
				m.put(l[0],l[1]);
				btr.setLoc(l);
				s.add(btr);
			}
			
		}
	}
	public void setBt(Binary_Tree bt) {
		this.bt = bt;
	}
	public Binary_Tree getBt() {
		return bt;
	}
}
