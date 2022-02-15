import React, { FunctionComponent , useState, useEffect } from 'react'
import { DataGrid } from '@mui/x-data-grid';

/**
 * Classe de responsavel pela listagem incial de livros
 * Essa classe é usada na tela de CRUD
 * @param props - objeto com as propriedades declaradas nos atributos do componente
 * @author Bruna Leiras - bruna.leiras@spot-edu.com.br
 */
const Subnets: FunctionComponent<any> = (props: any) => {
  Long id;

  String name;

  String description;

  String createdAt;

  IptableModel ip;
  const [subnets, setSubnets] = useState([])
  const [id, setId] = useState<number>(-1)
  const columns = [
    { field: 'id', headerName: 'ID', width: 70 },
    { field: 'name', headerName: 'Nome Subnet', width: 70 },
    { field: 'description', headerName: 'Descrição', width: 70 },
    { field: 'createdAt', headerName: 'Data Criação', width: 70 },
  ];
  
  const rows = [
    { id: 1, name: 'Subnet 1', description: 'Subnet Desc', createdAt: '11/11/2022' },
    { id: 2, name: 'Subnet 2', description: 'Subnet Desc', createdAt: '11/11/2022' },
    { id: 3, name: 'Subnet 3', description: 'Subnet Desc', createdAt: '11/11/2022' },
    { id: 4, name: 'Subnet 4', description: 'Subnet Desc', createdAt: '11/11/2022' },
    { id: 5, name: 'Subnet 5', description: 'Subnet Desc', createdAt: '11/11/2022' },
  ];


  useEffect(() => {
    /*
    api.get({}).then(async (books:any) => {

      setBooks(subnets.data._embedded.subnets)

    })
    .catch((err:Error) => {
      console.log(err)
    });
    */
  }, []);

  return (
    <>
    <div style={{ height: 400, width: '100%' }}>
      <DataGrid
        rows={rows}
        columns={columns}
        pageSize={5}
        rowsPerPageOptions={[5]}
        checkboxSelection
      />
    </div>
    </>
  );
};

export default Subnets;