package algorithmPractice;

/**
 * 链表
 * @author 帅帅的李志颖
 *
 */
public interface LinkedList {
	
	/**
	 * 求指定元素下标，没有这个元素就返回-1
	 * @param e
	 * @return
	 */
	int indexOf(Object e);
	/**
	 * 获得指定下标处的元素
	 * @param index
	 * @return
	 */
	Object get(int index);
	         
	/**
	 * 在指定下标处插入元素
	 * @param b
	 * @param index
	 */
	void add(Object b,int index);
	/**
	 * 删除指定下标处的元素
	 * @param index
	 * @return
	 */
	Object delete(int index);
}
