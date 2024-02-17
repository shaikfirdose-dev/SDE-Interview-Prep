

//GFG (medium) : https://www.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1?itm_source=geeksforgeeks

package com.firdose.linkedlist;

public class IntersectionOfTwoLinkedList {
	
	
	int intersectPoint(Node head1, Node head2)
	{
         // code here
         //brute force
         
        //  if(head1==null || head2==null){     // if node value asked in question means return -1 else return null
        //      return -1;
        //  }
         
        //  Node temp1 = head1;
        //  Node temp2 = head2;
         
        //  HashMap<Node, Integer> hm = new HashMap<>();
         
        //  while(temp1!=null){
        //      hm.put(temp1, 1);
        //  }
         
        //  while(temp2!=null){
        //      if(hm.containsKey(temp2)==true){
        //          return temp2.data;
        //      }
        //      else{
        //          hm.put(temp2, 1);
        //      }
        //  }
        //  return -1;
        
        
        
        //better approach  T.C : O(N+2M) -----S.C : O(1)
          if(head1==null || head2==null){     // if node value asked in question means return -1 else return null
              return -1;
          }
         
          Node temp1 = head1;
          Node temp2 = head2;
         
          int n1 = 0;
          while(temp1!=null){
              n1++;
              temp1 = temp1.next;
          }
         
          int n2 = 0;
          while(temp2!=null){
              n2++;
              temp2 = temp2.next;
          }
         
          if(n1 < n2){                                       // if node value asked in question means return -1 else return node
              Node ans = collisionPoint(head1, head2, n2-n1);
              if(ans!=null){
                  return ans.data;
              }
              return -1;
          }
          else{
              Node ans = collisionPoint(head2, head1, n1-n2);     // if node value asked in question means return -1 else return node
              if(ans!=null){
                  return ans.data;
              }
              return -1;
          }
 	}
	
 	private static Node collisionPoint(Node t1, Node t2, int d){
 	    while(d!=0){
 	        d--;
 	        t2 = t2.next;
 	    }
	    
 	    while(t1!=t2){
 	        t1 = t1.next;
 	        t2 = t2.next;
 	    }
 	    return t1;
	    
 	}
		
		//optimal approach  ------T.C : O(N+M)------S.C : O(1)
//        if(head1==null || head2==null){        // if node asked in question return node
//             return null;
//         }
//         
//         Node temp1 = head1;
//         Node temp2 = head2;
//         
//         while(temp1!=temp2){
//             temp1 = temp1.next;
//             temp2 = temp2.next;
//             
//             if(temp1==temp2){
//                 return temp1;
//             }
//             if(temp1==null){
//                 temp1 = head2;
//             }
//             if(temp2==null){
//                 temp2 = head1;
//             }
//         }
//         return temp1;
         
//	}

}

