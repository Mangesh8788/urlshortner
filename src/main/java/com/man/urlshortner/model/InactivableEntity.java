package com.man.urlshortner.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class InactivableEntity extends AuditableEntiy {

	public static final String IS_ACTIVE = "is_active";
	public static final char ACTIVE = 'Y';
	public static final char IN_ACTIVE = 'N';

	@Column(name = IS_ACTIVE, length = 1, columnDefinition = " CHAR(1) default 'N'")
	private char isActive;
}
