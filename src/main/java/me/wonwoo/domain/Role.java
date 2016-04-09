
package me.wonwoo.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "role")
@Data
public class Role {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "ROLE_ID", unique = true, nullable = false)
  private Integer roleId;

  private String roleName;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
  private List<Authorities> authorities = new ArrayList<>();

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
  private List<RoleResource> roleResources = new ArrayList<>();
}
