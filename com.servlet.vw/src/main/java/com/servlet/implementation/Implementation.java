package com.servlet.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.servlet.encapsulated.Volkswagenentity;
import com.servlet.jdbc.Jdbc;

public class Implementation {
	Connection connect;
	PreparedStatement prep;
	ResultSet resultset;
	Statement state;
	
	
	public Implementation() {
		connect = Jdbc.getinstance();
	}
	//create 
	public int Insertmethod(Volkswagenentity entity) {
		int result = 0;
		String query = "insert into vans values(?,?,?,?)";
		
		try {
			prep = connect.prepareStatement(query);
			prep.setString(1, entity.getModelName());
			prep.setInt(2, entity.getPrice());
			prep.setString(3, entity.getFueltype());
			prep.setInt(4, entity.getSafetyrating());
			result = prep.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	//Read Search
	public Volkswagenentity Search(String en) {
		Volkswagenentity entity = null;
		System.out.println("Implimentation class Triggered");
		String ec = String.valueOf(en);
		try {
			String query = "select * from vans where modelName =?";
			prep = connect.prepareStatement(query);
			prep.setString(1, ec);
			resultset =prep.executeQuery();
		
			
			while(resultset.next()) {
				entity = new Volkswagenentity();
				entity.setModelName(resultset.getString(1));
				entity.setPrice(resultset.getInt(2));
				entity.setFueltype(resultset.getString(3));
				entity.setSafetyrating(resultset.getInt(4));
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return entity;
		
	}
	
	//Search
	public List<Volkswagenentity>Fetch(){
		List<Volkswagenentity> listproduct = new ArrayList<Volkswagenentity>();
		String query = "select * from vans";
		try {
			state = connect.createStatement();
			resultset = state.executeQuery(query);
			Volkswagenentity entity = null;
			while(resultset.next()) {
				entity = new Volkswagenentity();
				entity.setModelName(resultset.getString(1));
				entity.setPrice(resultset.getInt(2));
				entity.setFueltype(resultset.getString(3));
				entity.setSafetyrating(resultset.getInt(4));
				listproduct.add(entity);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listproduct;	
		
	}
	
	//delete 
	public int delete(Volkswagenentity volkswagen) {
		int result = 0;
		String query = "delete from vans where modelName = '"+volkswagen.getModelName()+"';";
		
		try {
			state = connect.createStatement();
			result = state.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	
		
	}
	//update
	public int update(Volkswagenentity entity) {
		int result = 0;
		String query = "update vans set price =? , fueltype =? where modelName = ?";
		try {
			prep=connect.prepareStatement(query);
			prep.setInt(1, entity.getPrice());
			prep.setString(2, entity.getFueltype());
			prep.setString(3, entity.getModelName());
			result = prep.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
		
		
	}
}
