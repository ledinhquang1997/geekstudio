package com.codingmanstudio.courses.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AccountCourse implements Serializable {

    public AccountCourse(Account account, Course course) {
        this.account = account;
        this.course = course;
        this.accountCourseId = new AccountCourseId(account.getUsername(),course.getId());
    }

    @EmbeddedId
    private AccountCourseId accountCourseId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("username")
    @JoinColumn( name = "account_username")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    @Column
    private int progress;

}
