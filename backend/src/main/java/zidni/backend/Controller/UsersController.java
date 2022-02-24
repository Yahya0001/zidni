package zidni.backend.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import zidni.backend.Services.UserServiceImpl;
import zidni.backend.model.Users;

import io.jsonwebtoken.Jwts;
import zidni.backend.Contants.Constants;
import io.jsonwebtoken.SignatureAlgorithm;


@CrossOrigin(origins="http://localhost:4200")  
@RestController
@RequestMapping("/Api/Users")

public class UsersController {
@Autowired

private UserServiceImpl userService;
@RequestMapping(value="/getuser/{id}", method=RequestMethod.GET)
public Users getUser(@PathVariable int id)
{
	return this.userService.getUser(id);
}
@RequestMapping(value="/hi",method=RequestMethod.POST)
public String gethi(@RequestBody int id)
{
	return "hhh";
}
@RequestMapping(value="/register", method=RequestMethod.POST)
public ResponseEntity<Map<String,String>> register(@RequestBody Users users)
{
	Users users_=this.userService.register(users);
	return new ResponseEntity<>(this.generateJWTToken(users_),HttpStatus.OK);
}
@RequestMapping(value="/login", method=RequestMethod.POST)
public ResponseEntity<Map<String,String>> login(@RequestBody Map<String,Object> userMap)
{
	String mail=(String) userMap.get("mail");
	String password=(String) userMap.get("password");
	System.out.println(mail +" "+password);
	Users users_=this.userService.login(mail, password);
	return new ResponseEntity<>(this.generateJWTToken(users_),HttpStatus.OK);
}
private Map<String,String> generateJWTToken(Users users)
{
	long timestamp =System.currentTimeMillis();
	String token=Jwts.builder().signWith(SignatureAlgorithm.HS256,Constants.API_SECRET_KEY).setIssuedAt(new Date(timestamp))
			.setExpiration(new Date(timestamp+Constants.TOKEN_VALIDITY))
			.claim("id",String.valueOf(users.getId()))
			.claim("mail",users.getMail())
			.compact();
	Map<String,String> map=new HashMap<String, String>();
	map.put("token", token);
	return map;
}
@RequestMapping(value="/getallusers",method=RequestMethod.GET)
public List<Users> getallusers()
{
	return this.userService.getallusers();
}
@RequestMapping(value="/getUserByEmail",method=RequestMethod.GET)
public ResponseEntity<Users> getUserByEmail(@RequestParam String email)
{
	return new ResponseEntity<Users>(this.userService.getUserByEmail(email),HttpStatus.OK);
}
}
