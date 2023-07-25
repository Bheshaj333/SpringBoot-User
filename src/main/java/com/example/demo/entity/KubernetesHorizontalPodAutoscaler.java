package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(schema = "kubernetes", name = "kubernetes_horizontal_pod_autoscaler")
@Data
public class KubernetesHorizontalPodAutoscaler {

@Id
private UUID cdId = UUID.randomUUID();

@Column private String accountId;

@Column private UUID cdOrgId;

@Column private long cdSnapshotVersion;

@Column(columnDefinition = "jsonb")
private Object annotations;

@Column(columnDefinition = "jsonb")
private Object conditions;

@Column(columnDefinition = "text")
private String contextName;

@Column private ZonedDateTime creationTimestamp;

@Column(columnDefinition = "jsonb")
private Object currentMetrics;

@Column private long currentReplicas;

@Column private long deletionGracePeriodSeconds;

@Column private ZonedDateTime deletionTimestamp;

@Column private long desiredReplicas;

@Column private long endLine;

@Column(columnDefinition = "jsonb")
private Object finalizers;

@Column(columnDefinition = "text")
private String generateName;

@Column private long generation;

@Column(columnDefinition = "jsonb")
private Object labels;

@Column private ZonedDateTime lastScaleTime;

@Column private long maxReplicas;

@Column(columnDefinition = "jsonb")
private Object metrics;

@Column private long minReplicas;

@Column(columnDefinition = "text")
private String name;

@Column(columnDefinition = "text")
private String namespace;

@Column private long observedGeneration;

@Column(columnDefinition = "jsonb")
private Object ownerReferences;

@Column(columnDefinition = "text")
private String path;

@Column(columnDefinition = "text")
private String resourceVersion;

@Column(columnDefinition = "jsonb")
private Object scaleDownBehavior;

@Column(columnDefinition = "jsonb")
private Object scaleTargetRef;

@Column(columnDefinition = "jsonb")
private Object scaleUpBehavior;

@Column(columnDefinition = "text")
private String sourceType;

@Column private long startLine;

@Column(columnDefinition = "jsonb")
private Object tags;

@Column(columnDefinition = "text")
private String title;

@Column(columnDefinition = "text")
private String uid;

}
