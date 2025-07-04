package com.lld.lowleveldesign.fileSystem;

import java.util.HashMap;

public class File implements FileSystemNode{
    public String name;
    public boolean isEndNode;
    public String content;
    public String extension;
    public File (String name, String content, String extension){
        this.name = name;
        this.content = content;
        this.extension = extension;
        this.isEndNode = true;
    }
}
