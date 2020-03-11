import { IAppointment } from 'app/shared/model/appointment.model';
import { IntensityLevel } from 'app/shared/model/enumerations/intensity-level.model';
import { AffectedLocation } from 'app/shared/model/enumerations/affected-location.model';

export interface IExercise {
  id?: number;
  name?: string;
  description?: string;
  intensityLevel?: IntensityLevel;
  affectedLocation?: AffectedLocation;
  steps?: string;
  itemsUsed?: string;
  appointments?: IAppointment[];
}

export class Exercise implements IExercise {
  constructor(
    public id?: number,
    public name?: string,
    public description?: string,
    public intensityLevel?: IntensityLevel,
    public affectedLocation?: AffectedLocation,
    public steps?: string,
    public itemsUsed?: string,
    public appointments?: IAppointment[]
  ) {}
}
