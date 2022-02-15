import React, { FunctionComponent , useState, useEffect } from 'react'
import { DataGrid } from '@mui/x-data-grid';

/**
 * Classe de responsavel pela listagem incial de livros
 * Essa classe é usada na tela de CRUD
 * @param props - objeto com as propriedades declaradas nos atributos do componente
 * @author Bruna Leiras - bruna.leiras@spot-edu.com.br
 */
const Subnets: FunctionComponent<any> = (props: any) => {

  const [subnets, setSubnets] = useState([])
  const [id, setId] = useState<number>(-1)
  const columns = [
    { field: 'id', headerName: 'ID', width: 70 },
    { field: 'firstName', headerName: 'First name', width: 130 },
    { field: 'lastName', headerName: 'Last name', width: 130 },
    {
      field: 'age',
      headerName: 'Age',
      type: 'number',
      width: 90,
    },
    {
      field: 'fullName',
      headerName: 'Full name',
      description: 'This column has a value getter and is not sortable.',
      sortable: false,
      width: 160,
      valueGetter: (params:any) =>
        `${params.row.firstName || ''} ${params.row.lastName || ''}`,
    },
  ];
  
  const rows = [
    { id: 1, lastName: 'Snow', firstName: 'Jon', age: 35 },
    { id: 2, lastName: 'Lannister', firstName: 'Cersei', age: 42 },
    { id: 3, lastName: 'Lannister', firstName: 'Jaime', age: 45 },
    { id: 4, lastName: 'Stark', firstName: 'Arya', age: 16 },
    { id: 5, lastName: 'Targaryen', firstName: 'Daenerys', age: null },
    { id: 6, lastName: 'Melisandre', firstName: null, age: 150 },
    { id: 7, lastName: 'Clifford', firstName: 'Ferrara', age: 44 },
    { id: 8, lastName: 'Frances', firstName: 'Rossini', age: 36 },
    { id: 9, lastName: 'Roxie', firstName: 'Harvey', age: 65 },
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