package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(schema = "kubernetes", name = "kubernetes_node")
@Data
public class KubernetesNode {

@Id
private UUID cdId = UUID.randomUUID();

@Column private String accountId;

@Column private UUID cdOrgId;

@Column private long cdSnapshotVersion;

@Column(columnDefinition = "jsonb")
private Object addresses;

@Column(columnDefinition = "jsonb")
private Object allocatable;

@Column(columnDefinition = "jsonb")
private Object annotations;

@Column(columnDefinition = "jsonb")
private Object capacity;

@Column(columnDefinition = "jsonb")
private Object conditions;

@Column(columnDefinition = "jsonb")
private Object config;

@Column(columnDefinition = "jsonb")
private Object configSource;

@Column(columnDefinition = "text")
private String contextName;

@Column private ZonedDateTime creationTimestamp;

@Column(columnDefinition = "jsonb")
private Object daemonEndpoints;

@Column private long deletionGracePeriodSeconds;

@Column private ZonedDateTime deletionTimestamp;

@Column private long endLine;

@Column(columnDefinition = "jsonb")
private Object finalizers;

@Column(columnDefinition = "text")
private String generateName;

@Column private long generation;

@Column(columnDefinition = "jsonb")
private Object images;

@Column(columnDefinition = "jsonb")
private Object labels;

@Column(columnDefinition = "text")
private String name;

@Column(columnDefinition = "jsonb")
private Object nodeInfo;

@Column(columnDefinition = "jsonb")
private Object ownerReferences;

@Column(columnDefinition = "text")
private String path;

@Column(columnDefinition = "text")
private String phase;

@Column(columnDefinition = "text")
private String podCidr;

@Column(columnDefinition = "jsonb")
private Object podCidrs;

@Column(columnDefinition = "text")
private String providerId;

@Column(columnDefinition = "text")
private String resourceVersion;

@Column(columnDefinition = "text")
private String sourceType;

@Column private long startLine;

@Column(columnDefinition = "jsonb")
private Object tags;

@Column(columnDefinition = "jsonb")
private Object taints;

@Column(columnDefinition = "text")
private String title;

@Column(columnDefinition = "text")
private String uid;

@Column private boolean unschedulable;

@Column(columnDefinition = "jsonb")
private Object volumesAttached;

@Column(columnDefinition = "jsonb")
private Object volumesInUse;

}
