import seedPackages from "./seed-packages.json";

export type MockPackage = {
    id : string;
    title : string;
    destination : string;
    price : number;
    currency : string;
    departureDate : string;
    nights : number;
    departure : string;
    includes : string[];
    image : string;
};

export const mockPackages : MockPackage[] = seedPackages;