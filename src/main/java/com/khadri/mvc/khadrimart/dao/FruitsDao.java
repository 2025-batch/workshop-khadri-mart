package com.khadri.mvc.khadrimart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.khadri.mvc.khadrimart.connection.DBConnection;
import com.khadri.mvc.khadrimart.service.dto.FruitsDto;

public class FruitsDao {
    public int insert(FruitsDto dto) {
        int result = 0;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO fruits (fruitname, quantity) VALUES (?, ?)"
            );
            ps.setString(1, dto.getFruitname());
            ps.setInt(2, dto.getQuantity());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

