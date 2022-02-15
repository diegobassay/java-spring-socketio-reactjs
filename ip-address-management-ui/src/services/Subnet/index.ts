import axios from 'axios'
import api from '../api'
import { Subnet } from '../../types/Subnet'

export const subnetApi = {
  findAll:() => api.get<Subnet[]>(`/network`),
  update:(subnet:Subnet) => api.put(`/network/${subnet.id}`, subnet),
  create:(subnet:Subnet) => api.post('/network', subnet),
  delete:(subnet:Subnet) => api.delete(`/network/${subnet.id}`),
}
