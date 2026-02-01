package database;

import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO {

    //            UPDATE
    public boolean updateDoctor(Doctor doctor) {
        String sql = """
            UPDATE staff
            SET name = ?, salary = ?, experience_years = ?, specialization = ?
            WHERE staff_id = ? AND staff_type = 'DOCTOR'
        """;

        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return false;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, doctor.getName());
            ps.setDouble(2, doctor.getSalary());
            ps.setInt(3, doctor.getExperienceYears());
            ps.setString(4, doctor.getSpecialization());
            ps.setInt(5, doctor.getStaffId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(conn);
        }
        return false;
    }

    public boolean updateNurse(Nurse nurse) {
        String sql = """
            UPDATE staff
            SET name = ?, salary = ?, experience_years = ?
            WHERE staff_id = ? AND staff_type = 'NURSE'
        """;

        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return false;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nurse.getName());
            ps.setDouble(2, nurse.getSalary());
            ps.setInt(3, nurse.getExperienceYears());
            ps.setInt(4, nurse.getStaffId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(conn);
        }
        return false;
    }

    //          DELETE
    public boolean deleteStaff(int staffId) {
        String sql = "DELETE FROM staff WHERE staff_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return false;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, staffId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(conn);
        }
        return false;
    }

    //            SEARCH
    public List<Staff> searchByName(String name) {
        List<Staff> list = new ArrayList<>();
        String sql = "SELECT * FROM staff WHERE name ILIKE ? ORDER BY name";

        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return list;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(extractStaff(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(conn);
        }
        return list;
    }

    public List<Staff> searchBySalaryRange(double min, double max) {
        List<Staff> list = new ArrayList<>();
        String sql = """
            SELECT * FROM staff
            WHERE salary BETWEEN ? AND ?
            ORDER BY salary DESC
        """;

        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return list;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, min);
            ps.setDouble(2, max);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(extractStaff(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(conn);
        }
        return list;
    }

    public List<Staff> searchByMinSalary(double minSalary) {
        List<Staff> list = new ArrayList<>();
        String sql = """
            SELECT * FROM staff
            WHERE salary >= ?
            ORDER BY salary DESC
        """;

        Connection conn = DatabaseConnection.getConnection();
        if (conn == null) return list;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, minSalary);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(extractStaff(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.close(conn);
        }
        return list;
    }

    //             HELPER
    private Staff extractStaff(ResultSet rs) throws SQLException {
        int id = rs.getInt("staff_id");
        String name = rs.getString("name");
        double salary = rs.getDouble("salary");
        int exp = rs.getInt("experience_years");
        String type = rs.getString("staff_type");

        if (type.equals("DOCTOR")) {
            return new Doctor(id, name, salary, exp,
                    rs.getString("specialization"));
        } else {
            return new Nurse(id, name, salary, exp);
        }
    }
}
