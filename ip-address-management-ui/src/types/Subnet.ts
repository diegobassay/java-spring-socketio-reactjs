export type SubnetType = {
    id?: number | null;
    name: string | null;
    description: string | null;
};

export interface Subnet extends SubnetType {
    name: string | null;
    description: string | null;
}

export const SubnetsTypeInitiator: Array<Subnet> = [];