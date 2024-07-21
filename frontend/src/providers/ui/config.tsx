/** */
import { SWRConfig } from "swr";

/** */
import { value } from "../api/value";

/** */
export const Config = ({ children }: { children: React.ReactNode }) => {
  /** */
  return <SWRConfig value={value}>{children}</SWRConfig>;
};
