package com.khadri.mvc.khadrimart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.khadri.mvc.khadrimart.connection.DBConnection;
import com.khadri.mvc.khadrimart.service.dto.ClothesDto;

public class ClothesDao {

    public int insertCloth(ClothesDto dto) {
        int count = 0;
        String sql = "INSERT INTO clothes (cloth_name, quantity) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dto.getClothName());
            ps.setInt(2, dto.getQuantity());

            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
