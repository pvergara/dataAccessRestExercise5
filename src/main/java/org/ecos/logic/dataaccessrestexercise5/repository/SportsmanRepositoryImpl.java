package org.ecos.logic.dataaccessrestexercise5.repository;

import org.ecos.logic.dataaccessrestexercise5.entity.BySportCounter;
import org.ecos.logic.dataaccessrestexercise5.entity.Sportsman;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.ecos.logic.dataaccessrestexercise5.repository.SportRepositoryImpl.getConnection;

public class SportsmanRepositoryImpl implements SportsmanRepository {

    public static final String DEPORTE = "deporte";

    @Override
    public List<Sportsman> getAll() throws SQLException, ClassNotFoundException, IOException {
        Connection connection = openConnection();

        List<Sportsman> result = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT id,nombre,deporte,activo,genero FROM ad_tema6.deportistas;");
            fromResultSetToSportspeopleCollection(resultSet, result);
        }
        closeConnection(connection);
        return result;
    }

    @Override
    public Sportsman getById(int id) throws SQLException, ClassNotFoundException, IOException {
        Connection connection = openConnection();
        Sportsman result;
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT id,nombre,deporte,activo,genero FROM ad_tema6.deportistas WHERE id = " + id + ";");
            resultSet.next();
            result = fromResultSetToSportspeople(resultSet);
        }
        closeConnection(connection);
        return result;
    }

    @Override
    public List<Sportsman> getBySportName(String sportName) throws SQLException, ClassNotFoundException, IOException {
        Connection connection = openConnection();

        List<Sportsman> result = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement("SELECT id,nombre,deporte,activo,genero FROM ad_tema6.deportistas WHERE deporte = ?;")) {
            statement.setString(1, sportName);
            ResultSet resultSet = statement.executeQuery();
            fromResultSetToSportspeopleCollection(resultSet, result);
        }
        closeConnection(connection);
        return result;
    }

    @Override
    public List<Sportsman> getByActivity(boolean active) throws SQLException, ClassNotFoundException, IOException {
        Connection connection = openConnection();

        List<Sportsman> result = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT id,nombre,deporte,activo,genero FROM ad_tema6.deportistas WHERE activo = " + active + ";");
            fromResultSetToSportspeopleCollection(resultSet, result);
        }
        closeConnection(connection);
        return result;
    }

    @Override
    public List<Sportsman> getByGender(String gender) throws SQLException, ClassNotFoundException, IOException {
        Connection connection = openConnection();
        List<Sportsman> result = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement("SELECT id,nombre,deporte,activo,genero FROM ad_tema6.deportistas WHERE genero = ?;")) {
            statement.setString(1, gender);
            ResultSet resultSet = statement.executeQuery();

            fromResultSetToSportspeopleCollection(resultSet, result);
        }

        closeConnection(connection);
        return result;
    }

    @Override
    public List<Sportsman> getByActiveSport(String sportName) throws SQLException, ClassNotFoundException, IOException {
        Connection connection = openConnection();
        List<Sportsman> result = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement("SELECT id,nombre,deporte,activo,genero FROM ad_tema6.deportistas WHERE deporte = ? and activo = true;")) {
            statement.setString(1, sportName);
            ResultSet resultSet = statement.executeQuery();

            fromResultSetToSportspeopleCollection(resultSet, result);
        }

        closeConnection(connection);
        return result;
    }

    @Override
    public List<BySportCounter> getGroupedBySport() throws SQLException, ClassNotFoundException, IOException {
        Connection connection = openConnection();
        List<BySportCounter> result = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT deporte,COUNT(*) as counter FROM ad_tema6.deportistas GROUP BY deporte ;");

            while (resultSet.next()) {
                result.add(
                        new BySportCounter(
                                resultSet.getString(DEPORTE),
                                resultSet.getInt("counter")
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

    private void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    private static Sportsman fromResultSetToSportspeople(ResultSet resultSet) throws SQLException {
        Sportsman result;
        result = new Sportsman(
                resultSet.getInt("id"),
                resultSet.getString("nombre"),
                resultSet.getString(DEPORTE),
                resultSet.getBoolean("activo"),
                resultSet.getString("genero")
        );
        return result;
    }

    private static void fromResultSetToSportspeopleCollection(ResultSet resultSet, List<Sportsman> result) throws SQLException {
        while (resultSet.next()) {
            result.add(
                    new Sportsman(
                            resultSet.getInt("id"),
                            resultSet.getString("nombre"),
                            resultSet.getString(DEPORTE),
                            resultSet.getBoolean("activo"),
                            resultSet.getString("genero")
                    )
            );
        }
    }

}