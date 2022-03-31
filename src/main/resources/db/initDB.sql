DROP TABLE user_roles IF EXISTS;
DROP TABLE question_types IF EXISTS;
DROP TABLE users IF EXISTS;
DROP TABLE questions IF EXISTS;
DROP TABLE surveys IF EXISTS;
DROP SEQUENCE global_seq IF EXISTS;

CREATE SEQUENCE GLOBAL_SEQ AS INTEGER START WITH 100000;

CREATE TABLE users
(
  id         INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
  name       VARCHAR(255)            NOT NULL,
  email      VARCHAR(255)            NOT NULL,
  password   VARCHAR(255)            NOT NULL,
  registered TIMESTAMP DEFAULT NOW() NOT NULL,
  enabled    BOOLEAN   DEFAULT TRUE  NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx
  ON USERS (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR(255),
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE
);

CREATE TABLE surveys
(
  id          INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
  name        VARCHAR(255)       NOT NULL,
  start_date  DATE DEFAULT NOW() NOT NULL,
  finish_date DATE DEFAULT NOW(),
  description VARCHAR(255)       NOT NULL
);

CREATE TABLE questions
(
  id        INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
  survey_id INTEGER      NOT NULL,
  text      VARCHAR(255) NOT NULL,
  CONSTRAINT questions_unique_id_idx UNIQUE (id, survey_id),
  FOREIGN KEY (survey_id) REFERENCES surveys (id) ON DELETE CASCADE
);

CREATE TABLE question_types
(
  question_id   INTEGER NOT NULL,
  question_type VARCHAR(255),
  CONSTRAINT question_types_idx UNIQUE (question_id, question_type),
  FOREIGN KEY (question_id) REFERENCES questions (id) ON DELETE CASCADE
);
