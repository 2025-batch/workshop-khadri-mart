package com.khadri.mvc.khadrimart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.khadri.mvc.khadrimart.connection.DBConnection;
import com.khadri.mvc.khadrimart.service.dto.VegetableDto;

public class VegetableDao {
	public int insert(VegetableDto dto) {
		int result = 0;
		Connection con = DBConnection.getConnection();
		if (con == null) {
			System.err.println("DB Connection is null!");
			return 0;
		}

		try (PreparedStatement ps = con
				.prepareStatement("INSERT INTO public.vegetables(vegname, quantity, user_name) VALUES (?, ?, ?)")) {

			ps.setString(1, dto.getVegname());
			ps.setDouble(2, dto.getQuantity());
			ps.setString(3, dto.getUserName());

			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
