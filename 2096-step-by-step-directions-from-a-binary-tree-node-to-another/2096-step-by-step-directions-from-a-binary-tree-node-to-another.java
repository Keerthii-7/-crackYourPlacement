/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    StringBuilder ans;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        ans=new StringBuilder();
        TreeNode lca_node=getLca(root,startValue,destValue);
        System.out.println(lca_node.val);
        pathFromSourcetoLca(lca_node,startValue,ans);
        System.out.println(ans.toString());
        pathFromLcatoDest(lca_node,destValue,ans);
        return ans.toString();
    }
    public static boolean pathFromSourcetoLca(TreeNode node,int start,StringBuilder s){
        if(node==null){
            return false;
        }
        if(node.val==start){
            return true;
        }
        s.append("U");
        if (pathFromSourcetoLca(node.left, start, s)) {
            return true;
        }
        s.deleteCharAt(s.length() - 1);
        
        s.append("U");
        if (pathFromSourcetoLca(node.right, start, s)) {
            return true;
        }
        s.deleteCharAt(s.length() - 1);
        
        return false;
    }
    public static boolean pathFromLcatoDest(TreeNode node,int start,StringBuilder s){
        if(node==null){
            return false;
        }
        if(node.val==start){
            return true;
        }
        s.append("L");
        if (pathFromLcatoDest(node.left, start, s)) {
            return true;
        }
        s.deleteCharAt(s.length() - 1);
        
        s.append("R");
        if (pathFromLcatoDest(node.right, start, s)) {
            return true;
        }
        s.deleteCharAt(s.length() - 1);
        
        return false;
    }
    public static TreeNode getLca(TreeNode root,int node1,int node2){
        if(root==null){
            return null;
        }
        if(root.val==node1 || root.val==node2){
            return root;
        }
        TreeNode left_lca=getLca(root.left,node1,node2);
        TreeNode right_lca=getLca(root.right,node1,node2);
        if(left_lca!=null && right_lca!=null){
            return root;
        }
        if(left_lca!=null){
            return left_lca;
        }
        return right_lca;
    }
}