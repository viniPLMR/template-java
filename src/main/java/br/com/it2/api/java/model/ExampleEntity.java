package br.com.it2.api.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="example_table")
//@AttributeOverride(name = "id", column = @Column(name = "newId"))
public class ExampleEntity extends BaseEntity {

	@Column
	private String name;
	
	@Column
	private Boolean active;
	
	@Transient
	private String message;
	
	public void work() {
		this.message = "Hello world";
	}
	
}
