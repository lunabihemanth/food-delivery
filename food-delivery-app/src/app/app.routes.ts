import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Welcome } from './pages/welcome/welcome';
import { RoleSelect } from './pages/role-select/role-select';
import { Auth } from './pages/auth/auth';
import { Home } from './pages/customer/home/home';
import { Menu } from './pages/customer/menu/menu';
import { Cart } from './pages/customer/cart/cart';
import { Checkout } from './pages/customer/checkout/checkout';
import { OrderSuccess } from './pages/customer/order-success/order-success';
import { MyOrders } from './pages/customer/my-orders/my-orders';
import { Rating } from './pages/customer/rating/rating';
import { Coupons } from './pages/customer/coupons/coupons';
import { Profile } from './pages/customer/profile/profile';
import { MenuManagement } from './pages/restaurant/menu-management/menu-management';
import { Orders as RestaurantOrders } from './pages/restaurant/orders/orders';
import { Ratings } from './pages/restaurant/ratings/ratings';
import { Profile as RestaurantProfile } from './pages/customer/profile/profile';
import { Dashboard as DriverDashboard } from './pages/driver/dashboard/dashboard';
import { Deliveries } from './pages/driver/deliveries/deliveries';
import { Profile as DriverProfile } from './pages/customer/profile/profile';
import { Dashboard as RestaurantDashboard } from './pages/restaurant/dashboard/dashboard';
export const routes: Routes = [
  { path: '', redirectTo: 'welcome', pathMatch: 'full' },
  { path: 'welcome', component: Welcome },
  { path: 'role-select', component: RoleSelect},
  { path: 'login/:role', component: Auth },

  // Customer routes
  { path: 'customer/home', component: Home },
  { path: 'customer/menu/:id', component: Menu},
  { path: 'customer/cart', component: Cart },
  { path: 'customer/checkout', component: Checkout },
  { path: 'customer/order-success', component: OrderSuccess },
  { path: 'customer/orders', component: MyOrders },
  { path: 'customer/rating/:orderId', component: Rating },
  { path: 'customer/coupons', component: Coupons},
  { path: 'customer/profile', component: Profile},

  // Restaurant routes
  { path: 'restaurant/dashboard', component: RestaurantDashboard },
  { path: 'restaurant/menu', component: MenuManagement },
  { path: 'restaurant/orders', component: RestaurantOrders },
  { path: 'restaurant/ratings', component: Ratings },
  { path: 'restaurant/profile', component: RestaurantProfile },

  // Driver routes
  { path: 'driver/dashboard', component: DriverDashboard },
  { path: 'driver/deliveries', component: Deliveries },
  { path: 'driver/profile', component: DriverProfile },

  { path: '**', redirectTo: 'welcome' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
exports: [RouterModule]
})
export class AppRoutingModule { }