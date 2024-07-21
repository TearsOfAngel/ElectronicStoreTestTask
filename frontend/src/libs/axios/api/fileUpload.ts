import { AxiosError } from "axios";
import { errorToast } from "../../toast/error";
import { api } from "../main";

interface Config {}

export const uploadFiles = async (body: FormData) => {
  try {
    const response = await api.post("/shop/upload", body);
    return response.data;
  } catch (err) {
    if (err instanceof AxiosError) {
      errorToast("Что-то пошло не так");
      return err.response?.data;
    }
  }
};
