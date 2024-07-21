import styled from "styled-components";
import {
  DataGrid,
  GridColDef,
  GridRowsProp,
  useGridApiRef,
} from "@mui/x-data-grid";
import useSWR from "swr";
import { useMemo } from "react";
import { Typography } from "@mui/material";

const columns: GridColDef[] = [
  { field: "id", headerName: "id", flex: 1 },
  { field: "name", headerName: "Name", flex: 1 },
  { field: "description", headerName: "Description", flex: 1 },
  { field: "price", headerName: "Price", flex: 1 },
  { field: "electronicType", headerName: "Electronic type", flex: 1 },
  { field: "count", headerName: "Count", flex: 1 },
  { field: "archive", headerName: "Archive", flex: 1 },
];

export const ElectronicsTable = () => {
  const apiRef = useGridApiRef();
  const { data: electronics } = useSWR(`/electronics`);

  console.log(electronics);

  const rows: GridRowsProp = useMemo(() => {
    const data = !electronics
      ? []
      : electronics.content.map((item: any) => ({
          id: item.id,
          name: item.name,
          description: item.description,
          price: item.price,
          electronicType: item.electronicType.id,
          count: item.count,
          archive: item.archive,
        }));

    return data;
  }, [electronics]);

  return (
    <Main>
      <Typography variant="h4">Электроника</Typography>
      <DataGrid
        apiRef={apiRef}
        autoHeight
        rows={rows}
        columns={columns}
        initialState={{
          pagination: {
            paginationModel: {
              pageSize: 5,
            },
          },
        }}
      />
    </Main>
  );
};

const Main = styled.div`
  display: grid;
  gap: 20px;
`;
