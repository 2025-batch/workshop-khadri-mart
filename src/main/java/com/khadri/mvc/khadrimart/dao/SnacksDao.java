package com.khadri.mvc.khadrimart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.khadri.mvc.khadrimart.connection.DBConnection;
import com.khadri.mvc.khadrimart.controller.form.SnacksForm;

public class SnacksDao {

	public int insertSnack(SnacksForm form) {
		int count = 0;
		Connection con = DBConnection.getConnection();
		if (con == null) {
			System.err.println("DB Connection is null!");
			return 0;
		}

		try (PreparedStatement ps = con
				.prepareStatement("INSERT INTO public.snacks(snack_name, quantity, user_name) VALUES (?, ?, ?)")) {

			ps.setString(1, form.getSnackName());
			ps.setDouble(2, form.getQuantity());
			ps.setString(3, form.getUserName());

			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
