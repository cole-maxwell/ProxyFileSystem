package edu.umb.cs680.hw08;

import java.time.LocalDateTime;
import java.util.LinkedList;


public class File extends FSElement
{
	public File(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
		super(parent, name, size, creationTime, target);
	}
	public boolean isDirectory() {
		return false;
	}
	public boolean isFile() {
		return true;
	}
	public boolean isLink() {
		return false;
	}
	public boolean inDirectory(Directory dir) {
		return (dir == this.parent);
	}
	
}

