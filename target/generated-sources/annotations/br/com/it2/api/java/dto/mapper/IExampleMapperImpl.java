package br.com.it2.api.java.dto.mapper;

import br.com.it2.api.java.dto.request.ExampleRequest;
import br.com.it2.api.java.dto.response.ExampleResponse;
import br.com.it2.api.java.model.ExampleEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-16T17:45:03-0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_321 (Oracle Corporation)"
)
@Component
public class IExampleMapperImpl implements IExampleMapper {

    @Override
    public ExampleEntity toEntity(ExampleRequest request) {
        if ( request == null ) {
            return null;
        }

        ExampleEntity exampleEntity = new ExampleEntity();

        exampleEntity.setName( request.getName() );

        return exampleEntity;
    }

    @Override
    public ExampleEntity toEntity(Long id) {
        if ( id == null ) {
            return null;
        }

        ExampleEntity exampleEntity = new ExampleEntity();

        exampleEntity.setId( id );

        return exampleEntity;
    }

    @Override
    public ExampleEntity toEntity(ExampleRequest request, Long id) {
        if ( request == null && id == null ) {
            return null;
        }

        ExampleEntity exampleEntity = new ExampleEntity();

        if ( request != null ) {
            exampleEntity.setName( request.getName() );
        }
        if ( id != null ) {
            exampleEntity.setId( id );
        }

        return exampleEntity;
    }

    @Override
    public ExampleResponse toResponse(ExampleEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ExampleResponse exampleResponse = new ExampleResponse();

        exampleResponse.setId( entity.getId() );
        exampleResponse.setName( entity.getName() );

        return exampleResponse;
    }

    @Override
    public List<ExampleResponse> toResponse(List<ExampleEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ExampleResponse> list = new ArrayList<ExampleResponse>( entityList.size() );
        for ( ExampleEntity exampleEntity : entityList ) {
            list.add( toResponse( exampleEntity ) );
        }

        return list;
    }
}
