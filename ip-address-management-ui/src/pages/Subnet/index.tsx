import React, { FunctionComponent , useState, useEffect } from 'react'
import { DataGrid } from '@mui/x-data-grid';
import { IconButton } from '@mui/material';
import EditIcon from '@mui/icons-material/ModeEdit';
import DeleteIcon from '@mui/icons-material/Delete';
import { subnetApi } from '../../services/Subnet'
import { Subnet, SubnetType } from '../../types/Subnet'
import Button from '@mui/material/Button'
import Box from '@mui/material/Box';
import Modal from '@mui/material/Modal';
import TextField from '@mui/material/TextField';
import Grid from '@mui/material/Grid';
import { StylesForm, StylePopup, StyleDatagrid } from './styles'

const SubnetPage: FunctionComponent<any> = (props: any) => {

  const [subnets, setSubnets] = useState<Subnet[]>([])
  const [subnet, setSubnet] = useState<Subnet>({name: null, description: null})
  const [open, setOpen] = React.useState(false);
  
  const closeModalForm = () => setOpen(false);
  const stylesForm = StylesForm();

  const columns = [
    { field: 'id', headerName: 'ID', width: 100 },
    { field: 'name', headerName: 'Nome Subnet', width: 150 },
    { field: 'description', headerName: 'Descrição', width: 250 },
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
  ];

  const onClickDelete = async (params:any) => {
    if(window.confirm('Confirma a remoção de :'+params.row.name+' ?')){
      subnetApi.delete(params.row).then((response:any) => {
        list()
      })
      .catch((err:Error) => {
        console.log(err)
      });
    }
  };
  const onClickEdit = async (params:any) => {
    setSubnet(params.row)
    setOpen(true)
  };

  const openModalForm = () => {
    setSubnet({name: null, description: null})
    setOpen(true)
  }

  const list = () => {
    subnetApi.findAll().then((response:any) => {
      setSubnets(response.data._embedded.subnets)
      setOpen(false)
    })
    .catch((err:Error) => {
      console.log(err)
    });
  }

  const save = () => {
    let promisse = subnet.hasOwnProperty('id') 
                  ? subnetApi.update(subnet)
                  : subnetApi.create(subnet)

    promisse.then((response:any) => {
      list()
    })
    .catch((err:Error) => {
      console.log(err)
    });
  };

  useEffect(() => {
    list()
  }, []);

  return (
    <>
    <Button onClick={openModalForm}>Criar Subnet</Button>

    <div style={StyleDatagrid}>
      <DataGrid
        rows={subnets}
        columns={columns}
        pageSize={5}
        rowsPerPageOptions={[10]}
      />
    </div>

    <Modal open={open} onClose={closeModalForm} aria-labelledby="modal-modal-title" aria-describedby="modal-modal-description">

        <Box sx={StylePopup} component="form" autoComplete="off" noValidate>
            <Grid>
              <form className={stylesForm.formPopup} noValidate autoComplete="off">
              <Grid item spacing={3}>
                <TextField required id="text-name" 
                label="Nome" 
                onChange={(ev: any) => {setSubnet({ ...subnet, name: ev.target.value })}} 
                value={subnet.name} />
              </Grid>
              <Grid item spacing={3}>
                <TextField required id="text-description" 
                label="Descrição" 
                onChange={(ev: any) => {setSubnet({ ...subnet, description: ev.target.value })}} 
                value={subnet.description} />
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

export default SubnetPage;