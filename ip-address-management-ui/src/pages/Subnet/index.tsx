import React, { FunctionComponent , useState, useEffect } from 'react'
import { DataGrid } from '@mui/x-data-grid';
import { subnetApi } from '../../services/Subnet'
import { Subnet } from '../../types/Subnet'

const SubnetPage: FunctionComponent<any> = (props: any) => {

  const [subnets, setSubnets] = useState<Subnet[]>([])
  const [id, setId] = useState<number>(-1)
  const columns = [
    { field: 'id', headerName: 'ID', width: 100 },
    { field: 'name', headerName: 'Nome Subnet', width: 150 },
    { field: 'description', headerName: 'Descrição', width: 150 },
    { field: 'createdAt', headerName: 'Data Criação', width: 150 },
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
    <div style={{ height: 400, width: '800px' }}>
      <DataGrid
        rows={subnets}
        columns={columns}
        pageSize={5}
        rowsPerPageOptions={[5]}
        checkboxSelection
      />
    </div>
    </>
  );
};

export default SubnetPage;