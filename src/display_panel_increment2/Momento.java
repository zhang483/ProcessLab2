package display_panel_increment2;

import java.util.Stack;

import binary_tree_increment1.Binary_Tree;

public class Momento {
	
	private Stack<Binary_Tree> last = new Stack<Binary_Tree>();
	private Stack<Binary_Tree> next = new Stack<Binary_Tree>();
	public Binary_Tree get_last(Binary_Tree bt)
	{
		if(last.isEmpty())return null;
		Binary_Tree lbt = last.pop();
		next.push(bt);
		return lbt;
	}
	public Binary_Tree get_next(Binary_Tree bt)
	{
		if(next.isEmpty())return null;
		Binary_Tree nbt = next.pop();
		last.push(bt);
		return nbt;
	}
	public void set_last(Binary_Tree bt)
	{
		last.push(bt);
	}
}
