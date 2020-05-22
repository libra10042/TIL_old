create user c##MULTI
IDENTIFIED by multi1234
DEFAULT TABLESPACE MULTI;

select * from user_tablespaces;

alter user c##multi default tablespace multi;
select * from sys.dba_tablespace;


grant connect, resource, dba to c##multi;