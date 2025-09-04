package io.github.code100.struct;

import java.util.ArrayList;
import java.util.List;

public class CompositePattern {
    public static void main(String[] args) {
        FileComponent file1 = new FileLeaf("Resume.docx");
        FileComponent file2 = new FileLeaf("Design.pdf");
        FileComponent file3 = new FileLeaf("Todo.txt");

        FolderComposite folder1 = new FolderComposite("Documents");
        folder1.add(file1);
        folder1.add(file2);

        FolderComposite folder2 = new FolderComposite("Desktop");
        folder2.add(file3);
        folder2.add(folder1); // 桌面中还包含 Documents 文件夹

        folder2.display();
    }
}

abstract class FileComponent {
    protected String name;

    public FileComponent(String name) {
        this.name = name;
    }

    public abstract void display();
}

class FileLeaf extends FileComponent {
    public FileLeaf(String name) {
        super(name);
    }

    public void display() {
        System.out.println("文件：" + name);
    }
}

class FolderComposite extends FileComponent {
    private List<FileComponent> children = new ArrayList<>();

    public FolderComposite(String name) {
        super(name);
    }

    public void add(FileComponent file) {
        children.add(file);
    }

    public void remove(FileComponent file) {
        children.remove(file);
    }

    public void display() {
        System.out.println("文件夹：" + name);
        for (FileComponent child : children) {
            child.display();
        }
    }
}