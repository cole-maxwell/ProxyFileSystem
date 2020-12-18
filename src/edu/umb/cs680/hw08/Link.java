package edu.umb.cs680.hw08;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Link extends FSElement
{
	public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
		super(parent, name, size, creationTime, target);
	}

	public boolean inDirectory(Directory dir) {
		return (dir == this.parent);
	}

	public boolean isDirectory() {
		return false;
	}
	public boolean isFile() {
		return false;
	}
	public boolean isLink() {
		return true;
	}
}


 