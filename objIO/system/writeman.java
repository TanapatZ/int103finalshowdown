package system;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import world.Person;

public class writeman {
	private static String myf ="/Users/tanapatkrowattanajaroenkit/Desktop/eclipseworkspace/objtestfile.dat"; 
	public static boolean checkNewObjectwriter() {
		try(FileInputStream fi = new FileInputStream(myf);
		        BufferedInputStream bi = new BufferedInputStream(fi,1024);
		        ObjectInputStream oi = new ObjectInputStream(bi)){
			return(oi.readObject() == null) ;
			
		}
		catch (EOFException e) {
        System.out.println("  No more Person to read.");
        return true;
     } catch (Exception e) {
        System.out.println("  Unexpected content/problem. 001");
        e.printStackTrace();
        return true;
        
     }
		
	}
	public static void createObjectWriter(Person person) {
		
		try (FileOutputStream fo = new FileOutputStream(myf);
		        BufferedOutputStream bo = new BufferedOutputStream(fo,1024);
		        ObjectOutputStream oo = new ObjectOutputStream(bo))  {
					oo.writeObject(person);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
	public static void appendObjectWriter(Person person) {
		try (FileOutputStream fo = new FileOutputStream(myf,true);
		        BufferedOutputStream bo = new BufferedOutputStream(fo,1024);
		        ObjectOutputStream oo = new ObjectOutputStream(bo))  {
					oo.writeObject(person);
				} catch (Exception e) {
					e.printStackTrace();
				}
		
	}
	public static String callAllPerson() {
		 StringBuilder sb = new StringBuilder();
		ArrayList<Person> PersonList = new ArrayList<Person>();
		try (FileInputStream fi = new FileInputStream(myf);
		        BufferedInputStream bo = new BufferedInputStream(fi,1024);
		        ObjectInputStream oi = new ObjectInputStream(bo)) {
			
			
			while (true) {
                try {
                    var p = (Person) oi.readObject();
                    System.out.println(p);
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }

        
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
            return "ERROR TO READ";
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
            return "ERROR TO READ";
        } catch (Exception e) {
            System.out.println("Unexpected content/problem.");
            e.printStackTrace();
            return "ERROR TO READ";
        }
			ArrayList<Person> person = new ArrayList<Person>();	
			while (!PersonList.isEmpty()) {
				Person Person = PersonList.remove(0);
				if(person.add(Person)) {
					for (var persons : person) {
						persons.recalFriend();
						
					      sb.append("[Person(")
					      .append(persons).append("]");
					     
					}
				}
			}
			return sb.toString();
		
	}
public static void creatClaneObjectWriter() {
		
		try (FileOutputStream fo = new FileOutputStream(myf);
		        BufferedOutputStream bo = new BufferedOutputStream(fo,1024);
		        ObjectOutputStream oo = new ObjectOutputStream(bo))  {
					oo.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
}

