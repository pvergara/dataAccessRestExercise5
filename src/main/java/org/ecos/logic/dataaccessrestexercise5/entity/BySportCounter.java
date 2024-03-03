package org.ecos.logic.dataaccessrestexercise5.entity;

import jakarta.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("unused")
@XmlRootElement
public class BySportCounter {
    private String sportName;
    private int counter;

    public BySportCounter() {
    }

    public BySportCounter(String sportName, Integer counter) {

        this.sportName = sportName;
        this.counter = counter;
    }

    public String getSportName() {
        return sportName;
    }

    public int getCounter() {
        return counter;
    }
}
