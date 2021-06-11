package com.man.urlshortner.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class AuditableEntiy extends IdentityEntity {

	public static final String CREATED_BY = "created_by";
	public static final String CREATED_DATE = "created_date";
	public static final String UPDATED_BY = "updated_by";
	public static final String UPDATED_DATE = "updated_date";

	@Column(name = CREATED_BY)
	private String createdBy;
	@Column(name = CREATED_DATE)
	private Timestamp createdDate;
	@Column(name = UPDATED_BY)
	private String updatedBy;
	@Column(name = UPDATED_DATE)
	private Timestamp updatedDate;

}
