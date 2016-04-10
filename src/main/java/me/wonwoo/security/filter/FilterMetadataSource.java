package me.wonwoo.security.filter;

import lombok.extern.slf4j.Slf4j;
import me.wonwoo.domain.dto.AuthoritiesDto;
import me.wonwoo.security.service.CacheManager;
import me.wonwoo.security.service.ResourceMetaService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class FilterMetadataSource implements FilterInvocationSecurityMetadataSource, InitializingBean {

  @Autowired
  private ResourceMetaService resourceMetaService;

  @Autowired
  private CacheManager cacheManager;


  @Override
  public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
    FilterInvocation fi = (FilterInvocation) object;
    String url = fi.getRequestUrl();

    List<AuthoritiesDto> userRoleDto = cacheManager.getAuthorities().get(url);
    if (userRoleDto == null) {
      return null;
    }
    List<String> roles = userRoleDto.stream().map(AuthoritiesDto::getRoleName).collect(Collectors.toList());

    String[] stockArr = new String[roles.size()];
    stockArr = roles.toArray(stockArr);

    return SecurityConfig.createList(stockArr);
  }

  @Override
  public Collection<ConfigAttribute> getAllConfigAttributes() {
    return null;
  }

  @Override
  public boolean supports(Class<?> clazz) {
    return FilterInvocation.class.isAssignableFrom(clazz);
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    resourceMetaService.findAllResources();
  }
}