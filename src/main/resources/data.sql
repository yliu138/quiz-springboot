insert into quiz(description, quizType) values ('What is the MVP in the Germany national football team', 'mcq');
insert into quiz(description, quizType) values ('Which country listed below is the host of 2018 world cup', 'paragraph');

insert into answer(content) values('Kloze');
insert into answer(content) values('Maze');
insert into answer(content) values('Ronaldo');
insert into answer(content) values('Beckham');
insert into answer(content) values('Russia');
insert into answer(content) values('China');
insert into answer(content) values('Australia');

insert into quiz_has_answer(quiz_Id, answer_id, is_correct) values (1, 1, true);
insert into quiz_has_answer(quiz_Id, answer_id, is_correct) values (1, 2, false);
insert into quiz_has_answer(quiz_Id, answer_id, is_correct) values (1, 3, false);
insert into quiz_has_answer(quiz_Id, answer_id, is_correct) values (1, 4, false);

insert into quiz_has_answer(quiz_Id, answer_id, is_correct) values (2, 1, false);
insert into quiz_has_answer(quiz_Id, answer_id, is_correct) values (2, 5, true);
insert into quiz_has_answer(quiz_Id, answer_id, is_correct) values (2, 6, false);
insert into quiz_has_answer(quiz_Id, answer_id, is_correct) values (2, 7, false);