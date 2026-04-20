import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-dashboard',
  imports: [CommonModule, RouterLink],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css'
})
export class Dashboard implements OnInit {

  driverName = '';
  stats = {
    totalDeliveries: 0,
    pendingDeliveries: 0,
    completedDeliveries: 0
  };

  recentOrders: any[] = [];

  constructor(public router: Router) {}

  ngOnInit() {
    const user = JSON.parse(localStorage.getItem('user') || '{}');
    this.driverName = user.name || 'Driver';

    this.stats = {
      totalDeliveries: 25,
      pendingDeliveries: 3,
      completedDeliveries: 22
    };

    this.recentOrders = [
      { orderId: 1001, customerName: 'John Smith', address: '123 Elm St, Chennai', orderStatus: 'Assigned' },
      { orderId: 1002, customerName: 'Alice Johnson', address: '456 Oak Ave, Chennai', orderStatus: 'Delivered' },
      { orderId: 1003, customerName: 'Michael Brown', address: '789 Pine Rd, Chennai', orderStatus: 'Assigned' },
    ];
  }

  getStatusClass(status: string) {
    if (status === 'Assigned') return 'bg-yellow-900 text-yellow-300';
    if (status === 'Out for Delivery') return 'bg-blue-900 text-blue-300';
    if (status === 'Delivered') return 'bg-green-900 text-green-300';
    return 'bg-gray-700 text-gray-300';
  }

  logout() {
    if (confirm('Are you sure you want to logout?')) {
      localStorage.clear();
      this.router.navigate(['/welcome']);
    }
  }
}