package org.ecos.logic.dataaccessrestexercise5.entity;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement
@SuppressWarnings("unused")
public class ByGenderSportspeople {
    private List<Sportsman> sportsmen;
    private List<Sportsman> sportswomen;

    public ByGenderSportspeople() {
        // Needed by XMLParser
    }

    public void setSportsmen(List<Sportsman> sportsmen) {
        this.sportsmen = sportsmen;
    }

    public void setSportswomen(List<Sportsman> sportswomen) {
        this.sportswomen = sportswomen;
    }

    public List<Sportsman> getSportsmen() {
        return sportsmen;
    }

    public List<Sportsman> getSportswomen() {
        return sportswomen;
    }
}
