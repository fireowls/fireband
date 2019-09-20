import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProjectsListComponent } from './projects-list/projects-list.component';
import { ProjectsComponent } from './projects/projects.component';
import { MaterialModule } from '../material/material.module';
import { ProjectsService } from './service/projects.service';



@NgModule({
  declarations: [ProjectsListComponent, ProjectsComponent],
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
