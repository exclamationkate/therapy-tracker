package org.launchcode.therapytracker.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.launchcode.therapytracker.domain.enumeration.Progress;

/**
 * A Appointment.
 */
@Entity
@Table(name = "appointment")
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @NotNull
    @Size(max = 500)
    @Column(name = "notes", length = 500, nullable = false)
    private String notes;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "progress", nullable = false)
    private Progress progress;

    @ManyToMany
    @JoinTable(name = "appointment_exercises",
               joinColumns = @JoinColumn(name = "appointment_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "exercises_id", referencedColumnName = "id"))
    private Set<Exercise> exercises = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("appointments")
    private Patient patient;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Appointment date(LocalDate date) {
        this.date = date;
        return this;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public Appointment notes(String notes) {
        this.notes = notes;
        return this;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Progress getProgress() {
        return progress;
    }

    public Appointment progress(Progress progress) {
        this.progress = progress;
        return this;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public Set<Exercise> getExercises() {
        return exercises;
    }

    public Appointment exercises(Set<Exercise> exercises) {
        this.exercises = exercises;
        return this;
    }

    public Appointment addExercises(Exercise exercise) {
        this.exercises.add(exercise);
        exercise.getAppointments().add(this);
        return this;
    }

    public Appointment removeExercises(Exercise exercise) {
        this.exercises.remove(exercise);
        exercise.getAppointments().remove(this);
        return this;
    }

    public void setExercises(Set<Exercise> exercises) {
        this.exercises = exercises;
    }

    public Patient getPatient() {
        return patient;
    }

    public Appointment patient(Patient patient) {
        this.patient = patient;
        return this;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Appointment)) {
            return false;
        }
        return id != null && id.equals(((Appointment) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Appointment{" +
            "id=" + getId() +
            ", date='" + getDate() + "'" +
            ", notes='" + getNotes() + "'" +
            ", progress='" + getProgress() + "'" +
            "}";
    }
}
