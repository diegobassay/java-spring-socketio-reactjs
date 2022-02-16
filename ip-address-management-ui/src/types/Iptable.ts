export type IptableType = {
    id?: number | null;
    name: string | null;
    description: string | null;
};

export interface Iptable extends IptableType {
    name: string | null;
    description: string | null;
}

export const IptablesTypeInitiator: Array<Iptable> = [];