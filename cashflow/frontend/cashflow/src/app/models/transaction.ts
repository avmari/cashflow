import { Card } from "./card";
import { Sphere } from "./sphere";

export class Transaction{
    id?: string;
    sphere?: Sphere;
    card?: Card;
    amount?: number;
    date?: Date;
}