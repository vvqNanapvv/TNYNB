package org.example;

public class Dll {
    private static class Node{
        Human org;
        Node next;
        Node prev;

        Node(Human human){
            this.org = human;
            this.next = null;
            this.prev = null;
        }
        // Add original Human
        void add(Human human){
            Node head = new Node(human);
            if (this.next == null){
                this.next = head;
            }else {
                this.next.prev = head;
            }
        }


    }
}
