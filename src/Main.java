import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


//main file for leetCode
public class Main {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	 }

	
	/**82. Remove Duplicates from Sorted List II: 1ms
	 * 
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates(ListNode head) {

        
        ListNode newHead = new ListNode(0);
        ListNode tempN = newHead;

        
        while(head != null){
            if(head.next == null || head.val != head.next.val){
                tempN.next = head;
                tempN = tempN.next;
                head = head.next;
            }else{
                int val = head.val;
                do{
                    head = head.next;
                }while( head != null && head.val == val);
            }
        }
        
        tempN.next = null;
        return newHead.next;
        
    }
	
	
	/**86. Partition List: 2ms
	 * 
	 * @param head
	 * @param x
	 * @return
	 */
	public ListNode partition(ListNode head, int x) {
        ListNode check;
        check = head;
        ListNode less = null;
        ListNode greater = null;
        
       while( check != null){                        
            if(check.val < x){               
                if( less == null){ 
                	
                    less = new ListNode(check.val);   
                    
                }else{
                	
                    ListNode tempL = new ListNode(check.val);                                        
                    ListNode cur = less;                   
                    int find = 0;
                    
                    while(find == 0){                                            
                        if(cur.next == null){
                            cur.next = tempL;
                            find = 1;
                        }                        
                        cur = cur.next;
                    }
                    
                }
            }
            else{
                if( greater == null){
                	
                    greater = new ListNode(check.val);
                    
                }else{
                    
                    ListNode tempG = new ListNode(check.val);                   
                    ListNode cur = greater;                    
                    int find = 0;
                    
                    while( find == 0){                       
                        if(cur.next == null){
                        	
                            cur.next = tempG;
                            find = 1;
                            
                        }                       
                        cur = cur.next;                        
                    }
                }
            }            
            check = check.next;
            //check.next
        }
       
        ListNode newHead = head;
        
        while( less != null){
            newHead.val = less.val;
            newHead = newHead.next;
            less = less.next;
        }
        
        while( greater != null){
            newHead.val = greater.val;
            newHead = newHead.next;
            greater = greater.next;
        }
        return head;
    }
	
	/**93. Restore IP Addresses:3ms
	 * 
	 * @param s
	 * @return
	 */
	static  List<String> restoreIpAddresses(String s) {
		List<String> ipLists = new ArrayList<String>();
		String[] ipS = new String[4];
		findIpAddresses( 0, 0, ipLists, ipS, s);
		
		return ipLists;
	}
	
	static void findIpAddresses(int start, int step, List<String> ipLists, String[] ipS, String ip){
		if(step == 4){
			if(start == ip.length()){
				ipLists.add(ipS[0]+"."+ipS[1]+"."+ipS[2]+"."+ipS[3]);
				
			}
			
			return;
		}
		
		for(int curP = start; curP < start+3 && curP < ip.length(); curP++){
			if(curP > start && ip.charAt(start) == '0'){
				return;
			}
			
			String tempS = ip.substring(start, curP+1);
			if(Integer.parseInt(tempS) <= 255){
				ipS[step] = tempS;
				findIpAddresses(curP+1, step+1, ipLists, ipS, ip);
			}
		}		
		
	}
	
	/**111. Minimum Depth of Binary Tree:1ms
	 * 
	 */
	public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        if(root.left == null && root.right == null){
            return 1;
        }
        else if( root.left == null){
            return minDepth(root.right) + 1;
        }
        else if( root.right == null){
            return minDepth(root.left) + 1;
        }else{
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
        
        
    }
	
	/**165. Compare Version Numbers: 1ms
	 * 
	 * @param version1
	 * @param version2
	 * @return
	 */
	static public int compareVersion(String version1, String version2) {
		int curP1 = version1.indexOf('.');
		int curP2 = version2.indexOf('.');
		int curV1 = 0, curV2 = 0;
		
		if(curP1 != -1 && curP2 != -1){
			curV1 = Integer.parseInt(version1.substring(0, curP1));
			curV2 = Integer.parseInt(version2.substring(0, curP2));
			if(curV1 == curV2){
				return compareVersion(version1.substring(curP1+1),version2.substring(curP2+1));
			}			
		}
		
		else if(curP2 != -1){
			curV1 = Integer.parseInt(version1);
			curV2 = Integer.parseInt(version2.substring(0, curP2));
			if(curV1 == curV2){
				return compareVersion("0",version2.substring(curP2+1));
			}
		}
		
		else if(curP1 != -1){
			curV2 = Integer.parseInt(version2);
			curV1 = Integer.parseInt(version1.substring(0, curP1));
			if(curV1 == curV2){
				return compareVersion(version1.substring(curP1+1),"0");
			}
		}
		
		if(curP1 == -1 && curP2 == -1){
			curV1 = Integer.parseInt(version1);
			curV2 = Integer.parseInt(version2);
			if(curV1 == curV2){
				return 0;
			}
		
		}
		
		
		return curV1 > curV2? 1:-1;

    }
	
	/**169. Majority Element
	 * 
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {
	       Arrays.sort(nums);
		   return nums[nums.length/2];
	 }
	
	/**173. Binary Search Tree Iterator: 6ms
	 * see BSTIterator
	 */
	
    
    
	/**292. Nim Game: 0ms
	 * 
	 * @param n
	 * @return
	 */
	static public boolean canWinNim(int n) {
        if(n <= 3){
            return true;
        }
        else{
            if(n%4 == 0){
                return false;
            }else{
                return true;
            }
        }
    }
	
	
	/**344. Reverse String: 4ms
	 * 
	 * @param s
	 * @return
	 */
	static public String reverseString(String s) {
        
        StringBuilder newS = new StringBuilder(s);
    /*    for(int i = 0; i < s.length(); i++){
            newS.append(s.charAt(s.length()-1-i));
        }*/
        
        return newS.reverse().toString();
        
    }
	
	
	
	static public String convert(String s, int numRows) {
		
        return "";
        
	}
        
        
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
