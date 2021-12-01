package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    String fileName ="";

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream (fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

       // out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        stream = new FileOutputStream(fileName,true);
        in.defaultReadObject();
      //  in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Solution solutionTwo = new Solution("c:\\1\\two.txt");
        try(Solution solution = new Solution("c:\\1\\one.txt")

        )
        {
            solution.writeObject("hjhk");

            ByteArrayOutputStream obj = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(obj);
            out.writeObject(solution);
            out.close();
            ByteArrayInputStream inpObj = new ByteArrayInputStream(obj.toByteArray());
            ObjectInputStream in = new ObjectInputStream(inpObj);

            solutionTwo =(Solution) in.readObject();
            in.close();

        }

        catch (Exception ex){

        }


    }
}
