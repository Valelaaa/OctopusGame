DROP TABLE IF EXISTS t_answers;
CREATE TABLE IF NOT EXISTS t_answers(
    answer_id UUID PRIMARY KEY NOT NULL,
    ans_quest_id UUID,
    answer TEXT NOT NULL,
    is_correct BOOLEAN NOT NULL DEFAULT(FALSE),
    FOREIGN KEY (ans_quest_id) REFERENCES t_quests(quest_id)
)