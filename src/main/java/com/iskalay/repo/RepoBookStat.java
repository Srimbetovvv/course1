package com.iskalay.repo;

import com.iskalay.models.BookStat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepoBookStat extends JpaRepository<BookStat, Long> {
    List<BookStat> findAllByUserid(long id);

}
