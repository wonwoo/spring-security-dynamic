package me.wonwoo.security.service;

import lombok.extern.slf4j.Slf4j;
import me.wonwoo.domain.dto.AuthoritiesDto;
import me.wonwoo.repository.ResourceRepository;
import me.wonwoo.security.CacheEventMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wonwoo on 2016. 4. 9..
 */
@Slf4j
public class ResourceMetaServiceImpl implements ResourceMetaService {

  @Autowired
  private ResourceRepository resourceRepository;

  @Autowired
  private ApplicationContext applicationContext;

  @Override
  public void findAllResources() {
    List<AuthoritiesDto> authorities = resourceRepository.findAllAuthorities();

    authorities.stream().forEach(userRoleDto -> {
      log.info("role name {} ", userRoleDto.getRoleName());
      log.info("url {}", userRoleDto.getUrl());
    });
    applicationContext.publishEvent(new CacheEventMessage(this, authorities));
  }
}
