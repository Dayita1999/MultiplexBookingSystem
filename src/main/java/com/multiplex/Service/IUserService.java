package com.multiplex.Service;

import com.multiplex.Exceptions.UserAlreadyExistsException;
import com.multiplex.Model.User;

public interface IUserService {
	public User addUserDetails(User user) throws UserAlreadyExistsException ;

}
