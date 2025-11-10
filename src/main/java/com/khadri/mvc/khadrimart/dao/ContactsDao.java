package com.khadri.mvc.khadrimart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.khadri.mvc.khadrimart.connection.DBConnection;
import com.khadri.mvc.khadrimart.service.dto.ContactsDto;

public class ContactsDao {

    public int saveContact(ContactsDto dto) {
        int count = 0;
        String sql = "INSERT INTO contact_messages (name, email, message) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dto.getName());
            ps.setString(2, dto.getEmail());
            ps.setString(3, dto.getMessage());

            count = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}

