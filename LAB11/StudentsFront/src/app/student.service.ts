import { Injectable } from '@angular/core';
import { Student } from './student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  students: Student[] = [
 {id: 1, index: 123456, firstName: 'Marek', lastName: 'Wojciechowski'},
 {id: 2, index: 123457, firstName: 'Krzysztof', lastName: 'Jankiewicz'},
]
  constructor() {
    
   }
  getStudents(): Student[] {
    return this.students;
  }

}
