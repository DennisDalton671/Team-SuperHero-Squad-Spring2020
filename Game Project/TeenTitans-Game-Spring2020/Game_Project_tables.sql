DROP TABLE puzzles;
DROP TABLE rooms;
DROP TABLE monsters;
DROP TABLE items;

CREATE TABLE items(
item_id VARCHAR(10) PRIMARY KEY NOT NULL,
item VARCHAR(200) NOT NULL,
item_desc VARCHAR(50) NOT NULL,
aquired VARCHAR(20) NOT NULL,
additive_prereq VARCHAR(20),
item_boost NUMBER,
item_use VARCHAR(50)
);

create TABLE monsters(
monster_id VARCHAR(50) PRIMARY KEY NOT NULL,
monster VARCHAR(30) NOT NULL,
monster_desc VARCHAR(200) NOT NULL,
health_point NUMBER NOT NULL,
attack_point NUMBER NOT NULL,
win_message VARCHAR(100) REFERENCES items(item_id) NOT NULL,
item_reward VARCHAR(20) REFERENCES items(item_id) NOT NULL,
item_reward_2 VARCHAR(20)
);

CREATE TABLE rooms(
room_ID VARCHAR(50) PRIMARY KEY NOT NULL,
room VARCHAR(30) NOT NULL,
room_desc VARCHAR(200) NOT NULL,
monster_id varchar(30) REFERENCES monsters(monster_id),
item_id varchar(30) REFERENCES items(item_id),
north_id varchar(10),
east_id varchar(10),
south_id varchar(10),
west_id varchar(10)
);

CREATE TABLE puzzles(
puzzle_id VARCHAR(30) PRIMARY KEY NOT NULL,
puzzle VARCHAR(200),
solution VARCHAR(200),
reward VARCHAR(100),
penalty VARCHAR(30) REFERENCES monsters(monster_id),
room_puzzle VARCHAR(50) REFERENCES rooms(room_id),
room_puzzle2 VARCHAR(50) REFERENCES rooms(room_id)
);


puzzle_id varchar(30) REFERENCES puzzles(puzzle_id)

INSERT INTO items(item_id, item, item_desc, acquired, additive_prereq, item_boost, item_use)
VALUES('AR_WP1', 'Crowbar', 'A black rusty crowbar', 'RM_1', NULL, 10, NULL);
INSERT INTO items(item_id, item, item_desc, acquired, additive_prereq, item_boost, item_use)
VALUES('AR_VP1', 'Stake', 'A sharp wooden stake', 'AR_WP2', 'AR_WP4', NULL);
INSERT INTO items(item_id, item, item_desc, acquired, additive_prereq, item_boost, item_use)
VALUES('AR_WP2', 'Dagger', 'A dagger with a silver blade and black handle', 'MN5_AA', NULL, 15, NULL);
INSERT INTO items(item_id, item, item_desc, acquired, additive_prereq, item_boost, item_use)
VALUES('AR_WP3', 'Club', 'A heavy wooden club', 'MN5_AA', NULL, 15, NULL);
INSERT INTO items(item_id, item, item_desc, acquired, additive_prereq, item_boost, item_use)
VALUES('AR_WP4', 'Broken table leg', 'A broken piece of wood that was the leg to the dining room table', 'RM_18', NULL, 15, 'Craft: Dagger');
INSERT INTO items(item_id, item, item_desc, aquired, additive_prereq, item_boost, item_use)
VALUES('AR_VP2', 'Garlic', 'A bundle of white garlic cloves', 'RM_19', NULL, NULL, 'Kill Vampire');
INSERT INTO items(item_id, item, item_desc, acquired, additive_prereq, item_boost, item_use)
VALUES('AR_HP', 'Health potion', 'A small glass container filled with red liquid', 'random', NULL, NULL, 'Heal');
INSERT INTO items(item_id, item, item_desc, acquired, additive_prereq, item_boost, item_use)
VALUES('AR_WP5', 'Garden Hoe', 'A garden hoe covered in dirt', 'RM_20', NULL, 10, 'Attack');
INSERT INTO items(item_id, item, item_desc, acquired, additive_prereq, item_boost, item_use)
VALUES('AR_KEY1', 'Silver Key', 'A small silver key', 'MN3_GH', NULL, NULL, 'Unlock Lab');
INSERT INTO items(item_id, item, item_desc, acquired, additive_prereq, item_boost, item_use)
VALUES('AR_KEY2', 'Red Key', 'A big red key', 'MN6_VP', NULL, NULL, 'Unlock Observatory');
INSERT INTO items(item_id, item, item_desc, acquired, additive_prereq, item_boost, item_use)
VALUES('AR_KEY3', 'Brown Key', 'A small brown key', 'MN1_WW', NULL, NULL, 'Unlock Library');
INSERT INTO items(item_id, item, item_desc, acquired, additive_prereq, item_boost, item_use)
VALUES('AR_KEY4', 'White Key', 'A shiny white key', 'MN4_GB', NULL, NULL, 'Unlock Chapel');
INSERT INTO items(item_id, item, item_desc, acquired, additive_prereq, item_boost, item_use)
VALUES('AR_KEY5', 'Gold Key', 'A big gold key', 'MN8_WH', NULL, NULL, 'Unlock Entrance Room');
INSERT INTO items(item_id, item, item_desc, acquired, additive_prereq, item_boost, item_use)
VALUES('AR_PUZ1', 'Spellbook', 'A magical tome for casting spells', 'PZ_E3LB', NULL, NULL, 'Used to solve puzzles');
INSERT INTO items(item_id, item, item_desc, acquired, additive_prereq, item_boost, item_use)
VALUES('AR_PUZ2', 'Autobiography Memo', 'A memo on the resident’s favorite books', 'PZ_E1CL', NULL, NULL, 'Used to remind solution to library puzzle');
INSERT INTO items(item_id, item, item_desc, acquired, additive_prereq, item_boost, item_use)
VALUES('AR_PUZ3', 'Captive Memo', 'A single word from a captive in the Torture Chamber that passed away', 'Examine skeleton in torture chamber', NULL, NULL, 'Used to remind solution to chapel puzzle');
INSERT INTO items(item_id, item, item_desc, acquired, additive_prereq, item_boost, item_use)
VALUES('AR_PUZ4', 'Prayer Book', 'A holy book revered by those faithful to its teachings. Is used in rituals to banish evil', 'PZ_E2PB', NULL, NULL, 'Used to defeat crusader and witch puzzle');
INSERT INTO items(item_id, item, item_desc, acquired, additive_prereq, item_boost, item_use)
VALUES('AR_PUZ5', 'Holy Sigil', 'A religious symbol that radiates a warm and comforting light', 'RM_17', NULL, NULL, 'Used to solve witch puzzle');
INSERT INTO items(item_id, item, item_desc, acquired, additive_prereq, item_boost, item_use)
VALUES('AR_PUZ6', 'Bag of Salt', 'A generous bag of multipurpose salts', 'RM_17', NULL, NULL, 'Used to solve witch puzzle');

INSERT INTO rooms
VALUES('RM_1', 'Dungeon', 'You wake up on a cold, hard floor. There is a dead body next to you on the ground. The cell door is open to the north, and there are stairs that lead up. There is a rusty crowbar laying on theground next to the door. You notice scuff marks on the ground next to the wall to the west.',NULL, 'AR_WP1', NULL, NULL, NULL, 'RM_2', NULL);
INSERT INTO rooms
VALUES('RM_2', 'Secret Hallway', 'A small, dusty hallway where the only light is coming from 1 candle. There is a door to the east and a door to the west.', NULL, NULL, NULL, 'RM_1', NULL, 'RM_3', NULL);
INSERT INTO rooms
VALUES('RM_3', 'Torture Chamber', 'This room is dark and has a wretched odor. There is a cage with a skeleton in it, and a table with straps and blood stains. There is a small, green goblin down here too. They heard you when you fell down and lunged at you. It attacks you first. The only door in here is to the east.', 'MN4_GB', 'AR_HP', NULL, 'RM_2', NULL, NULL, 'AR_PUZ3');
INSERT INTO monsters
VALUES('MN_WW', 'Werewolf', 'A tall, hairy man-like creature is growling at you.', 70, 10, 'The werewolf whimpers and falls to the ground.', 'AR_HP', 'AR_KEY3');


