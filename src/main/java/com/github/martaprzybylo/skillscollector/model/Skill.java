package com.github.martaprzybylo.skillscollector.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "skills")
public class Skill extends EntityBase  {

    @Column (name = "skill_name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
