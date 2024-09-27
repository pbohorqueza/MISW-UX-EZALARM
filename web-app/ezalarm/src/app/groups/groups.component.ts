import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common'
import { MatListModule } from '@angular/material/list'; 
import { MatListItem } from '@angular/material/list';
import { MatListItemAvatar } from '@angular/material/list';
import { MatListItemIcon } from '@angular/material/list';
import { MatLineModule } from '@angular/material/core';
import { MatDivider } from '@angular/material/divider';
import { MatButtonModule } from '@angular/material/button';

interface Grupo {
  nombre: string;
  ringtone: string;
}
@Component({
  selector: 'app-groups',
  standalone: true,
  imports: [CommonModule,MatListModule,MatListItem,MatListItemAvatar,MatListItemIcon,MatLineModule,MatDivider,MatButtonModule],
  templateUrl: './groups.component.html',
  styleUrls: ['./groups.component.css']
})


export class GroupsComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    
  }
  grupos: Grupo[] = [
    { nombre: 'Mascotas', ringtone: 'Lullaby' },
    { nombre: 'Personal', ringtone: 'Spark' },
    { nombre: 'Salud', ringtone: 'Harmony' },
    { nombre: 'Trabajo', ringtone: 'Ring' },
  ];
  
  editGroup(grupo: Grupo) {
    // Lógica para editar el grupo
    console.log('Editando grupo:', grupo);
  }

  deleteGroup(grupo: Grupo) {
    // Lógica para eliminar el grupo
    console.log('Borrando grupo:', grupo);
  }

}
