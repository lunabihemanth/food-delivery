import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.html',
  styleUrls: ['./login.css']
})
export class LoginComponent {

  // Input fields
  username: string = '';
  password: string = '';
  errorMsg: string = '';

  constructor(private router: Router) {}

  // 🔐 Dummy users (for demo)
  users = [
    { username: 'annie', password: '123', role: 'customer' },
    { username: 'jeevitha', password: '123', role: 'delivery' },
    { username: 'kisol', password: '123', role: 'restaurant' },
    { username: 'thenmozhi', password: '123', role: 'customer' },
    { username: 'hemanth', password: '123', role: 'profile' }
  ];

  // 🔄 Back button
  goBack() {
    this.router.navigate(['/home']);
  }

  // 🚀 Login logic
  onLogin() {

    // Check empty fields
    if (!this.username || !this.password) {
      this.errorMsg = 'Please enter username and password';
      return;
    }

    // Find user
    const user = this.users.find(
      u => u.username === this.username && u.password === this.password
    );

    // Invalid login
    if (!user) {
      this.errorMsg = 'Invalid credentials';
      return;
    }

    // Clear error
    this.errorMsg = '';

    // (Optional) store role
    localStorage.setItem('userRole', user.role);

    // 🔀 Role-based navigation
    if (user.role === 'customer') {
      this.router.navigate(['/customers']);
    } 
    else if (user.role === 'delivery') {
      this.router.navigate(['/delivery']);
    } 
    else if (user.role === 'restaurant') {
      this.router.navigate(['/restaurants']);
    } 
    else if (user.role === 'profile') {
      this.router.navigate(['/profile']);
    }
  }
}