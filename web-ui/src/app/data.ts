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
