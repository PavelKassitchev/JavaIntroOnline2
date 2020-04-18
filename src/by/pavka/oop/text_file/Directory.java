package by.pavka.oop.text_file;

import java.util.ArrayList;
import java.util.List;

public class Directory {

    private Directory host;
    private List<Directory> children;
    private List<File> files;
    private String name;

    private boolean hasContent;

    public Directory(String name) {
        this.name = name;
        children = new ArrayList<>();
        files = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasContent() {
        return hasContent;
    }


    public Directory getHost() {
        return host;
    }

    private void setHost(Directory host) {
        this.host = host;
    }

    public List<Directory> getChildren() {
        return children;
    }

    public void setChildren(List<Directory> children) {
        this.children = children;
        for(Directory c: children) {
            c.setHost(this);
        }
        if(children != null && !children.isEmpty()) hasContent = true;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
        for(File f: files) {
            f.setHost(this);
        }
        if(files != null && !files.isEmpty()) hasContent = true;
    }

    @Override
    public String toString() {
        return name  + (host == null? " - no host ": " - host: " + host.getName()) + "- directories: " + children + "- files: " + files + "- has content: " + hasContent;
    }

    public void addChild(Directory dir) {
        children.add(dir);
        dir.setHost(this);
        if(dir != null) hasContent = true;
    }

    public boolean removeDirectory(Directory dir) {
        if (children.contains(dir)) {
            dir.setHost(null);
            if (children.size() == 1 && files.isEmpty()) {
                hasContent = false;
            }
        }
        return children.remove(dir);
    }

    public void addFile(File file) {
        files.add(file);
        file.setHost(this);
        if(file != null) hasContent = true;
    }

    public boolean removeFile(File file) {
        if (files.contains(file)) {
            file.setHost(null);
            if (files.size() == 1 && children.isEmpty()) {
                hasContent = false;
            }
        }
        return files.remove(file);
    }

    public void delete() {

        if(host != null) {
            host.removeDirectory(this);
            host = null;
        }

        if(hasContent) {
            List<File> copyFiles = new ArrayList<>(files);
            for(File f: copyFiles) {
                f.delete();
            }
            List<Directory> copyChildren = new ArrayList<>(children);
            for(Directory dir: copyChildren) {
                dir.delete();
            }
        }

    }


}
