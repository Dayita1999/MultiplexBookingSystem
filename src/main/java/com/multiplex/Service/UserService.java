package com.multiplex.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.Exceptions.UserAlreadyExistsException;
import com.multiplex.Exceptions.UserNotFoundException;
import com.multiplex.Model.User;
import com.multiplex.Repository.UserDAO;
import com.multiplex.Repository.UserRepository;



@Service
public class UserService implements IUserService {
	
	public UserService() {
	}

@Autowired
private UserDAO userDAO;

@Override
public User addUserDetails(User user) throws UserAlreadyExistsException {
	Optional<User> optionalUser =  userDAO.findById(user.getId());
    if(optionalUser.isPresent()) {
    	throw new UserAlreadyExistsException("User already exists..!!");
    }
    
  
	return userDAO.save(user);

}
}