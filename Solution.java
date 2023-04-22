/*
https://leetcode.com/problems/largest-rectangle-in-histogram/description/
Time complexity: O(N)
Auxiliary Space: θ(N)
*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int topIndex = 0;
        int currArea = 0;
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            while(!(stack.isEmpty()) && heights[stack.peek()]>=heights[i]){
                topIndex = stack.pop();
                currArea = heights[topIndex]*(stack.isEmpty()? i: i-stack.peek()-1);
                maxArea = Math.max(currArea,maxArea);
            }
            stack.push(i);
        }
        while(!(stack.isEmpty())){
            topIndex = stack.pop();
            currArea = heights[topIndex]*
            (stack.isEmpty()? heights.length: heights.length-stack.peek()-1);
            maxArea = Math.max(currArea,maxArea);
        }
        return maxArea;
    }
}
