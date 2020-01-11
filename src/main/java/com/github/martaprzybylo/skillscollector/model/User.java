package com.github.martaprzybylo.skillscollector.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "users")
public class User extends EntityBase {

    /**
     * nazwa użytkownika (username),
     * hasło (password),
     * imię (firstName),
     * nazwisko (lastName),
     * zbiór znanych źródeł wiedzy (knownSources),
     */

    @Column (unique = true, nullable = false, name = "user_name")
    private String userName;

    @Column (nullable = false, name = "password")
    private String password;

    @Column (name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @ManyToMany
    @JoinTable (name = "users_known_sources",
    joinColumns = @JoinColumn (name = "user_id"),
    inverseJoinColumns = @JoinColumn (name = "source_id"))
    private Set<Source> knownSources;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Source> getKnownSources() {
        return knownSources;
    }

    public void setKnownSources(Set<Source> knownSources) {
        this.knownSources = knownSources;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }


}
