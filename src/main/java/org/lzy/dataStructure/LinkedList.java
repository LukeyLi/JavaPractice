package org.lzy.dataStructure;

import java.util.Collection;


public class LinkedList<E> implements Ilist{
  private Entry<E> head = new Entry<E>(null,null,null);
  private int size = 0;
  class Entry<E>{
     E element;
     Entry<E> next;
     Entry<E> pre;
     
     Entry(E element,Entry<E> next,Entry<E> previous){
         this.element = element;
         this.next = next;
         this.pre = previous;
     }
  }
 
  public LinkedList() {
      head.next = head.pre = head;
  }
  public LinkedList(Collection<? extends E> c) {
     this();
     addAll(c);
  }
  //两个构造方法。第一个将head节点前后一节点都设为自身
  //第二个构造方法接收一个Collection参数C，调用第一个构造方法构造一个空链表后，通过addAll将c中元素全部添加到链表中
  public boolean addAll(Collection<? extends E> c) {
      return addAll(size,c);
  }

  public boolean addAll(int index, Collection<? extends E> c) {
    // 插入位置超过了链表的长度或小于0，
      if(index < 0 || index > size)
          throw new IndexOutOfBoundsException("index： "+index+",size: "+size);
      Object[] a = c.toArray();
      int numNew = a.length;
      //若要插入的节点个数为0则返回false，则在头节点前面插入，否则获取index处的节点
      if(numNew == 0)
          return false;
      
      return false;
}
    @Override
    public int indexOf(Object e) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Object get(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void add(Object e, int index) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Object delete(int index) {
        // TODO Auto-generated method stub
        return null;
    }

}
