package com.khadri.mvc.khadrimart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.khadri.mvc.khadrimart.connection.DBConnection;
import com.khadri.mvc.khadrimart.service.dto.CarsDto;

public class CarsDao {

    public int saveCar(CarsDto dto) {
        int count = 0;
        String sql = "INSERT INTO cars (car_name, quantity, color) VALUES (?, ?, ?)";
        
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, dto.getCarName());
            ps.setInt(2, dto.getQuantity());
            ps.setString(3, dto.getColor());
            
            count = ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return count;
    }
}

