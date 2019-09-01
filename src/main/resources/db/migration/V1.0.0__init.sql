create table Github_Project(id Identity not null primary key,org_name varchar(50) not null,repo_name varchar(50) not null unique);

create index idx_repo_name on Github_project(repo_name);