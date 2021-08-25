import { Siderbar } from "../components/Sidebar";

type PropsType = {
    children: JSX.Element | JSX.Element[];
}
export function Principal({ children }: PropsType) {
    return (
        <div>
            <Siderbar />
            {children}
        </div>
    );
}