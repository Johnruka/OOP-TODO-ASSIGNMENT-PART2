package se.lexicon.impl;

import se.lexicon.Dao.AppUserDao;
import se.lexicon.model.AppUser;

import java.util.ArrayList;
import java.util.List;

public class AppUserDaoImpl implements AppUserDao {

    private final List<AppUser> appUsers;


    private static AppUserDaoImpl instance;


    private AppUserDaoImpl() {
        appUsers = new ArrayList<>();
    }

    public AppUserDaoImpl(List<AppUser> appUsers) {
        this.appUsers = appUsers;
    }

    @Override
    public AppUser persist(AppUser appUser) {
        if (findByUsername(appUser.getUsername()) != null) {
            throw new IllegalArgumentException("Username " + appUser.getUsername() + " is taken");
        }
        if (!appUsers.contains(appUser)) {
            appUsers.add(appUser);
        }
        return appUser;
    }

    @Override
    public AppUser findByUsername(String username) {
        for (AppUser appUser : appUsers) {
            if (appUser.getUsername().equals(username)) {
                return appUser;
            }
        }
        return null;
    }

    @Override
    public List<AppUser> findAll() {
        return new ArrayList<>(appUsers);
    }

    @Override
    public void remove(String username) {
        AppUser appUser = findByUsername(username);
        if (appUser != null) {
            appUsers.remove(appUser);
        }
    }
}
