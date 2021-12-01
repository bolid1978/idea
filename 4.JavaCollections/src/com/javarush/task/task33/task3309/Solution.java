package com.javarush.task.task33.task3309;

/*
Комментарий внутри xml
*/

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;

public class Solution {

    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException {


            String str =  "";
            StringWriter writer = new StringWriter();
            JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // сама сериализация
            marshaller.marshal(obj, writer);
            str = writer.toString();
            //----------------------------------
            String com = "<!--" + comment + "-->";
            String [] strMass = str.split("\\n");
            ArrayList<String>  arrayList = new ArrayList<String>();
            String one = "<" + tagName + ">";

            String two = "</" + tagName + ">";

        for (int i = 0; i < strMass.length; i++) {

            String temp = strMass[i].trim();
            if(temp.startsWith(one)&&temp.endsWith(two)){
               arrayList.add(com);
            }
            arrayList.add(strMass[i]);
        }
        System.out.println(arrayList);
        str = "";
        for (String el : arrayList){
            str = str + el + "\n";
        }
        System.out.println(str);
        return str;
    }

    public static  void main(String[] args) throws JAXBException {
       Obeck obg =  new Obeck();
        String vivod  = toXmlWithComment(obg, "second", "it's a comment");
        System.out.println(vivod);
    }
}
