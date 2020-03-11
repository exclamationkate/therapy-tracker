import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'patient',
        loadChildren: () => import('./patient/patient.module').then(m => m.TherapytrackerPatientModule)
      },
      {
        path: 'exercise',
        loadChildren: () => import('./exercise/exercise.module').then(m => m.TherapytrackerExerciseModule)
      },
      {
        path: 'appointment',
        loadChildren: () => import('./appointment/appointment.module').then(m => m.TherapytrackerAppointmentModule)
      }
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ])
  ]
})
export class TherapytrackerEntityModule {}
