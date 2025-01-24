package guru.springframework.sfgrestbrewery.web.mappers;

import guru.springframework.sfgrestbrewery.domain.Customer;
import guru.springframework.sfgrestbrewery.domain.Customer.CustomerBuilder;
import guru.springframework.sfgrestbrewery.web.model.CustomerDto;
import guru.springframework.sfgrestbrewery.web.model.CustomerDto.CustomerDtoBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-18T12:29:07+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer customerDtoToCustomer(CustomerDto dto) {
        if ( dto == null ) {
            return null;
        }

        CustomerBuilder customer = Customer.builder();

        customer.id( dto.getId() );
        customer.name( dto.getName() );

        return customer.build();
    }

    @Override
    public CustomerDto customerToCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDtoBuilder customerDto = CustomerDto.builder();

        customerDto.id( customer.getId() );
        customerDto.name( customer.getName() );

        return customerDto.build();
    }
}
