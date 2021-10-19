DROP TABLE IF EXISTS books;

CREATE TABLE books (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  summary VARCHAR(250) DEFAULT NULL,
  author VARCHAR(250) NOT NULL,
  ISBN VARCHAR(14) NOT NULL
);

INSERT INTO books (title, summary, author, ISBN) VALUES
  ('Refactoring: Improving the Design of Existing Code', 'The best refactoring book', 'Martin Fowler', '978-0134757599'),
  ('Test Driven Development: By Example', 'The best TDD book', 'Kent Beck', '978-8131715956'),
  ('Working Effectively with Legacy Code', 'The best Legacy code book', 'Michael feathers', '978-0131177055');