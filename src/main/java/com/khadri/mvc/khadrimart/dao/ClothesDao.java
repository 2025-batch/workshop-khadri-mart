package com.khadri.mvc.khadrimart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.khadri.mvc.khadrimart.connection.DBConnection;
import com.khadri.mvc.khadrimart.service.dto.ClothesDto;

public class ClothesDao {

	public int insertCloth(ClothesDto dto) {
		int count = 0;
		Connection con = DBConnection.getConnection();

		try (PreparedStatement ps = con
				.prepareStatement("INSERT INTO public.clothes(clothname, quantity, user_name) VALUES (?, ?, ?)")) {

			ps.setString(1, dto.getClothName());
			ps.setInt(2, dto.getQuantity());
			ps.setString(3, dto.getUserName());

			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
