package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/*
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {

        ByteArrayOutputStream password1 = new ByteArrayOutputStream();

        StringBuilder key = new StringBuilder();

        char number = (char) (Math.random());
      //  key.append(number);
        for(int i = 1; i<=8 ; i++){
            if(i%2 == 0){
                char up = (char) ((int)(49 + Math.random()*8));
                key.append(up);
            }
            else{
                if(i<4) {
                    char down = (char) ((int) (65 + Math.random() * 24));
                    key.append(down);
                }
                else{
                    char down1 = (char)((int)(98 + Math.random() * 24));
                    key.append(down1);
                }
            }
        }
        try{
            password1.write(key.toString().getBytes());
        }
        catch (IOException e){
            e.printStackTrace();
        }

        System.out.println(password1);

        return password1;
    }
}
