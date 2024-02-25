package com.part3.msplus.category.query.dao;

import com.part3.msplus.category.command.domain.entity.Category;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.part3.msplus.category.command.domain.entity.QCategory.category;

@Repository
@RequiredArgsConstructor
public class CategoryDAO {
    private final JPAQueryFactory jpaQueryFactory;

    public List<Category> findAll() {
        return jpaQueryFactory
                .select(category)
                .from(category)
                .fetch();
    }

}
