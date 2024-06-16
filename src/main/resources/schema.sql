CREATE TABLE IF NOT EXISTS User (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    firsName VARCHAR(16) NOT NULL,
    lastName VARCHAR(16),
    avatarPath VARCHAR(256),
    username VARCHAR(16) NOT NULL UNIQUE,
    salt VARCHAR(32) NOT NULL,
    passwordHash VARCHAR(64) NOT NULL,
    recoveryKeyHash VARCHAR(64) NOT NULL,
    createdAt BIGINT NOT NULL
--     is_mfa_enabled BOOLEAN DEFAULT FALSE,
--     pin_hash VARCHAR(64) NOT NULL,
--     lastSeen BIGINT,
--     isOnline BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS Conversation (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    type ENUM('ONE_TO_ONE', 'GROUP') NOT NULL,
    name VARCHAR(255),
    createdAt BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS Message (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    conversationId BIGINT NOT NULL,
    senderId BIGINT NOT NULL,
    textContent TEXT,
    hasAttachment BOOLEAN DEFAULT FALSE,
    unixTimestamp BIGINT NOT NULL,
    FOREIGN KEY (conversationId) REFERENCES Conversation(id) ON DELETE CASCADE,
    FOREIGN KEY (senderId) REFERENCES User(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Attachment (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    fileName VARCHAR(128) NOT NULL,
    messageId BIGINT NOT NULL,
    path VARCHAR(256) NOT NULL,
    FOREIGN KEY (messageId) REFERENCES Message(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS User_Conversation (
    userId BIGINT,
    conversationId BIGINT,
    PRIMARY KEY (userId, conversationId),
    FOREIGN KEY (userId) REFERENCES User(id) ON DELETE CASCADE,
    FOREIGN KEY (conversationId) REFERENCES Conversation(id) ON DELETE CASCADE
);