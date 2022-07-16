package br.com.api.java.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.api.java.dto.filter.ExampleFilter;
import br.com.api.java.model.ExampleEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExampleSpecification extends GenericSpecification<ExampleEntity, ExampleFilter> {

	private static final long serialVersionUID = 8419349800842250487L;
	
	private final ExampleFilter filter;

	@Override
	public Predicate toPredicate(Root<ExampleEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		
		Predicate predicate = criteriaBuilder.conjunction();

		if (filter == null)
			return null;

		generateBasicPredicate(predicate, filter, root, criteriaBuilder, new ExampleEntity());

		return predicate;
		
	}

}
