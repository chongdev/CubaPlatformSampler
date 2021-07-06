create table CUBAPLATFORMSAMPLER_SESSION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TOPIC varchar(255) not null,
    START_DATE timestamp not null,
    END_DATE timestamp not null,
    SPEAKER_ID varchar(36) not null,
    DISCRIPTION varchar(2000),
    --
    primary key (ID)
);