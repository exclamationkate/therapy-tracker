package org.launchcode.therapytracker.service;

import org.launchcode.therapytracker.domain.Appointment;
import org.launchcode.therapytracker.domain.Patient;
import org.launchcode.therapytracker.repository.AppointmentRepository;
import org.launchcode.therapytracker.service.dto.AppointmentDTO;
import org.launchcode.therapytracker.service.mapper.AppointmentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Appointment}.
 */
@Service
@Transactional
public class AppointmentService {

    private final Logger log = LoggerFactory.getLogger(AppointmentService.class);

    private final AppointmentRepository appointmentRepository;

    private final AppointmentMapper appointmentMapper;

    public AppointmentService(AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
    }

    /**
     * Save an appointment.
     *
     * @param appointmentDTO the entity to save.
     * @return the persisted entity.
     */
    public AppointmentDTO save(AppointmentDTO appointmentDTO) {
        log.debug("Request to save Appointment : {}", appointmentDTO);
        Appointment appointment = appointmentMapper.toEntity(appointmentDTO);
        Patient patient = new Patient();
        patient.setId(appointmentDTO.getPatientId());
        appointment.setPatient(patient);
        appointment = appointmentRepository.save(appointment);
        return appointmentMapper.toDto(appointment);
    }

    /**
     * Get all the appointments.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AppointmentDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Appointments");
        return appointmentRepository.findAll(pageable)
            .map(appointmentMapper::toDto);
    }

    /**
     * Get all the appointments.
     * If appointment's patientId matches selected patient's Id, appointment is added to the list and displayed.
     * @return the list of all entities.
     */
    @Transactional(readOnly = true)
    public List<AppointmentDTO> findAll(Long id) {
        log.debug("Request to get all Appointments");
        List<Appointment> appointmentList = appointmentRepository.findAll();
        List<AppointmentDTO> appointmentDTOList = new ArrayList<>();
        for(Appointment appointment: appointmentList) {
            if (appointment.getPatient() != null && appointment.getPatient().getId() == id) {
                appointmentDTOList.add(appointmentMapper.toDto(appointment));
            }
        }
        return appointmentDTOList;
    }

    /**
     * Get all the appointments with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    public Page<AppointmentDTO> findAllWithEagerRelationships(Pageable pageable) {
        return appointmentRepository.findAllWithEagerRelationships(pageable).map(appointmentMapper::toDto);
    }

    /**
     * Get one appointment by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AppointmentDTO> findOne(Long id) {
        log.debug("Request to get Appointment : {}", id);
        return appointmentRepository.findOneWithEagerRelationships(id)
            .map(appointmentMapper::toDto);
    }

    /**
     * Delete the appointment by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Appointment : {}", id);
        appointmentRepository.deleteById(id);
    }
}
