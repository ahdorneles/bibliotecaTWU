package com.twu.biblioteca.user;

public class User {

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
    public boolean authenticate(String email, String password) {
        return (email.equals(this.email) && password.equals(this.password));
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Name='" + name + '\n' +
                ", Emal='" + email + '\n' +
                ", Phone=" + phone + '\n';
    }
}
