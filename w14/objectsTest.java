package home;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import world.Person;

public class objectsTest {
	private static String z = "/Users/tanapatkrowattanajaroenkit/Desktop/eclipseworkspace/OBJIO.rtf";
	public static void main(String[] args) {
		objTest();
	}
	private static void objTest() {
		enum Type {INT,LONG,FLOAT,DOUBLE,PERSON}
		final Type[] TYPES = Type.values();
		try (FileOutputStream fo = new FileOutputStream(z);
				BufferedOutputStream bo = new BufferedOutputStream(fo, 1024);
				ObjectOutputStream oos = new ObjectOutputStream(bo)){
			oos.write(Type.INT.ordinal());
			oos.writeInt(123);
			oos.write(Type.LONG.ordinal());
			oos.writeLong(112);
			oos.write(Type.PERSON.ordinal());
			oos.writeObject(new Person("Danny"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try (FileInputStream fi = new FileInputStream(z);
		         BufferedInputStream bi = new BufferedInputStream(fi,1024);
		         ObjectInputStream ooi = new ObjectInputStream(bi)) {
			int t;
			while ((t = ooi.read()) != -1) {
				switch (TYPES[t]) {
				case INT ->  System.out.println("INT ="+ ooi.readInt());
				case LONG ->  System.out.println("LONG ="+ ooi.readLong());
				case FLOAT ->  System.out.println("FLOAT ="+ ooi.readFloat());
				case DOUBLE ->  System.out.println("DOUBLE ="+ ooi.readDouble());
				case PERSON -> {Person p = (Person) ooi.readObject();
				System.out.println(p);
				}
				default ->
					throw new IllegalArgumentException("Unexpected value: ");
				}
			}
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();		}
	}
}
