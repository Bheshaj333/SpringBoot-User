package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(schema = "kubernetes", name = "kubernetes_service")
@Data
public class KubernetesService {

@Id
private UUID cdId = UUID.randomUUID();

@Column private String accountId;

@Column private UUID cdOrgId;

@Column private long cdSnapshotVersion;

@Column private boolean allocateLoadBalancerNodePorts;

@Column(columnDefinition = "jsonb")
private Object annotations;

@Column(columnDefinition = "text")
private String clusterIp;

@Column(columnDefinition = "jsonb")
private Object clusterIps;

@Column(columnDefinition = "text")
private String contextName;

@Column private ZonedDateTime creationTimestamp;

@Column private long deletionGracePeriodSeconds;

@Column private ZonedDateTime deletionTimestamp;

@Column private long endLine;

@Column(columnDefinition = "jsonb")
private Object externalIps;

@Column(columnDefinition = "text")
private String externalName;

@Column(columnDefinition = "text")
private String externalTrafficPolicy;

@Column(columnDefinition = "jsonb")
private Object finalizers;

@Column(columnDefinition = "text")
private String generateName;

@Column private long generation;

@Column private long healthCheckNodePort;

@Column(columnDefinition = "jsonb")
private Object ipFamilies;

@Column(columnDefinition = "text")
private String ipFamilyPolicy;

@Column(columnDefinition = "jsonb")
private Object labels;

@Column(columnDefinition = "jsonb")
private Object loadBalancerIngress;

@Column(columnDefinition = "text")
private String loadBalancerIp;

@Column(columnDefinition = "jsonb")
private Object loadBalancerSourceRanges;

@Column(columnDefinition = "text")
private String name;

@Column(columnDefinition = "text")
private String namespace;

@Column(columnDefinition = "jsonb")
private Object ownerReferences;

@Column(columnDefinition = "text")
private String path;

@Column(columnDefinition = "jsonb")
private Object ports;

@Column private boolean publishNotReadyAddresses;

@Column(columnDefinition = "text")
private String resourceVersion;

@Column(columnDefinition = "jsonb")
private Object selector;

@Column(columnDefinition = "text")
private String selectorQuery;

@Column(columnDefinition = "text")
private String sessionAffinity;

@Column private long sessionAffinityClientIpTimeout;

@Column(columnDefinition = "text")
private String sourceType;

@Column private long startLine;

@Column(columnDefinition = "jsonb")
private Object tags;

@Column(columnDefinition = "text")
private String title;

@Column(columnDefinition = "jsonb")
private Object topologyKeys;

@Column(columnDefinition = "text")
private String type;

@Column(columnDefinition = "text")
private String uid;

}
