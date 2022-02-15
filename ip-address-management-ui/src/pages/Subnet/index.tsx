import React, { FunctionComponent , useState, useEffect } from 'react'
import { DataGrid } from '@mui/x-data-grid';
import { IconButton } from '@mui/material';
import EditIcon from '@mui/icons-material/ModeEdit';
import DeleteIcon from '@mui/icons-material/Delete';
import { subnetApi } from '../../services/Subnet'
import { Subnet } from '../../types/Subnet'
import Button from '@mui/material/Button'
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Modal from '@mui/material/Modal';
import TextField from '@mui/material/TextField';
import Grid from '@mui/material/Grid';
import { Theme, createStyles, makeStyles } from '@material-ui/core/styles'

const style = {
  position: 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 260,
  bgcolor: 'background.paper',
  boxShadow: 24,
  p: 4,
};

const SubnetPage: FunctionComponent<any> = (props: any) => {

  const [subnets, setSubnets] = useState<Subnet[]>([])
  const [id, setId] = useState<number>(-1)
  const [open, setOpen] = React.useState(false);
  const openModalForm = () => setOpen(true);
  const closeModalForm = () => setOpen(false);


  const styles = makeStyles((theme: Theme) =>
    createStyles({
      formPopup: {
        "& > *": {
          margin: theme.spacing(1),
          width: "25ch"
        }
      }
    }),
  )();

  
  const columns = [
    { field: 'id', headerName: 'ID', width: 100 },
    { field: 'name', headerName: 'Nome Subnet', width: 150 },
    { field: 'description', headerName: 'Descrição', width: 150 },
    { field: 'createdAt', headerName: 'Data Criação', width: 150 },
    {
      field: '       ',
      width: 100,
      sortable: false,
      renderCell: (params:any) => {
        const onClickDelete = async () => {
          return alert(JSON.stringify(params.row, null, 4));
        };
        const onClickEdit = async () => {};
  
        return (
          <>
            <IconButton color="primary" onClick={onClickDelete}>
              <EditIcon />
            </IconButton>
            <IconButton color="error" onClick={onClickEdit}>
              <DeleteIcon />
            </IconButton>
          </>
        );
      }
    }
  ];

  useEffect(() => {
    subnetApi.findAll().then((response:any) => {
      setSubnets(response.data._embedded.subnets);
    })
    .catch((err:Error) => {
      console.log(err)
    });
    
  }, []);

  return (

    
    <>
    <Button onClick={openModalForm}>Criar Subnet</Button>
    
    <div style={{ height: 400, width: '950px' }}>
      <DataGrid
        rows={subnets}
        columns={columns}
        pageSize={5}
        rowsPerPageOptions={[10]}
      />
    </div>

    <Modal open={open} onClose={closeModalForm} aria-labelledby="modal-modal-title" aria-describedby="modal-modal-description">

        <Box sx={style} component="form" autoComplete="off" noValidate>
            <Grid>
              <form className={styles.formPopup} noValidate autoComplete="off">
              <Grid item spacing={3}>
                <TextField required id="text-name" label="Nome" />
              </Grid>
              <Grid item spacing={3}>
                <TextField required id="text-description" label="Descrição" />
              </Grid>
              <Grid item spacing={3}>
                <Button color="primary">Salvar</Button>
              </Grid>
              </form>
            </Grid>
        </Box>

      </Modal>
    </>
  );
};

export default SubnetPage;