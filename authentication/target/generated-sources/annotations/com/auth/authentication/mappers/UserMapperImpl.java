package com.auth.authentication.mappers;

import com.auth.authentication.dtos.UserDto;
import com.auth.authentication.exceptions.ServiceException;
import com.auth.authentication.models.User;
import com.auth.authentication.models.User.UserBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-22T23:29:37+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 19.0.2 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User mapDto(UserDto d) throws ServiceException {
        if ( d == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.username( d.getUsername() );
        user.password( d.getPassword() );
        user.firstName( d.getFirstName() );
        user.lastName( d.getLastName() );
        user.accountNumber( d.getAccountNumber() );
        user.cardNumber( d.getCardNumber() );
        user.mobile( d.getMobile() );

        return user.build();
    }

    @Override
    public UserDto mapEntity(User e) {
        if ( e == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( e.getId() );
        userDto.setVersion( e.getVersion() );
        userDto.setUsername( e.getUsername() );
        userDto.setPassword( e.getPassword() );
        userDto.setFirstName( e.getFirstName() );
        userDto.setLastName( e.getLastName() );
        userDto.setAccountNumber( e.getAccountNumber() );
        userDto.setCardNumber( e.getCardNumber() );
        userDto.setMobile( e.getMobile() );

        return userDto;
    }
}
