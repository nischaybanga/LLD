package com.lld.lowleveldesign.fileSystem;

import java.util.HashMap;

public class Directory implements FileSystemNode{
    public String name;
    public HashMap<String, FileSystemNode> children;
    public boolean isEndNode;
    public Directory(String name) {
        this.name = name;
        this.children = new HashMap<>();
        this.isEndNode = false;
    }
}
