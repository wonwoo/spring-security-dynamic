package me.wonwoo.repository.querydsl;

import com.mysema.query.types.ConstructorExpression;
import me.wonwoo.domain.*;
import me.wonwoo.domain.dto.AuthoritiesDto;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

public class ResourceRepositoryImpl extends QueryDslRepositorySupport implements CustomResourceRepository {

    public ResourceRepositoryImpl() {
        super(Resources.class);
    }

    @Override
    public List<AuthoritiesDto> findAllAuthorities() {
        QRole r = QRole.role;
        QRoleResource ra = QRoleResource.roleResource;
        QResources a = QResources.resources;
        List<AuthoritiesDto> list = from(r)
                .innerJoin(r.roleResources, ra)
                .where(r.eq(ra.role))
                .innerJoin(ra.resources, a)
                .where(ra.resources.eq(a)).list(ConstructorExpression.create(AuthoritiesDto.class, a.name, r.roleName));
        return list;
    }
}
