/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Account {

    public Account(String name, String passWord, String email, int admin) {
	super();
	this.name = name;
	this.passWord = passWord;
	this.email = email;
	this.admin = admin;
    }

    public Account(String name, String passWord, String email) {
	super();
	this.name = name;
	this.passWord = passWord;
	this.email = email;
    }

    public Account(int id, String name, String passWord) {
	super();
	this.id = id;
	this.name = name;
	this.passWord = passWord;
    }

    public Account(int id, String name, String passWord, String email) {
	super();
	this.id = id;
	this.name = name;
	this.passWord = passWord;
	this.email = email;
    }

    private int id;
    private String name;
    private String passWord;
    private String email;
    private int admin;

    public int getAdmin() {
	return admin;
    }

    public void setAdmin(int admin) {
	this.admin = admin;
    }

    public Account() {
    }

    public Account(int id, String name, String passWord, String email, int admin) {
	this.id = id;
	this.name = name;
	this.passWord = passWord;
	this.email = email;
	this.admin = admin;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getPassWord() {
	return passWord;
    }

    @Override
    public String toString() {
	return "Account [id=" + id + ", name=" + name + ", passWord=" + passWord + ", email=" + email + ", admin="
		+ admin + "]";
    }

    public void setPassWord(String passWord) {
	this.passWord = passWord;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

}
