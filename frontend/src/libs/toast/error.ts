/** @module npm */
import toast from "react-hot-toast";

export const errorToast = (message: string) =>
  toast(message, {
    style: {
      border: "1px solid red",
    },
  });
