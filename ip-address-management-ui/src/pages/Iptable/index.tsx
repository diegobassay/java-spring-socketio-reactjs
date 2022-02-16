import React, { FunctionComponent , useState, useEffect, useContext } from 'react'
import { DataGrid } from '@mui/x-data-grid'
import { IconButton } from '@mui/material'
import EditIcon from '@mui/icons-material/ModeEdit'
import DeleteIcon from '@mui/icons-material/Delete'
import { iptableApi } from '../../services/Iptable'
import { Iptable } from '../../types/Iptable'
import Button from '@mui/material/Button'
import Box from '@mui/material/Box'
import Modal from '@mui/material/Modal'
import TextField from '@mui/material/TextField'
import Grid from '@mui/material/Grid'
import { SocketContext } from '../../services/socket'

const IptablePage: FunctionComponent<any> = (props: any) => {

  const [iptables, setIptables] = useState<Iptable[]>([])
  const [iptable, setIptable] = useState<Iptable>({ip: null, device: null})
  const [open, setOpen] = React.useState(false);

  const socket = useContext(SocketContext)

  
  const closeModalForm = () => setOpen(false);

  const columns = [
    { field: 'id', headerName: 'ID', width: 100 },
    { field: 'ip', headerName: 'IP', width: 150 },
    { field: 'device', headerName: 'Dispositivo', width: 250 },
    { field: 'createdAt', headerName: 'Data Criação', width: 150 },
    { field: '       ',
      width: 100,
      sortable: false,
      renderCell: (params:any) => {
        return (
          <>
            <IconButton color="primary" onClick={(e:React.ChangeEvent<any>) => onClickEdit(params)}>
              <EditIcon />
            </IconButton>
            <IconButton color="error" onClick={(e:React.ChangeEvent<any>) => onClickDelete(params)}>
              <DeleteIcon />
            </IconButton>
          </>
        );
      }
    }
  ]

  const onClickDelete = async (params:any) => {
    if(window.confirm('Confirma a remoção de :'+params.row.name+' ?')){
      iptableApi.delete(params.row).then((response:any) => {
        list()
      })
      .catch((err:Error) => {
        console.log(err)
      })
    }
  }

  const onClickEdit = async (params:any) => {
    setIptable(params.row)
    setOpen(true)
  };

  const list = () => {
    iptableApi.findAll().then((response:any) => {
        setIptables(response.data._embedded.iptables)
    })
    .catch((err:Error) => {
        console.log(err)
    })
  }

  const save = () => {
    let promisse = iptable.hasOwnProperty('id') 
                  ? iptableApi.update(iptable)
                  : iptableApi.create(iptable)

    promisse.then((response:any) => {
      list()
    })
    .catch((err:Error) => {
      console.log(err)
    })
  }

  const sendSocketInfo = () => {
    console.log("teste")
    socket.emit('ipinfo', {id: null, ip: '127.0.0.1', device: 'meu device'})
  }

  const openModalForm = () => {
    setIptable({ip: null, device: null})
    setOpen(true)
  }


  useEffect(() => {
    list()


    socket.on("ipinfo", (data: any) => {
        console.log(data);
    });
  }, [])

  return (
    <>
    <Button onClick={openModalForm}>Adicionar IP</Button>

    <div style={{height: 400, width: '950px' }}>
      <DataGrid
        rows={iptables}
        columns={columns}
        pageSize={5}
        rowsPerPageOptions={[10]}
      />
    </div>

    <Modal open={open} onClose={closeModalForm} aria-labelledby="modal-modal-title" aria-describedby="modal-modal-description">

        <Box component="form" autoComplete="off" noValidate>
            <Grid>
              <form noValidate autoComplete="off">
              <Grid item spacing={3}>
                <TextField required id="text-name" 
                label="IP" 
                onChange={(ev: any) => {setIptable({ ...iptable, ip: ev.target.value })}} 
                value={iptable.ip} />
              </Grid>
              <Grid item spacing={3}>
                <TextField required id="text-description" 
                label="Descrição" 
                onChange={(ev: any) => {setIptable({ ...iptable, device: ev.target.value })}} 
                value={iptable.device} />
              </Grid>
              <Grid item spacing={3}>
                <Button color="primary" onClick={save}>Salvar</Button>
              </Grid>
              </form>
            </Grid>
        </Box>
        
      </Modal>
    </>
  );
};

export default IptablePage;