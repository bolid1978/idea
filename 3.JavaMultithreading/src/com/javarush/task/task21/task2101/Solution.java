package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/

public class Solution {
    public static void main(String[] args) {
        byte j = 2;
       // System.out.println(Integer.toBinaryString(192));
      //  System.out.println(Integer.toBinaryString(256 + (int) j));
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte res[] = new byte[4];
        int mas[] = new int[4];
        for (int i = 0,l = ip.length ;i < l; i++) {
            mas[i] = ((Byte.toUnsignedInt(ip[i])&Byte.toUnsignedInt(mask[i])));
          //  System.out.println(mas[i]);
        }
        for (int i = 0; i < 4; i++) {
            res[i] = (byte)mas[i];
          //  System.out.println(res[i]);
        }
        return res;
    }

    public static void print(byte[] bytes) {
        for (int i = 0; i < bytes.length; i++) {
           int k = Byte.toUnsignedInt(bytes[i]);
           String str = Integer.toBinaryString(k);
           String res = "";
         //   for (int j = str.length(); j < 8; j++) {
           //     res +="0";
         //   }
           // System.out.print(res);
         //   res +=str;
             str = String.format("%8s",str);
             str = str.replaceAll(" ", "0");
            System.out.print(str + " ");

        }
            System.out.println();
    }

}
