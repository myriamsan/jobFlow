import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  firstName = '';
  lastName = '';
  email = '';
  password = '';
  errorMessage = '';


  constructor(private authService: AuthService, private router: Router) { }

  onSubmit(): void {
    this.authService.register({ firstName: this.firstName, lastName: this.lastName, email: this.email, password: this.password })
      .subscribe({
        next: () => {
          this.router.navigate(['/login']);
        },
        error: (err) => {
          if (err.status === 409) {
            this.errorMessage = 'Cet email est déjà utilisé';
          } else {
            this.errorMessage = 'Une erreur est survenue, veuillez réessayer';
          }
          console.error(err);
        }
      });
  }

}
