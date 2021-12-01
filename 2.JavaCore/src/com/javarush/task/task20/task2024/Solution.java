package com.javarush.task.task20.task2024;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/* 
Знакомство с графами
*/

public class Solution implements Serializable {
    int node;
    List<Solution> edges = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        ObjectOutputStream osf = new ObjectOutputStream(new FileOutputStream("c:\\1\\one.txt"));
        osf.writeObject(new Solution());

    }
}
