// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract StudentRegistry {
    // Structure to represent student data
    struct Student {
        uint256 studentId;
        string name;
        uint256 age;
    }

    // Array to store multiple student records
    Student[] public students;

    // Function to add a new student
    function addStudent(uint256 _studentId, string memory _name, uint256 _age) public {
        Student memory newStudent = Student(_studentId, _name, _age);
        students.push(newStudent);
    }

    // Function to get the number of students
    function getNumberOfStudents() public view returns (uint256) {
        return students.length;
    }

    // Fallback function
    fallback() external {
        // This function will be called if a transaction is sent to the contract
        // without specifying any function. It can be used for general purposes.
        // For simplicity, we can leave it empty.
    }
}
