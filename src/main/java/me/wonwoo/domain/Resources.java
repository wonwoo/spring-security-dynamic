package me.wonwoo.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "resources")
@Data
public class Resources {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "ID", unique = true, nullable = false)
  private Integer id;

  private String name;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "resources")
  private Set<RoleResource> roleResources = new HashSet<>();

}
