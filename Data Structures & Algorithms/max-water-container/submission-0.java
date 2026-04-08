class Solution {
    public int maxArea(int[] heights) {
       int start = 0;
       int end = heights.length - 1;
       int area = 0;

       while(start < end){
        if(heights[start] < heights[end]){
            int currentArea = (end - start) * heights[start];
            if(currentArea > area){
                area = currentArea;
            }
            start++;
        }else{
            int currentArea = (end - start) * heights[end];
            if(currentArea > area){
                area = currentArea;
            }
            end--;
        }
       } 

       return area;
    }
}
