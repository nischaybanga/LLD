package com.lld.lowleveldesign.fileSystem;

import java.util.HashMap;

public class RootDirectory {
    public HashMap<String, FileSystemNode> children;
    public RootDirectory() {
        this.children = new HashMap<>();
    }
}
