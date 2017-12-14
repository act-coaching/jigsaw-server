CREATE TABLE project
  ( 
     id                INTEGER AUTO_INCREMENT PRIMARY KEY,
     project_name      VARCHAR(255),
     project_code      VARCHAR(255),
     total_count       INTEGER,
     pm                INTEGER ,
     dev                INTEGER,
     cx                INTEGER

  );


insert into project(project_name,project_code,total_count, pm, dev, cx)values('CPEX 구축프로젝트','PJT_0542',20, 1, 15, 4);
insert into project(project_name,project_code,total_count, pm, dev, cx)values('Agile 문화 확산','AGA_12312',3, 1, 1, 1);