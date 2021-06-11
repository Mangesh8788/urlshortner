package com.man.urlshortner.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class IdentityEntity {

	private static final String ID="id";
	@Column(name=ID)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
}
