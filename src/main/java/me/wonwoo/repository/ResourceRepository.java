package me.wonwoo.repository;

import me.wonwoo.domain.Resources;
import me.wonwoo.repository.querydsl.CustomResourceRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resources, Integer>, CustomResourceRepository {

}
