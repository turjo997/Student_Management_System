package com.suffixIT.StudentManagementSystem.Service;

import com.suffixIT.StudentManagementSystem.Exception.ResourceNotFoundException;
import com.suffixIT.StudentManagementSystem.Repository.CourseRepository;
import com.suffixIT.StudentManagementSystem.Request.CourseRequest;
import com.suffixIT.StudentManagementSystem.Request.StudentRequest;
import com.suffixIT.StudentManagementSystem.Response.MessageResponse;
import com.suffixIT.StudentManagementSystem.entity.Course;
import com.suffixIT.StudentManagementSystem.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    CourseRepository courseRepository;

    @Override
    public MessageResponse createCourse(CourseRequest courseRequest){
        Course newCourse= new Course();

        newCourse.setTitle(courseRequest.getTitle());
        newCourse.setCredit(courseRequest.getCredit());
        try{
            courseRepository.save(newCourse);
        }
        catch(Exception e){
            return new MessageResponse("Course created failed!");
        }
        return new MessageResponse("Course Created successfully!");
    }

    @Override
    public MessageResponse updateCourse(Integer courseId, CourseRequest courseRequest) throws ResourceNotFoundException {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course", "courseId", courseId));

            course.setTitle(courseRequest.getTitle());
            course.setCredit(courseRequest.getCredit());
            courseRepository.save(course);
            return new MessageResponse("Course updated successfully!");

    }

    @Override
    public Course getASingleCourse(Integer courseId) throws ResourceNotFoundException{
        return courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course", "courseId", courseId));

    }

    @Override
    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }

    @Override
    public MessageResponse deleteCourse(Integer courseId) throws ResourceNotFoundException{
        final Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "courseId", courseId));

        courseRepository.deleteById(course.getCourseId());
        return new MessageResponse("Course id deleted successfully!");
    }
}