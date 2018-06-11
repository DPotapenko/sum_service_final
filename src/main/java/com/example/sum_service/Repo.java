package com.example.sum_service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Repo extends JpaRepository<Model, Long> {

    @Query(value = "select * from test_table t where t.name = :name", nativeQuery = true)
    Model findByName(@Param("name") String name);

    @Query(value = "select count(*) from test_table t where t.name = :name", nativeQuery = true)
    int userCount(@Param("name") String name);

    @Query(value = "select t.value from test_table t where t.name = :name", nativeQuery = true)
    int getVal(@Param("name") String name);
}
