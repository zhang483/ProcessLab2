package travel_increment1;

import java.util.List;

import binary_tree_increment1.Binary_Tree;

public interface Travel {
    /**
     * 
     * @param bt 二叉树
     * @return 输出的是遍历到的结点坐标
     */
	public List<int[]> travel(Binary_Tree bt);
}
