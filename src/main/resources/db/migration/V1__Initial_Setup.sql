CREATE TABLE "user_info" (
  id           BIGSERIAL PRIMARY KEY,
  first_name   VARCHAR(20) NOT NULL,
  last_name    VARCHAR(20) NOT NULL,
  login        VARCHAR(20) NOT NULL UNIQUE,
  password     VARCHAR(35) NOT NULL,
  user_type_id BIGINT      NOT NULL
);

CREATE TABLE "user_type" (
  id        BIGSERIAL PRIMARY KEY,
  role_name VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE "project" (
  id              BIGSERIAL PRIMARY KEY,
  name            VARCHAR(40) NOT NULL UNIQUE,
  user_creator_id BIGINT      NOT NULL
);

CREATE TABLE "task" (
  id              BIGSERIAL PRIMARY KEY,
  project_id      BIGINT       NOT NULL,
  description     VARCHAR(200) NOT NULL,
  user_creator_id BIGINT       NOT NULL
);

CREATE TABLE "user_2task" (
  user_id BIGINT NOT NULL,
  task_id BIGINT NOT NULL
);

CREATE TABLE "user_projects" (
  user_id    BIGINT NOT NULL,
  project_id BIGINT NOT NULL
);

ALTER TABLE "user_info"
  ADD CONSTRAINT user_fk0 FOREIGN KEY (user_type_id) REFERENCES "user_type" (id);

ALTER TABLE "project"
  ADD CONSTRAINT project_fk0 FOREIGN KEY (user_creator_id) REFERENCES "user_info" (id);

ALTER TABLE "task"
  ADD CONSTRAINT task_fk0 FOREIGN KEY (project_id) REFERENCES "project" (id);

ALTER TABLE "task"
  ADD CONSTRAINT task_fk1 FOREIGN KEY (user_creator_id) REFERENCES "user_info" (id);

ALTER TABLE "user_2task"
  ADD CONSTRAINT user_2task_fk0 FOREIGN KEY (user_id) REFERENCES "user_info" (id);

ALTER TABLE "user_2task"
  ADD CONSTRAINT user_2task_fk1 FOREIGN KEY (task_id) REFERENCES "task" (id);

ALTER TABLE "user_projects"
  ADD CONSTRAINT user_projects_fk0 FOREIGN KEY (user_id) REFERENCES "user_info" (id);

ALTER TABLE "user_projects"
  ADD CONSTRAINT user_projects_fk1 FOREIGN KEY (project_id) REFERENCES "project" (id);