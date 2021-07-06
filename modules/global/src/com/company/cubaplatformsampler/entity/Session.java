package com.company.cubaplatformsampler.entity;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Table(name = "CUBAPLATFORMSAMPLER_SESSION")
@Entity(name = "cubaplatformsampler_Session")
public class Session extends StandardEntity {
    private static final long serialVersionUID = 5665508923536107759L;

    @NotNull
    @Column(name = "TOPIC", nullable = false)
    private String topic;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    @Column(name = "START_DATE", nullable = false)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    @Column(name = "END_DATE", nullable = false)
    private Date endDate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SPEAKER_ID")
    @Lookup(type = LookupType.DROPDOWN, actions = "lookup")
    private Speaker speaker;

    @Column(nullable = false, length = 2000)
    @NotNull
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @PrePersist
    @PreUpdate
    public void updateEndDate() {
        endDate = calculateEndDate(startDate);
    }

    public static Date calculateEndDate(Date startDate){
        return Date.from(startDate.toInstant().plus(1, ChronoUnit.HOURS));
    }

}