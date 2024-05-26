package util;

import system.writeman;
import world.Person;

public class runing {
	public static void main(String[] args) {
		objrun();
	}

	private static void objrun() {
		 Person p1 = new Person("Adam Smith");
         Person p2 = new Person("Evalyn Johnson");
         Person p3 = new Person("Emily Brown");
         Person p4 = new Person("Noah Garcia");
         
         writeman.creatClaneObjectWriter();
         p1.addFriend(p4);
         p2.addFriend(p3);
         p3.addFriend(p1);
         
         Person.addToFile(p1);
         Person.addToFile(p2);
         Person.addToFile(p3);
         System.out.println(writeman.callAllPerson());
         
	}
}
