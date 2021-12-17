package com.iskalay.repo;

import com.iskalay.models.Books;
import com.iskalay.models.enums.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepoBooks extends JpaRepository<Books, Long> {
    List<Books> findAllByGenre(Genre genre);
    List<Books> findAllByYear(int year);
    List<Books> findAllByPub(String pub);
    List<Books> findAllByUserid(long userid);
}
