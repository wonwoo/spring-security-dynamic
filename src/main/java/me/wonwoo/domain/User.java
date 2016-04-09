package me.wonwoo.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;
import static me.wonwoo.domain.QUser.user;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "USERNAME"))
@Data
@ToString(exclude = "userRoles")
public class User {

  @Id
  @GeneratedValue
  @Column(name = "ID", unique = true, nullable = false)
  private Integer id;

  @Column(name = "USERNAME", unique = true, length = 50)
  private String username;

  @Column(name = "PASSWORD", length = 50)
  private String password;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  private List<Authorities> userRoles = new ArrayList<>();
}
