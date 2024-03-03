package org.ecos.logic.dataaccessrestexercise5.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.ecos.logic.dataaccessrestexercise5.entity.ByGenderSportspeople;
import org.ecos.logic.dataaccessrestexercise5.entity.BySportCounter;
import org.ecos.logic.dataaccessrestexercise5.entity.Sportsman;
import org.ecos.logic.dataaccessrestexercise5.repository.SportsmanRepository;
import org.ecos.logic.dataaccessrestexercise5.repository.SportsmanRepositoryImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Path("/sportsman")
public class SportsmanController {

    private final SportsmanRepository sportsmanRepository = new SportsmanRepositoryImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sportsman> getAll() throws SQLException, ClassNotFoundException, IOException {
        return this.sportsmanRepository.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Sportsman getById(@PathParam("id") int id) throws SQLException, ClassNotFoundException, IOException {
        return this.sportsmanRepository.getById(id);
    }

    @GET
    @Path("/sports/{sportName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sportsman> getAll(@PathParam("sportName") String sportName) throws SQLException, ClassNotFoundException, IOException {
        return this.sportsmanRepository.getBySportName(sportName);
    }

    @GET
    @Path("/activos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sportsman> getActive() throws SQLException, ClassNotFoundException, IOException {
        return this.sportsmanRepository.getByActivity(true);
    }

    @GET
    @Path("/retirados")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sportsman> getRetired() throws SQLException, ClassNotFoundException, IOException {
        return this.sportsmanRepository.getByActivity(false);
    }

    @GET
    @Path("/masculinos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sportsman> getMales() throws SQLException, ClassNotFoundException, IOException {
        return this.sportsmanRepository.getByGender("Masculino");
    }

    @GET
    @Path("/femeninos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sportsman> getFemales() throws SQLException, ClassNotFoundException, IOException {
        return this.sportsmanRepository.getByGender("Femenino");
    }
    @GET
    @Path("/xg")
    @Produces(MediaType.APPLICATION_JSON)
    public ByGenderSportspeople getGroupedByGender() throws SQLException, ClassNotFoundException, IOException {
        ByGenderSportspeople result = new ByGenderSportspeople();
        result.setSportsmen(this.sportsmanRepository.getByGender("Masculino"));
        result.setSportswomen(this.sportsmanRepository.getByGender("Femenino"));
        return result;
    }

    @GET
    @Path("/deporte/{sportName}/activos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sportsman> getALlBySportActive(@PathParam("sportName")String sportName) throws SQLException, ClassNotFoundException, IOException {
        return this.sportsmanRepository.getByActiveSport(sportName);
    }
    @GET
    @Path("/sdepor")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BySportCounter> getBySportcounter() throws SQLException, ClassNotFoundException, IOException {

        return this.sportsmanRepository.getGroupedBySport();
    }
}