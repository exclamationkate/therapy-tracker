import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { TherapytrackerSharedModule } from 'app/shared/shared.module';
import { TherapytrackerCoreModule } from 'app/core/core.module';
import { TherapytrackerAppRoutingModule } from './app-routing.module';
import { TherapytrackerHomeModule } from './home/home.module';
import { TherapytrackerEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    TherapytrackerSharedModule,
    TherapytrackerCoreModule,
    TherapytrackerHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    TherapytrackerEntityModule,
    TherapytrackerAppRoutingModule
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [MainComponent]
})
export class TherapytrackerAppModule {}
