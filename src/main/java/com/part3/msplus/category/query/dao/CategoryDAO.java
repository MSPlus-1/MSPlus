package com.part3.msplus.category.query.dao;

import com.part3.msplus.category.command.domain.entity.Category;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.part3.msplus.category.command.domain.entity.QCategory.category;

@Repository
@RequiredArgsConstructor
public class CategoryDAO {
    private final JPAQueryFactory jpaQueryFactory;

    public Page<Category> findAll(Pageable pageable) {
        QueryResults<Category> results = jpaQueryFactory
                .select(category)
                .from(category)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }

//    paging 없이 전체 조회
//    public List<Category> findAll() {
//        return jpaQueryFactory
//                .select(category)
//                .from(category)
//                .fetch();
//    }

}
