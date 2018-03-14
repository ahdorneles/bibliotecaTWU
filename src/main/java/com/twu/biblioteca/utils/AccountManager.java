package com.twu.biblioteca.utils;

import com.twu.biblioteca.user.Role;
import com.twu.biblioteca.user.User;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {

    private List<User> userList;
    private User whoIsLogged;

    public AccountManager() {
        userList = new ArrayList<>();
        User user = new User("didi","didi",1234,"1234");
        user.setLibraryID("123-1236");

        User user2 = new User("teste","teste",1234,"1234");
        user2.setLibraryID("123-1234");
        userList.add(user2);

        User admin = new User("admin", "admin", 1234,"1234");
        admin.setLibraryID("666-6666");
        admin.setRole(Role.ADMIN);
        userList.add(admin);
    }

    public void addUser(User user) {
        if (isUserUnique(user)) {
            userList.add(user);
        }
    }

    public boolean isUserUnique(User user) {
        for (User userExistent :
                userList) {
            if (userExistent.getEmail().equals(user.getEmail())) {
                return false;
            }
        }
        return true;
    }

    public boolean authenticate(String libraryID, String password) {
        for (User user :
                userList) {
            if (user.getLibraryID() != null && user.getLibraryID().equals(libraryID)) {
                if (user.getPassword().equals(password)) {
                    setUserLogged(user);
                    return true;
                }
            }
        }
        return false;
    }

    private void setUserLogged(User userLogged) {
        whoIsLogged = userLogged;
    }

    public List<User> getUserList() {
        return userList;
    }

    public boolean isAdminAccess(User user) {
        return user.getRole() == Role.ADMIN;
    }

    public boolean isClientAccess(User user) {
        return user.getRole() == Role.CLIENT;
    }

    public void createLibID(User user) {
        int libID1 = (int) (Math.random() * 100) + 1;
        int libID2 = (int) (Math.random() * 100) + 1;

        String libId = Integer.toString(libID1) + "-" + Integer.toString(libID2);

        if (isUnique(libId)) {
            user.setLibraryID(libId);
        } else {
            createLibID(user);
        }

    }

    public boolean isUnique(String libId) {
        for (User user :
                userList) {
            if (user.getLibraryID() != null && user.getLibraryID().equals(libId)) {
                return false;
            }
        }
        return true;
    }

    public User getWhoIsLogged() {
        return whoIsLogged;
    }

    public User findByLibId(String libId) {
        for (User user :
                userList) {
            if (user.getLibraryID().equals(libId)) {
                return user;
            }
        }
        return null;
    }

    public Role getRole(String libraryId) {
        for (User user: userList) {
            if(user.getLibraryID().equals(libraryId)) {
                return user.getRole();
            }
        }
        return Role.CLIENT;
    }
}
