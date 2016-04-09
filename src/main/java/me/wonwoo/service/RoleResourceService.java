package me.wonwoo.service;

import me.wonwoo.repository.RoleResourceRepository;
import me.wonwoo.security.service.ResourceMetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleResourceService {

  @Autowired
  private RoleResourceRepository roleResourceRepository;

  @Autowired
  private ResourceMetaService resourceMetaService;

  @Transactional
  public void delete(Integer id){
    roleResourceRepository.delete(id);
    resourceMetaService.findAllResources();
  }
}
