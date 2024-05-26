package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.CharArrayWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class iotest {
	private static String a = "/Users/tanapatkrowattanajaroenkit/Desktop/eclipseworkspace/test.rtf";
 public static void main(String[] args) {
	
	iostreamtest();
	ioArrayReadWrite();
	ioReadwriteAndPrintStream();
}

private static void ioReadwriteAndPrintStream() {
	var f = "/Users/tanapatkrowattanajaroenkit/Desktop/eclipseworkspace/RW.rtf";	
	System.out.println("File writer Test");
	try (FileWriter fw = new FileWriter(f)){
	fw.write('O');
	fw.write('X');
	fw.write("asdw");
	fw.close();
	System.err.println("write complete");
} catch (Exception e) {
	e.printStackTrace();
}	
	System.out.println("~~~~~~Reader Test~~~~~~");
	try (FileReader fr = new FileReader(f)){
		int b ;
		while ((b = fr.read()) != -1) {
			System.out.println((char)b);
		}
	} catch (Exception e) {
	e.printStackTrace();
	}
	System.err.println("~~~~~~Print Writer~~~~~~");
	try (PrintWriter pw = new PrintWriter(f)){
		pw.print(true);
		pw.println();
		pw.print(12334497736l);
		pw.print("AZ5");
		
	} catch (Exception e) {
	e.printStackTrace();	
	}
	System.out.println("~~~~~~Reader Test~~~~~~");
	try (FileReader fr = new FileReader(f)){
		int b ;
		while ((b = fr.read()) != -1) {
			System.out.println((char)b);
		}
	} catch (Exception e) {
	e.printStackTrace();
	}
}



private static void ioArrayReadWrite() {
	var x = "/Users/tanapatkrowattanajaroenkit/Desktop/eclipseworkspace/ARW.rtf";
	System.out.println("?????????????????");
	try (CharArrayWriter cw = new CharArrayWriter()){
		cw.write(new char[] {'X','Y','Z','W','P'});
		System.out.println("write complete");
		System.out.println("write content =" + cw.toString());

		try (FileWriter fw = new FileWriter(a)){
			cw.writeTo(fw);
			System.out.println("Done write write !!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	try (FileReader fr = new FileReader(a)){
		int o ;
		while ((o =fr.read()) != -1) {
			System.out.println((char) o);
			
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

private static void iostreamtest() {
	try(DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(a)))){
		dos.writeBoolean(false);
		dos.writeInt(123);
		System.out.println(dos.toString());
	}catch (Exception e) {
		e.printStackTrace();
	}
	try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(a))) ){
		System.out.println(dis.readBoolean());
		System.out.println(dis.readInt());
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
}
