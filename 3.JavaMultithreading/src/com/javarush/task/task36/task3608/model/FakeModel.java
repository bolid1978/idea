package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.List;

public class FakeModel implements Model{

    private ModelData modelData = new ModelData();

    @Override
    public void loadUsers() {
        List<User> users = modelData.getUsers();

        users.add(new User("a", 1, 1));
        users.add(new User("b", 1, 1));
        users.add(new User("c", 1, 1));
    }

    @Override
    public void loadDeletedUsers() {
        throw  new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId) {
        throw  new UnsupportedOperationException();
    }

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void deleteUserById(long id) {
        throw  new UnsupportedOperationException();
    }
    public void changeUserData(String name, long id, int level){
        throw  new UnsupportedOperationException();
    }
}
