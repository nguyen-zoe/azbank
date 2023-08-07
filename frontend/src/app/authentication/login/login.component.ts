import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  loginForm: FormGroup;

  constructor(
    private service: AuthService,
    private fb: FormBuilder,
    private router: Router
  ) {}

  //this method will called after constructor
  ngOnInit() {
    this.loginForm = this.fb.group({
      email: ['', Validators.required, Validators.email],
      password: ['', Validators.required],
    });
  }

  login() {
    console.log(this.loginForm.value);
    this.service.login(this.loginForm.value).subscribe((response) => {
      console.log(response);
      if (response.jwtToken) {
        alert(response.jwtToken);
        const jwtToken = response.jwtToken;
        localStorage.setItem('JWT', jwtToken);
        this.router.navigateByUrl('/dashboard');
      }
    });
  }
}
//   login() {
//     console.log(this.loginForm.value);
//     this.service.login(this.loginForm.value).subscribe((response) => {
//       //to show token to user
//       if (response.jwtToken) {
// const jwtToken= response.jwtToken;
//         alert('Here is your TOKEN ' + response.jwtToken);
//         console.log(response);
//         localStorage.setItem('JWT', jwtToken);
//       }
//     });
//   }
// }
