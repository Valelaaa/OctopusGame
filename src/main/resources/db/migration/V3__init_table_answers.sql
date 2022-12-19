DROP TABLE IF EXISTS t_answers;
CREATE TABLE IF NOT EXISTS t_answers(
--     ans_id UUID PRIMARY KEY,
    quest_id UUID PRIMARY KEY REFERENCES t_quests(quest_id),
    answer TEXT NOT NULL,
    is_correct BOOLEAN NOT NULL DEFAULT(FALSE)
)