package org.launchcode.therapytracker.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.launchcode.therapytracker.domain.enumeration.AffectedLocation;

import org.launchcode.therapytracker.domain.enumeration.HomeStatus;

/**
 * A Patient.
 */
@Entity
@Table(name = "patient")
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @NotNull
    @Column(name = "reason_for_therapy", nullable = false)
    private String reasonForTherapy;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "affected_location", nullable = false)
    private AffectedLocation affectedLocation;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "home_status", nullable = false)
    private HomeStatus homeStatus;

    @NotNull
    @Min(value = 1)
    @Max(value = 10)
    @Column(name = "activity_level", nullable = false)
    private Integer activityLevel;

    @NotNull
    @Min(value = 1)
    @Max(value = 10)
    @Column(name = "stress_level", nullable = false)
    private Integer stressLevel;

    @NotNull
    @Min(value = 1)
    @Max(value = 10)
    @Column(name = "mobility", nullable = false)
    private Integer mobility;

    @Column(name = "notes")
    private String notes;

    @OneToMany(mappedBy = "patient")
    private Set<Appointment> appointments = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public Patient firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Patient lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Patient birthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getReasonForTherapy() {
        return reasonForTherapy;
    }

    public Patient reasonForTherapy(String reasonForTherapy) {
        this.reasonForTherapy = reasonForTherapy;
        return this;
    }

    public void setReasonForTherapy(String reasonForTherapy) {
        this.reasonForTherapy = reasonForTherapy;
    }

    public AffectedLocation getAffectedLocation() {
        return affectedLocation;
    }

    public Patient affectedLocation(AffectedLocation affectedLocation) {
        this.affectedLocation = affectedLocation;
        return this;
    }

    public void setAffectedLocation(AffectedLocation affectedLocation) {
        this.affectedLocation = affectedLocation;
    }

    public HomeStatus getHomeStatus() {
        return homeStatus;
    }

    public Patient homeStatus(HomeStatus homeStatus) {
        this.homeStatus = homeStatus;
        return this;
    }

    public void setHomeStatus(HomeStatus homeStatus) {
        this.homeStatus = homeStatus;
    }

    public Integer getActivityLevel() {
        return activityLevel;
    }

    public Patient activityLevel(Integer activityLevel) {
        this.activityLevel = activityLevel;
        return this;
    }

    public void setActivityLevel(Integer activityLevel) {
        this.activityLevel = activityLevel;
    }

    public Integer getStressLevel() {
        return stressLevel;
    }

    public Patient stressLevel(Integer stressLevel) {
        this.stressLevel = stressLevel;
        return this;
    }

    public void setStressLevel(Integer stressLevel) {
        this.stressLevel = stressLevel;
    }

    public Integer getMobility() {
        return mobility;
    }

    public Patient mobility(Integer mobility) {
        this.mobility = mobility;
        return this;
    }

    public void setMobility(Integer mobility) {
        this.mobility = mobility;
    }

    public String getNotes() {
        return notes;
    }

    public Patient notes(String notes) {
        this.notes = notes;
        return this;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public Patient appointments(Set<Appointment> appointments) {
        this.appointments = appointments;
        return this;
    }

    public Patient addAppointments(Appointment appointment) {
        this.appointments.add(appointment);
        appointment.setPatient(this);
        return this;
    }

    public Patient removeAppointments(Appointment appointment) {
        this.appointments.remove(appointment);
        appointment.setPatient(null);
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
        if (!(o instanceof Patient)) {
            return false;
        }
        return id != null && id.equals(((Patient) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Patient{" +
            "id=" + getId() +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", birthDate='" + getBirthDate() + "'" +
            ", reasonForTherapy='" + getReasonForTherapy() + "'" +
            ", affectedLocation='" + getAffectedLocation() + "'" +
            ", homeStatus='" + getHomeStatus() + "'" +
            ", activityLevel=" + getActivityLevel() +
            ", stressLevel=" + getStressLevel() +
            ", mobility=" + getMobility() +
            ", notes='" + getNotes() + "'" +
            "}";
    }
}
