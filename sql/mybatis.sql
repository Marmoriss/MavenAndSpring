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