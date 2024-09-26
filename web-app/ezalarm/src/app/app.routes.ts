import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { PasswordresetComponent } from './passwordreset/passwordreset.component';
import { MainappComponent } from './mainapp/mainapp.component';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'register', component: SignupComponent },
  { path: 'passwordreset', component: PasswordresetComponent },
  { path: 'mis-alarmas', component: MainappComponent},
  { path: '**', component: LoginComponent  }
];
