class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int count=0;
        int k=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                count++;
            }
            else if(nums[i]!=0){
                nums[k]=nums[i];
                k++;
            }
        }
        for(int i=0;i<count;i++){
            nums[k+i]=0;
        }
    }
}