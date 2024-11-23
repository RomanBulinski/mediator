import {Component, OnInit} from '@angular/core';
import {WebSocketService} from "./web_socket/web-socket-service";
import {map, tap} from "rxjs";
import {MatSnackBar} from "@angular/material/snack-bar";
import {MatButton} from "@angular/material/button";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [MatButton],
  providers: [WebSocketService],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'mediatorFront';

  constructor(private webSocketService: WebSocketService,
              private snackBar: MatSnackBar) {

    // this.webSocketService.onMessageReceived().subscribe((x) => {
    // });
    this.webSocketService.onMessageReceived().pipe(
      tap((message) => {
        this.snackBar.open(message, "closse", {
          duration: 3000,
        });
      }),
      map((x) => {
        return x;
      })
    ).subscribe((result) => {
    })
  }

  ngOnInit(): void {
  }

  activateSocket() {
    this.webSocketService.activate();
  }

  deactivateSocket() {
    this.webSocketService.deactivate();
  }

  getMessage() {
    this.webSocketService.sendMessage("aaaaaaa");
  }

}
