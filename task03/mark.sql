use abc;
-- select * from t_students_attend_class;
-- 
-- select * from t_teach;
-- 
-- select * from t_student;

select * from t_teachers;

select * from t_classes;

select * from t_evaluation_template_simple;

select * 
from t_teacher_evaluation_simple;

select *
from t_integral_simple;

select*
from t_property_simple;
-- select t_student.name
-- from t_students_attend_class,t_teach,t_studentc
-- where t_students_attend_class.studentId=t_student.studentId
-- and t_students_attend_class.classId=t_teach.classId 
-- and t_teach.teacherId = t_teachers.teacherId
-- and t_teachers.teacherName=`监测`;


-- select t_teach.classId
-- from t_teachers,t_teach
-- where t_teach.teacherId = t_teachers.teacherId and t_teachers.teacherName='监测';
-- 

-- select t_student.name
-- from t_teachers,t_teach,t_students_attend_class,t_student
-- where t_teach.teacherId = t_teachers.teacherId and t_teachers.teacherName='监测' 
-- and t_teach.classId=t_students_attend_class.classId and t_students_attend_class.studentId=t_student.studentId;
-- 
-- select className,teacherName
-- from t_teachers,t_teach,t_classes
-- where t_teachers.teacherName='监测' and t_teachers.teacherId=t_teach.teacherId and t_teach.classId=t_classes.classId






