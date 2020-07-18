package com.Interview;

class node{
    int val;
    node next;
    node(int i){
        this.val = i;
        this.next = null;
    }
}


public class leetcode25 {
    public static void main(String[] args) {
        node a = new node(1);
        node b = new node(2);
        node c = new node(3);
        node d = new node(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = new node(5);
        leetcode25 l = new leetcode25();
        System.out.println("start");
        node ans = l.KthReverse(a,3);
        while(ans!=null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    public node KthReverse(node root,int k){
        int cnt = 0;
        node cur = root;
        while(cur!=null){
            cur = cur.next;
            cnt++;
        }
        int first = cnt%k;
        node head = new node(-1);
        head.next = root;
        cur = head;
        for(int i=0;i<first;i++){
            cur = cur.next;
        }
        for(int i=first+1;i<=cnt;i+=k){
            node tmp = cur.next;
            cur.next = reverseList(cur.next,k-1);
            cur = tmp;
        }
        return head.next;
    }

    public node reverseList(node root,int k){
        node pre = new node(-1);
        node cur = new node(-1);
        pre = root;
        cur = root.next;
        while(k>0){
            node tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            k--;
        }
        root.next = cur;
        return pre;
    }
}
