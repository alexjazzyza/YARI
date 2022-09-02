package com.doranco.yari.authentication;


public interface ApplicationUserDao {
    public ApplicationUserDetail getUserByUsername(String username);
}
