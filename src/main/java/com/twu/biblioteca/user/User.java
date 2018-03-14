package com.twu.biblioteca.user;

public class User {

    private String libraryID;
    private String name;
    private String email;
    private int phone;
    private String password;
    private Role role = Role.CLIENT;


    public User(String name, String email, int phone, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public void setLibraryID(String libraryID) {
        this.libraryID = libraryID;
    }

    public String getLibraryID() {
        return libraryID;
    }

    @Override
    public String toString() {
        return "\n" +
                "LibraryId: "+ libraryID +'\n' +
                "Name: " + name + '\n' +
                "Email: " + email + '\n' +
                "Phone: " + phone + '\n';
    }
}
