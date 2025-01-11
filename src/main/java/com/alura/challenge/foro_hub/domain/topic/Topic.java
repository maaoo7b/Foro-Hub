package com.alura.challenge.foro_hub.domain.topic;

import com.alura.challenge.foro_hub.domain.topic.dto.TopicDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Table(name = "topics")
@Entity(name = "Topic")
@EqualsAndHashCode(of = "topicID")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long topicID;

    @Column(name = "topicTitle")
    private String topicTitle;

    @Column(name = "topicMessage")
    private String topicMessage;

    @Column(name = "topicDate")
    private LocalDateTime topicDate;


    //Constructors
    public Topic() {
    }

    public Topic(TopicDTO topicDTO) {
        this.topicTitle = topicDTO.topicTitle();
        this.topicMessage = topicDTO.topicMessage();
        this.topicDate = topicDTO.topicDate();
    }

    //toString

    @Override
    public String toString() {
        return "Topic{" +
                "topicID='" + topicID + '\'' +
                ", topicTitle='" + topicTitle + '\'' +
                ", topicMessage='" + topicMessage + '\'' +
                ", topicDate='" + topicDate + '\'' +
                '}';
    }

    //Getter&Setters

    public Long getTopicID() {
        return topicID;
    }

    public void setTopicID(Long topicID) {
        this.topicID = topicID;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public String getTopicMessage() {
        return topicMessage;
    }

    public void setTopicMessage(String topicMessage) {
        this.topicMessage = topicMessage;
    }

    public LocalDateTime getTopicDate() {
        return topicDate;
    }

    public void setTopicDate(LocalDateTime topicDate) {
        this.topicDate = topicDate;
    }
}
