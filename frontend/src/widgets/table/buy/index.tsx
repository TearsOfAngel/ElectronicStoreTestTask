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

const limit = 50;

const columns: GridColDef[] = [
  { field: "id", headerName: "id", flex: 1 },
  { field: "electroId", headerName: "ElectroId", flex: 1 },
  { field: "employeeId", headerName: "EmployeeId", flex: 1 },
  { field: "purchaseDate", headerName: "purchaseDate", flex: 1 },
  { field: "shopId", headerName: "ShopId", flex: 1 },
  { field: "typeId", headerName: "TypeId", flex: 1 },
];

export const BuyTable = () => {
  const apiRef = useGridApiRef();
  const { data: purchases } = useSWR(`/purchases`);

  console.log(purchases);

  const rows: GridRowsProp = useMemo(() => {
    const data = !purchases
      ? []
      : purchases.content.map((item: any) => ({
          id: item.id,
          electroId: item.electroId,
          employeeId: item.employeeId.id,
          purchaseDate: item.purchaseDate,
          shopId: item.shopId.id,
          typeId: item.typeId.id,
        }));

    return data;
  }, [purchases]);

  return (
    <Main>
      <Typography variant="h4">Покупки</Typography>
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
