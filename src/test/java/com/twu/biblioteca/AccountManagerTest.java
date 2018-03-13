package com.twu.biblioteca;

import com.twu.biblioteca.user.Role;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.utils.AccountManager;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class AccountManagerTest {

    private AccountManager accountManager;
    private User clientUser;
    private User adminUser;

    @Before
    public void init() {
        accountManager = new AccountManager();
        clientUser = new User("ahdorneles@gmail.com","ahdorneles@gmail.com",123123,"1234");
        adminUser = new User("oi","oi@oi.com",1234,"123456");
        adminUser.setRole(Role.ADMIN);

        accountManager.addUser(clientUser);
        accountManager.addUser(adminUser);
    }

    @Test
    public void shouldAuthenticateUser() {
        assertTrue(accountManager.authenticate("ahdorneles@gmail.com","1234"));
    }

    @Test
    public void shouldNotAuthenticateUserWithWrongEmail () {
        assertFalse(accountManager.authenticate("kas", "1234"));
    }

    @Test
    public void shouldNotAuthenticateUserWithWrongPassword() {
        assertFalse(accountManager.authenticate("ahdorneles@gmail.com", "12345"));
    }

    @Test
    public void shouldAddUser() {
        assertTrue(accountManager.getUserList().size() > 0);
    }

    @Test
    public void shouldHaveAdminRole() {
        assertTrue(adminUser.getRole() == Role.ADMIN);
        assertFalse(clientUser.getRole() == Role.ADMIN);
    }

    @Test
    public void shouldHaveClientRole() {
        assertTrue(clientUser.getRole() ==  Role.CLIENT);
        assertFalse(clientUser.getRole() == Role.ADMIN);

    }

    @Test
    public void shouldHaveAdminAccess () {
        assertTrue(accountManager.isAdminAccess(adminUser));
        assertFalse(accountManager.isAdminAccess(clientUser));
    }

    @Test
    public void shouldHaveClientAccess() {
        assertTrue(accountManager.isClientAccess(clientUser));
        assertFalse(accountManager.isClientAccess(adminUser));
    }

}
