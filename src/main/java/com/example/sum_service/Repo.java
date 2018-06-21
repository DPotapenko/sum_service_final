package com.example.sum_service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Repo extends JpaRepository<Model, Long> {

    @Query(value = "select * from test_tab t where t.name = :name", nativeQuery = true)
    Model findByName(@Param("name") String name);

    @Query(value = "select count(*) from test_tab t where t.name = :name", nativeQuery = true)
    int userCount(@Param("name") String name);

    @Query(value = "select t.value from test_tab t where t.name = :name", nativeQuery = true)
    int getVal(@Param("name") String name);

}
