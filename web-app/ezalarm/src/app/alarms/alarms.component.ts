import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common'
import { MatListModule } from '@angular/material/list'; 
import { MatListItem } from '@angular/material/list';
import { MatListItemAvatar } from '@angular/material/list';
import { MatListItemIcon } from '@angular/material/list';
import { MatLineModule } from '@angular/material/core';
import { MatDivider } from '@angular/material/divider';

interface Alarma {
  nombre: string;
  periodicidad: string;
  grupo: string;
}

@Component({
  selector: 'app-alarms',
  standalone: true,
  imports: [CommonModule,MatListModule,MatListItem,MatListItemAvatar,MatListItemIcon,MatLineModule,MatDivider], 
  templateUrl: './alarms.component.html',
  styleUrls: ['./alarms.component.css']
})
export class AlarmsComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  alarmas: Alarma[] = [
    { nombre: 'Llamar a Pedro | 6:00 a.m.', periodicidad: 'Una vez',grupo: 'Trabajo' },
    { nombre: 'Hacer Yoga | 8:00 a.m.', periodicidad: 'Lun-Vie',grupo: 'Salud' },
    { nombre: 'Ir al CADE | 11:30 a.m.', periodicidad: 'Una vez',grupo: 'Personal' },
    { nombre: 'Pedir medicamento | 2:10 p.m.', periodicidad: 'Mensual',grupo: 'Salud' },
  ];
  

}
