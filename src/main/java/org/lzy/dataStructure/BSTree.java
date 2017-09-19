package org.lzy.dataStructure;

public class BSTree<T extends Comparable<T>>{
    private BSTNode<T> mroot; //根节点
    public BSTree() {
        mroot = null;
    }
    public class BSTNode<T extends Comparable<T>>{
        T key;  //关键字
        BSTNode<T> left; //左孩纸
        BSTNode<T> right; //右孩纸
        BSTNode<T> parent; //父节点
        
       
        public BSTNode(T key, BSTNode<T> left, BSTNode<T> right, BSTNode<T> parent) {
            super();
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public T getKey() {
            return key;
        }   
    }
    
    
    /**
     * 若二叉树非空，则执行以下操作： 
     * (01) 中序遍历左子树；
     * (02) 访问根结点；
     * (03) 中序遍历右子树。
     * @return 
     */
    void inOrder(BSTNode<T> tree) {
        if(tree != null) {
            inOrder(tree.left);
            System.out.println(tree.key+" ");
            inOrder(tree.right);
        }
    }
    
    public void inOrder() {
        inOrder(mroot);
    }
    
    
    /*非递归实现查找二叉树x中键值为key的节点*
     */
    BSTNode<T> search(BSTNode<T> x,T key){
        while(x != null)
        {
        int cmp = key.compareTo(x.key);
        
        if(cmp < 0)
        x = x.left;
        else if(cmp > 0)
        x = x.right;
        else 
            return x;     
    }
        return x;
    }
    /*递归实现查找
     */
    public BSTNode<T> search2(BSTNode<T> x,T key){
        if(x == null)
            return x;
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            return search2(x.left,key);
        else if(cmp > 0)
            return search2(x.right, key);
        else
            return x;
    }
    public BSTNode<T> search(T key){
        return search(mroot,key);
    }
    /*查找最大值，返回一tree 为根 节点的二叉树的最大节点*/
    BSTNode<T> max(BSTNode<T> tree){
        if(tree == null) {
            return null;
        }
        while(tree.right != null)
            tree = tree.right;
        return tree;
    }
    
    public T max() {
        BSTNode<T> p = max(mroot);
        if(p != null)
            return p.key;
        return null;
    }
    
    /*查找最小值，返回一tree 为根 节点的二叉树的最大节点*/
    BSTNode<T> min(BSTNode<T> tree){
        if(tree == null) {
            return null;
        }
        while(tree.left != null)
            tree = tree.left;
        return tree;
    }
    
    public T min() {
        BSTNode<T> p = max(mroot);
        if(p != null)
            return p.key;
        return null;
    }
    
    
    /*查找前驱节点，即查找二叉树中数据小于节点的最大值节点*/
    public BSTNode<T> predecessor(BSTNode<T> x){
        //如果x存在左孩纸，则x的前驱结点为以左孩纸为根的最大节点
        if(x.left != null)
            return max(x.left);
        
       //如果x没有左孩纸，则x有以下两种可能
        //x是一种右孩纸，则x的前驱节点为他的父节点
        //x是一种左孩纸，则查找x的最低父节点，并且该父节点要有具体右孩纸，找到这个最低的父节点
        BSTNode<T> y = x.parent;   
        while ((y!=null) && (x == y.left)) {
            x = y;
            y = y.parent;
        }
        return y;
    }
    /*找结点x的后继结点，即查找二叉树中数据值大于结点的最小结点*/
    public BSTNode<T> successor(BSTNode<T> x){
        //如果x存在右孩纸，则x的后继结点为 以其右孩纸为根的子树的最小结点
        if(x.right != null)
            return min(x.right);
        
        //如果x没有右孩纸，则x有以下两种可能
        //x是一个左孩纸，则x的后继结点为它的父节点
        //x是一个右孩纸。则查找x最低的父节点，并且该父节点要具有左孩纸
        BSTNode<T> y = x.parent;
        while((y != null) && (x == y.right)) {
            x = y;
            y = y.parent;
        }
        return y;
    }
    
    /*插入结点*/
    void insert(BSTree<T> bst, BSTNode<T> z) {
        int cmp;
        BSTNode<T> y = null;
        BSTNode<T> x = bst.mroot;
        while(x != null) {
            y = x;
            cmp = z.key.compareTo(x.key);
            if(cmp < 0) 
                x = x.left;
            else
                x = x.right;
        }
        z.parent = y;
        if(y == null )
            bst.mroot = z;
        else 
            y.right = z;
    }

    //新建结点，并将其插入二叉树中
    public void insert(T key) {
        BSTNode<T> z = new BSTNode<T>(key,null,null,null);
    }
}