package model;

import lombok.Data;

@Data
public class Project {
    private long id;
    private String name;
    private long clientId;
    private String startDate;
    private String finishDate;
}
