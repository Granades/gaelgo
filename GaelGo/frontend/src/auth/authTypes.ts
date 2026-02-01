export type LoginRequest = {
    email : string,
    password : string;
};

export type AuthResponse = {
    userId : string,
    username : string,
    email : string,
    token : string
};