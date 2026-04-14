import { Component, OnInit } from '@angular/core'
import { CommonModule } from '@angular/common'
import { FormsModule } from '@angular/forms'
import { CardService } from './services/card.service'
import { Card } from './models/card'

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class App implements OnInit {

  todo: Card[] = []
  doing: Card[] = []
  done: Card[] = []

  novoTitulo = ''
  novaDescricao = ''
  novaPrioridade = 1

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
      .subscribe(() => this.carregarCards())
  }

  criar() {
    const card = {
      titulo: this.novoTitulo,
      descricao: this.novaDescricao,
      prioridade: this.novaPrioridade
    }

    this.service.createCard(card)
      .subscribe(() => {
        this.novoTitulo = ''
        this.novaDescricao = ''
        this.novaPrioridade = 1
        this.carregarCards()
      })
  }
}