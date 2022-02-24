package zidni.backend.Services;

import zidni.backend.Exception.EtAuthException;
import zidni.backend.model.Users;

public interface UsersService {

	public Users login(String mail,String password) throws EtAuthException;
	
	public Users register(Users user) throws EtAuthException;
	
	public Users getUserByEmail(String email) throws EtAuthException;
}
