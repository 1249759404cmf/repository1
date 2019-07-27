import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashM {
	public static void main(String[] args) {
		HashSet<User> set=new HashSet();
		User user=new User("A");
		User user1=new User("B");
		User user2=new User("C");
		User user3=new User("D");
		set.add(user);set.add(user1);set.add(user2);set.add(user3);
		for (User user5 : set) {
			System.out.println(user5.getName()+"   "+user5);
		}
		System.out.println();

		user.setName("E");
		System.out.println(user);
		System.out.println();
		set.remove(user);
		set.add(user);
		for (User user4 : set) {
			System.out.println(user4.getName()+"  "+user4);
		}
	}
}
