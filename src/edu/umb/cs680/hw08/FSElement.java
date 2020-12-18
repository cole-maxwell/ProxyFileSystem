package edu.umb.cs680.hw08;

import java.time.LocalDateTime;
import java.util.LinkedList;

abstract class FSElement
{
	protected Directory parent;
	protected String name;
	protected int size;
	protected LocalDateTime creationTime;
	protected FSElement target;

	public FSElement(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
		this.parent = parent;
		this.name = name;
		this.size = size;
		this.creationTime = creationTime;
		this.target = target;
	}
	public Directory getParent() {
		return parent;
	}
	public String getName() {
		return name;
	}
	public int getSize() {
		return size;
	}
	public LocalDateTime getCreationTime() {
		return creationTime;
	}
	public FSElement getTarget() {
		return target;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void setParent(Directory parent) {
		this.parent = parent;
	}
	abstract boolean isDirectory();
	abstract boolean inDirectory(Directory dir);
	abstract boolean isFile();
	abstract boolean isLink();

}

