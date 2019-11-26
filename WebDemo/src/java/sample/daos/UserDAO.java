/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.dtos.UserDTO;
import sample.utils.DBUtils;

/**
 *
 * @author sonho
 */
public class UserDAO {

    static Connection cnn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;

    private static void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (cnn != null) {
            cnn.close();
        }
    }

    public static UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO dto = new UserDTO();
        try {
            cnn = DBUtils.getConnection();
            if (cnn != null) {
                String sql = "select userName,email, roleID from tblUsers where userID = ? and password = ?";
                ps = cnn.prepareStatement(sql);
                ps.setString(1, userID);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs.next()) {
                    dto.setUserName(rs.getString("UserName"));
                    dto.setRoleID(rs.getString("RoleID").trim());
                    dto.setEmail(rs.getString("Email"));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeConnection();
        }
        return dto;
    }

    public static List<UserDTO> getListUser(String search) throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        try {
            cnn = DBUtils.getConnection();
            if (cnn != null) {
                String sql = "Select userID, userName,email, password, roleID from tblUsers where userName like ?";
                ps = cnn.prepareStatement(sql);
                ps.setString(1, "%" + search + "%");
                //ps.setString(1, search);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("UserID");
                    String password = rs.getString("Password");
                    String userName = rs.getString("UserName");
                    String email = rs.getString("Email");
                    String roleID = rs.getString("RoleID");
                    list.add(new UserDTO(userID, userName, email, password, roleID));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }
}
