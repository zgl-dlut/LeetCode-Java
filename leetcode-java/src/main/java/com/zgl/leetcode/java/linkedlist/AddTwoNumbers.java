package com.zgl.leetcode.java.linkedlist;

/**
 * LeetCode 02
 *
 * @author zgl
 * @date 2018/11/25 下午3:04
 */

/**
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

	/**
	 * (错误写法-转换成long型有位数限制)
	 * @param listNode
	 * @return
	 */
	public Long getIntNum(ListNode listNode){
		String s=new String();
		while(listNode!=null){
			s+=String.valueOf(listNode.val);
			listNode=listNode.next;
		}
		return Long.valueOf(s);
	}

		/*Long total=getIntNum(l1)+getIntNum(l2);
		String totalStr=String.valueOf(total);
		int[]part=new int[totalStr.length()];
		int i=0;
		while (total!=0){
			part[i]=total.intValue()%10;
			total/=10;
			i++;
		}
		ListNode result=new ListNode(part[0]);
		ListNode head=result;
		for (int j=1;j<part.length;j++){
			ListNode temp=new ListNode(part[j]);
			head.next=temp;
			head=temp;
		}
		return result;*/

		public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode result=new ListNode(0);
		ListNode head=result;
		/**
		 * 进位标识
		 */
		int carry=0;
		while(l1!=null||l2!=null){
			int x=(l1!=null)?l1.val:0;
			int y=(l2!=null)?l2.val:0;
			int sum=carry+x+y;
			carry=sum/10;
			head.next=new ListNode(sum%10);
			head=head.next;
			if(l1!=null){
				l1=l1.next;
			}
			if(l2!=null){
				l2=l2.next;
			}
		}
		if(carry>0){
			head.next=new ListNode(carry);
		}
		return result.next;
	}

}

