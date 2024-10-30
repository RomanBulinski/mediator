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
    // this.webSocketService.connect();
    // this.webSocketService.onMessageReceived().subscribe((x)=>{
    //   console.log("jestem w OnInit")
    //   console.log(x)
    // });
  }

  connectToSocket(){
    this.webSocketService.connect();
  }

  disconnectSocket(){
    this.webSocketService.disconnect();
  }

  getMessage(){
    this.webSocketService.sendMessage("aaaaaaa");

    this.webSocketService.onMessageReceived().subscribe((x)=>{
      console.log("jestem w OnInit")
      console.log(x)
    });
  }

}
