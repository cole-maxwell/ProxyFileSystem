package edu.umb.cs680.hw08;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LinkTest {

	@Test
	public void verifyLinkTargetName() {
		FileSystem fs = FileSystem.getFileSystem();

        Directory root = new Directory(null, "root", 0, LocalDateTime.now(), null); 
        Directory home = new Directory(root, "home", 0, LocalDateTime.now(), null);
        
        Link x = new Link(home, "linkToRoot", 0, LocalDateTime.now(), root);		
		Object expected = "root";
		Object actual = x.getTarget().getName();
		assertEquals(expected, actual);
	}
}