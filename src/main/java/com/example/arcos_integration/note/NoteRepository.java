package com.example.arcos_integration.note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note,Integer> {
    @Query("select n from Note n where n.title = ?1")
    Optional<Note> findByTitle(String title);

    @Query("select n from Note n where n.title = ?1 and n.id = ?2")
    Optional<Note> findByTitleAndId(String title, int id);
    /*@Query(value = "SELECT n from Note n where n.id=?1")
    Optional<Note> getNoteForId2(Integer id);*/


}
