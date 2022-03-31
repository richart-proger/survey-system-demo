DELETE
FROM user_roles;
DELETE
FROM users;
DELETE
FROM surveys;
DELETE
FROM questions;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', '{noop}admin');

INSERT INTO user_roles (role, user_id)
VALUES ('ADMIN', 100000);

INSERT INTO surveys (name, start_date, finish_date, description)
VALUES ('Братья наши меньшие', DATE_SUB(CURRENT_DATE, INTERVAL 1 DAY), CURRENT_DATE,
        'Вопросы о домашних животных'),
       ('Вокруг света', DATE_SUB(CURRENT_DATE, INTERVAL 3 DAY), null,
        'Вопросы для путешественников')

--        ('Эх, прокачу!', DATE_SUB(CURRENT_DATE, INTERVAL 1 DAY), null,
--         'Вопросы для автомобилистов')
;

INSERT INTO questions (survey_id, text)
VALUES (100001, 'Назовите любимое домашнее животное'),
       (100001, 'Гуляете ли Вы со своим питомцем?'),
       (100002, 'Назовите Ваш любимый город'),
       (100002, 'Каким способом Вам больше нравится путешествовать?');

INSERT INTO question_types (question_id, question_type)
VALUES (100003, 'ANSWER_IN_TEXT'),
       (100004, 'CHOICE_OF_ONE_OPTION'),
       (100005, 'ANSWER_IN_TEXT'),
       (100006, 'CHOICE_OF_SEVERAL_OPTIONS');