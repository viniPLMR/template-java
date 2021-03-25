package br.com.it2.api.java.model;

import java.time.LocalDate;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class BaseEntityListener {

	@PrePersist
	public void onPrePersist(BaseEntity entity) {
		entity.setCreationDate(LocalDate.now());
		entity.setUpdateDate(LocalDate.now());
	}

	@PreUpdate
	public void onPreUpdate(BaseEntity entity) {
		entity.setUpdateDate(LocalDate.now());
	}

}
