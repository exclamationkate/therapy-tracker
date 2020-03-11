import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { JhiResolvePagingParams } from 'ng-jhipster';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IExercise, Exercise } from 'app/shared/model/exercise.model';
import { ExerciseService } from './exercise.service';
import { ExerciseComponent } from './exercise.component';
import { ExerciseDetailComponent } from './exercise-detail.component';
import { ExerciseUpdateComponent } from './exercise-update.component';

@Injectable({ providedIn: 'root' })
export class ExerciseResolve implements Resolve<IExercise> {
  constructor(private service: ExerciseService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IExercise> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((exercise: HttpResponse<Exercise>) => {
          if (exercise.body) {
            return of(exercise.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new Exercise());
  }
}

export const exerciseRoute: Routes = [
  {
    path: '',
    component: ExerciseComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: ['ROLE_USER'],
      defaultSort: 'id,asc',
      pageTitle: 'Exercises'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: ExerciseDetailComponent,
    resolve: {
      exercise: ExerciseResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'Exercises'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: ExerciseUpdateComponent,
    resolve: {
      exercise: ExerciseResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'Exercises'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: ExerciseUpdateComponent,
    resolve: {
      exercise: ExerciseResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'Exercises'
    },
    canActivate: [UserRouteAccessService]
  }
];
