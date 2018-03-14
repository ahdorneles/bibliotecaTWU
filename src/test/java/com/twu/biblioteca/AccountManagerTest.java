package com.twu.biblioteca;

import com.twu.biblioteca.user.Role;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.utils.AccountManager;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class AccountManagerTest {

    private AccountManager accountManager;
    private User clientUser;
    private User adminUser;

    @Before
    public void init() {
        accountManager = new AccountManager();
        clientUser = new User("didi","ahdorneles@gmail.com",123123,"1234");
        clientUser.setLibraryID("123-1236");

        adminUser = new User("oi","oi@oi.com",1234,"123456");
        adminUser.setRole(Role.ADMIN);

        accountManager.addUser(clientUser);
        accountManager.addUser(adminUser);
    }

    @Test
    public void shouldAuthenticateUser() {
        assertTrue(accountManager.authenticate("123-1236","1234"));
    }

    @Test
    public void shouldNotAuthenticateUserWithWrongLibId() {
        assertFalse(accountManager.authenticate("123-1234", "1234"));
    }

    @Test
    public void shouldNotAuthenticateUserWithWrongPassword() {
        assertFalse(accountManager.authenticate("123-1236", "12345"));
    }

    @Test
    public void shouldAddUser() {
        User user = new User("Teste","userteste@gmail.com",123,"123");
        accountManager.addUser(user);
        assertTrue(accountManager.getUserList().size() == 3);
    }

    @Test
    public void shouldNotAddAnUser() {
        User user = new User("teste", "ahdorneles@gmail.com",123,"1234");
        accountManager.addUser(user);
        assertTrue(accountManager.getUserList().size() == 2);
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

    @Test
    public void shouldReturnFalseWhenLibIdIsNotUnique() {
        clientUser.setLibraryID("123-1234");
        assertFalse(accountManager.isUnique("123-1234"));
    }

    @Test
    public void shouldReturnTrueWhenLibIdIsUnique() {
        clientUser.setLibraryID("123-1234");
        assertTrue(accountManager.isUnique("123-1235"));
    }


    @Test
    public void shouldCreateLibId() {
        User user = new User("teste", "dummy",1223,"12345");
        assertTrue(user.getLibraryID() == null);
        accountManager.createLibID(user);
        assertFalse(user.getLibraryID() == null);

    }

    @Test
    public void shouldFindByLibId () {
        assertEquals(clientUser, accountManager.findByLibId("123-1236"));
    }

    @Test
    public void shouldKnowWhoIsLogged() {
        accountManager.authenticate("123-1236","1234");
        assertTrue(accountManager.getWhoIsLogged().getName().equals("didi"));
    }
}
