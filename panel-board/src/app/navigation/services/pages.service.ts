import { Injectable } from '@angular/core';
import { Page } from '../../models/page.model';

@Injectable({
  providedIn: 'root'
})
export class PagesService {

  pages: Page[] = [
    {
      label: 'home',
      path: ''
    },
    {
      label: 'projects',
      path: 'projects'
    }
  ];

  constructor() { }
}
