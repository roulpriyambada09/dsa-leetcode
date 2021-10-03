package priya;

public class RotatedArray {
	    public int search(int[] nums, int target) {
	        
	        int pivot = findPivot(nums);
	        
	        //if array is not pivot, it means the array is not rotated
	        if(pivot == -1){
	            return search(nums,target,0,nums.length-1);
	        }
	        //if pivot is found, you have found 2 asc sorted arrays
	        if(nums[pivot]==target)
	            return pivot;
	        if(target >= nums[0]){
	            return search(nums, target,0,pivot-1);
	        }
	         
	        return search(nums,target,pivot+1,nums.length-1);
	        
	    }
	    
	    int search(int[] nums, int target, int start, int end){
	        
	        while(start<=end)
	        {
	            int mid = start + (end - start)/2;
	            if(target < nums[mid]){
	                end = mid -1;
	            }
	            else if(target > nums[mid]){
	                start = mid + 1;
	            } 
	            else
	                return mid;
	        }
	        return -1;
	  }
	    int findPivot(int[] nums)
	    {
	        int start=0;
	        int end=nums.length-1;
	        while(start<=end)
	        {
	            int mid = start +(end-start)/2;
	            
	            if(mid < end && nums[mid] > nums[mid+1])
	            {
	                return mid;
	            }
	            if(mid > start && nums[mid] < nums[mid-1]){
	                return mid -1;
	            }
	            if(nums[mid] <= nums[start]){
	                end = mid-1;
	            }
	            else{
	                start=mid+1;
	            }
	           
	    }
	         return -1;
	  }
}