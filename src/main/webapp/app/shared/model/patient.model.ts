import { Moment } from 'moment';
import { IAppointment } from 'app/shared/model/appointment.model';
import { AffectedLocation } from 'app/shared/model/enumerations/affected-location.model';
import { HomeStatus } from 'app/shared/model/enumerations/home-status.model';

export interface IPatient {
  id?: number;
  firstName?: string;
  lastName?: string;
  birthDate?: Moment;
  reasonForTherapy?: string;
  affectedLocation?: AffectedLocation;
  homeStatus?: HomeStatus;
  activityLevel?: number;
  stressLevel?: number;
  mobility?: number;
  notes?: string;
  appointments?: IAppointment[];
}

export class Patient implements IPatient {
  constructor(
    public id?: number,
    public firstName?: string,
    public lastName?: string,
    public birthDate?: Moment,
    public reasonForTherapy?: string,
    public affectedLocation?: AffectedLocation,
    public homeStatus?: HomeStatus,
    public activityLevel?: number,
    public stressLevel?: number,
    public mobility?: number,
    public notes?: string,
    public appointments?: IAppointment[]
  ) {}
}
