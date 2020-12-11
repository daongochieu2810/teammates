import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TeammatesRouterModule } from '../../components/teammates-router/teammates-router.module';
import { IndexPageComponent } from './index-page.component';
import { BannerModule } from '../../components/banner/banner.module';

const routes: Routes = [
  {
    path: '',
    component: IndexPageComponent,
  },
];

/**
 * Module for index page.
 */
@NgModule({
  declarations: [
    IndexPageComponent,
  ],
  exports: [
    IndexPageComponent,
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    TeammatesRouterModule,
    BannerModule
  ],
})
export class IndexPageModule { }
