export class Team {
  id?: number;
  teamName?: string;
  teamDl?: string;
  applicationName?: string;
  serviceId?: string;
  description?: string;
  averageTraffic?: string;
  peakTraffic?: string;
  peakTrafficHrs?: string;

  constructor(init?: Partial<Team>) {
    Object.assign(this, init);
  }
}
