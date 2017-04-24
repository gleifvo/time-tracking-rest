ALTER TABLE "user_info"
  DROP CONSTRAINT user_fk0;
ALTER TABLE "user_info"
  DROP COLUMN "user_type_id",
  ADD COLUMN "user_type" VARCHAR(50) NOT NULL;
DROP TABLE "user_type";