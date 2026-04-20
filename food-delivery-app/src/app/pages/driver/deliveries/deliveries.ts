import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-deliveries',
  imports: [CommonModule, RouterLink],
  templateUrl: './deliveries.html',
  styleUrl: './deliveries.css'
})
export class Deliveries implements OnInit {

  orders: any[] = [];
  selectedStatus = 'All';
  statuses = ['All', 'Assigned', 'Out for Delivery', 'Delivered'];

  constructor(public router: Router) {}

  ngOnInit() {
    this.orders = [
      {
        orderId: 1001,
        customerName: 'John Smith',
        customerPhone: '9876543210',
        address: '123 Elm Street, Chennai',
        orderStatus: 'Assigned',
        totalAmount: 450,
        items: ['Margherita Pizza x2', 'Garlic Bread x1']
      },
      {
        orderId: 1002,
        customerName: 'Alice Johnson',
        customerPhone: '9876543211',
        address: '456 Oak Avenue, Mumbai',
        orderStatus: 'Out for Delivery',
        totalAmount: 320,
        items: ['Chicken Burger x1']
      },
      {
        orderId: 1003,
        customerName: 'Michael Brown',
        customerPhone: '9876543212',
        address: '789 Pine Road, Bangalore',
        orderStatus: 'Delivered',
        totalAmount: 210,
        items: ['Veggie Wrap x2']
      },
    ];
  }

  filteredOrders() {
    if (this.selectedStatus === 'All') return this.orders;
    return this.orders.filter(o => o.orderStatus === this.selectedStatus);
  }

  getStatusClass(status: string) {
    if (status === 'Assigned') return 'bg-yellow-900 text-yellow-300';
    if (status === 'Out for Delivery') return 'bg-blue-900 text-blue-300';
    if (status === 'Delivered') return 'bg-green-900 text-green-300';
    return 'bg-gray-700 text-gray-300';
  }

  updateStatus(order: any, status: string) {
    order.orderStatus = status;
    alert('Order #' + order.orderId + ' updated to ' + status);
  }
}