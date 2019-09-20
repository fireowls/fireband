import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProjectsListComponent } from './projects-list/projects-list.component';
import { ProjectItemComponent } from './project-item/project-item.component';
import { ProjectsComponent } from './projects/projects.component';
import { MaterialModule } from '../material/material.module';
import { ProjectsService } from './service/projects.service';



@NgModule({
  declarations: [ProjectsListComponent, ProjectItemComponent, ProjectsComponent],
  imports: [
    CommonModule,
    MaterialModule
  ],
  exports: [
    ProjectsComponent
  ],
  providers: [ ProjectsService ]
})
export class ProjectsModule { }
