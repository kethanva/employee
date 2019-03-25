import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { EmployeeComponent } from './employee/employee.component';
import {AddEmployeeComponent} from './employee/add-employee.component';

const routes: Routes = [
  { path: 'employees', component: EmployeeComponent },
  { path: 'add', component: AddEmployeeComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
