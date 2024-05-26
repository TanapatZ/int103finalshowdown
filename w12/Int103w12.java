package int103w12;

import delicacy.*;
import exception.*;
import java.util.LinkedList;
import java.util.List;

public class Int103w12 {

    public static void main(String[] args) {
        System.out.println("Today's Topics");
        System.out.println("Exceptions");
        System.out.println("Decolator Design Patterns");
        demoNewException();
        
        //demoDecolator();
    }
    public static void demoDecolator() {
       System.out.println("Demo Decolator Design Pattern");
       Dish d1 = Meat.addBeef(Noodle.EGG_NOODLE);
       Dish d2 = Meat.addPork(Meat.addBeef(Noodle.RICE_NOODLE));
       Dish d3 = Meat.addPork(Noodle.EGG_NOODLE);
       System.out.println("Dish1: " + d1.getPrice() + " " + d1.ingredientsToString());
       System.out.println("Dish2: " + d2.getPrice() + " " + d2.ingredientsToString());
       System.out.println("Dish3: " + d3.getPrice() + " " + d3.ingredientsToString());
       Dish d4 = new Meat(100, "Crab", new Meat(50, "Shrimp", new Noodle(30, "Book")));
       System.out.println("Dish4: " + d4.getPrice() + " " + d4.ingredientsToString());
    }
    public static void demoNewException() {
        System.out.println("Demo New Exception");
        try {
           demoUncheckedException();
        } catch (Exception e) {
           e.printStackTrace();
        }
        List<String> x = null;
        try {
           demoCheckedException();
           x = new LinkedList<>();
           x.add("abc");
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
           if (x != null) x.clear();
        }
        System.out.println("The End");       
    }
    public static void demoUncheckedException() {
       throw new MyUncheckedException("Test Unchecked Exception");
    }
    // throws clause
    public static void demoCheckedException() throws MyCheckedException {
       throw new MyCheckedException(new IllegalAccessError());
    }
}
