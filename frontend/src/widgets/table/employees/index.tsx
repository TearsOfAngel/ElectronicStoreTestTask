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
  { field: "lastname", headerName: "Lastname", flex: 1 },
  { field: "firstname", headerName: "Firstname", flex: 1 },
  { field: "patronymic", headerName: "Patronymic", flex: 1 },
  { field: "birth_date", headerName: "Birth_date", flex: 1 },
  { field: "position_id", headerName: "Position_id", flex: 1 },
  { field: "gender", headerName: "Gender", flex: 1 },
  { field: "shop_name", headerName: "Shop_name", flex: 1 },
];

export const EmployeesTable = () => {
  const apiRef = useGridApiRef();
  const { data: employees } = useSWR(`/employee?limit=${limit}`);

  console.log(employees);

  const rows: GridRowsProp = useMemo(() => {
    const data = !employees
      ? []
      : employees.content.map((item: any) => ({
          id: item.id,
          lastname: item.lastName,
          firstname: item.firstName,
          patronymic: item.patronymic,
          birth_date: item.birthDate,
          position_id: item.positionId.name,
          gender: item.gender ? "Мужской" : "Женский",
          shop_name: item.shopId.name,
        }));

    return data;
  }, [employees]);

  return (
    <Main>
      <Typography variant="h4">Сотрудники</Typography>
      <DataGrid
        apiRef={apiRef}
        autoHeight
        rows={rows}
        columns={columns}
        initialState={{
          pagination: {
            paginationModel: {
              pageSize: 10,
            },
          },
        }}
        pageSizeOptions={[10]}
      />
    </Main>
  );
};

const Main = styled.div`
  display: grid;
  gap: 20px;
`;
