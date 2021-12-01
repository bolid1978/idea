 package com.javarush.task.task20.task2028;

/*
Построй дерево(1)
*/

 import java.io.Serializable;
 import java.util.*;

 public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
     Entry<String> root;
    // Deque<Entry> deque = new ArrayDeque<>();
     ArrayList<Entry> arrayList =  new ArrayList<>();
     LinkedList<Entry> linkedList =  new LinkedList<>();
     public CustomTree() {
         root = new Entry<>("0");
        // deque.add(root);
         arrayList.add(root);
         linkedList.add(root);
     }

     static class Entry<T> implements Serializable{
         String elementName;
         boolean availableToAddLeftChildren, availableToAddRightChildren;
         Entry<T> parent, leftChild, rightChild;


         public Entry(String elementName) {
             this.elementName = elementName;
             availableToAddLeftChildren = false;
             availableToAddRightChildren = false;
         }
         public boolean isAvailableToAddChildren(){
            return availableToAddLeftChildren&availableToAddRightChildren;
         }

     }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();

    }

    @Override
    public int size() {

         return arrayList.size()-1;
    }

    public String set(int index, String element){
        throw new UnsupportedOperationException();
    }
    public void add(int index, String element){
        throw new UnsupportedOperationException();
    }
    public String remove(int index){
        throw new UnsupportedOperationException();
    }
    public List<String> subList(int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }
     protected void removeRange(int fromIndex, int toIndex){
         throw new UnsupportedOperationException();
     }
     public boolean addAll(int index, Collection<? extends String> c){
         throw new UnsupportedOperationException();
     }

     public boolean add(String s){

         int i = 0;
         while (i < arrayList.size())
         {
             if(!arrayList.get(i).isAvailableToAddChildren()) break;
             i++;
         }

         if(arrayList.get(i).availableToAddLeftChildren == false )
         {
           Entry entry = new Entry(s);
           arrayList.get(i).availableToAddLeftChildren = true;
           arrayList.get(i).leftChild = entry;
           entry.parent = arrayList.get(i);
           arrayList.add(entry);
             return true;
         }
         if(arrayList.get(i).availableToAddRightChildren == false )
         {
             Entry entry = new Entry(s);
             arrayList.get(i).availableToAddRightChildren = true;
             arrayList.get(i).rightChild = entry;
             entry.parent = arrayList.get(i);
             arrayList.add(entry);
             return true;
         }
            return  false;
     }
     public String getParent(String s){
         for (Entry  element:arrayList
              ) {
             if (element.elementName.equals(s)) return element.parent.elementName;
            }
         return null;
     }

     public boolean remove(Object o){
         String s = null;
//         try{
//              s = String.valueOf(o);
//            }
//       catch (Exception e){
//             throw new UnsupportedOperationException();
//
//       }
         if(!(o instanceof String)) throw new UnsupportedOperationException();
            s = (String)o;
         ArrayList<Entry> removeStringEntry = new ArrayList<>();
         Stack<Entry> entryStackRemove = new Stack<>();
         for (Entry element:arrayList
              ) {
             if(element.elementName.equals(s))  {
                 entryStackRemove.add(element);
                 removeStringEntry.add(element);
                 try{
                 if(element.parent.leftChild.elementName.equals(element.elementName))
                     element.parent.availableToAddLeftChildren = false;
                 }
                 catch (Exception e){}
                 try {
                     if (element.parent.rightChild.elementName.equals(element.elementName))
                         element.parent.availableToAddRightChildren = false;
                 }
                 catch (Exception e){}
             }
         }
         if(entryStackRemove.empty()) return false;
         while(!entryStackRemove.empty()){
             Entry tempEntry = entryStackRemove.pop();
             if(tempEntry.availableToAddLeftChildren)
             {
                 removeStringEntry.add(tempEntry.leftChild);
                 entryStackRemove.add(tempEntry.leftChild);
                 if(tempEntry.parent.leftChild.elementName.equals(tempEntry.elementName))  tempEntry.parent.availableToAddLeftChildren = false;
             }
             if(tempEntry.availableToAddRightChildren)
             {
                 removeStringEntry.add(tempEntry.rightChild);
                 entryStackRemove.add(tempEntry.rightChild);
                 if(tempEntry.parent.rightChild.elementName.equals(tempEntry.elementName))  tempEntry.parent.availableToAddRightChildren = false;
             }


         }
//         for (Entry element:removeStringEntry
//              ) {
//             System.out.println(element.elementName);
//         }
//         for (Entry element: arrayList
//              ) {
//             System.out.print(element.elementName +" ");
//         }
//         System.out.println();
         arrayList.removeAll(removeStringEntry);
//         for (Entry element: arrayList
//         ) {
//             System.out.print(element.elementName+ " ");
//         }
//         System.out.println();
         return true;
     }
}
