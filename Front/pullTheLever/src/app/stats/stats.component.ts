import { Component, OnInit } from '@angular/core';
import { UserInterface } from "../models/UserInterface";
import { RestService } from "../rest.service";
import {Observable} from "rxjs";
import {filter} from "rxjs/operators";

@Component({
  selector: 'app-stats',
  templateUrl: './stats.component.html',
  styleUrls: ['./stats.component.css']
})
export class StatsComponent implements OnInit {
  public respuestas: any = {}
  public data: any = {}
  public labels: any = {}
  public listPreguntas:any = {}
  constructor(private RestService: RestService) { }

  ngOnInit(): void {
    
    this.readPreguntas();
  }


  public readPreguntas() {
    this.RestService.get('https://app-pull-the-lever.herokuapp.com/pull/v1/preguntas')
      .subscribe(response => {
        this.listPreguntas = JSON.parse(JSON.stringify(response)).data;
      })
  }

  public getRespuestas() {
    let id = (document.getElementById("selectDilema") as HTMLInputElement).value
    this.RestService.get(`https://app-pull-the-lever.herokuapp.com/pull/v1/respuestas/${id}`)
      .subscribe( response =>{
        this.respuestas = JSON.parse(JSON.stringify(response)).data
        /*let minEdad = 0
        let maxEdad = 20
        let genero = "M"
        let nacionalidad = "Perú"
        let filter0 = this.respuestas.filter(function (f: any) {
          return f.respuesta == 0 && (f.edad >= minEdad || f.edad <= maxEdad) && f.genero == genero && f.nacionalidad == nacionalidad
        })
        let filter1 = this.respuestas.filter(function (f: any) {
          return f.respuesta == 1 && (f.edad >= minEdad || f.edad <= maxEdad) && f.genero == genero && f.nacionalidad == nacionalidad
        })
        */
        let filter0 = this.respuestas.filter(function (f: any) {
          return f.respuesta == 0;
        })
        let filter1 = this.respuestas.filter(function (f: any) {
          return f.respuesta == 1;
        })
        this.data = [filter0.length, filter1.length]
        this.labels = ["Option 0", "Option 1"]
        this.chartDatasets = [{ data: this.data, label:"Resultados de pregunta 1"}]
        this.chartLabels = this.labels
      })
  }

  public groupBy(list: any, keyGetter: any) {
    const map = new Map()
    list.forEach((item: any) => {
      const key = keyGetter(item)
      const collection = map.get(key)
      if (!collection) {
        map.set(key, [item])
      } else {
        collection.push(item)
      }
    })
    return map
  }

  public chartType: string = 'bar';

  public chartDatasets: Array<any> = [
    { data: [], label: 'Seleccion un dilema' }
  ];

  public chartLabels: Array<any> = [];

  public chartColors: Array<any> = [
    {
      backgroundColor: [
        'rgba(255, 99, 132, 0.2)',
        'rgba(54, 162, 235, 0.2)',
        'rgba(255, 206, 86, 0.2)',
        'rgba(75, 192, 192, 0.2)',
        'rgba(153, 102, 255, 0.2)',
        'rgba(255, 159, 64, 0.2)'
      ],
      borderColor: [
        'rgba(255,99,132,1)',
        'rgba(54, 162, 235, 1)',
        'rgba(255, 206, 86, 1)',
        'rgba(75, 192, 192, 1)',
        'rgba(153, 102, 255, 1)',
        'rgba(255, 159, 64, 1)'
      ],
      borderWidth: 2,
    }
  ];

  public chartOptions: any = {
    responsive: true,
    scales: {
      yAxes: [{
        ticks: {
          beginAtZero: true
        }
      }]
    }
  };
  public chartClicked(e: any): void { }
  public chartHovered(e: any): void { }
}
