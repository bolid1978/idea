package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

import java.util.List;

public class UsersView implements View{

   private Controller controller ;

    @Override
    public void refresh(ModelData modelData) {
        List<User> users = modelData.getUsers();

        if(!modelData.isDisplayDeletedUserList()) System.out.println("All users:");
        else System.out.println("All deleted users:");
        for (User element:users
             ) {
            System.out.print("\t");
            System.out.println(element);

        }
        System.out.println("===================================================");

    }

    @Override
    public void setController(Controller controller) {
           this.controller = controller;
    }

    public void fireEventShowAllUsers(){

        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }

    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }
}
