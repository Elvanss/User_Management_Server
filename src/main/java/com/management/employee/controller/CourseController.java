package com.management.employee.controller;

import com.management.employee.dto.CourseDTO;
import com.management.employee.dto.ResponseDTO;
import com.management.employee.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/")
    public ResponseEntity<ResponseDTO<CourseDTO>> create(@RequestBody CourseDTO courseDTO){
        ResponseDTO<CourseDTO> res = courseService.create(courseDTO);
        return ResponseEntity.status(res.getStatus()).body(res);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDTO<CourseDTO>> updateById(@RequestBody CourseDTO courseDTO, @PathVariable Long id){
        ResponseDTO<CourseDTO> res = courseService.updateById(courseDTO,id);
        return ResponseEntity.status(res.getStatus()).body(res);
    }
    @GetMapping("/")
    public ResponseEntity<ResponseDTO<List<CourseDTO>>> findAll(){
        ResponseDTO<List<CourseDTO>> res = courseService.findAll();
        return ResponseEntity.status(res.getStatus()).body(res);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<CourseDTO>> findById(@PathVariable Long id){
        ResponseDTO<CourseDTO> res = courseService.findById(id);
        return ResponseEntity.status(res.getStatus()).body(res);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO<Void>> deleteById(@PathVariable Long id){
        ResponseDTO<Void> res = courseService.deleteById(id);
        return ResponseEntity.status(res.getStatus()).body(res);
    }
}
