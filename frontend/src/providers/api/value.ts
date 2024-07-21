/** */
import type { SWRConfiguration } from "swr";
import { api } from "../../libs/axios/main";

/** */
export const value: SWRConfiguration = {
  revalidateIfStale: false,
  revalidateOnFocus: true,
  revalidateOnReconnect: true,
  fetcher: (path) =>
    api.get(`http://localhost:8080/estore/api${path}`).then((res) => res.data),
};
