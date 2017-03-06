package ru.ifmo.p3411.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.ifmo.p3411.data.BoardColumn;
import ru.ifmo.p3411.data.Task;

import javax.persistence.Table;
import java.util.List;

/**
 * @author Ellepsis
 * @since 1.0
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long>, JpaSpecificationExecutor<Task> {
    @Query(value = "select t from Task t " +
            "where t.boardColumn.id = :boardColumn")
    List<Task> getAllTaskByBoardColumn(@Param(value = "boardColumn") Long boardColumn);
}
