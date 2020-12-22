package edu.umb.cs680.hw08;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement
{
	private LinkedList<FSElement> children = new LinkedList<FSElement>();
	private LinkedList<Directory> subDirectories = new LinkedList<Directory>();
	private LinkedList<File> files = new LinkedList<File>();
	private LinkedList<Link> links = new LinkedList<Link>();

	public Directory(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
		super(parent, name, size, creationTime, target);
	}

	public boolean inDirectory(Directory dir) {
		return (dir == this.parent);
	}

	public boolean isDirectory() {
		return true;
	}
	public boolean isFile() {
		return false;
	}
	public boolean isLink() {
		return false;
	}

	public void appendChild(FSElement child) {

		if (child.isDirectory()) {
			this.subDirectories.add((Directory)child);
			this.children.add(child);
			child.setParent(this);			
		} else if (child.isFile()) {
			this.files.add((File)child);
			this.children.add(child);
			child.setParent(this);			
		} else {
			this.links.add((Link)child);
			this.children.add(child);
			child.setParent(this);
		}
	}

	public LinkedList<FSElement> getChildren() {
		return children;
	}
	public LinkedList<Directory> getSubDirectories() {
		return subDirectories;
	}
	public LinkedList<File> getFiles() {
		return files;
	}
	public LinkedList<Link> getLinks() {
		return links;
	}
	public int countChildren() {
		return this.children.size();	
	}
	public int getTotalSize() {
		
		int totalSize = 0;
	
		for (File file: this.getFiles()) {
			totalSize = totalSize + file.getSize();
		}
		for (Directory dir: this.getSubDirectories())   {
			dir.getTotalSize();
		}
		return totalSize;	
	}
}

