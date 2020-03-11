package org.launchcode.therapytracker.repository;

import org.launchcode.therapytracker.domain.Appointment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the Appointment entity.
 */
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query(value = "select distinct appointment from Appointment appointment left join fetch appointment.exercises",
        countQuery = "select count(distinct appointment) from Appointment appointment")
    Page<Appointment> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct appointment from Appointment appointment left join fetch appointment.exercises")
    List<Appointment> findAllWithEagerRelationships();

    @Query("select appointment from Appointment appointment left join fetch appointment.exercises where appointment.id =:id")
    Optional<Appointment> findOneWithEagerRelationships(@Param("id") Long id);

}
