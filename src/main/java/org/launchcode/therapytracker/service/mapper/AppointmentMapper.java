package org.launchcode.therapytracker.service.mapper;


import org.launchcode.therapytracker.domain.*;
import org.launchcode.therapytracker.service.dto.AppointmentDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Appointment} and its DTO {@link AppointmentDTO}.
 */
@Mapper(componentModel = "spring", uses = {ExerciseMapper.class, PatientMapper.class})
public interface AppointmentMapper extends EntityMapper<AppointmentDTO, Appointment> {

    @Mapping(source = "patient.id", target = "patientId")
    AppointmentDTO toDto(Appointment appointment);

    @Mapping(target = "removeExercises", ignore = true)
    @Mapping(source = "patientId", target = "patient")
    Appointment toEntity(AppointmentDTO appointmentDTO);

    default Appointment fromId(Long id) {
        if (id == null) {
            return null;
        }
        Appointment appointment = new Appointment();
        appointment.setId(id);
        return appointment;
    }
}
