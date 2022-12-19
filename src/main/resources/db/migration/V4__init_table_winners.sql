DROP TABLE IF EXISTS t_winners;
CREATE TABLE IF NOT EXISTS t_winners (
    winner_id UUID NOT NULL,
    nickname VARCHAR(255) NOT NULL,
    win_date DATE NOT NULL
)