package com.example.Controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Pojo.Signup;

import com.example.Repository.Myrepo;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Mycontroller 
{
	@Autowired
	public Myrepo repo;

	public Myrepo getRepo() {
		return repo;
	}

	public void setRepo(Myrepo repo) {
		this.repo = repo;
	}
	@PostMapping("/inserted")
	public Signup save(@RequestBody Signup s) throws ClassNotFoundException, SQLException
	{
		return repo.insert(s);
	}
	@PutMapping("/upd")
	public Signup save1(@RequestBody Signup s1) throws ClassNotFoundException, SQLException
	{
		return repo.update(s1);
	}
	@DeleteMapping("/delete/{id}")
	public String save2(@PathVariable int id) throws ClassNotFoundException, SQLException
	{
		return repo.delete(id);
	}
	@GetMapping("/gets")
	public List<Signup> getdata() throws ClassNotFoundException, SQLException
	{
		return repo.get();
	}
}
