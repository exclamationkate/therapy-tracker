package org.launchcode.therapytracker.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import org.launchcode.therapytracker.domain.enumeration.IntensityLevel;
import org.launchcode.therapytracker.domain.enumeration.AffectedLocation;

/**
 * A DTO for the {@link org.launchcode.therapytracker.domain.Exercise} entity.
 */
public class ExerciseDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    @Size(max = 150)
    private String description;

    @NotNull
    private IntensityLevel intensityLevel;

    @NotNull
    private AffectedLocation affectedLocation;

    @NotNull
    @Size(max = 1000)
    private String steps;

    @Size(max = 100)
    private String itemsUsed;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IntensityLevel getIntensityLevel() {
        return intensityLevel;
    }

    public void setIntensityLevel(IntensityLevel intensityLevel) {
        this.intensityLevel = intensityLevel;
    }

    public AffectedLocation getAffectedLocation() {
        return affectedLocation;
    }

    public void setAffectedLocation(AffectedLocation affectedLocation) {
        this.affectedLocation = affectedLocation;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getItemsUsed() {
        return itemsUsed;
    }

    public void setItemsUsed(String itemsUsed) {
        this.itemsUsed = itemsUsed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ExerciseDTO exerciseDTO = (ExerciseDTO) o;
        if (exerciseDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), exerciseDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ExerciseDTO{" +
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
