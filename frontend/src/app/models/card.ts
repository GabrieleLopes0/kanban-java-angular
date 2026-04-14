export interface Card {
  id: number
  titulo: string
  descricao: string
  status: 'TODO' | 'DOING' | 'DONE'
  prioridade: number
  dataCriacao: string
}