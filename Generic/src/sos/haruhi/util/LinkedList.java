package sos.haruhi.util;

public class LinkedList<T> {
    private static class Node<T> {
        T item;
        Node<T> next;
        Node(){item = null; next = null;}
        Node(T item, Node<T> next){
            this.item = item;
            this.next = next;
        }
        boolean end(){return item == null && next == null;}
    }
    private int size = 0;
    private Node<T> top = new Node<T>();
    public T push(T t){
        top =  new Node<T>(t, top);
        size++;
        return t;
    }
    public T pop(){
        T result = top.item;
        if(!top.end()){
            top = top.next;
            size--;
        }
        return result;
    }


    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        for(String item:"jj kk ll dd sj kjdf kdf".split(" ")){
            list.push(item);
        }
        while(list.size != 0){
            System.out.println(list.pop());
        }
    }

}
