package controller;

import model.User;
import view.UserView;

public class UserController {
    private User model;
    private UserView view;

    public UserController(User model, UserView view) {
        this.model = model;
        this.view = view;
    }

    public void setUsername(String name){
        model.setName(name);
    }

    public String getUserName(){
        return model.getName();
    }

    public void updateView(){
        view.displayUser(model);
    }
}
