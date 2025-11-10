package com.khadri.mvc.khadrimart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.khadri.mvc.khadrimart.connection.DBConnection;
import com.khadri.mvc.khadrimart.service.dto.VegetableDto;

public class VegetableDao {
	 public int insert(VegetableDto dto) {
	        int result = 0;
	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(
	                 "INSERT INTO vegetables(vegname, quantity) VALUES (?, ?)")) {

	            ps.setString(1, dto.getVegname());
	            ps.setDouble(2, dto.getQuantity());

	            result = ps.executeUpdate();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return result;
	 }
}
