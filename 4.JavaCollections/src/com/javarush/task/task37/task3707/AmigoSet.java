package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable , Set<E> {

    private static final Object PRESENT = new Object();

    private transient HashMap<E,Object> map;


    private static final long serialVersionUID = 23;
    @Override
    public Iterator<E> iterator() {

        return map.keySet().iterator();
    }

    @Override
    public int size() {

        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        boolean temp = false;
        for (Map.Entry<E, Object> element: map.entrySet()){
            if(element.getValue().equals(o)) {
                remove(map.remove(element.getKey())) ;
                temp  = true;
                break;
            }
        }
        return temp;
    }

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        this.map = new HashMap<E,Object>(Math.max((int) (collection.size() / .75f) + 1, 16));
        addAll(collection);
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;

    }

    @Override
    public Object clone()  {
    try {
        AmigoSet<E> set = (AmigoSet<E>) super.clone();
        set.map = (HashMap<E, Object>) map.clone();
        return set;
    }catch (Exception ex){
        throw new InternalError();
    }
    }

    private void writeObject(ObjectOutputStream oOut) throws IOException {
        oOut.defaultWriteObject();
        oOut.writeObject(this.map.size());
        oOut.writeInt(HashMapReflectionHelper.callHiddenMethod(this.map, "capacity"));
        oOut.writeFloat(HashMapReflectionHelper.callHiddenMethod(this.map, "loadFactor"));
        for (E e:map.keySet()) {
            oOut.writeObject(e);
        }





    }

    private void readObject(ObjectInputStream oIn) throws IOException, ClassNotFoundException {

        oIn.defaultReadObject();
        int size = (int) oIn.readObject();
        int capacity = oIn.readInt();
        float loadFactor = oIn.readFloat();
        map = new HashMap<>(capacity, loadFactor);
        for (int i = 0; i < size ; i++) {
            E e= (E) oIn.readObject();
            map.put(e, PRESENT);
        }

    }
}



