ALTER TABLE `project`
  MODIFY COLUMN `user_creator_id` BIGINT;

ALTER TABLE `task`
  MODIFY COLUMN `user_creator_id` BIGINT;

ALTER TABLE `project`
  DROP FOREIGN KEY `project_fk0`,
  ADD CONSTRAINT `user_creator` FOREIGN KEY (`user_creator_id`) REFERENCES `user` (`id`)
  ON DELETE SET NULL;

ALTER TABLE `task`
  DROP FOREIGN KEY `task_fk0`,
  ADD CONSTRAINT `task_project` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`)
  ON DELETE CASCADE;

ALTER TABLE `task`
  DROP FOREIGN KEY `task_fk1`,
  ADD CONSTRAINT `task_user_creator` FOREIGN KEY (`user_creator_id`) REFERENCES `user` (`id`)
  ON DELETE SET NULL;

ALTER TABLE `user_2task`
  DROP FOREIGN KEY `user_2task_fk0`,
  ADD CONSTRAINT `user_task` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
  ON DELETE CASCADE;

ALTER TABLE `user_2task`
  DROP FOREIGN KEY `user_2task_fk1`,
  ADD CONSTRAINT `user_2task` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`)
  ON DELETE CASCADE;

ALTER TABLE `user_projects`
  DROP FOREIGN KEY `user_projects_fk0`,
  ADD CONSTRAINT `user_2project` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
  ON DELETE CASCADE;

ALTER TABLE `user_projects`
  DROP FOREIGN KEY `user_projects_fk1`,
  ADD CONSTRAINT `user_projects` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`)
  ON DELETE CASCADE;