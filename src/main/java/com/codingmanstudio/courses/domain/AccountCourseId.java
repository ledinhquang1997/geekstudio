package com.codingmanstudio.courses.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class AccountCourseId implements Serializable {
    @Column(name = "Account_Id")
    private UUID accountId;

    @Column(name = "Course_id")
    private UUID courseId;

    public AccountCourseId(UUID accountId, UUID courseId) {
        this.accountId = accountId;
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        AccountCourseId that = (AccountCourseId) obj;
        return Objects.equals(accountId, that.accountId) && Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, courseId);
    }
}
