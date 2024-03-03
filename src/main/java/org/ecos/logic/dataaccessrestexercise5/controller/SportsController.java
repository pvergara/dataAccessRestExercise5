package org.ecos.logic.dataaccessrestexercise5.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.ecos.logic.dataaccessrestexercise5.entity.Sport;
import org.ecos.logic.dataaccessrestexercise5.repository.SportRepository;
import org.ecos.logic.dataaccessrestexercise5.repository.SportRepositoryImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Path("/sport")
public class SportsController {
    private final SportRepository sportRepository = new SportRepositoryImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sport> getAll() throws SQLException, ClassNotFoundException, IOException {
        return this.sportRepository.getAll();
    }

}
