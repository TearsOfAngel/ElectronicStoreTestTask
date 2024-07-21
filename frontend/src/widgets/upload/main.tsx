import { Button, Input, TextField, Typography } from "@mui/material";
import styled from "styled-components";
import CloudUploadIcon from "@mui/icons-material/CloudUpload";
import { FormEvent, useState } from "react";
import { successToast } from "../../libs/toast/success";
import { uploadFiles } from "../../libs/axios/api/fileUpload";
import { mutate } from "swr";

const VisuallyHiddenInput = styled("input")({
  clip: "rect(0 0 0 0)",
  clipPath: "inset(50%)",
  height: 1,
  overflow: "hidden",
  position: "absolute",
  bottom: 0,
  left: 0,
  whiteSpace: "nowrap",
  width: 1,
});

export const Upload = () => {
  const [filename, setFileName] = useState<string>("Выберите файл");

  const uploadFile = async (file: File) => {
    const formData = new FormData();

    formData.append("file", file);

    const result = await uploadFiles(formData);

    mutate("/employee");

    if (result === true) {
      successToast(`Файл ${file.name} загружен`);
    }
  };

  const onChangeFileName = (e: FormEvent<HTMLInputElement>) => {
    const target = e.target as HTMLInputElement;

    if (target.files && target.files.length > 0) {
      const file = target.files[0];
      setFileName(file.name);

      uploadFile(file);
    }
  };

  return (
    <Main>
      <Typography>Импорт данных из csv файла</Typography>
      <InputBlock>
        <Button
          component="label"
          role={undefined}
          variant="contained"
          tabIndex={-1}
          startIcon={<CloudUploadIcon />}
          style={{ height: "40px" }}
        >
          Выберите файл{" "}
          <VisuallyHiddenInput
            type="file"
            accept=".zip,.rar,.7zip"
            onChange={(e) => onChangeFileName(e)}
          />
        </Button>
        <FileName>{filename}</FileName>
      </InputBlock>
    </Main>
  );
};

const Main = styled.div`
  display: grid;
  align-content: center;
  gap: 10px;
`;

const InputBlock = styled.div`
  display: grid;
  grid-template-columns: max-content 1fr;
  grid-auto-flow: column;
  align-items: center;
  gap: 10px;
`;

const FileName = styled.div`
  cursor: default;
  display: grid;
  height: 40px;
  align-items: center;
  border: 1px solid grey;
  padding-left: 10px;
  border-radius: 4px;
`;
