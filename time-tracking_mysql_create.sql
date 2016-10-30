SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `user_type`;
DROP TABLE IF EXISTS `project`;
DROP TABLE IF EXISTS `task`;
DROP TABLE IF EXISTS `user_2task`;
DROP TABLE IF EXISTS `user_projects`;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `user` (
  `id`           BIGINT      NOT NULL AUTO_INCREMENT,
  `first_name`   VARCHAR(20) NOT NULL,
  `last_name`    VARCHAR(20) NOT NULL,
  `login`        VARCHAR(20) NOT NULL UNIQUE,
  `password`     VARCHAR(35) NOT NULL,
  `user_type_id` BIGINT      NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `user_type` (
  `id`        BIGINT      NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `project` (
  `id`              BIGINT      NOT NULL AUTO_INCREMENT,
  `name`            VARCHAR(40) NOT NULL UNIQUE,
  `user_creator_id` BIGINT      NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `task` (
  `id`              BIGINT       NOT NULL AUTO_INCREMENT,
  `project_id`      BIGINT       NOT NULL,
  `description`     VARCHAR(200) NOT NULL,
  `user_creator_id` BIGINT       NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `user_2task` (
  `user_id` BIGINT NOT NULL,
  `task_id` BIGINT NOT NULL
);

CREATE TABLE `user_projects` (
  `user_id`    BIGINT NOT NULL,
  `project_id` BIGINT NOT NULL
);

ALTER TABLE `user`
  ADD CONSTRAINT `user_fk0` FOREIGN KEY (`user_type_id`) REFERENCES `user_type` (`id`);

ALTER TABLE `project`
  ADD CONSTRAINT `project_fk0` FOREIGN KEY (`user_creator_id`) REFERENCES `user` (`id`);

ALTER TABLE `task`
  ADD CONSTRAINT `task_fk0` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`);

ALTER TABLE `task`
  ADD CONSTRAINT `task_fk1` FOREIGN KEY (`user_creator_id`) REFERENCES `user` (`id`);

ALTER TABLE `user_2task`
  ADD CONSTRAINT `user_2task_fk0` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `user_2task`
  ADD CONSTRAINT `user_2task_fk1` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`);

ALTER TABLE `user_projects`
  ADD CONSTRAINT `user_projects_fk0` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `user_projects`
  ADD CONSTRAINT `user_projects_fk1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`);

INSERT INTO `user_type` (role_name) VALUES ('test');
INSERT INTO `user` (first_name, last_name, login, password, user_type_id)
  VALUES ('test', 'test', 'test', 'test', 1);