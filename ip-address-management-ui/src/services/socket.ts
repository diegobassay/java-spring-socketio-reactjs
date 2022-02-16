import React from 'react'

import io from "socket.io-client";

console.log("-----------------------------------TESTE-___---------------------------------------------")
console.log(io)

export const socket = io("http://localhost:9991/chat?token=abc123", {
    transports: ['polling', 'websocket']
});

export const SocketContext = React.createContext(socket);