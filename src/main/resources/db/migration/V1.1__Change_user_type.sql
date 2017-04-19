ALTER TABLE `user`
  DROP FOREIGN KEY `user_fk0`;
ALTER TABLE `user`
  CHANGE COLUMN `user_type_id` `user_type` VARCHAR(50) NOT NULL;
DROP TABLE `user_type`;