package com.twu.biblioteca.utils;

import com.sun.javafx.UnmodifiableArrayList;
import com.twu.biblioteca.user.Role;
import com.twu.biblioteca.user.User;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {

    private List<User> userList;

    public AccountManager() {
        userList = new ArrayList<>();
    }

    public void addUser(User user) {
        userList.add(user);
    }


    public boolean authenticate(String email, String password) {
        for (User user :
                userList) {
            if (user.getEmail().equals(email)) {
                if (user.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public boolean isAdminAccess(User user) {
        return user.getRole() == Role.ADMIN;
    }

    public boolean isClientAccess(User user) {
        return user.getRole() == Role.CLIENT;
    }
}
