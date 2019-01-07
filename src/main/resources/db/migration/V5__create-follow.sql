CREATE TABLE follows(id INT PRIMARY KEY AUTO_INCREMENT, follower_id VARCHAR(30), followed_id VARCHAR(30), reg_date DATE, upd_date DATE);

INSERT INTO follows(
follower_id, 
followed_id,
reg_date,
upd_date
) VALUES (
'user2', 
'user1',
CURRENT_TIMESTAMP(),
CURRENT_TIMESTAMP()
);