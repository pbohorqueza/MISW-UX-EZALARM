import { Component, OnInit } from '@angular/core';
import { RouterLink,RouterOutlet,RouterLinkActive } from '@angular/router';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-passwordreset',
  standalone: true,
  imports: [
    RouterLink, 
    RouterOutlet, 
    RouterLinkActive,
    MatInputModule,
    MatButtonModule,
    MatFormFieldModule,
    MatIconModule,
    FormsModule,
  ],
  templateUrl: './passwordreset.component.html',
  styleUrls: ['./passwordreset.component.css']
})
export class PasswordresetComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
