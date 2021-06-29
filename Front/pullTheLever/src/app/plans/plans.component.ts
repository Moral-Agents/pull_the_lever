import { Component, OnInit } from '@angular/core';
import { RestService } from "../rest.service";
import { Router } from "@angular/router";

@Component({
  selector: 'app-plans',
  templateUrl: './plans.component.html',
  styleUrls: ['./plans.component.css']
})

export class PlansComponent implements OnInit {
  public userId: any
  paymentHandler: any = null
  constructor(private RestService: RestService, private router: Router) { }

  ngOnInit(): void {
    this.userId = localStorage.getItem("accessToken")
    this.invokeStripe()
  }

  invokeStripe() {
    if(!window.document.getElementById('stripe-script')) {
      const script = window.document.createElement('script')
      script.id = 'stripe-script'
      script.type  = 'text/javascript'
      script.src = "https://checkout.stripe.com/checkout.js"
      window.document.body.appendChild(script)
    }
  }

  makePayment(amount:any) {
    let $this = this
    const paymentHandler = (<any>window).StripeCheckout.configure({
      key: 'pk_test_51J7mwtINFpaIY9krRkYRJ9n0HAyIdZXaIWQ3m7gQBIVXZflU0Mz0t2rmNOr7tFkomJ60OIL99zcnLY2EMDwJ1rIX00PRMN1QLI',
      locale: 'auto',
      token: function() {
        $this.upgraded()
      }
    })
    paymentHandler.open({
      name: 'Moral Agents',
      description: 'Mejorar plan',
      amount: amount * 100,
    })
  }

  upgraded() {
    this.RestService.put(`https://app-pull-the-lever.herokuapp.com/pull/v1/usuarios/${localStorage.getItem("userEmail")}/P`, {})
    this.router.navigate(["../game"])
    alert("Ahora eres miembro del plan premium")
  }
}
