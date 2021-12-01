package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName = null;
    private String partOfContent = null;
    private int minSize  = 0;
    private int maxSize = 0;
    private final List<Path> foundFiles = new ArrayList<>();

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }




    boolean isPartOfName = true;
    boolean isPartOfContent = true;
    boolean isMinSize = true;
    boolean isMaxSize = true;


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length

        if (minSize == 0 && maxSize == 0 && partOfContent == null && partOfName == null) {
            foundFiles.add(file);
            return FileVisitResult.CONTINUE;
        }


        if (partOfName != null)
            isPartOfName = file.toString().contains(partOfName);
        if (partOfContent != null)
            isPartOfContent = new String(content).contains(partOfContent);
        if (minSize != 0)
            isMinSize = content.length > minSize;
        if (maxSize != 0)
            isMaxSize = content.length < maxSize;

        if (isPartOfName & isPartOfContent & isMinSize & isMaxSize)
            foundFiles.add(file);
        return FileVisitResult.CONTINUE;


    }
}
