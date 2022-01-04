-- INSERT AUTHORS			
insert into author (author_name ) values ('Shaimaa Hamd');
insert into author (author_name ) values ('William Shakespeare');
insert into author (author_name ) values ('J. K Rowling');
insert into author (author_name ) values ('Barbara Cartland');
insert into author (author_name ) values ('Stephen King');

-- INSERT BOOKS			
insert into book (title, price, author_id) values ('Mostafa', 10000, 1);
insert into book (title, price, author_id) values ('Romeo and Juliet', 99.9, 2);
insert into book (title, price, author_id) values ('Harry Potter and the Philosophers Stone', 50, 3);
insert into book (title, price, author_id) values ('Harry Potter and the Chamber of Secrets', 50, 3);
insert into book (title, price, author_id) values ('Harry Potter and the Prisoner of Azkaban', 50, 3);
insert into book (title, price, author_id) values ('Harry Potter and the Goblet of Fire', 50, 3);
insert into book (title, price, author_id) values ('Harry Potter and the Order of the Phoenix', 50, 3);
insert into book (title, price, author_id) values ('Harry Potter and the Half-Blood Prince', 50, 3);
insert into book (title, price, author_id) values ('Harry Potter and the Deathly Hallows – Part 1', 50, 3);
insert into book (title, price, author_id) values ('Harry Potter and the Deathly Hallows – Part 2', 50, 3);
insert into book (title, price, author_id) values ('Romance', 109.9, 4);
insert into book (title, price, author_id) values ('The Green Mile', 109.9, 5);
insert into book (title, price, author_id) values ('The Shining', 109.9, 5);

insert into category (category) values ('ACTION');
insert into category (category) values ('ADVENTURE');
insert into category (category) values ('HORROR');
insert into category (category) values ('CLASSIC');
insert into category (category) values ('FANTACY');
insert into category (category) values ('MYSTERY');
insert into category (category) values ('CRIME');
insert into category (category) values ('DRAMA');

---- INSERT book_category
insert into book_category (book_id, category_id) values (1,4);
insert into book_category (book_id, category_id) values (2,8);
insert into book_category (book_id, category_id) values (3,1);
insert into book_category (book_id, category_id) values (4,1);
insert into book_category (book_id, category_id) values (5,1);
insert into book_category (book_id, category_id) values (6,1);
insert into book_category (book_id, category_id) values (7,1);
insert into book_category (book_id, category_id) values (8,1);
insert into book_category (book_id, category_id) values (9,1);
insert into book_category (book_id, category_id) values (10,1);
insert into book_category (book_id, category_id) values (11,2);
insert into book_category (book_id, category_id) values (12,8);
insert into book_category (book_id, category_id) values (12,7);
insert into book_category (book_id, category_id) values (12,6);
insert into book_category (book_id, category_id) values (13,3);

--INSERT ROLES
insert into roles(name) VALUES('USER');
insert into roles(name) VALUES('ADMIN');
