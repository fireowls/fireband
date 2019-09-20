import { Component, OnInit } from '@angular/core';
import { Project } from 'src/app/models/project.model';
import { ProjectsService } from '../service/projects.service';

@Component({
  selector: 'app-projects-list',
  templateUrl: './projects-list.component.html',
  styleUrls: ['./projects-list.component.scss']
})
export class ProjectsListComponent implements OnInit {

  projects: Project[] = [];

  constructor(private projectsService: ProjectsService) { }

  ngOnInit() {
    this.projects = this.projectsService.projects;
  }

}
