package org.safari.et.Service;

import org.safari.et.dao.UserDao;
import org.safari.et.dto.RequestDto.UserRequestDto;
import org.safari.et.dto.StatusDto;
import org.safari.et.model.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UserService {
@EJB
private UserDao userDao;

    public StatusDto register(UserRequestDto userRequestDto) {
        try {
            User user =new User();
            user.setFirstname(userRequestDto.getFirstname());
            user.setLastname(userRequestDto.getLastname());
            userDao.create(user);
            return (new StatusDto(true, "success"));
        } catch (Exception e) {
            return new StatusDto(false, "unable to register");
        }

    }


    public StatusDto update(UserRequestDto userRequestDto, Long id) {
        User user =userDao.findById(id);
        if (user == null) {
            return new StatusDto(false, "does not exit");
        }
        try {

            user.setFirstname(userRequestDto.getFirstname());
            user.setLastname(userRequestDto.getLastname());
            return (new StatusDto(true, "Updated"));
        } catch (Exception e) {
            return new StatusDto(false, "unable to register");
        }

    }
}