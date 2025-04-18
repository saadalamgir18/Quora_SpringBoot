package com.backend.Quora.repository;

import com.backend.Quora.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface QuestionRepository extends JpaRepository<Question, UUID> {
//    @Query("SELECT q FROM Question q WHERE q.title like :text")
    List<Question> findByTitleIgnoreCaseContaining(@Param("text") String text);
}
