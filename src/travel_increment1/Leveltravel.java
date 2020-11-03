package travel_increment1;

import java.util.ArrayList;
import java.util.List;

import binary_tree_increment1.Binary_Tree;

public class Leveltravel implements Travel {

	@Override
	public List<int[]> travel(Binary_Tree bt) {
		List<int[]> locs = new ArrayList<int []>();
		List<Binary_Tree> s = new ArrayList<Binary_Tree>();
		s.add(bt);
		while(!s.isEmpty())
		{
			Binary_Tree node = s.get(0);
			s.remove(0);
			locs.add(node.getloc());
			Binary_Tree btr = node.getRight_child();
			Binary_Tree btl = node.getLeft_child();
			if(btl!=null)
			{
				s.add(btl);
			}
			if(btr!=null)
			{
				s.add(btr);
			}

		}
		return locs;
	}

}
