package sk.upjs.paz1c.homer.dao;

import sk.upjs.paz1c.homer.entity.User;

public interface UserDao {
    public User podlaMena(String meno);
    public void pridajUser(User user);
}
