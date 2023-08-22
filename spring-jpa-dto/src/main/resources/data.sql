-- Professors
INSERT INTO professor ("name") VALUES ('William Fences'); -- 1
INSERT INTO professor ("name") VALUES ('Arvid Strøm'); -- 2
INSERT INTO professor ("name") VALUES ('Anne Hansen'); -- 3
INSERT INTO professor ("name") VALUES ('Liv Larsen'); -- 4
-- Projects
INSERT INTO project (title) VALUES ('Automating your life in 3 easy steps'); -- 1
INSERT INTO project (title) VALUES ('How to build a technology empire'); -- 2
INSERT INTO project (title) VALUES ('Powering the new age'); -- 3
INSERT INTO project (title) VALUES ('Predicting the weather on Mars'); -- 4
INSERT INTO project (title) VALUES ('Classifying Deep Learning classifiers'); -- 5
INSERT INTO project (title) VALUES ('Can we make safe bets? An analysis of card counting'); -- 6
-- Students
INSERT INTO student ("name", professor_id, project_id) VALUES ('Ola Nordmann', 1, 1); -- 1
INSERT INTO student ("name", professor_id, project_id) VALUES ('Emma Hansen', 1, 2); -- 2
INSERT INTO student ("name", professor_id, project_id) VALUES ('Olivia Nordmann', 2, 3); -- 3
INSERT INTO student ("name", professor_id) VALUES ('Lucas Olsen', 2); -- 4
INSERT INTO student ("name", professor_id, project_id) VALUES ('Askel Nilsen', 3, 4); -- 5
INSERT INTO student ("name", professor_id) VALUES ('Frida Kristiansen', 3); -- 6
INSERT INTO student ("name", professor_id, project_id) VALUES ('Ingrid Johansen', 3, 5); -- 7
INSERT INTO student ("name", professor_id, project_id) VALUES ('Jakob Andersen', 3, 6); -- 8
-- Subjects
INSERT INTO subject (code, title, professor_id) VALUES ('ONT4001', 'Advanced Programming', 1); -- 1
INSERT INTO subject (code, title, professor_id) VALUES ('UIX3000', 'User Experience Design', 2); -- 2
INSERT INTO subject (code, title, professor_id) VALUES ('DATA4002', 'Big Data in Practice', 3); -- 3
INSERT INTO subject (code, title, professor_id) VALUES ('ALM3000', 'Applied Machine Learning', 3); -- 4
-- Students in subject
INSERT INTO student_subject (student_id, subject_id) VALUES (1,1);
INSERT INTO student_subject (student_id, subject_id) VALUES (2,1);
INSERT INTO student_subject (student_id, subject_id) VALUES (1,2);
INSERT INTO student_subject (student_id, subject_id) VALUES (2,2);
INSERT INTO student_subject (student_id, subject_id) VALUES (3,2);
INSERT INTO student_subject (student_id, subject_id) VALUES (5,3);
INSERT INTO student_subject (student_id, subject_id) VALUES (6,3);
INSERT INTO student_subject (student_id, subject_id) VALUES (7,3);
INSERT INTO student_subject (student_id, subject_id) VALUES (8,3);
INSERT INTO student_subject (student_id, subject_id) VALUES (5,4);
INSERT INTO student_subject (student_id, subject_id) VALUES (6,4);
INSERT INTO student_subject (student_id, subject_id) VALUES (7,4);
INSERT INTO student_subject (student_id, subject_id) VALUES (8,4);