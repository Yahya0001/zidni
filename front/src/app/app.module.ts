import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavbarComponent } from './views/navbar/navbar.component';
import { HomeComponent } from './views/home/home.component';
import { ProfileComponent } from './views/profile/profile.component';
import { AppRoutingModule } from './app-routing.module';
import { ProduitPageComponent } from './views/produit-page/produit-page.component';
import { CategoryPageComponent } from './views/category-page/category-page.component';
import { LoginComponent } from './views/auth/login/login.component';
import { RegisterComponent } from './views/auth/register/register.component';
import { BuyTokenComponent } from './views/buy-token/buy-token.component';
import { ConditionsComponent } from './views/conditions/conditions.component';
import { FooterComponent } from './views/footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    ProfileComponent,
    ProduitPageComponent,
    CategoryPageComponent,
    LoginComponent,
    RegisterComponent,
    BuyTokenComponent,
    ConditionsComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
