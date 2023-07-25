package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(schema = "kubernetes", name = "kubernetes_pod")
@Data
public class KubernetesPod {

@Id
private UUID cdId = UUID.randomUUID();

@Column private String accountId;

@Column private UUID cdOrgId;

@Column private long cdSnapshotVersion;

@Column(columnDefinition = "text")
private String activeDeadlineSeconds;

@Column(columnDefinition = "jsonb")
private Object affinity;

@Column(columnDefinition = "jsonb")
private Object annotations;

@Column private boolean automountServiceAccountToken;

@Column(columnDefinition = "jsonb")
private Object conditions;

@Column(columnDefinition = "jsonb")
private Object containerStatuses;

@Column(columnDefinition = "jsonb")
private Object containers;

@Column(columnDefinition = "text")
private String contextName;

@Column private ZonedDateTime creationTimestamp;

@Column private long deletionGracePeriodSeconds;

@Column private ZonedDateTime deletionTimestamp;

@Column(columnDefinition = "jsonb")
private Object dnsConfig;

@Column(columnDefinition = "text")
private String dnsPolicy;

@Column private boolean enableServiceLinks;

@Column private long endLine;

@Column(columnDefinition = "jsonb")
private Object ephemeralContainerStatuses;

@Column(columnDefinition = "jsonb")
private Object ephemeralContainers;

@Column(columnDefinition = "jsonb")
private Object finalizers;

@Column(columnDefinition = "text")
private String generateName;

@Column private long generation;

@Column(columnDefinition = "jsonb")
private Object hostAliases;

@Column(columnDefinition = "text")
private String hostIp;

@Column private boolean hostIpc;

@Column private boolean hostNetwork;

@Column private boolean hostPid;

@Column(columnDefinition = "text")
private String hostname;

@Column(columnDefinition = "jsonb")
private Object imagePullSecrets;

@Column(columnDefinition = "jsonb")
private Object initContainerStatuses;

@Column(columnDefinition = "jsonb")
private Object initContainers;

@Column(columnDefinition = "jsonb")
private Object labels;

@Column(columnDefinition = "text")
private String name;

@Column(columnDefinition = "text")
private String namespace;

@Column(columnDefinition = "text")
private String nodeName;

@Column(columnDefinition = "jsonb")
private Object nodeSelector;

@Column(columnDefinition = "text")
private String nominatedNodeName;

@Column(columnDefinition = "jsonb")
private Object overhead;

@Column(columnDefinition = "jsonb")
private Object ownerReferences;

@Column(columnDefinition = "text")
private String path;

@Column(columnDefinition = "text")
private String phase;

@Column(columnDefinition = "text")
private String podIp;

@Column(columnDefinition = "jsonb")
private Object podIps;

@Column(columnDefinition = "text")
private String preemptionPolicy;

@Column private long priority;

@Column(columnDefinition = "text")
private String priorityClassName;

@Column(columnDefinition = "text")
private String qosClass;

@Column(columnDefinition = "jsonb")
private Object readinessGates;

@Column(columnDefinition = "text")
private String resourceVersion;

@Column(columnDefinition = "text")
private String restartPolicy;

@Column(columnDefinition = "text")
private String runtimeClassName;

@Column(columnDefinition = "text")
private String schedulerName;

@Column(columnDefinition = "jsonb")
private Object securityContext;

@Column(columnDefinition = "text")
private String selectorSearch;

@Column(columnDefinition = "text")
private String serviceAccountName;

@Column private boolean setHostnameAsFqdn;

@Column private boolean shareProcessNamespace;

@Column(columnDefinition = "text")
private String sourceType;

@Column private long startLine;

@Column private ZonedDateTime startTime;

@Column(columnDefinition = "text")
private String statusMessage;

@Column(columnDefinition = "text")
private String statusReason;

@Column(columnDefinition = "text")
private String subdomain;

@Column(columnDefinition = "jsonb")
private Object tags;

@Column private long terminationGracePeriodSeconds;

@Column(columnDefinition = "text")
private String title;

@Column(columnDefinition = "jsonb")
private Object tolerations;

@Column(columnDefinition = "jsonb")
private Object topologySpreadConstraints;

@Column(columnDefinition = "text")
private String uid;

@Column(columnDefinition = "jsonb")
private Object volumes;

}
