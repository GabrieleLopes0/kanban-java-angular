import { Injectable } from '@angular/core'
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs'
import { Card } from '../models/card'

@Injectable({
  providedIn: 'root'
})
export class CardService {

  private api = 'http://localhost:8080/cards'

  constructor(private http: HttpClient) {}

  getCards(): Observable<Card[]> {
    return this.http.get<Card[]>(this.api)
  }

  createCard(card: any): Observable<Card> {
    return this.http.post<Card>(this.api, card)
  }

  deleteCard(id: number) {
    return this.http.delete(`${this.api}/${id}`)
  }

  updateStatus(id: number, status: string) {
    return this.http.patch(
      `${this.api}/${id}/status?status=${status}`,
      {}
    )
  }
}