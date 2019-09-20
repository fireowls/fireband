import { Injectable } from '@angular/core';
import { Project } from 'src/app/models/project.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProjectsService {

  projects: Project[] = environment.projectList;

  constructor() { }
}
