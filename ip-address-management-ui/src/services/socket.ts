import React from 'react'

import io from "socket.io-client";

/* export const socket = io("http://localhost:8082/ipinfo?token=abc123", {transports: ["websocket", "polling"]}); */

export const socket = {emit:(p1:string, p2:any) => {}, on:(p1:string, p2:any) => {}};
export const SocketContext = React.createContext(socket);