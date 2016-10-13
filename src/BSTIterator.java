import java.util.Stack;


public class BSTIterator {
    
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	
	}
    Stack<TreeNode> stack;
    

    public BSTIterator(TreeNode root) {
       stack = new Stack<TreeNode>();
       while(root != null){
           stack.push(root);
           root = root.left;
       }
    }


    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tempN = stack.pop();
        int val = tempN.val;
        if(tempN.right != null){
            tempN = tempN.right;
            while(tempN != null){
                stack.push(tempN);
                tempN = tempN.left;
            }
        }
        
        return val;
    }
}
