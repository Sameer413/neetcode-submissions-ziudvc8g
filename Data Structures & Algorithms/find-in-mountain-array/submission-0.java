/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);

        int leftResult = binarySearchLeft(0, peak, target, mountainArr);
        if(leftResult != -1) return leftResult;

        return binarySearchRight(peak + 1, mountainArr.length() - 1, target, mountainArr);
    }

    private int findPeak(MountainArray mountainArr){
        int start = 0;
        int end = mountainArr.length() - 1;

        while(start < end){
            int mid = start + (end - start) / 2;

            if(mountainArr.get(mid) < mountainArr.get(mid + 1)){
                start = mid + 1;
            }else{
                end = mid;
            }
        }

        return end;
    }

    private int binarySearchLeft(int start, int end, int target, MountainArray mountainArr){
        while(start <= end){
            int mid = start + (end - start) / 2;

            if(mountainArr.get(mid) == target) return mid;

            if(mountainArr.get(mid) < target) start = mid + 1;
            else end = mid - 1;
        }

        return -1;
    }
    
    private int binarySearchRight(int start, int end, int target, MountainArray mountainArr){
        while(start <= end){
            int mid = start + (end - start) / 2;

            if(mountainArr.get(mid) == target) return mid;

            if(mountainArr.get(mid) > target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
    
}