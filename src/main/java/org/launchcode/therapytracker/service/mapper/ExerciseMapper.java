package org.launchcode.therapytracker.service.mapper;


import org.launchcode.therapytracker.domain.*;
import org.launchcode.therapytracker.service.dto.ExerciseDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Exercise} and its DTO {@link ExerciseDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ExerciseMapper extends EntityMapper<ExerciseDTO, Exercise> {


    @Mapping(target = "appointments", ignore = true)
    @Mapping(target = "removeAppointments", ignore = true)
    Exercise toEntity(ExerciseDTO exerciseDTO);

    default Exercise fromId(Long id) {
        if (id == null) {
            return null;
        }
        Exercise exercise = new Exercise();
        exercise.setId(id);
        return exercise;
    }
}
