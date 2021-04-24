package com.Buyers.BuyersReg.model;



/**
 * buyer.java
 * This is a model class represents a buyer entity
 */
public class Buyer{
    protected int id;
    protected String FristName;
    protected String LastName;
    protected String Username;
    protected String MobileNu;
    protected String Email;
    protected String Address;
    protected String Password;
    
 
    public Buyer() {
    }
 
    public Buyer(int id) {
        this.id = id;
        
    }
 
    public Buyer(int id, String FristName, String LastName, String Username,String MobileNu, String Email, String Address, String Password) {
        this(FristName, LastName, Username, MobileNu, Email, Address,Password);
        this.id = id;
        
    }
     
    public Buyer(String FristName, String LastName, String Username,String MobileNu , String Email, String Address, String Password) {
        this.FristName = FristName;
        this.LastName = LastName;
        this.Username = Username;
        this.MobileNu=MobileNu;
        this.Email = Email;
        this.Address = Address;
        this.Password = Password;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFristName() {
		return FristName;
	}

	public void setFristName(String fristName) {
		FristName = fristName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getMobileNu() {
		return MobileNu;
	}

	public void setMobileNu(String mobileNu) {
		MobileNu = mobileNu;
	}
 
   
 
  
}