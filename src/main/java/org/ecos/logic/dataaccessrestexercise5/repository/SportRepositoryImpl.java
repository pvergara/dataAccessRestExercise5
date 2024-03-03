package org.ecos.logic.dataaccessrestexercise5.repository;

import org.ecos.logic.dataaccessrestexercise5.entity.Sport;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class SportRepositoryImpl implements SportRepository {
    @Override
    public List<Sport> getAll() throws SQLException, ClassNotFoundException, IOException {
        Connection connection = openConnection();
        List<Sport> result = new ArrayList<>();

        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT deporte FROM ad_tema6.deportistas GROUP BY deporte ORDER BY deporte;");

            while (resultSet.next()) {
                result.add(
                        new Sport(
                                resultSet.getString("deporte")
                        )
                );
            }
        }

        closeConnection(connection);
        return result;
    }

    private static Connection openConnection() throws ClassNotFoundException, SQLException, IOException {
        return getConnection();

    }

    static Connection getConnection() throws ClassNotFoundException, IOException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        String appConfigPath = rootPath + "application.properties";

        Properties appProps = new Properties();
        String password;
        try (FileInputStream fileInputStream = new FileInputStream(appConfigPath)) {
            appProps.load(fileInputStream);
            password = appProps.getProperty("database.credential.password");
        }

        return DriverManager.getConnection("jdbc:mariadb://localhost:3306/ad_tema6", "sports_user", password);
    }

    private void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
}
