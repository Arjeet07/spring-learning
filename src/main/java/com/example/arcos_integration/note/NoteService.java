package com.example.arcos_integration.note;

import java.util.List;
import java.util.Map;

public interface NoteService {
    List<Note> getAllNotes();
    Note getNoteById(Integer id);
    Note getNodeByTitle(String str); ////////////

    Note getNoteByIdandTitle(String str, Integer id);
    Map<String, String> saveNote(Note note);
}
