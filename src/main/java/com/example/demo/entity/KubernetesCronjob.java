package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(schema = "kubernetes", name = "kubernetes_cronjob")
@Data
public class KubernetesCronjob {

@Id
private UUID cdId = UUID.randomUUID();

@Column private String accountId;

@Column private UUID cdOrgId;

@Column private long cdSnapshotVersion;

@Column(columnDefinition = "jsonb")
private Object active;

@Column(columnDefinition = "jsonb")
private Object annotations;

@Column(columnDefinition = "jsonb")
private Object concurrencyPolicy;

@Column(columnDefinition = "text")
private String contextName;

@Column private ZonedDateTime creationTimestamp;

@Column private long deletionGracePeriodSeconds;

@Column private ZonedDateTime deletionTimestamp;

@Column private long endLine;

@Column private long failedJobsHistoryLimit;

@Column(columnDefinition = "jsonb")
private Object finalizers;

@Column(columnDefinition = "text")
private String generateName;

@Column private long generation;

@Column(columnDefinition = "jsonb")
private Object jobTemplate;

@Column(columnDefinition = "jsonb")
private Object labels;

@Column private ZonedDateTime lastScheduleTime;

@Column private ZonedDateTime lastSuccessfulTime;

@Column(columnDefinition = "text")
private String name;

@Column(columnDefinition = "text")
private String namespace;

@Column(columnDefinition = "jsonb")
private Object ownerReferences;

@Column(columnDefinition = "text")
private String path;

@Column(columnDefinition = "text")
private String resourceVersion;

@Column(columnDefinition = "text")
private String schedule;

@Column(columnDefinition = "text")
private String sourceType;

@Column private long startLine;

@Column private long startingDeadlineSeconds;

@Column private long successfulJobsHistoryLimit;

@Column private boolean suspend;

@Column(columnDefinition = "jsonb")
private Object tags;

@Column(columnDefinition = "text")
private String title;

@Column(columnDefinition = "text")
private String uid;

}
