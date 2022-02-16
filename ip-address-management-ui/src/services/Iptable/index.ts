import api from '../api'
import { Iptable } from '../../types/Iptable'

export const iptableApi = {
  findAll:() => api.get<Iptable[]>(`/ip`),
  update:(ip:Iptable) => api.put(`/ip/${ip.id}`, ip),
  create:(ip:Iptable) => api.post('/ip', ip),
  delete:(ip:Iptable) => api.delete(`/ip/${ip.id}`),
}
