package me.wonwoo.security.service;

import me.wonwoo.domain.dto.AuthoritiesDto;
import me.wonwoo.security.CacheEventMessage;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

@Component
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

//    String dbUrl;
//    for (UserRoleDto userRoleDto : event.getUserRoleDto()) {
//      dbUrl = userRoleDto.getUrl();
//      if (this.urlRoles.containsKey(dbUrl)) {
//        List<String> roles = this.urlRoles.get(dbUrl);
//        roles.add(userRoleDto.getRoleName());
//
//      } else {
//        List<String> roles = new ArrayList<>();
//        roles.add(userRoleDto.getRoleName());
//        this.urlRoles.put(dbUrl, roles);
//      }
//    }
  }
}
