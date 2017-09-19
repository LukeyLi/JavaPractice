package org.lzy.dataStructure;

public interface Ilist {
    /**
     * 求指定元素的下标，没有这个元素就返回-1
     * @param e
     * @return
     */
    int indexOf(Object e);
    /**
     * 获取指定下标插入元素
     * @param index
     * @return
     */
    Object get(int index);
    /**
     * 在指定下标处插入元素
     * @param e
     * @param index
     */
    void add(Object e,int index);
    /**
     * 删除指定下标处的元素
     * @param index
     * @return
     */
    Object delete(int index);
}
