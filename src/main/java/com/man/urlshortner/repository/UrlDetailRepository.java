package com.man.urlshortner.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.man.urlshortner.constant.UrlStatusConstant;
import com.man.urlshortner.model.UrlDetail;

@Repository
@Transactional
public interface UrlDetailRepository extends JpaRepository<UrlDetail, Integer> {

	UrlDetail findByShortCodeForUrl(String shortCode);
	UrlDetail findByShortCodeForUrlAndUrlStatus(String shortCode,
			UrlStatusConstant urlStatus);

	String updateUrlStatus = "UPDATE tab_url_detail tud SET tud.url_status=:STATUS WHERE tud.url_expiry_date < CURDATE()";
	@Modifying
	@Query(value = updateUrlStatus, nativeQuery = true)
	void updateUrlStatus(@Param("STATUS") String status);
}
