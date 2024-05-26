package Service;

import java.io.IOException;

public interface FileRepo {
	public void saveToFile(String fileName) throws IOException;
    public void loadFromFile(String fileName) throws IOException, ClassNotFoundException;
}
