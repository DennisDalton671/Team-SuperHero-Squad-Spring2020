DROP TABLE puzzles;
DROP TABLE rooms;
DROP TABLE monsters;
DROP TABLE items;

CREATE TABLE items(
item_id VARCHAR(10) PRIMARY KEY NOT NULL,
item VARCHAR(300) NOT NULL,
item_desc VARCHAR(50) NOT NULL,
aquired VARCHAR(20) NOT NULL,
additive_prereq VARCHAR(20),
item_boost NUMBER,
item_use VARCHAR(50)
);

create TABLE monsters(
monster_id VARCHAR(10) PRIMARY KEY NOT NULL,
monster VARCHAR(20) NOT NULL,
monster_desc VARCHAR(300) NOT NULL,
health_point NUMBER NOT NULL,
attack_point NUMBER NOT NULL,
win_message VARCHAR(100) REFERENCES items(item_id) NOT NULL,
item_reward VARCHAR(20) REFERENCES items(item_id) NOT NULL,
item_reward_2 VARCHAR(20)
);

CREATE TABLE rooms(
room_ID VARCHAR(10) PRIMARY KEY NOT NULL,
room VARCHAR(10) NOT NULL,
room_desc VARCHAR(300) NOT NULL,
monster_id varchar(10) REFERENCES monsters(monster_id),
item_id varchar(30) REFERENCES items(item_id),
north_id varchar(10),
east_id varchar(10),
south_id varchar(10),
west_id varchar(10)
);

CREATE TABLE puzzles(
puzzle_id VARCHAR(10) PRIMARY KEY NOT NULL,
puzzle VARCHAR(300),
solution VARCHAR(300),
reward VARCHAR(100),
penalty VARCHAR(10) REFERENCES monsters(monster_id),
room_puzzle VARCHAR(10) REFERENCES rooms(room_id),
room_puzzle2 VARCHAR(10) REFERENCES rooms(room_id)
);

ALTER TABLE rooms ADD(
puzzle_id varchar(300) REFERENCES puzzles(puzzle_id)
);

INSERT INTO items(item_id, item, item_desc, aquired, additive_prereq, item_boost, item_use)
VALUES('AR_WP1', 'Crowbar', 'A black rusty crowbar', 'RM_1', NULL, 10, NULL);
INSERT INTO items(item_id, item, item_desc, aquired, additive_prereq, item_boost, item_use)
VALUES('AR_VP1', 'Stake', 'A sharp wooden stake', 'AR_WP2', 'AR_WP4', NULL);
INSERT INTO items(item_id, item, item_desc, aquired, additive_prereq, item_boost, item_use)
VALUES('AR_WP2', 'Dagger', 'A dagger with a silver blade and black handle', 'MN5_AA', NULL, 15, NULL);
INSERT INTO items(item_id, item, item_desc, aquired, additive_prereq, item_boost, item_use)
VALUES('AR_WP3', 'Club', 'A heavy wooden club', 'MN5_AA', NULL, 15, NULL);
INSERT INTO items(item_id, item, item_desc, aquired, additive_prereq, item_boost, item_use)
VALUES('AR_WP4', 'Broken table leg', 'A broken piece of wood that was the leg to the dining room table', 'RM_18', NULL, 15, 'Craft: Dagger');
INSERT INTO items(item_id, item, item_desc, aquired, additive_prereq, item_boost, item_use)
VALUES('AR_VP2', 'Garlic', 'A bundle of white garlic cloves', 'RM_19', NULL, NULL, 'Kill Vampire');
INSERT INTO items(item_id, item, item_desc, aquired, additive_prereq, item_boost, item_use)
VALUES('AR_HP', 'Health potion', 'A small glass container filled with red liquid', 'Dropped by monsters and found around house', NULL, NULL, 'Kill Vampire');
