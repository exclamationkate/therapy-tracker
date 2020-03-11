import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IExercise } from 'app/shared/model/exercise.model';
import { ExerciseService } from './exercise.service';

@Component({
  templateUrl: './exercise-delete-dialog.component.html'
})
export class ExerciseDeleteDialogComponent {
  exercise?: IExercise;

  constructor(protected exerciseService: ExerciseService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.exerciseService.delete(id).subscribe(() => {
      this.eventManager.broadcast('exerciseListModification');
      this.activeModal.close();
    });
  }
}
