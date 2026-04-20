import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-menu-management',
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './menu-management.html',
  styleUrl: './menu-management.css'
})
export class MenuManagement implements OnInit {

  menuItems: any[] = [];
  showForm = false;
  editingItem: any = null;

  form = {
    itemName: '',
    description: '',
    price: null as any
  };

  constructor(private router: Router) {}

  ngOnInit() {
    this.menuItems = [
      { itemId: 1, itemName: 'Margherita Pizza', description: 'Classic pizza', price: 299 },
      { itemId: 2, itemName: 'Pepperoni Pizza', description: 'Spicy pepperoni', price: 349 },
      { itemId: 3, itemName: 'Chicken Burger', description: 'Grilled chicken', price: 199 },
      { itemId: 4, itemName: 'Veggie Wrap', description: 'Fresh vegetables', price: 149 },
    ];
  }

  openAdd() {
    this.editingItem = null;
    this.form = { itemName: '', description: '', price: null };
    this.showForm = true;
  }

  openEdit(item: any) {
    this.editingItem = item;
    this.form = { ...item };
    this.showForm = true;
  }

  saveItem() {
    if (!this.form.itemName || !this.form.price) {
      alert('Please fill all fields');
      return;
    }
    if (this.editingItem) {
      const index = this.menuItems.findIndex(i => i.itemId === this.editingItem.itemId);
      this.menuItems[index] = { ...this.editingItem, ...this.form };
      alert('Item updated!');
    } else {
      this.menuItems.push({
        itemId: Date.now(),
        ...this.form
      });
      alert('Item added!');
    }
    this.showForm = false;
    this.form = { itemName: '', description: '', price: null };
  }

  deleteItem(id: number) {
    if (confirm('Delete this item?')) {
      this.menuItems = this.menuItems.filter(i => i.itemId !== id);
    }
  }

  cancel() {
    this.showForm = false;
    this.form = { itemName: '', description: '', price: null };
  }
}