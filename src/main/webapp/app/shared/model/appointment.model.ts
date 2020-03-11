import { Moment } from 'moment';
import { IExercise } from 'app/shared/model/exercise.model';
import { Progress } from 'app/shared/model/enumerations/progress.model';

export interface IAppointment {
  id?: number;
  date?: Moment;
  notes?: string;
  progress?: Progress;
  exercises?: IExercise[];
  patientId?: number;
}

export class Appointment implements IAppointment {
  constructor(
    public id?: number,
    public date?: Moment,
    public notes?: string,
    public progress?: Progress,
    public exercises?: IExercise[],
    public patientId?: number
  ) {}
}
