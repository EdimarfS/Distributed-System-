//This is the User class, we are getting the Users data
import java.io.*;
import java.util.*;
import java.net.*;


public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private String email;
	private transient String passoword;
	private Date reg_date;
	private int age;


	User(String username, String email, String passoword, Date reg_date, int age)
	{
		this.username = username;
		this.email = email;
		this.passoword = passoword;
		this.reg_date = reg_date;
		this.age = age;
	}

	//getter and setters 

	//username
	public void setUserName()
	{
		this.username = username;

	}

	public String getUserName()
	{
		return username;
	}

	//email
	public void setEmail()
	{
		this.email = email;

	}

	public String getEmail()
	{
		return email;
	}

	//password
	public void setPassword()
	{
		this.passoword = passoword;

	}

	public String getPassword()
	{
		return passoword;
	}

	//date
	public void setReg_date()
	{
		this.reg_date = reg_date;

	}

	public Date getReg_date()
	{
		return reg_date;
	}


	//age
	public void setAge()
	{
		this.age = age;

	}

	public int getAge()
	{
		return age;
	}


	//tostring function
	public String toString()
	{


		return 
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
               ", passoword='" + passoword + '\'' +
               ", date='" + reg_date + '\'' +
               ", age='" + age;
	}


}//End of the User class 

