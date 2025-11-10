package com.khadri.mvc.khadrimart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.khadri.mvc.khadrimart.connection.DBConnection;
import com.khadri.mvc.khadrimart.service.dto.SnacksDto;

public class SnacksDao {

    public int insertSnack(SnacksDto dto) {
        int count = 0;
        String sql = "INSERT INTO snacks (snack_name, quantity) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, dto.getSnackName());
            ps.setDouble(2, dto.getQuantity());
            
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}

