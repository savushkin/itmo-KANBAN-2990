package ru.ifmo.p3411.data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Created by Ellepsis on 11.02.2017.
 */
@Entity
@Table(name = "task")
public class Task {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id_seq")
    @SequenceGenerator(name = "task_id_seq", sequenceName = "task_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "creation_date", nullable = false)
    private Timestamp creationDate;

    @Column(name = "estimated_time")
    private Timestamp estimatedTime;

    @Column(name = "spent_time")
    private Timestamp spentTime;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private KanbanUser owner;

    @ManyToOne
    @JoinColumn(name = "board_column_id", nullable = false)
    private BoardColumn boardColumn;

    @OneToMany(mappedBy = "task")
    private Set<TaskUser> taskUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Timestamp getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Timestamp estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public Timestamp getSpentTime() {
        return spentTime;
    }

    public void setSpentTime(Timestamp spentTime) {
        this.spentTime = spentTime;
    }

    public KanbanUser getOwner() {
        return owner;
    }

    public void setOwner(KanbanUser owner) {
        this.owner = owner;
    }

    public BoardColumn getBoardColumn() {
        return boardColumn;
    }

    public void setBoardColumn(BoardColumn boardColumn) {
        this.boardColumn = boardColumn;
    }

    public Set<TaskUser> getTaskUser() {
        return taskUser;
    }

    public void setTaskUser(Set<TaskUser> taskUser) {
        this.taskUser = taskUser;
    }
}