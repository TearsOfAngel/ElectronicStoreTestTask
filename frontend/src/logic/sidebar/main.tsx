import { Typography } from "@mui/material";
import { FC } from "react";
import styled from "styled-components";

type Props = {
  setType: (value: string) => void;
};

export const Sidebar: FC<Props> = ({ setType }) => {
  return (
    <Main>
      <Typography
        style={{ cursor: "pointer" }}
        variant="h5"
        onClick={() => setType("employee")}
      >
        Сотрудники
      </Typography>
      <Typography
        style={{ cursor: "pointer" }}
        variant="h5"
        onClick={() => setType("buy")}
      >
        Покупки
      </Typography>
      <Typography
        style={{ cursor: "pointer" }}
        variant="h5"
        onClick={() => setType("electro")}
      >
        Электротовары
      </Typography>
    </Main>
  );
};

const Main = styled.div`
  display: grid;
  align-content: start;
  gap: 10px;
  padding: 40px;
  background-color: #e4e4e4;
`;
