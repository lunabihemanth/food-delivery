import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-profile',
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './profile.html',
  styleUrl: './profile.css'
})
export class Profile implements OnInit {

  driver: any = {};
  form: any = {};
  editMode = false;

  constructor(public router: Router) {}

  ngOnInit() {
    this.driver = {
      driverId: 1,
      driverName: 'Michael Johnson',
      driverPhone: '9876543210',
      driverVehicle: 'Car'
    };
    this.form = { ...this.driver };
  }

  update() {
    this.driver = { ...this.form };
    this.editMode = false;
    alert('Profile updated successfully!');
  }

  logout() {
    if (confirm('Logout?')) {
      localStorage.clear();
      this.router.navigate(['/welcome']);
    }
  }
}