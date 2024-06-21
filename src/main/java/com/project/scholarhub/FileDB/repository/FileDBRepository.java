package com.project.scholarhub.FileDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.scholarhub.FileDB.model.FileDB;

//import com.bezkoder.spring.files.upload.db.model.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}