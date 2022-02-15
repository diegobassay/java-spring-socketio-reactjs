import axios from 'axios'
import api from '../api'
import { Subnet } from '../../types/Subnet'

export const subnetApi = {
  findAll:() => api.get<Subnet[]>(`/network`),
}
