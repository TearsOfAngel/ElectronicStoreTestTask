/** @module npm */
import toast from "react-hot-toast";

export const successToast = (message: string) =>
  toast(message, {
    style: {
      border: "1px solid green",
    },
  });
