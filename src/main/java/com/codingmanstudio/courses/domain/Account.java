package com.codingmanstudio.courses.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Account {
    @Id
    private String username;

    private String encrytedPassword;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "accounts_roles", joinColumns = @JoinColumn(name = "account_username"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles=new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL ,mappedBy = "course")
    private Set<AccountCourse> courses = new HashSet<>();

    public Account() {
    }

    public Account(String username, String encrytedPassword) {
        this.username = username;
        this.encrytedPassword = encrytedPassword;
    }
    public void addCourse(Course course){
        AccountCourse accountCourse = new AccountCourse(this,course);
        courses.add(accountCourse);
        course.getAccounts().add(accountCourse);
    }

}
