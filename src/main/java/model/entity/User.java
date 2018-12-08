package model.entity;

/**
 * Created by User on 01.12.2018.
 */


public class User {
    private int id;
    private String login;
    private String pass;

    public enum ROLE{
        ADMIN, USER, MASTER, UNKNOWN
    }

    private ROLE role;
}
