package com.man.urlshortner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.man.urlshortner.model.UrlDetail;

@Repository
public interface UrlDetailRepository extends JpaRepository<UrlDetail, Integer> {

}
