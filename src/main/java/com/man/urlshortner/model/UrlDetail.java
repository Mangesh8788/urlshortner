package com.man.urlshortner.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.man.urlshortner.constant.UrlStatusConstant;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = UrlDetail.TABLE_NAME)
@Getter
@Setter
public class UrlDetail extends AuditableEntiy {

	public static final String TABLE_NAME = "tab_url_detail";
	public static final String ACTUAL_URL = "actual_url";
	public static final String SHORT_CODE_FOR_URL = "short_code_for_url";
	public static final String URL_EXPIRY_DATE = "url_expiry_date";
	public static final String TOTAL_COUNT_OF_URL_ACCESS_ALLOWED = "total_count_of_url_accessed_allowed";
	public static final String URL_ACCESSED_COUNT = "url_accessed_count";
	public static final String URL_STATUS = "url_status";

	@Column(name = ACTUAL_URL, columnDefinition = "varchar(1000)")
	private String actualUrl;

	@Column(name = SHORT_CODE_FOR_URL)
	private String shortCodeForUrl;

	@Column(name = URL_EXPIRY_DATE)
	private Date urlExpiryDate;

	@Enumerated(EnumType.STRING)
	private UrlStatusConstant urlStatus;
}
