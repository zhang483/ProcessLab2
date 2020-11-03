package travel_increment1;

import java.util.ArrayList;
import java.util.List;

import binary_tree_increment1.Binary_Tree;

public class Beforetravel implements Travel{

	private List<int[]> l =new ArrayList<int[]>();
	@Override
	public List<int[]> travel(Binary_Tree bt) {
		l.add(bt.getloc());
		if(bt.getLeft_child()!=null)this.travel(bt.getLeft_child());
		if(bt.getRight_child()!=null)this.travel(bt.getRight_child());
		return l;
	}

}
