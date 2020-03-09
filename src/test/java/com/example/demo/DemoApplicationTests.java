package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.po.Student;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private StudentMapper studentMapper;
    @Test
    void contextLoads() {
        Student student = new Student();
        student.setName("臧磊");
        student.setAge(24);
        student.setClassId(1L);
        student.setDeleted(0);
        int i = studentMapper.insert(student);
        Assert.assertEquals(1, i);
    }

    @Test
    void selectList(){

        List<Student> students = studentMapper.selectList(new QueryWrapper<Student>().lambda().eq(Student::getName,
                "臧磊1"));
        students.forEach(System.out::println);
    }
}
