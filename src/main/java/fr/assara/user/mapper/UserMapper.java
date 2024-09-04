package fr.assara.user.mapper;

import fr.assara.user.ReadUserDTO;
import fr.assara.user.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    ReadUserDTO readUserDTOtoUser(User entity);
}
