package com.javarush.task.task33.task3309;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
 class Obeck {
    public String[]second = {"some string","some string","<![CDATA[need CDATA because of < and >]]>",""};

    public void Test() {
    }
}
