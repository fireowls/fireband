import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MatTabsModule } from '@angular/material/tabs';
import { MatSidenavModule, MatToolbarModule, MatButtonModule, MatIconModule, MatListModule } from '@angular/material';

const materials = [
  BrowserAnimationsModule,
  MatTabsModule,
  MatSidenavModule,
  MatToolbarModule,
  MatButtonModule,
  MatIconModule,
  MatListModule,
];

@NgModule({
  declarations: [],
  imports: [materials],
  exports: [materials]
})
export class MaterialModule { }
