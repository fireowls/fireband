import { NgModule } from '@angular/core';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { Route, RouterModule } from '@angular/router';
import { HomeComponent } from '../home/home/home.component';
import { ProjectsComponent } from '../projects/projects/projects.component';
import { PagesService } from './services/pages.service';
import { MaterialModule } from '../material/material.module';

const routes: Route[] = [
  {path: 'home', component: HomeComponent},
  {path: 'projects', component: ProjectsComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'}
];


@NgModule({
  declarations: [NavBarComponent],
  imports: [
    RouterModule.forRoot(routes),
    MaterialModule
  ],
  exports: [
    NavBarComponent,
    RouterModule
  ],
  providers: [PagesService]
})
export class NavigationModule { }
