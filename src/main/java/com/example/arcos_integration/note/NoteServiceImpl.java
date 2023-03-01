package com.example.arcos_integration.note;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService{
    private final NoteRepository NoteRepo; //constructor injection //dependencies injection

    @Override
    public List<Note> getAllNotes() {
        return NoteRepo.findAll();
    }

    @Override
    public Note getNoteById(Integer id) {
        Optional<Note>nt=NoteRepo.findById(id);
        if(nt.isPresent())
        {
            return nt.get();
        }
        throw new RuntimeException("Note does not exists");
    }

    @Override
    public Note getNodeByTitle(String str) {
        Optional<Note> tt=NoteRepo.findByTitle(str);
        if(tt.isPresent())
        {
            return tt.get();
        }
        throw new RuntimeException("Note does not exists");
    }

    @Override
    public Note getNoteByIdandTitle(String str, Integer id) {
        Optional<Note> tt=NoteRepo.findByTitleAndId(str,id);
        if(tt.isPresent())
        {
            return tt.get();
        }
        throw new RuntimeException("Note does not exists");
    }

    @Override
    public Map<String, String> saveNote(Note note) {
        NoteRepo.save(note);
        return new HashMap<>(){{
            put("msg","Note saved");
        }};
    }
}
