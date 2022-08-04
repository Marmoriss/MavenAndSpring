--=======================
-- mybatis
--=======================

create table student (
    no number,
    name varchar2(50) not null,
    tel char(11) not null,
    created_at date default sysdate,
    updated_at date, -- 최종 수정일
    deleted_at date, -- 학생 정보 제거시 delete하지 않고 deleted_at컬럼을 sysdate로 작성
    constraint pk_student_no primary key(no)
);

create sequence seq_student_no;

insert into
    student (no, name, tel)
values (
    seq_student_no.nextval, '홍길동', '01012341234'
);

insert into
    student (no, name, tel)
values (
    seq_student_no.nextval, '신사임당', '01044445555'
);

insert into
    student (no, name, tel)
values (
    seq_student_no.nextval, '세종대왕', '01033334444'
);

select * from student where deleted_at is null;
select * from student where deleted_at is null and no = 1;
select count(*) from student where deleted_at is null;

-- 수정
update
    student
set
    tel = '01088889999',
    updated_at = sysdate
where
    no = 2;
    
-- 제거
update
    student
set
    deleted_at = sysdate
where
    no = 3;

commit;
rollback;
update
        student
    set
       name = '김감자',
       tel = '01011112222',
       updated_at = sysdate
    where
        no = 4;
        
--  kh 계정의 데이터 사용하기

select * from kh.employee;
select * from kh.department;
select * from kh.job;

-- select 권한 부여
grant select on kh.employee to web;
grant select on kh.department to web;
grant select on kh.job to web;

-- 관리자 계정 : create synonym 권한 부여
grant create synonym to web;

-- synonym 동의어 객체 생성
create synonym emp for kh.employee;
create synonym dept for kh.department;
create synonym job for kh.job;

select * from emp;
select * from dept;
select * from job;











