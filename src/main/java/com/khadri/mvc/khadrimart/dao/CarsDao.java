package com.khadri.mvc.khadrimart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.khadri.mvc.khadrimart.connection.DBConnection;
import com.khadri.mvc.khadrimart.service.dto.CarsDto;

public class CarsDao {

	public int saveCar(CarsDto dto) {
		int count = 0;
		Connection con = DBConnection.getConnection();
		if (con == null) {
			System.err.println("DB Connection is null!");
			return 0;
		}

		try (PreparedStatement ps = con
				.prepareStatement("INSERT INTO public.cars(carname, quantity, color, user_name) VALUES (?, ?, ?, ?)")) {

			ps.setString(1, dto.getCarName());
			ps.setInt(2, dto.getQuantity());
			ps.setString(3, dto.getColor());
			ps.setString(4, dto.getUserName());

			count = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}
}
