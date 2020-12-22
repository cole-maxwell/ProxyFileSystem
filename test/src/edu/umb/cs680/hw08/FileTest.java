package edu.umb.cs680.hw08;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FileTest {

	@Test
	public void verifyFileSize() {
		FileSystem fs = FileSystem.getFileSystem();
		Directory root = new Directory(null, "root", 0, LocalDateTime.now(), null); 
		File a = new File(null, "a.txt", 20, LocalDateTime.now(), null);
		fs.appendRootDir(root);
		root.appendChild(a);
		Object expected = 20;
		Object actual = a.getSize();
		assertEquals(expected, actual);
	}
}