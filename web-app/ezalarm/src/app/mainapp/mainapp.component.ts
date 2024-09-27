import { Component, OnInit } from '@angular/core';
import { RouterLink,RouterOutlet,RouterLinkActive } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatTabsModule } from '@angular/material/tabs';
import { MatToolbar} from '@angular/material/toolbar';
import { GroupsComponent } from '../groups/groups.component';
import { AlarmsComponent } from "../alarms/alarms.component";
import { AccountComponent } from "../account/account.component";

@Component({
  selector: 'app-mainapp',
  standalone: true,
  imports: [
    RouterLink,
    RouterOutlet,
    RouterLinkActive,
    MatButtonModule,
    MatIconModule,
    MatTabsModule,
    MatToolbar,
    GroupsComponent,
    AlarmsComponent,
    AccountComponent
],
  templateUrl: './mainapp.component.html',
  styleUrls: ['./mainapp.component.css']
})
export class MainappComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
