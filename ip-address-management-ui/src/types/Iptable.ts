export type IptableType = {
    id?: number | null;
    ip: string | null;
    device: string | null;
};

export interface Iptable extends IptableType {
    ip: string | null;
    device: string | null;
}

export const IptablesTypeInitiator: Array<Iptable> = [];