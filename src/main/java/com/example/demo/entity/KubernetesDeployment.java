package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(schema = "kubernetes", name = "kubernetes_deployment")
@Data
public class KubernetesDeployment {

@Id
private UUID cdId = UUID.randomUUID();

@Column private String accountId;

@Column private UUID cdOrgId;

@Column private long cdSnapshotVersion;

@Column(columnDefinition = "jsonb")
private Object annotations;

@Column private long availableReplicas;

@Column private long collisionCount;

@Column(columnDefinition = "jsonb")
private Object conditions;

@Column(columnDefinition = "text")
private String contextName;

@Column private ZonedDateTime creationTimestamp;

@Column private long deletionGracePeriodSeconds;

@Column private ZonedDateTime deletionTimestamp;

@Column private long endLine;

@Column(columnDefinition = "jsonb")
private Object finalizers;

@Column(columnDefinition = "text")
private String generateName;

@Column private long generation;

@Column(columnDefinition = "jsonb")
private Object labels;

@Column private long minReadySeconds;

@Column(columnDefinition = "text")
private String name;

@Column(columnDefinition = "text")
private String namespace;

@Column private long observedGeneration;

@Column(columnDefinition = "jsonb")
private Object ownerReferences;

@Column(columnDefinition = "text")
private String path;

@Column private boolean paused;

@Column private long progressDeadlineSeconds;

@Column private long readyReplicas;

@Column private long replicas;

@Column(columnDefinition = "text")
private String resourceVersion;

@Column private long revisionHistoryLimit;

@Column(columnDefinition = "jsonb")
private Object selector;

@Column(columnDefinition = "text")
private String selectorQuery;

@Column(columnDefinition = "text")
private String sourceType;

@Column private long startLine;

@Column private long statusReplicas;

@Column(columnDefinition = "jsonb")
private Object strategy;

@Column(columnDefinition = "jsonb")
private Object tags;

@Column(columnDefinition = "jsonb")
private Object template;

@Column(columnDefinition = "text")
private String title;

@Column(columnDefinition = "text")
private String uid;

@Column private long unavailableReplicas;

@Column private long updatedReplicas;

}
