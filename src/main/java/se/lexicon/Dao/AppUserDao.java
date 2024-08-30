package se.lexicon.Dao;

import se.lexicon.model.AppUser;

import java.util.List;

public interface AppUserDao {

    AppUser persist(AppUser appUser);
    AppUser findByUsername(String username);
    List<AppUser> findAll();
    void remove(String username);
}
