import styled from "styled-components";
import { Sidebar } from "../../logic/sidebar/main";
import { EmployeesTable } from "../../widgets/table/employees";
import { Table } from "../../widgets/table/main";
import { useState } from "react";

export const IndexPage = () => {
  const [type, setType] = useState<string>("employee");

  const onChangeType = (value: string) => {
    setType(value);
  };

  return (
    <Main>
      <Sidebar setType={onChangeType} />
      <Table type={type} />
    </Main>
  );
};

const Main = styled.div`
  height: 100dvh;
  display: grid;
  grid-template-columns: 20% 80%;
`;
