package org.launchcode.therapytracker.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.launchcode.therapytracker.domain.enumeration.IntensityLevel;

import org.launchcode.therapytracker.domain.enumeration.AffectedLocation;

/**
 * A Exercise.
 */
@Entity
@Table(name = "exercise")
public class Exercise implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 150)
    @Column(name = "description", length = 150)
    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "intensity_level", nullable = false)
    private IntensityLevel intensityLevel;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "affected_location", nullable = false)
    private AffectedLocation affectedLocation;

    @NotNull
    @Size(max = 1000)
    @Column(name = "steps", length = 1000, nullable = false)
    private String steps;

    @Size(max = 100)
    @Column(name = "items_used", length = 100)
    private String itemsUsed;

    @ManyToMany(mappedBy = "exercises")
    @JsonIgnore
    private Set<Appointment> appointments = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Exercise name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public Exercise description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IntensityLevel getIntensityLevel() {
        return intensityLevel;
    }

    public Exercise intensityLevel(IntensityLevel intensityLevel) {
        this.intensityLevel = intensityLevel;
        return this;
    }

    public void setIntensityLevel(IntensityLevel intensityLevel) {
        this.intensityLevel = intensityLevel;
    }

    public AffectedLocation getAffectedLocation() {
        return affectedLocation;
    }

    public Exercise affectedLocation(AffectedLocation affectedLocation) {
        this.affectedLocation = affectedLocation;
        return this;
    }

    public void setAffectedLocation(AffectedLocation affectedLocation) {
        this.affectedLocation = affectedLocation;
    }

    public String getSteps() {
        return steps;
    }

    public Exercise steps(String steps) {
        this.steps = steps;
        return this;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getItemsUsed() {
        return itemsUsed;
    }

    public Exercise itemsUsed(String itemsUsed) {
        this.itemsUsed = itemsUsed;
        return this;
    }

    public void setItemsUsed(String itemsUsed) {
        this.itemsUsed = itemsUsed;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public Exercise appointments(Set<Appointment> appointments) {
        this.appointments = appointments;
        return this;
    }

    public Exercise addAppointments(Appointment appointment) {
        this.appointments.add(appointment);
        appointment.getExercises().add(this);
        return this;
    }

    public Exercise removeAppointments(Appointment appointment) {
        this.appointments.remove(appointment);
        appointment.getExercises().remove(this);
        return this;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Exercise)) {
            return false;
        }
        return id != null && id.equals(((Exercise) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Exercise{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", intensityLevel='" + getIntensityLevel() + "'" +
            ", affectedLocation='" + getAffectedLocation() + "'" +
            ", steps='" + getSteps() + "'" +
            ", itemsUsed='" + getItemsUsed() + "'" +
            "}";
    }
}
