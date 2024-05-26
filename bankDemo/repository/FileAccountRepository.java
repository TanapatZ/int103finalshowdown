package repository;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import Service.FileRepo;
import domain.Account;
import domain.Customer;


public class FileAccountRepository implements FileRepo{
	private Map<String, Account> repo = new HashMap<>();

	  public void saveToFile(String fileName) throws IOException {
	        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
	            outputStream.writeObject(repo);
	        }
	    }

	    @Override
	    public void loadFromFile(String fileName) throws IOException, ClassNotFoundException {
	        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
	            repo = (Map<String, Account>) inputStream.readObject();
	        }
	        }

}
