package repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import domain.*;
import Service.FileRepo;

public class FileCustomerRepo implements FileRepo{
	private Map<String, Customer> repo = new HashMap<>();
	 @Override
	    public void saveToFile(String fileName) throws IOException {
		 
	        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
	            outputStream.writeObject(repo);
	        }
	    }

	    @Override
	    public void loadFromFile(String fileName) throws IOException, ClassNotFoundException {
	        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
	            repo = (Map<String, Customer>) inputStream.readObject();
	        }
	    }
}
