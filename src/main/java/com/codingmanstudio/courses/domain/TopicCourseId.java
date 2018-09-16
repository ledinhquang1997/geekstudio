package com.codingmanstudio.courses.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class TopicCourseId implements Serializable {
    @Column(name = "Topic_Id")
    private UUID topicId;

    @Column(name = "Course_id")
    private UUID courseId;

    public TopicCourseId(UUID topicId, UUID courseId) {
        this.topicId = topicId;
        this.courseId = courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(topicId, courseId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        TopicCourseId that = (TopicCourseId) obj;
        return Objects.equals(topicId, that.topicId) && Objects.equals(courseId, that.courseId);
    }
}
