import styled from "styled-components";
import { Upload } from "../upload/main";
import { EmployeesTable } from "./employees";
import { FC } from "react";
import { BuyTable } from "./buy";
import { ElectronicsTable } from "./electro";

type Props = {
  type: string;
};

export const Table: FC<Props> = ({ type }) => {
  return (
    <Main>
      <Upload />
      {type === "employee" && <EmployeesTable />}
      {type === "buy" && <BuyTable />}
      {type === "electro" && <ElectronicsTable />}
    </Main>
  );
};

const Main = styled.div`
  display: grid;
  grid-template-rows: 15% 85%;
  align-items: start;
  padding: 40px;
`;
