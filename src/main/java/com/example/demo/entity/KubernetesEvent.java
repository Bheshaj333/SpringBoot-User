package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(schema = "kubernetes", name = "kubernetes_event")
@Data
public class KubernetesEvent {

@Id
private UUID cdId = UUID.randomUUID();

@Column private String accountId;

@Column private UUID cdOrgId;

@Column private long cdSnapshotVersion;

@Column(columnDefinition = "text")
private String action;

@Column(columnDefinition = "jsonb")
private Object annotations;

@Column(columnDefinition = "text")
private String contextName;

@Column private long count;

@Column private ZonedDateTime creationTimestamp;

@Column private long deletionGracePeriodSeconds;

@Column private ZonedDateTime deletionTimestamp;

@Column private long endLine;

@Column private ZonedDateTime eventTime;

@Column(columnDefinition = "jsonb")
private Object finalizers;

@Column private ZonedDateTime firstTimestamp;

@Column(columnDefinition = "text")
private String generateName;

@Column private long generation;

@Column(columnDefinition = "jsonb")
private Object involvedObject;

@Column(columnDefinition = "jsonb")
private Object labels;

@Column private ZonedDateTime lastTimestamp;

@Column(columnDefinition = "text")
private String message;

@Column(columnDefinition = "text")
private String name;

@Column(columnDefinition = "text")
private String namespace;

@Column(columnDefinition = "jsonb")
private Object ownerReferences;

@Column(columnDefinition = "text")
private String path;

@Column(columnDefinition = "text")
private String reason;

@Column(columnDefinition = "jsonb")
private Object related;

@Column(columnDefinition = "text")
private String reportingComponent;

@Column(columnDefinition = "text")
private String reportingInstance;

@Column(columnDefinition = "text")
private String resourceVersion;

@Column(columnDefinition = "jsonb")
private Object series;

@Column(columnDefinition = "jsonb")
private Object source;

@Column(columnDefinition = "text")
private String sourceType;

@Column private long startLine;

@Column(columnDefinition = "text")
private String type;

@Column(columnDefinition = "text")
private String uid;

}
