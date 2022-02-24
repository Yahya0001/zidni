package zidni.backend.Services;

import java.util.Optional;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import zidni.backend.Exception.EtAuthException;
import zidni.backend.Repository.UsersRepository;
import zidni.backend.model.Historique;
import zidni.backend.model.Users;

@Transactional

@Service
public class UserServiceImpl implements UsersService {

private UsersRepository usersRepository;
public Users getUser(int id)
{
	Optional<Users> user=this.usersRepository.findById(id);
	if(user.isPresent())
		return user.get();
	else
		return null;
}
public Users login(String mail, String password) throws EtAuthException {
	try
	{
		System.out.println(mail);
		Users users=this.usersRepository.findByEmail(mail);
		if(users==null)
			throw new EtAuthException("Can't find any user with indicated email");
		if(!BCrypt.checkpw(password, users.getPassword()))
			throw new EtAuthException("Invalid email/password");
		return users;
	}catch(EmptyResultDataAccessException ex)
	{
		throw new EtAuthException("Invalid email/password"+ex.getMessage());
	}
	}
public Users register(Users users) throws EtAuthException {
	Pattern pattern=Pattern.compile("^(.+)@(.+)$");
	if(users.getMail()!=null)
		users.setMail(users.getMail().toLowerCase());
	if(!pattern.matcher(users.getMail()).matches())
	{
		throw new EtAuthException("Invalid Email format");
	}
	long count=this.usersRepository.countByEmail(users.getMail());
	if(count>0)
		throw new EtAuthException("Email already in use");
	String hashedPassword=BCrypt.hashpw(users.getPassword(),BCrypt.gensalt(10));
	users.setPassword(hashedPassword);
	users.setId(93432342);
	Historique p=new Historique(999);
	users.setHistorique(p);
	this.usersRepository.save(users);
	return users;
	}
	public java.util.List<Users> getallusers()
	{
		java.util.List<Users> liste=this.usersRepository.findAll();
		return liste;
	}
	
	public Users getUserByEmail(String email) throws EtAuthException {
		Users users= this.usersRepository.findByEmail(email);
		if(users==null)
			throw new EtAuthException("Can't find any user with this email");
		return users;
	}
}