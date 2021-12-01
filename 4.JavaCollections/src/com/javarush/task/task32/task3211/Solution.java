package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {

      MessageDigest messageDigest =  MessageDigest.getInstance("MD5");
      messageDigest.update(byteArrayOutputStream.toByteArray());
      byte[] mass = messageDigest.digest();
      byteArrayOutputStream.close();
       StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < mass.length; i++){
            String s = Integer.toHexString(0xff & mass[i]);
            s = (s.length() == 1) ? "0" + s : s;
            stringBuilder.append(s);
        }
//        for (Byte element:mass
//             ) {
//            stringBuilder.append(Integer.toHexString(Byte.toUnsignedInt(element)));
//
//        }

        return stringBuilder.toString().equals(md5);
    }

}
