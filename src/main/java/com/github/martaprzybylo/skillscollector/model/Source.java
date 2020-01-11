package com.github.martaprzybylo.skillscollector.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "sources")
public class Source extends EntityBase  {
    /**
     * nazwa (name),
     * opis (description),
     * przypisane umiejętności (attachedSkills).
     */

    @Column (name = "name")
    private String sourceName;

    @Column (name = "description")
    private String sourceDescription;

    @ManyToMany
    @JoinTable (name = "sources_attached_skills",
    joinColumns = @JoinColumn (name = "source_id"),
    inverseJoinColumns = @JoinColumn (name = "skill_id"))
    private List <Skill> attachedSkills;

    @ManyToMany (mappedBy = "knownSources")
    private Set <User> users;

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceDescription() {
        return sourceDescription;
    }

    public void setSourceDescription(String sourceDescription) {
        this.sourceDescription = sourceDescription;
    }

    public List<Skill> getAttachedSkills() {
        return attachedSkills;
    }

    public void setAttachedSkills(List<Skill> attachedSkills) {
        this.attachedSkills = attachedSkills;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
