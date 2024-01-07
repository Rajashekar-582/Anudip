import { Component } from '@angular/core';
import { User } from '../user';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  user: User = new User();
  nameFlag: boolean = false;
  phoneFlag: boolean = false;
  emailFlag: boolean = false;
  buttonFlag: boolean = true;

  constructor(
    private authService: AuthenticationService,
    private router: Router
  ) {}

  validateName(): void {
    this.nameFlag = this.user.userName.length < 3;
  }

  validatePhone(): void {
    this.phoneFlag = !/^\d{10}$/.test(this.user.userPhone.toString());
  }

  validateEmail(): void {
    this.emailFlag = !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(this.user.userEmail);
  }

  enableButton(): void {
    this.buttonFlag = this.nameFlag || this.phoneFlag || this.emailFlag;
  }

  signUp(): void {
    if (!this.buttonFlag) {
      this.authService.signUp(this.user).subscribe(
        () => {
          this.router.navigate(['/login']);
        },
        (error: any) => {
          console.error('Registration error:', error);
        }
      );
    }
  }
}



