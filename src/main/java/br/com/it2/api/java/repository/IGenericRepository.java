package br.com.it2.api.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.it2.api.java.model.GenericEntity;

@Repository
public interface IGenericRepository<Entity extends GenericEntity> extends JpaRepository<Entity, Long>, JpaSpecificationExecutor<Entity>{

}
