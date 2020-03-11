import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IExercise, Exercise } from 'app/shared/model/exercise.model';
import { ExerciseService } from './exercise.service';

@Component({
  selector: 'jhi-exercise-update',
  templateUrl: './exercise-update.component.html'
})
export class ExerciseUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    name: [null, [Validators.required]],
    description: [null, [Validators.maxLength(150)]],
    intensityLevel: [null, [Validators.required]],
    affectedLocation: [null, [Validators.required]],
    steps: [null, [Validators.required, Validators.maxLength(1000)]],
    itemsUsed: [null, [Validators.maxLength(100)]]
  });

  constructor(protected exerciseService: ExerciseService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ exercise }) => {
      this.updateForm(exercise);
    });
  }

  updateForm(exercise: IExercise): void {
    this.editForm.patchValue({
      id: exercise.id,
      name: exercise.name,
      description: exercise.description,
      intensityLevel: exercise.intensityLevel,
      affectedLocation: exercise.affectedLocation,
      steps: exercise.steps,
      itemsUsed: exercise.itemsUsed
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const exercise = this.createFromForm();
    if (exercise.id !== undefined) {
      this.subscribeToSaveResponse(this.exerciseService.update(exercise));
    } else {
      this.subscribeToSaveResponse(this.exerciseService.create(exercise));
    }
  }

  private createFromForm(): IExercise {
    return {
      ...new Exercise(),
      id: this.editForm.get(['id'])!.value,
      name: this.editForm.get(['name'])!.value,
      description: this.editForm.get(['description'])!.value,
      intensityLevel: this.editForm.get(['intensityLevel'])!.value,
      affectedLocation: this.editForm.get(['affectedLocation'])!.value,
      steps: this.editForm.get(['steps'])!.value,
      itemsUsed: this.editForm.get(['itemsUsed'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IExercise>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }
}
