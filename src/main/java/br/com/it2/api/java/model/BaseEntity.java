package br.com.it2.api.java.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(BaseEntityListener.class)
public class BaseEntity extends GenericEntity {
	
	@Column
	private LocalDate creationDate;
	
	@Column
	private LocalDate updateDate;

}
