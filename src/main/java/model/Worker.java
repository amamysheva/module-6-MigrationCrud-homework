package model;

import lombok.Data;

@Data
public class Worker {
    private long id;
    private String name;
    private String birthday;
    private String level;
    private int salary;
}
