import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IPatient, Patient } from 'app/shared/model/patient.model';
import { PatientService } from './patient.service';

@Component({
  selector: 'jhi-patient-update',
  templateUrl: './patient-update.component.html'
})
export class PatientUpdateComponent implements OnInit {
  isSaving = false;
  birthDateDp: any;

  editForm = this.fb.group({
    id: [],
    firstName: [null, [Validators.required]],
    lastName: [null, [Validators.required]],
    birthDate: [null, [Validators.required]],
    reasonForTherapy: [null, [Validators.required]],
    affectedLocation: [null, [Validators.required]],
    homeStatus: [null, [Validators.required]],
    activityLevel: [null, [Validators.required, Validators.min(1), Validators.max(10)]],
    stressLevel: [null, [Validators.required, Validators.min(1), Validators.max(10)]],
    mobility: [null, [Validators.required, Validators.min(1), Validators.max(10)]],
    notes: []
  });

  constructor(protected patientService: PatientService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ patient }) => {
      this.updateForm(patient);
    });
  }

  updateForm(patient: IPatient): void {
    this.editForm.patchValue({
      id: patient.id,
      firstName: patient.firstName,
      lastName: patient.lastName,
      birthDate: patient.birthDate,
      reasonForTherapy: patient.reasonForTherapy,
      affectedLocation: patient.affectedLocation,
      homeStatus: patient.homeStatus,
      activityLevel: patient.activityLevel,
      stressLevel: patient.stressLevel,
      mobility: patient.mobility,
      notes: patient.notes
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const patient = this.createFromForm();
    if (patient.id !== undefined) {
      this.subscribeToSaveResponse(this.patientService.update(patient));
    } else {
      this.subscribeToSaveResponse(this.patientService.create(patient));
    }
  }

  private createFromForm(): IPatient {
    return {
      ...new Patient(),
      id: this.editForm.get(['id'])!.value,
      firstName: this.editForm.get(['firstName'])!.value,
      lastName: this.editForm.get(['lastName'])!.value,
      birthDate: this.editForm.get(['birthDate'])!.value,
      reasonForTherapy: this.editForm.get(['reasonForTherapy'])!.value,
      affectedLocation: this.editForm.get(['affectedLocation'])!.value,
      homeStatus: this.editForm.get(['homeStatus'])!.value,
      activityLevel: this.editForm.get(['activityLevel'])!.value,
      stressLevel: this.editForm.get(['stressLevel'])!.value,
      mobility: this.editForm.get(['mobility'])!.value,
      notes: this.editForm.get(['notes'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IPatient>>): void {
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
