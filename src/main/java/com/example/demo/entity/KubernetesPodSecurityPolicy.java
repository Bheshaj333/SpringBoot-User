package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(schema = "kubernetes", name = "kubernetes_pod_security_policy")
@Data
public class KubernetesPodSecurityPolicy {

@Id
private UUID cdId = UUID.randomUUID();

@Column private String accountId;

@Column private UUID cdOrgId;

@Column private long cdSnapshotVersion;

@Column private boolean allowPrivilegeEscalation;

@Column(columnDefinition = "jsonb")
private Object allowedCsiDrivers;

@Column(columnDefinition = "jsonb")
private Object allowedFlexVolumes;

@Column(columnDefinition = "jsonb")
private Object allowedHostPaths;

@Column(columnDefinition = "jsonb")
private Object allowedProcMountTypes;

@Column(columnDefinition = "jsonb")
private Object allowedUnsafeSysctls;

@Column(columnDefinition = "jsonb")
private Object annotations;

@Column(columnDefinition = "text")
private String contextName;

@Column private ZonedDateTime creationTimestamp;

@Column(columnDefinition = "jsonb")
private Object defaultAddCapabilities;

@Column private boolean defaultAllowPrivilegeEscalation;

@Column private long deletionGracePeriodSeconds;

@Column private ZonedDateTime deletionTimestamp;

@Column private long endLine;

@Column(columnDefinition = "jsonb")
private Object finalizers;

@Column(columnDefinition = "jsonb")
private Object forbiddenSysctls;

@Column(columnDefinition = "jsonb")
private Object fsGroup;

@Column(columnDefinition = "text")
private String generateName;

@Column private long generation;

@Column private boolean hostIpc;

@Column private boolean hostNetwork;

@Column private boolean hostPid;

@Column(columnDefinition = "jsonb")
private Object hostPorts;

@Column(columnDefinition = "jsonb")
private Object labels;

@Column(columnDefinition = "text")
private String name;

@Column(columnDefinition = "jsonb")
private Object ownerReferences;

@Column(columnDefinition = "text")
private String path;

@Column private boolean privileged;

@Column private boolean readOnlyRootFilesystem;

@Column(columnDefinition = "jsonb")
private Object requiredDropCapabilities;

@Column(columnDefinition = "text")
private String resourceVersion;

@Column(columnDefinition = "jsonb")
private Object runAsGroup;

@Column(columnDefinition = "jsonb")
private Object runAsUser;

@Column(columnDefinition = "jsonb")
private Object runtimeClass;

@Column(columnDefinition = "jsonb")
private Object seLinux;

@Column(columnDefinition = "text")
private String sourceType;

@Column private long startLine;

@Column(columnDefinition = "jsonb")
private Object supplementalGroups;

@Column(columnDefinition = "jsonb")
private Object tags;

@Column(columnDefinition = "text")
private String title;

@Column(columnDefinition = "text")
private String uid;

@Column(columnDefinition = "jsonb")
private Object volumes;

}
