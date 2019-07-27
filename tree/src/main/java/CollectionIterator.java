import java.util.*;

public class CollectionIterator {
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()){
			Integer next = iterator.next();
			System.out.println(next);
		}
		//写一个降序排序
		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		System.out.println("-------");
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
}
