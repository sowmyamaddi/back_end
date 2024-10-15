package com.example.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.Pojo.Signup;



@Repository
public class Myrepo 
{
	public Signup insert(Signup s) throws ClassNotFoundException, SQLException
	{
		String url="jdbc:mysql://localhost:3306/project";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection(url,"root","root");
		String obj="INSERT INTO USERS VALUES(?,?,?,?,?)";
		PreparedStatement pst=c.prepareStatement(obj);
		pst.setInt(1, s.getId());
		pst.setString(2,s.getFullname());
		pst.setString(3, s.getEmail());
		pst.setString(4,s.getPassword());
		pst.setString(5, s.getConfirm_password());
		pst.executeUpdate();
		return s;
		
	}
	public Signup update(Signup s1) throws ClassNotFoundException, SQLException
	{
		String url="jdbc:mysql://localhost:3306/project";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection(url,"root","root");
		String obj="UPDATE USERS SET FULLNAME=?,EMAIL=?,PASSWORD=?,CONFIRM_PASSWORD=? WHERE ID=?";
		PreparedStatement pst=c.prepareStatement(obj);
		pst.setString(1, s1.getFullname());
		pst.setString(2, s1.getEmail());
		pst.setString(3, s1.getPassword());
		pst.setString(4, s1.getConfirm_password());
		pst.setInt(5, s1.getId());
		pst.executeUpdate();
		return s1;
	}
	public String delete(int id) throws ClassNotFoundException, SQLException
	{
		String url="jdbc:mysql://localhost:3306/project";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection(url,"root","root");
		String obj="DELETE FROM USERS WHERE ID=?";
		PreparedStatement pst=c.prepareStatement(obj);
		pst.setInt(1, id);
//		pst.setString(2, s1.getFullname());
//		pst.setString(3, s1.getEmail());
//		pst.setString(4, s1.getPassword());
//		pst.setString(5, s1.getConfirm_password());
		pst.executeUpdate();
		return "Delete Successfully";
	}
	public List<Signup> get() throws ClassNotFoundException, SQLException
	{
		List<Signup> list=new ArrayList<>();
		String url="jdbc:mysql://localhost:3306/project";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection(url,"root","root");
		String obj="SELECT * FROM USERS";
		PreparedStatement pst=c.prepareStatement(obj);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			Signup mysignup=new Signup();
			mysignup.setId(rs.getInt("Id"));
			mysignup.setFullname(rs.getString("fullname"));
			mysignup.setEmail(rs.getString("email"));
			mysignup.setPassword(rs.getString("password"));
			mysignup.setConfirm_password(rs.getString("confirm_password"));
			list.add(mysignup);
		}
		return list;
	}
}
