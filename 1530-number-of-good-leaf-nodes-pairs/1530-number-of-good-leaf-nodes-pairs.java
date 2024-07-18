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
    static int count;
    public int countPairs(TreeNode root, int distance) {
        count=0;
        dfsTraversal(root,distance);
        return count;
    }
    public static List<Integer> dfsTraversal(TreeNode root,int dis){
        if(root==null){
            return new ArrayList<>();
        }
        if(root.left==null&&root.right==null){
            List<Integer> leafDistances=new ArrayList<>();
            leafDistances.add(1);
            return leafDistances;
        }
        List<Integer> left_dis=dfsTraversal(root.left,dis);
        List<Integer> right_dis=dfsTraversal(root.right,dis);
        for(int ld:left_dis){
            for(int rd:right_dis){
                if(ld+rd<=dis){
                    count+=1;
                }
            }
        }
        List<Integer> currDistances=new ArrayList<>();
        for(int ld:left_dis){
            currDistances.add(ld+1);
        }
        for(int rd:right_dis){
            currDistances.add(rd+1);
        }
        return currDistances;
    }
}