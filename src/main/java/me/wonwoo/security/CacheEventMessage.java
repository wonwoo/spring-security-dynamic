package me.wonwoo.security;

import me.wonwoo.domain.dto.AuthoritiesDto;
import org.springframework.context.ApplicationEvent;

import java.util.List;

/**
 * Created by wonwoo on 2016. 4. 9..
 */
public class CacheEventMessage extends ApplicationEvent {
  /**
   * Create a new ApplicationEvent.
   *
   * @param source the object on which the event initially occurred (never {@code null})
   */
  final List<AuthoritiesDto> authoritiesDto;

  public CacheEventMessage(Object source, final List<AuthoritiesDto> authoritiesDto) {
    super(source);
    this.authoritiesDto = authoritiesDto;
  }

  public List<AuthoritiesDto> getAuthoritiesDto() {
    return authoritiesDto;
  }
}
