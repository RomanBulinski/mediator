import {Component, OnInit} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {WebSocketService} from "./web-socket-service";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  providers: [WebSocketService],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title = 'mediatorFront';

  constructor (private webSocketService: WebSocketService) {
  }

  ngOnInit(): void {
    // this.websocketService.connect();
    console.log("jestem w OnInit")
  }

  hitBaza(){
    console.log("push button")
    // this.websocketService.connect();
  }
}
