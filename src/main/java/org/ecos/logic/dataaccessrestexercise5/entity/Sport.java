package org.ecos.logic.dataaccessrestexercise5.entity;

import jakarta.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("unused")
@XmlRootElement
public class Sport {
    private String name;

    public Sport() {
    }

    public Sport(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
