package org.ecos.logic.dataaccessrestexercise5.repository;

import org.ecos.logic.dataaccessrestexercise5.entity.BySportCounter;
import org.ecos.logic.dataaccessrestexercise5.entity.Sportsman;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface SportsmanRepository {
    List<Sportsman> getAll() throws SQLException, ClassNotFoundException, IOException;

    Sportsman getById(int id) throws SQLException, ClassNotFoundException, IOException;

    List<Sportsman> getBySportName(String sportName) throws SQLException, ClassNotFoundException, IOException;
    List<Sportsman> getByActivity(boolean active) throws SQLException, ClassNotFoundException, IOException;

    List<Sportsman> getByGender(String gender) throws SQLException, ClassNotFoundException, IOException;

    List<Sportsman> getByActiveSport(String sportName) throws SQLException, ClassNotFoundException, IOException;

    List<BySportCounter> getGroupedBySport() throws SQLException, ClassNotFoundException, IOException;
}
