package ua.training.model.dao.impl;

import ua.training.model.Record;
import ua.training.model.dao.RecordBookDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCRecordbookDao implements RecordBookDao {

    private Connection connection;

    JDBCRecordbookDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Record recordBook) {
        try (PreparedStatement ps = connection.prepareStatement
                ("INSERT INTO recordbook (firstname, lastname, login, comment, phone, email)" +
                        " VALUES (?,?,?,?,?,?)")) {
            ps.setString(1, recordBook.getFirstName());
            ps.setString(2, recordBook.getLastName());
            ps.setString(3, recordBook.getLogin());
            ps.setString(4, recordBook.getComment());
            ps.setString(5, recordBook.getPhoneNumber());
            ps.setString(6, recordBook.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Record findById(int id) {
        try (PreparedStatement ps = connection.prepareStatement
                ("SELECT * FROM recordbook WHERE id = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Record result = extractFromResultSet(rs);
                return result;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private Record extractFromResultSet(ResultSet rs)
            throws SQLException {
        Record result = new Record();
        result.setId(rs.getInt("id"));
        result.setFirstName(rs.getString("firstname"));
        result.setLastName(rs.getString("lastname"));
        result.setLogin(rs.getString("login"));
        result.setComment(rs.getString("comment"));
        result.setPhoneNumber(rs.getString("phone"));
        result.setEmail(rs.getString("email"));
        return result;
    }

    @Override
    public List<Record> findAll() {
        List<Record> resultList = new ArrayList<>();
        try (Statement ps = connection.createStatement()) {
            ResultSet rs = ps.executeQuery("SELECT * FROM recordbook");

            while (rs.next()) {
                Record result = extractFromResultSet(rs);
                resultList.add(result);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    @Override
    public void update(Record recordBook) {
        //TODO
        try (PreparedStatement ps = connection.prepareStatement(
                "UPDATE recordbook SET firstname = ?, lastname = ?" +
                        "login = ?, comment = ?, phone = ?, email = ?" +
                        "WHERE id = ?")) {
            ps.setString(1, recordBook.getFirstName());
            ps.setString(2, recordBook.getLastName());
            ps.setString(3, recordBook.getLogin());
            ps.setString(4, recordBook.getComment());
            ps.setString(5, recordBook.getPhoneNumber());
            ps.setString(6, recordBook.getEmail());
            ps.setInt(7, recordBook.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        //TODO
        try (PreparedStatement ps = connection.prepareStatement(
                "DELETE FROM recordbook  WHERE id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
