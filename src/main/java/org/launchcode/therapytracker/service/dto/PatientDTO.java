package org.launchcode.therapytracker.service.dto;

import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import org.launchcode.therapytracker.domain.enumeration.AffectedLocation;
import org.launchcode.therapytracker.domain.enumeration.HomeStatus;

/**
 * A DTO for the {@link org.launchcode.therapytracker.domain.Patient} entity.
 */
public class PatientDTO implements Serializable {

    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private String reasonForTherapy;

    @NotNull
    private AffectedLocation affectedLocation;

    @NotNull
    private HomeStatus homeStatus;

    @NotNull
    @Min(value = 1)
    @Max(value = 10)
    private Integer activityLevel;

    @NotNull
    @Min(value = 1)
    @Max(value = 10)
    private Integer stressLevel;

    @NotNull
    @Min(value = 1)
    @Max(value = 10)
    private Integer mobility;

    private String notes;

    private List<AppointmentDTO> appointments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getReasonForTherapy() {
        return reasonForTherapy;
    }

    public void setReasonForTherapy(String reasonForTherapy) {
        this.reasonForTherapy = reasonForTherapy;
    }

    public AffectedLocation getAffectedLocation() {
        return affectedLocation;
    }

    public void setAffectedLocation(AffectedLocation affectedLocation) {
        this.affectedLocation = affectedLocation;
    }

    public HomeStatus getHomeStatus() {
        return homeStatus;
    }

    public void setHomeStatus(HomeStatus homeStatus) {
        this.homeStatus = homeStatus;
    }

    public Integer getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(Integer activityLevel) {
        this.activityLevel = activityLevel;
    }

    public Integer getStressLevel() {
        return stressLevel;
    }

    public void setStressLevel(Integer stressLevel) {
        this.stressLevel = stressLevel;
    }

    public Integer getMobility() {
        return mobility;
    }

    public void setMobility(Integer mobility) {
        this.mobility = mobility;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<AppointmentDTO> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<AppointmentDTO> appointments) {
        this.appointments = appointments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PatientDTO patientDTO = (PatientDTO) o;
        if (patientDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), patientDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PatientDTO{" +
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
