import { Component, OnInit } from '@angular/core'
import { CommonModule } from '@angular/common'
import { CardService } from './services/card.service'
import { Card } from './models/card'

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {

  todo: Card[] = []
  doing: Card[] = []
  done: Card[] = []

  constructor(private service: CardService) {}

  ngOnInit() {
    this.carregarCards()
  }

  carregarCards() {
    this.service.getCards().subscribe(cards => {
      this.todo = cards.filter(c => c.status === 'TODO')
      this.doing = cards.filter(c => c.status === 'DOING')
      this.done = cards.filter(c => c.status === 'DONE')
    })
  }

  mover(card: Card, status: string) {
    this.service.updateStatus(card.id, status)
      .subscribe(() => {
        this.carregarCards()
      })
  }
}