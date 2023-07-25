package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(schema = "kubernetes", name = "kubernetes_job")
@Data
public class KubernetesJob {

@Id
private UUID cdId = UUID.randomUUID();

@Column private String accountId;

@Column private UUID cdOrgId;

@Column private long cdSnapshotVersion;

@Column private long active;

@Column private long activeDeadlineSeconds;

@Column(columnDefinition = "jsonb")
private Object annotations;

@Column private long backoffLimit;

@Column private ZonedDateTime completionTime;

@Column private long completions;

@Column(columnDefinition = "jsonb")
private Object conditions;

@Column(columnDefinition = "text")
private String contextName;

@Column private ZonedDateTime creationTimestamp;

@Column private long deletionGracePeriodSeconds;

@Column private ZonedDateTime deletionTimestamp;

@Column private long endLine;

@Column private long failed;

@Column(columnDefinition = "jsonb")
private Object finalizers;

@Column(columnDefinition = "text")
private String generateName;

@Column private long generation;

@Column(columnDefinition = "jsonb")
private Object labels;

@Column private boolean manualSelector;

@Column(columnDefinition = "text")
private String name;

@Column(columnDefinition = "text")
private String namespace;

@Column(columnDefinition = "jsonb")
private Object ownerReferences;

@Column private long parallelism;

@Column(columnDefinition = "text")
private String path;

@Column(columnDefinition = "text")
private String resourceVersion;

@Column(columnDefinition = "jsonb")
private Object selector;

@Column(columnDefinition = "text")
private String selectorQuery;

@Column(columnDefinition = "text")
private String sourceType;

@Column private long startLine;

@Column private ZonedDateTime startTime;

@Column private long succeeded;

@Column(columnDefinition = "jsonb")
private Object tags;

@Column(columnDefinition = "jsonb")
private Object template;

@Column(columnDefinition = "text")
private String title;

@Column private long ttlSecondsAfterFinished;

@Column(columnDefinition = "text")
private String uid;

}
