DROP TABLE IF EXISTS t_quests;
CREATE TABLE IF NOT EXISTS t_quests(
    quest_id UUID PRIMARY KEY NOT NULL,
    quest_text TEXT NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT (TRUE),
    added_at DATE DEFAULT (NOW())
--     updatedAt DATE,
--     ans_id UUID UNIQUE NOT NULL
)