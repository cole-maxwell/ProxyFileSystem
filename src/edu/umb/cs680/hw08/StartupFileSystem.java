package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

public class StartupFileSystem {
	public static void main(String[] args)
	{
        FileSystem fs = FileSystem.getFileSystem();

        Directory root = new Directory(null, "root", 0, LocalDateTime.now(), null); 
        Directory home = new Directory(root, "home", 0, LocalDateTime.now(), null);
        Directory applications = new Directory(root, "applications", 0, LocalDateTime.now(), null);
        Directory code = new Directory(home, "code", 0, LocalDateTime.now(), null);
        
        File a = new File(null, "a.txt", 8, LocalDateTime.now(), null);
        File b = new File(null, "b.txt", 512, LocalDateTime.now(), null);
        File c = new File(null, "c.txt", 32, LocalDateTime.now(), null);
        File d = new File(null, "d.txt", 64, LocalDateTime.now(), null);
        File e = new File(null, "e.txt", 128, LocalDateTime.now(), null);
        File f = new File(null, "f.txt", 256, LocalDateTime.now(), null);

        Link x = new Link(home, "linkToApplications", 0, LocalDateTime.now(), applications);
        Link y = new Link(code, "linkToFileB", 0, LocalDateTime.now(), b); 
        
        fs.appendRootDir(root);
        root.appendChild(applications);
        root.appendChild(home);
        home.appendChild(code);
        applications.appendChild(a);
        applications.appendChild(b);
        home.appendChild(c);
        home.appendChild(d);
        home.appendChild(x);
        code.appendChild(e);
        code.appendChild(f);
        code.appendChild(y);

        for (FSElement fsElement: home.getLinks())   {
            System.out.println("Link Name: " + fsElement.getName());
            System.out.println("Link Size: " + fsElement.getSize());
            System.out.println("Link Creation time: " + fsElement.getCreationTime());
            System.out.println("Is link: " + fsElement.isDirectory());
            System.out.println("Is directory: " + fsElement.isDirectory());
            System.out.println("Is file: " + fsElement.isDirectory());
            System.out.println("Link Parent name: " + fsElement.getParent().getName());
            System.out.println("Link Target name: " + fsElement.getTarget().getName()); // link
            System.out.println("Link Target size: " + fsElement.getTarget().getSize()); // 0
            System.out.println("Link Target Creation Time: " + fsElement.getTarget().getCreationTime());
            System.out.println();
        }
        for (FSElement fsElement: code.getLinks())   {
            System.out.println("Link Name: " + fsElement.getName());
            System.out.println("Link Size: " + fsElement.getSize());
            System.out.println("Link Creation time: " + fsElement.getCreationTime());
            System.out.println("Is link: " + fsElement.isDirectory());
            System.out.println("Link Parent name: " + fsElement.getParent().getName());
            System.out.println("Link Target name: " + fsElement.getTarget().getName()); // link
            System.out.println("Link Target size: " + fsElement.getTarget().getSize()); // 0
            System.out.println("Link Target Creation Time: " + fsElement.getTarget().getCreationTime());
            System.out.println();
        }
	}
}




