package com.example.tododemo.repo;

import com.example.tododemo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {
    //select    insert    delete   update

//    List<S> findAll(Example<S> example);   //select * from todo
}
