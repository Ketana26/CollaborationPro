package com.chatapp.controller;



import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.chatapp.dao.UsersDao;

import com.chatapp.model.Users;

@RestController
public class UserController {
@Autowired
UsersDao usersDao;
@RequestMapping(value="/fileUpload", method=RequestMethod.POST)
public void registerUser(@RequestParam("file") MultipartFile file,@RequestParam("name") String name,@RequestParam("password") String password,@RequestParam("address") String address,@RequestParam("dob") String dob,@RequestParam("email") String email,@RequestParam("contact") String contact)
{
	System.out.println("Inside");
	System.out.println("file:"+file);
	System.out.println("Name:"+name+"\t"+password+"\t" + address);
	Users user=new Users();
	user.setDateofbirth(dob);
	user.setAddress(address);
	user.setPassword(password);
	user.setContact(contact);
	user.setEmail(email);
	user.setName(name);
	usersDao.registerUser(user);
	//D:\Chatbucketfront\WebContent\images
	
	Path path=Paths.get("D://Collaboration//WebContent//images//"+name+".jpg");
	if(file!=null)
	{
		try {
			file.transferTo(new File(path.toString()));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}


@RequestMapping(value = "/getUsers", method = RequestMethod.GET, headers = "Accept=application/json")  
public List<Users> getUsers()
{
	 List<Users> users=usersDao.listUsers();
	return users;
}
@RequestMapping(value="/authenticate", method=RequestMethod.POST,headers="Accept=application/json")
public int authenticateUser(@RequestBody Users users)
{
	System.out.println("in authenticate");
	 System.out.println("name:"+users.getName());
	 System.out.println("password:"+users.getPassword());
	 
int result=0;
	 result=usersDao.validateUser(users.getName(),users.getPassword());
	 System.out.println("result is:"+result);
	 return result;
}





@RequestMapping(value = "/findFriends/{name}", method = RequestMethod.GET, headers = "Accept=application/json")  
public List<Users> findFriends(@PathVariable String name)
{
	 List<Users> users=usersDao.findFriends(name);
	return users;
}
@RequestMapping(value = "/updateUsers", method = RequestMethod.PUT, headers = "Accept=application/json")  
public void updateUsers(@RequestBody Users users)
{
	 usersDao.updateUsers(users);
}
@RequestMapping(value = "/logout/{name}", method = RequestMethod.POST, headers = "Accept=application/json")  
public void logout(@PathVariable String name)
{
	 usersDao.logout(name);
}
}

