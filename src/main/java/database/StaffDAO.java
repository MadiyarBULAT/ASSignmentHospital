package database;

import model.*;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class StaffDAO {

    // ================= CREATE (INSERT) =================
    public boolean insertDoctor(Doctor doctor) {
        String sql = """
            INSERT INTO staff (name, salary, experience_years, staff_type, specialization)
            VALUES (?, ?, ?, 'DOCTOR', ?)
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, doctor.getName());
            ps.setDouble(2, doctor.getSalary());
            ps.setInt(3, doctor.getExperienceYears());
            ps.setString(4, doctor.getSpecialization());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ================= READ (SELECT ALL) =================
    public List<Staff> getAllStaff() {
        List<Staff> list = new LinkedList<>();
        String sql = "SELECT * FROM staff ORDER BY staff_id";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(extractStaff(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // ================= UPDATE =================
    public boolean updateDoctor(Doctor doctor) {
        String sql = """
            UPDATE staff
            SET name = ?, salary = ?, experience_years = ?, specialization = ?
            WHERE staff_id = ? AND staff_type = 'DOCTOR'
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, doctor.getName());
            ps.setDouble(2, doctor.getSalary());
            ps.setInt(3, doctor.getExperienceYears());
            ps.setString(4, doctor.getSpecialization());
            ps.setInt(5, doctor.getStaffId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateNurse(Nurse nurse) {
        String sql = """
            UPDATE staff
            SET name = ?, salary = ?, experience_years = ?
            WHERE staff_id = ? AND staff_type = 'NURSE'
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nurse.getName());
            ps.setDouble(2, nurse.getSalary());
            ps.setInt(3, nurse.getExperienceYears());
            ps.setInt(4, nurse.getStaffId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ================= DELETE =================
    public boolean deleteStaff(int staffId) {
        String sql = "DELETE FROM staff WHERE staff_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, staffId);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ================= SEARCH =================
    public List<Staff> searchByName(String name) {
        List<Staff> list = new LinkedList<>();
        String sql = "SELECT * FROM staff WHERE name ILIKE ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(extractStaff(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Staff> searchBySalaryRange(double min, double max) {
        List<Staff> list = new LinkedList<>();
        String sql = "SELECT * FROM staff WHERE salary BETWEEN ? AND ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, min);
            ps.setDouble(2, max);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(extractStaff(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Staff> searchByMinSalary(double minSalary) {
        List<Staff> list = new LinkedList<>();
        String sql = "SELECT * FROM staff WHERE salary >= ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, minSalary);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(extractStaff(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // ================= HELPER =================
    private Staff extractStaff(ResultSet rs) throws SQLException {
        int id = rs.getInt("staff_id");
        String name = rs.getString("name");
        double salary = rs.getDouble("salary");
        int exp = rs.getInt("experience_years");
        String type = rs.getString("staff_type");

        if ("DOCTOR".equals(type)) {
            return new Doctor(id, name, salary, exp, rs.getString("specialization"));
        } else {
            return new Nurse(id, name, salary, exp);
        }
    }
}
