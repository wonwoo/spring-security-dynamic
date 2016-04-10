package me.wonwoo.security.service;

import me.wonwoo.domain.dto.AuthoritiesDto;
import me.wonwoo.security.CacheEventMessage;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class CacheManager implements ApplicationListener<CacheEventMessage> {

  private Map<String, List<AuthoritiesDto>> authorities;

  public Map<String, List<AuthoritiesDto>> getAuthorities() {
    return authorities;
  }

  public List<AuthoritiesDto> getAuthoritie(String key) {
    return authorities.get(key);
  }

  @Override
  public void onApplicationEvent(CacheEventMessage event) {
    authorities = event.getAuthoritiesDto()
      .stream().collect(groupingBy(AuthoritiesDto::getUrl, toList()));

    // grouping
    // url => roles

//    String url;
//    for (UserRoleDto userRoleDto : event.getUserRoleDto()) {
//      url = userRoleDto.getUrl();
//      if (this.urlRoles.containsKey(url)) {
//        List<String> roles = this.urlRoles.get(url);
//        roles.add(userRoleDto.getRoleName());
//
//      } else {
//        List<String> roles = new ArrayList<>();
//        roles.add(userRoleDto.getRoleName());
//        this.urlRoles.put(url, roles);
//      }
//    }
  }
}
