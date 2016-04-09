package me.wonwoo.repository.querydsl;

import me.wonwoo.domain.dto.AuthoritiesDto;

import java.util.List;

public interface CustomResourceRepository {

    List<AuthoritiesDto> findAllAuthorities();
}
