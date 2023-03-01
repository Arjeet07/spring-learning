package com.example.arcos_integration.note;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "note")
public class NoteController {
    private final NoteService NoteSer;

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes(){
        return new ResponseEntity<>(NoteSer.getAllNotes(), HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Integer id) {
        return new ResponseEntity<>(NoteSer.getNoteById(id), HttpStatus.OK); //200
    }
    @GetMapping(path = "find")
    public  ResponseEntity<Note> getNoteByIdandTitle(@RequestParam String title, @RequestParam Integer id){
        return new ResponseEntity<>(NoteSer.getNoteByIdandTitle(title,id), HttpStatus.OK);//http://localhost:8069/note/find?title=Arjeet&id=2
    }
    @GetMapping(path = "title/{title}")
    public ResponseEntity<Note> getNoteByTitle(@PathVariable String title) {
        return new ResponseEntity<>(NoteSer.getNodeByTitle(title), HttpStatus.OK); //200
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> saveNote(@RequestBody Note nt){
        return new ResponseEntity<>(NoteSer.saveNote(nt), HttpStatus.CREATED); //201
    }



}
