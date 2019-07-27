import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.*;

public class Tree {
	private treeNode root;


	//创建树,自带一个根节点
	public Tree() {
		this.root = new treeNode(1,"A");
	}

	//创建分支叶的方法
	public void creatTree(){
		treeNode nodeB =new treeNode(2,"B");
		treeNode nodeC =new treeNode(3,"C");
		treeNode nodeD =new treeNode(4,"D");
		treeNode nodeE =new treeNode(5,"E");
		treeNode nodeF =new treeNode(6,"F");
		//自定义这个树的图形结构
		root.leftNode=nodeB;
		root.rightNode=nodeC;
		nodeB.leftNode=nodeD;
		nodeB.rightNode=nodeE;
		nodeC.rightNode=nodeF;
	}
	//跟据一个前序排序的集合来构建二叉树
	/*             A
	*         B          C
	*     D      E     #      F
	* #     #  #  #         #   #
	* ABD##E##C#F##
	*
	* */
	public treeNode createTree(int size, List<String> list){
		int size1 = list.size();
		String data = list.get(0);
		if(data.equals("#")){
			list.remove(0);
			return null;
		}

		treeNode treeNode = new treeNode(size - size1, data);
		if(size-size1==0){
			root=treeNode;
		}
		list.remove(0);

		treeNode.leftNode=createTree(size,list);
		treeNode.rightNode=createTree(size,list);

		return treeNode;
	}




	//求树的层次方法,利用递归,判断每一个节点的左子树和右子树是否存在,存在+1,不存在为0
	public int treeHight(){
		return Tree.hight(root);
	}

	private static int hight(treeNode root) {
		if(root==null){
			return 0;
		}else {
			int a=hight(root.leftNode);
			int b=hight(root.rightNode);
			return a>b?a+1:b+1;
		}
	}

	//前序遍历,根,左,右
	public void before(treeNode root){
		if(root==null){
			return;
		}
		System.out.println(root.data);
		before(root.leftNode);
		before(root.rightNode);
	}
	//利用栈来实现前序遍历
	public void stackBefor(treeNode root){
		if(root==null){
			return;
		}
		Stack<treeNode> stack=new Stack<treeNode>();
		stack.push(root);
		while (!stack.isEmpty()){
			treeNode pop = stack.pop();
			if(pop.rightNode!=null){
				stack.push(pop.rightNode);
			}
			if(pop.leftNode!=null){
				stack.push(pop.leftNode);
			}
			System.out.println(pop.data);
		}
	}
	//中序遍历
	public void mid(treeNode node){
		if(node==null){
			return;
		}else {
			mid(node.leftNode);
			System.out.println(node.data);
			mid(node.rightNode);
		}
	}
	public void midStack(treeNode node){
		if(node==null){
			return;
		}
		Stack<treeNode> stack=new Stack<treeNode>();
		stack.push(node);
		LinkedList<treeNode> treeList=new LinkedList();
		treeList.add(node);
		while (!stack.isEmpty()){
			treeNode pop = stack.pop();
			if(pop.rightNode!=null){
				stack.push(pop.rightNode);
				int i = treeList.indexOf(pop);
				treeList.add(i+1,pop.rightNode);
			}
			if(pop.leftNode!=null){
				stack.push(pop.leftNode);
				treeList.addFirst(pop.leftNode);
			}
		}
		for (treeNode treeNode : treeList) {
			System.out.println(treeNode.data);
		}
	}
	//后序遍历
	public void after(treeNode node){
		if(node==null){
			return;
		}
		after(node.leftNode);
		after(node.rightNode);
		System.out.println(node.data);
	}
	//利用栈的后续遍历
	public void  afterStack(treeNode node){
		if(node==null){
			return;
		}
		LinkedList<treeNode> linkedList = new LinkedList<treeNode>();
		Stack<treeNode> stack=new Stack<treeNode>();
		stack.push(node);
		linkedList.add(node);
		while (!stack.isEmpty()){
			//弹出最上面的元素
			treeNode pop = stack.pop();
			int i = linkedList.indexOf(pop);
			if(i==0){
				if(pop.rightNode!=null){
					stack.push(pop.rightNode);
					linkedList.addFirst(pop.rightNode);
				}
				if(pop.leftNode!=null){
					stack.push(pop.leftNode);
					linkedList.addFirst(pop.leftNode);
				}
			}else {
				if(pop.rightNode!=null){
					stack.push(pop.rightNode);
					linkedList.add(i,pop.rightNode);
				}
				if(pop.leftNode!=null){
					stack.push(pop.leftNode);
					linkedList.add(i+1,pop.leftNode);
				}
			}

		}
		for (treeNode treeNode : linkedList) {
			System.out.println(treeNode.data);
		}
	}




	//写一个内部类创建树中节点的方法
	public class  treeNode{
		private int index;
		private String data;
		private treeNode leftNode;
		private treeNode rightNode;

		public treeNode(int index, String data) {
			this.index = index;
			this.data = data;
			this.leftNode=null;
			this.rightNode=null;
		}


	}

	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		Collections.addAll(list,"A","B","D","#","#",
				"E","#","#","C","#","F","#","#");
		Tree tree=new Tree();
		treeNode tree1 = tree.createTree(list.size(), list);
		tree.before(tree1);

	}
}
