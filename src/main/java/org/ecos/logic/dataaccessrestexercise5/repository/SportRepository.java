package org.ecos.logic.dataaccessrestexercise5.repository;

import org.ecos.logic.dataaccessrestexercise5.entity.Sport;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface SportRepository {
    List<Sport> getAll() throws SQLException, ClassNotFoundException, IOException;
}
