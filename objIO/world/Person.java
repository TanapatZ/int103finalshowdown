package world;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import system.writeman;

public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id ;
	private static int NEXT_ID = 0;
	private String name;
	private List<Person> friend = new ArrayList<Person>();
	private transient int num;
	
	 public Person(String name) { this.id=++NEXT_ID; this.name=name; }
	   public boolean addFriend(Person p) {
	      if (!friend.add(p)) return false; ++num; return true;
	   }
	public Iterator<Person> iterator() {
		return friend.iterator();
	}
	public void recalFriend() {
		num = friend.size();
	}
	@Override
	   public String toString() {
	      StringBuilder sb = new StringBuilder();
	      sb.append("Person(");
	      sb.append(id); sb.append(",");
	      sb.append(name); sb.append(",");
	      sb.append("friends[");
	      sb.append(num); sb.append("]");
	      if (num>0) sb.append("id");
	      for (var f : friend) { sb.append(":"); sb.append(f.id); }
	      sb.append(")");
	      return sb.toString();
	   }
	public static void addToFile(Person person) {
		if(writeman.checkNewObjectwriter()) {
			writeman.createObjectWriter(person);
			System.out.println("C!!!");
		}
		else {
			writeman.appendObjectWriter(person);
			System.out.println("B!!!");
		}
	}
	
	   
}
