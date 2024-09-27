import { Component, OnInit } from '@angular/core';
import { RouterLink,RouterOutlet,RouterLinkActive } from '@angular/router';
import { CommonModule } from '@angular/common'
import { MatListModule } from '@angular/material/list'; 
import { MatListItem } from '@angular/material/list';
import { MatListItemAvatar } from '@angular/material/list';
import { MatListItemIcon } from '@angular/material/list';
import { MatLineModule } from '@angular/material/core';
import { MatDivider } from '@angular/material/divider';

@Component({
  selector: 'app-account',
  standalone: true,
  imports: [RouterLink, 
    RouterOutlet, 
    RouterLinkActive,
    CommonModule,MatListModule,MatListItem,MatListItemAvatar,MatListItemIcon,MatLineModule,MatDivider], 
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
