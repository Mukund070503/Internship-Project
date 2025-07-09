export class Client {
    id?: number;
    service_id?: string;
    client_id?: string;
    client_name?: string;
    client_secret?: string;
    token_value?: string | null;
    adhar_number?: String | null;
    pan_number?: String | null;
    constructor(init?: Partial<Client>) {
      Object.assign(this, init);
    }
  }
  