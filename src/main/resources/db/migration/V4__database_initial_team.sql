CREATE TABLE team
  ( 
     id                INTEGER AUTO_INCREMENT PRIMARY KEY,
     team              VARCHAR(255),
     department        VARCHAR(255),
     total_count       INTEGER,
     earning           INTEGER,
     working           INTEGER,
     staying           INTEGER

  );


insert into team(team,department,total_count,earning,working,staying)values('ICTO개발팀','전자개발그룹', 200, 150, 45, 5);
insert into team(team,department,total_count,earning,working,staying)values('개발1팀','개발2그룹', 150, 130, 18, 2);
