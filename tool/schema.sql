create table person
(
    id               int auto_increment primary key,
    create_time      datetime default current_timestamp     not null,
    last_modify_time datetime default current_timestamp     not null,
    delete_time      datetime default "1970-01-01 00:00:00" not null,
    person_name      varchar(256)                           not null,
    leader_Id        int                                    null,
    province         varchar(256)                           null,
    city             varchar(256)                           null,
    exact_address    varchar(512)                           null
);



create table approval_info
(
    id               int auto_increment primary key,
    create_time      datetime default current_timestamp     not null,
    last_modify_time datetime default current_timestamp     not null,
    delete_time      datetime default "1970-01-01 00:00:00" not null,
    leave_Id         int                                    not null,
    seq              int                                    not null,
    approver_Id      int                                    not null,
    approver_name    varchar(256)                           not null,
    approval_type    varchar(64)                            not null,
    msg              varchar(512)                           null,
    approve_time datetime default current_timestamp         not null
);




create table `leave`
(
    id               int auto_increment primary key,
    create_time      datetime default current_timestamp     not null,
    last_modify_time datetime default current_timestamp     not null,
    delete_time      datetime default "1970-01-01 00:00:00" not null,
    applicant_id     int                                    not null,
    applicant_name   varchar(256)                           not null,
    approver_Id      int                                    null,
    approver_name    varchar(256)                           null,
    content          varchar(512)                           null,
    status           varchar(64)                            not null,
    start_time       date                                   not null,
    end_time         date                                   not null,
    max_agree_count  int    default 0                       not null
);