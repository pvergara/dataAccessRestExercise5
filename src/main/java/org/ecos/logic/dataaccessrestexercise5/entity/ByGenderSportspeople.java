package org.ecos.logic.dataaccessrestexercise5.entity;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement
public class ByGenderSportspeople {
    private List<Sportsman> sportsmen;
    private List<Sportsman> sportswomen;

    public ByGenderSportspeople() {
    }

    public void setSportsmen(List<Sportsman> sportsmen) {
        this.sportsmen = sportsmen;
    }

    public void setSportswomen(List<Sportsman> sportswomen) {
        this.sportswomen = sportswomen;
    }
}
