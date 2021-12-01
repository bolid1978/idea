package com.javarush.task.task31.task3106;


import java.io.*;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) return;

        String [] onlyFiles = new String[args.length -1];
        int j = 0;
        for (int i = 1; j < onlyFiles.length; i++,j++) {
            onlyFiles[j] = args[i];
        }
        Arrays.sort(onlyFiles);

        Vector<FileInputStream> files = new Vector<>();
        for (int i = 0; i < onlyFiles.length; i++) {
            files.add(new FileInputStream(onlyFiles[i]));
        }

        Enumeration<FileInputStream> e = files.elements();
        SequenceInputStream sis = new SequenceInputStream(e);


        try (ZipInputStream zis = new ZipInputStream(sis)) {
            for (ZipEntry entry = null; (entry = zis.getNextEntry()) != null;) {
                try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(args[0]))) {
                    final int bufferSize = 1024;
                    byte[] buffer = new byte[bufferSize];

                    for (int readBytes; (readBytes = zis.read(buffer, 0, bufferSize)) > -1;) {
                        bos.write(buffer, 0, readBytes);
                    }
                    bos.flush();

                }
            }
        }
    }

}
