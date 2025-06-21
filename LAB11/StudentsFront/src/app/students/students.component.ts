import { Component } from '@angular/core';
import {Student} from '../student';
import {StudentService} from '../student.service';


@Component({
  selector: 'app-students',
  imports: [],
  templateUrl: './students.component.html',
  styleUrl: './students.component.css'
})
export class StudentsComponent {
  students!: Student [];
  constructor(private studentService: StudentService) { } 
  ngOnInit(): void {
    this.getStudents();
  }
  getStudents(): void {
 this.students = this.studentService.getStudents();
 }
}
