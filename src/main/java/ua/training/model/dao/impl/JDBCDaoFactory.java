package ua.training.model.dao.impl;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.RecordBookDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {
    @Override
    public RecordBookDao createRecordBookDao() {
        return new JDBCRecordbookDao(getConnection());
    }

    private Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/recordbook_db?",
                    "user",
                    "pass");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
