package br.com.it2.api.java.exception;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-16T17:45:03-0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_321 (Oracle Corporation)"
)
@Component
public class IValidExceptionMapperImpl implements IValidExceptionMapper {

    @Override
    public ValidationException toValidException(BindException exception) {
        if ( exception == null ) {
            return null;
        }

        ValidationException validationException = new ValidationException();

        List<ObjectError> list = exception.getAllErrors();
        if ( list != null ) {
            validationException.setErrors( new ArrayList<ObjectError>( list ) );
        }

        return validationException;
    }
}
