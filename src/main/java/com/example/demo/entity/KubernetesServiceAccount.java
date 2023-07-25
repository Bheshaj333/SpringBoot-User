package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(schema = "kubernetes", name = "kubernetes_service_account")
@Data
public class KubernetesServiceAccount {

@Id
private UUID cdId = UUID.randomUUID();

@Column private String accountId;

@Column private UUID cdOrgId;

@Column private long cdSnapshotVersion;

@Column(columnDefinition = "jsonb")
private Object annotations;

@Column private boolean automountServiceAccountToken;

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
private Object imagePullSecrets;

@Column(columnDefinition = "jsonb")
private Object labels;

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

@Column(columnDefinition = "jsonb")
private Object secrets;

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
