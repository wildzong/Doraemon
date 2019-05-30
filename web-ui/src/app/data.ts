export class User {
    HeadProfile: string;
    Name: string;
    Friends: User[];
    HistoryChat: User[];
    LastChatTime: string;
}

export class Task {
    Name: string;
    Content: string;
    State: string;
}

export class Message {
    UserChat: User;
    Text: string;
    // type true/false uesed as sender/receiver
    Type: boolean;
}
