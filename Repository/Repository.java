package Exceptions_Sem3_HomeTasks.Repository;

import Exceptions_Sem3_HomeTasks.User.User;

import java.util.ArrayList;

public abstract class Repository {
    private User user;
    private ArrayList<User> users;

    public Repository() {
        users = new ArrayList<>();

    }

    public void addUser(User user){
        users.add(user);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }


}
