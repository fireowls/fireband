import { Component, OnInit } from '@angular/core';
import { PagesService } from '../services/pages.service';
import { Page } from 'src/app/models/page.model';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss']
})
export class NavBarComponent implements OnInit {

  pages: Page[] = [];

  constructor(private pagesService: PagesService) { }

  ngOnInit() {
    this.pages = this.pagesService.pages;
  }

}
