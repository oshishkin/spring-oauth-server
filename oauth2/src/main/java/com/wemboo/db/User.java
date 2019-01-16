package com.wemboo.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User {
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    private Long userId;
 
    @Column(name = "username", nullable = false, unique = true)
    private String username;
 
    @Column(name = "password", nullable = false)
    private String password;
 
    @Column(name = "user_role", nullable = false)
    private String role;

    @Column(name = "user_group", nullable = false)
    private String group;

    @Column(name = "is_enabled", nullable = false)
    private Boolean isEnabled;

    /**
     * @return the isEnabled
     */
    public Boolean getIsEnabled() {
        return isEnabled;
    }

    /**
     * @param isEnabled the isEnabled to set
     */
    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }


    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }


    /**
     * @return the group
     */
    public String getGroup() {
        return group;
    }


    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }


    /**
     * @param group the group to set
     */
    public void setGroup(String group) {
        this.group = group;
    }


    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }


    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }


    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
}